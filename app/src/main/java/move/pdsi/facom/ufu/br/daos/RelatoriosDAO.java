package move.pdsi.facom.ufu.br.daos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import move.pdsi.facom.ufu.br.model.eventos.Evento;
import move.pdsi.facom.ufu.br.model.eventos.Gasto;
import move.pdsi.facom.ufu.br.model.eventos.Viagem;
import move.pdsi.facom.ufu.br.model.meiosdetransporte.MeioDeTransporte;
import move.pdsi.facom.ufu.br.model.relatorios.EstatisticasGeral;
import move.pdsi.facom.ufu.br.model.relatorios.EstatisticasPorMeioDeTransporte;

public class RelatoriosDAO {

    private CriaBancoCompleto db;
    private Context mContext;
    private static SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
    public RelatoriosDAO(Context context) {
        this.db = new CriaBancoCompleto(context);
        this.mContext = context;
    }

    public EstatisticasPorMeioDeTransporte relatorioIndividual(MeioDeTransporte meioDeTransporte,
                                                               Timestamp dataInicial, Timestamp datafinal) {
        EstatisticasPorMeioDeTransporte stats = new EstatisticasPorMeioDeTransporte();
        //Carrega todas as viagens dentro do intervalo
        StringBuilder viagensQuery = new StringBuilder();
        try{
            BufferedReader q = new BufferedReader(new InputStreamReader( this.mContext.getAssets().open("RelatAllViagens.sql") ) );
            String entrada;
            while( (entrada = q.readLine()) != null){
                viagensQuery.append(entrada);
            }
        }catch(IOException ex){
            Toast.makeText(mContext, "Falha ao ler consulta de viagens.", Toast.LENGTH_LONG).show();
        }
        //Carrega todos os gastos dentro do intervalo
        StringBuilder gastosQuery = new StringBuilder();
        try{
            BufferedReader q = new BufferedReader(new InputStreamReader( this.mContext.getAssets().open("RelatAllGastos.sql") ) );
            String entrada;
            while( (entrada = q.readLine()) != null){
                gastosQuery.append(entrada);
            }
        }catch(IOException ex){
            Toast.makeText(mContext, "Falha ao ler consulta de gastos.", Toast.LENGTH_LONG).show();
        }
        SQLiteDatabase banco = db.getInstance(mContext).getReadableDatabase();
        Cursor cursor;
        cursor = banco.rawQuery(viagensQuery.toString(), new String[]{Integer.toString(meioDeTransporte.getId())
                ,out.format(new Date(dataInicial.getTime())),out.format(new Date(datafinal.getTime()))});
        ArrayList<Evento> eventos = new ArrayList<>(20);
        if(cursor.moveToFirst()){
            do{
                Viagem v = new Viagem();
                v.setId(cursor.getInt(0));
                v.setMeiodetransporte_id(meioDeTransporte.getId());
                v.setData(cursor.getString(1));
                v.setInicio(cursor.getString(2));
                v.setFim(cursor.getString(3));
                v.setDistancia(cursor.getFloat(4));
                eventos.add(v);
            }while(cursor.moveToNext());
        }
        cursor = banco.rawQuery(gastosQuery.toString(), new String[]{Integer.toString(meioDeTransporte.getId())
                ,out.format(new Date(dataInicial.getTime())),out.format(new Date(datafinal.getTime()))});
        if(cursor.moveToFirst()){
            do{
                Gasto v = new Gasto();
                v.setId(cursor.getInt(0));
                v.setMeiodetransporte_id(meioDeTransporte.getId());
                v.setData(cursor.getString(1));
                v.setTipo(cursor.getString(2));
                v.setValor(cursor.getFloat(3));
                v.setObservacao(cursor.getString(4));
                eventos.add(v);
            }while(cursor.moveToNext());
        }
        HashMap<String,Float> listaDeGastos = new HashMap<>(eventos.size());
        //Prepara Médias, qtds e totais
        float combustivel = 0;
        for(Evento e : eventos){
            if(e instanceof  Viagem){
                Viagem v = (Viagem) e;
                stats.setQtdViagens(stats.getQtdViagens()+1);
                stats.setTotalDistancia(stats.getTotalDistancia()+v.getDistancia());
            }else{
                Gasto g = (Gasto) e;
                stats.setQtdServicos(stats.getQtdServicos()+1);
                stats.setTotalGastos(stats.getTotalGastos()+ g.getValor());
                if(g.getTipo().equals("Combustível")){
                    combustivel+= g.getValor();
                }
                //Prepara lista de gastos;
                if(g.getValor() != 0){
                    if(listaDeGastos.containsKey(g.getTipo())){
                        listaDeGastos.put(g.getTipo(),listaDeGastos.get(g.getTipo())+g.getValor());
                    }else{
                        listaDeGastos.put(g.getTipo(), g.getValor());
                    }
                }
            }
        }
        //Prepara Proporções
        String consultaTodosViagens = "SELECT SUM(DISTANCIA) FROM VIAGEM WHERE EVENTO_ID <> ?";
        String consultaTodosGastos = "SELECT SUM(VALOR) FROM GASTO WHERE EVENTO_ID <> ?";
        float totalViagens = 0;
        float totalGastos = 0;
        cursor = banco.rawQuery(consultaTodosViagens,new String[]{Integer.toString(meioDeTransporte.getId())});
        if(cursor.moveToFirst()){
            totalViagens = cursor.getFloat(0);
        }
        cursor = banco.rawQuery(consultaTodosGastos,new String[]{Integer.toString(meioDeTransporte.getId())});
        if(cursor.moveToFirst()){
            totalGastos = cursor.getFloat(0);
        }
        //Seta Médias
        stats.setMediaCombustivelPorKm(combustivel/stats.getTotalDistancia());
        stats.setMediaGastosPorKm(stats.getTotalGastos()/stats.getTotalDistancia());
        //Seta Proporções
        stats.setProporcaoGastos(stats.getTotalGastos()*100.0F/totalGastos);
        stats.setProporcaoViagens(stats.getTotalDistancia()*100.0F/totalViagens);
        stats.setDataFinal(datafinal);
        stats.setDataInicial(dataInicial);
        stats.setListaDeGastos(listaDeGastos);
        return stats;
    }

    public EstatisticasGeral relatorioGeral(Timestamp dataInicial, Timestamp datafinal) {
        //TODO implementar método e retornar este objeto preechido.
        return new EstatisticasGeral();
    }
}
