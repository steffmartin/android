package move.pdsi.facom.ufu.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import move.pdsi.facom.ufu.br.model.Alugado;
import move.pdsi.facom.ufu.br.model.Compartilhado;
import move.pdsi.facom.ufu.br.model.MeioDeTransporte;
import move.pdsi.facom.ufu.br.model.Particular;
import move.pdsi.facom.ufu.br.model.Publico;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class MeiosDeTransporteDAO {
    private CriaBanco db;
    private Context mContext;

    public MeiosDeTransporteDAO(Context context){
        this.db = new CriaBanco(context);
        this.mContext = context;
    }

    private long adicionaMeioDeTransporte(String descricao){
        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.KEY_DESCRICAO, descricao);

        SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
        long id = banco.insert(CriaBanco.TABELA_MEIODETRANSPORTE, null, valores);

        if (id == -1L) {
            //colocar log aqui caso haja erros
        }
        banco.close();
        return id;
    }

    private int buscaID(String descricao){
        int id;
        String busca = "SELECT _id FROM MeioDeTransporte WHERE descricao = '" + descricao + "'";
        SQLiteDatabase banco = db.getInstance(mContext).getReadableDatabase();

        Cursor cursor = banco.rawQuery(busca, null);
        cursor.moveToFirst();
        id = cursor.getInt(0);
        cursor.close();
        banco.close();
        return id;
    }

    private List<MeioDeTransporte> buscaMeiosDeTransporte(){
        List<MeioDeTransporte> lista = new ArrayList<MeioDeTransporte>();
        String particularSQL = "SELECT * FROM PARTICULAR";
        String alugadoSQL = "SELECT * FROM ALUGADO";
        String compartilhadoSQL = "SELECT * FROM COMPARTILHADO";
        String publicoSQL = "SELECT * FROM PUBLICO";
        SQLiteDatabase banco = db.getInstance(mContext).getReadableDatabase();

        //Incluir todos Meios de Transporte Particulares
        Cursor particular = banco.rawQuery(particularSQL, null);
        if(particular.moveToFirst()){
            do{
               Particular p = new Particular();
               p.setId(particular.getInt(0));
               p.setDescricaoP(particular.getString(1));
               p.setTipo(particular.getString(2));
               p.setMarca(particular.getString(3));
               p.setModelo(particular.getString(4));
               p.setCor(particular.getString(5));
               p.setMedia(particular.getFloat(6));
               p.setMaximo(particular.getFloat(7));
               p.setMinimo(particular.getFloat(8));
               lista.add(p);
            }while(particular.moveToNext());
        }
        particular.close();

        //Incluir todos Meios de Transporte Alugados
        Cursor alugado = banco.rawQuery(alugadoSQL, null);
        if(alugado.moveToFirst()){
            do{
                Alugado a = new Alugado();
                a.setId(alugado.getInt(0));
                a.setDescricaoA(alugado.getString(1));
                a.setTipo(alugado.getString(2));
                a.setLocadora(alugado.getString(3));
                a.setMarca(alugado.getString(4));
                a.setModelo(alugado.getString(5));
                a.setCor(alugado.getString(6));
                lista.add(a);
            }while(alugado.moveToNext());
        }
        alugado.close();

        //Incluir todos Meios de Transporte Compartilhados
        Cursor compartilhado = banco.rawQuery(compartilhadoSQL, null);
        if(compartilhado.moveToFirst()){
            do{
                Compartilhado c = new Compartilhado();
                c.setId(compartilhado.getInt(0));
                c.setDescricaoC(compartilhado.getString(1));
                c.setTipo(compartilhado.getString(2));
                c.setEmpresa(compartilhado.getString(3));
                lista.add(c);
            }while(compartilhado.moveToNext());
        }
        compartilhado.close();

        //Incluir todos Meios de Transporte Públicos
        Cursor publico = banco.rawQuery(publicoSQL, null);
        if(publico.moveToFirst()){
            do{
                Publico pub = new Publico();
                pub.setId(publico.getInt(0));
                pub.setDescricaoPub(publico.getString(1));
                pub.setTipo(publico.getString(2));
                pub.setEmpresa(publico.getString(3));
                lista.add(pub);
            }while(compartilhado.moveToNext());
        }
        publico.close();

        banco.close();
        db.close();
        return lista;
    }

    private void adicionaParticular(String descricao, String tipo, String marca, String modelo,
                                    String cor, float media, float maximo, float minimo){
        long err = adicionaMeioDeTransporte(descricao);
        if(err != -1L) {
            ContentValues valores = new ContentValues();
            valores.put(CriaBanco.KEY_DESCRICAO, descricao);
            valores.put(CriaBanco.KEY_TIPO, tipo);
            valores.put(CriaBanco.KEY_MARCA, marca);
            valores.put(CriaBanco.KEY_MODELO, modelo);
            valores.put(CriaBanco.KEY_COR, cor);
            valores.put(CriaBanco.KEY_MEDIA, media);
            valores.put(CriaBanco.KEY_MAXIMO, maximo);
            valores.put(CriaBanco.KEY_MINIMO, minimo);

            SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
            long erro = banco.insert(CriaBanco.TABELA_PARTICULAR, null, valores);

            if (erro != -1L) {
                Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
            }
            banco.close();
            db.close();
        } else {
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }
    }

    private void adicionaAlugado(String descricao, String tipo, String locadora, String marca,
                                 String modelo, String cor){
        long err = adicionaMeioDeTransporte(descricao);
        if(err != -1L) {
            ContentValues valores = new ContentValues();
            valores.put(CriaBanco.KEY_MEIODETRANSPORTEID, err);
            valores.put(CriaBanco.KEY_DESCRICAO, descricao);
            valores.put(CriaBanco.KEY_TIPO, tipo);
            valores.put(CriaBanco.KEY_LOCADORA, locadora);
            valores.put(CriaBanco.KEY_MARCA, marca);
            valores.put(CriaBanco.KEY_MODELO, modelo);
            valores.put(CriaBanco.KEY_COR, cor);

            SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
            long erro = banco.insert(CriaBanco.TABELA_ALUGADO, null, valores);

            if (erro != -1L) {
                Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
            }
            banco.close();
            db.close();
        } else {
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }
    }

    private void adicionaCompartilhado(String descricao, String tipo, String empresa){
        long err = adicionaMeioDeTransporte(descricao);
        if(err != -1L) {
            ContentValues valores = new ContentValues();
            valores.put(CriaBanco.KEY_DESCRICAO, descricao);
            valores.put(CriaBanco.KEY_TIPO, tipo);
            valores.put(CriaBanco.KEY_EMPRESA, empresa);

            SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
            long erro = banco.insert(CriaBanco.TABELA_COMPARTILHADO, null, valores);

            if (erro != -1L) {
                Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
            }
            banco.close();
            db.close();
        } else {
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }
    }

    private void adicionaPublico(String descricao, String tipo, String empresa){
        long err = adicionaMeioDeTransporte(descricao);
        if(err != -1L) {
            ContentValues valores = new ContentValues();
            valores.put(CriaBanco.KEY_DESCRICAO, descricao);
            valores.put(CriaBanco.KEY_TIPO, tipo);
            valores.put(CriaBanco.KEY_EMPRESA, empresa);

            SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
            long erro = banco.insert(CriaBanco.TABELA_PUBLICO, null, valores);

            if (erro != -1L) {
                Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
            }
            banco.close();
            db.close();
        } else {
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }
    }
}