package move.pdsi.facom.ufu.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    private static String query = null;

    private CriaBancoCompleto db;
    private Context mContext;

    public MeiosDeTransporteDAO(Context context) {
        this.db = new CriaBancoCompleto(context);
        this.mContext = context;
        if(MeiosDeTransporteDAO.query == null){
            try{
                BufferedReader q = new BufferedReader(new InputStreamReader( this.mContext.getAssets().open("MeioDeTransporteQuery.sql") ) );
                String entrada;
                while( (entrada = q.readLine()) != null){
                    query+= entrada;
                }
            }catch(IOException ex){
                Toast.makeText(mContext, "Falha ao ler arquivo de recurso.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public long adicionaMeioDeTransporte(String descricao, String tipo) {
        ContentValues valores = new ContentValues();
        valores.put(CriaBancoCompleto.MEIODETRANSPORTE_DESCRICAO, descricao);
        valores.put(CriaBancoCompleto.MEIODETRANSPORTE_TIPO, tipo);

        SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
        long id = banco.insert(CriaBancoCompleto.TABELA_MEIODETRANSPORTE, null, valores);

        if (id == -1L) {
            //colocar log aqui caso haja erros
        }
        banco.close();
        return id;
    }

    public int buscaID(String descricao) {
        int id;
        String busca = "SELECT id FROM MeioDeTransporte WHERE descricao LIKE '%" + descricao + "%'";
        SQLiteDatabase banco = db.getInstance(mContext).getReadableDatabase();
        Cursor cursor = banco.rawQuery(busca, null);
        cursor.moveToFirst();
        id = cursor.getInt(0);
        cursor.close();
        banco.close();
        return id;
    }

    public MeioDeTransporte buscaMeioDeTransporte(int id) {
        SQLiteDatabase banco = db.getInstance(mContext).getReadableDatabase();
        Cursor cursor;
        String particular = "SELECT * FROM Particular WHERE meiodetransporte_id = " + id;
        String alugado = "SELECT * FROM Alugado WHERE meiodetransporte_id = " + id;
        String compartilhado = "SELECT * FROM Compartilhado WHERE meiodetransporte_id = " + id;
        String publico = "SELECT * FROM Publico WHERE meiodetransporte_id = " + id;
        MeioDeTransporte m = null;
        cursor = banco.rawQuery(MeiosDeTransporteDAO.query+id, null);
        if(cursor.moveToFirst()){
            m = new MeioDeTransporte(cursor.getInt(0),cursor.getString(1));
            m.setTipo(cursor.getString(2));
        }
        cursor = banco.rawQuery(particular, null);
        if (cursor.moveToFirst()) {
            Particular p = new Particular();
            p.setId(id);
            p.setDescricaoP(m.getDescricao());
            p.setTipo(m.getTipo());
            p.setMarca(cursor.getString(1));
            p.setModelo(cursor.getString(2));
            p.setCor(cursor.getString(3));
            return p;
        }
        cursor = banco.rawQuery(alugado, null);
        if (cursor.moveToFirst()) {
            Alugado a = new Alugado();
            a.setId(id);
            a.setDescricao(m.getDescricao());
            a.setTipo(m.getTipo());
            a.setLocadora(cursor.getString(1));
            a.setMarca(cursor.getString(2));
            a.setModelo(cursor.getString(3));
            a.setCor(cursor.getString(4));
            return a;
        }
        cursor = banco.rawQuery(compartilhado, null);
        if (cursor.moveToFirst()) {
            Compartilhado c = new Compartilhado();
            c.setId(id);
            c.setDescricaoC(m.getDescricao());
            c.setTipo(m.getTipo());
            c.setEmpresa(cursor.getString(1));
            return c;
        }
        cursor = banco.rawQuery(publico, null);
        if (cursor.moveToFirst()) {
            Publico pub = new Publico();
            pub.setId(id);
            pub.setDescricaoPub(m.getDescricao());
            pub.setTipo(m.getTipo());
            pub.setEmpresa(cursor.getString(1));
            return pub;
        }
        return null;
    }

    public List<MeioDeTransporte> buscaMeiosDeTransporte() {
        List<MeioDeTransporte> lista = new ArrayList<MeioDeTransporte>();
        String particularSQL = "SELECT * FROM PARTICULAR";
        String alugadoSQL = "SELECT * FROM ALUGADO";
        String compartilhadoSQL = "SELECT * FROM COMPARTILHADO";
        String publicoSQL = "SELECT * FROM PUBLICO";
        SQLiteDatabase banco = db.getInstance(mContext).getReadableDatabase();

        //Incluir todos Meios de Transporte Particulares
        Cursor particular = banco.rawQuery(particularSQL, null);
        if (particular.moveToFirst()) {
            do {
                Particular p = new Particular();
                p.setId(particular.getInt(0));
                p.setMarca(particular.getString(1));
                p.setModelo(particular.getString(2));
                p.setCor(particular.getString(3));
                lista.add(p);
            } while (particular.moveToNext());
        }
        particular.close();

        //Incluir todos Meios de Transporte Alugados
        Cursor alugado = banco.rawQuery(alugadoSQL, null);
        if (alugado.moveToFirst()) {
            do {
                Alugado a = new Alugado();
                a.setId(alugado.getInt(0));
                a.setLocadora(alugado.getString(1));
                a.setMarca(alugado.getString(2));
                a.setModelo(alugado.getString(3));
                a.setCor(alugado.getString(4));
                lista.add(a);
            } while (alugado.moveToNext());
        }
        alugado.close();

        //Incluir todos Meios de Transporte Compartilhados
        Cursor compartilhado = banco.rawQuery(compartilhadoSQL, null);
        if (compartilhado.moveToFirst()) {
            do {
                Compartilhado c = new Compartilhado();
                c.setId(compartilhado.getInt(0));
                c.setEmpresa(compartilhado.getString(1));
                lista.add(c);
            } while (compartilhado.moveToNext());
        }
        compartilhado.close();

        //Incluir todos Meios de Transporte Públicos
        Cursor publico = banco.rawQuery(publicoSQL, null);
        if (publico.moveToFirst()) {
            do {
                Publico pub = new Publico();
                pub.setId(publico.getInt(0));
                pub.setEmpresa(publico.getString(1));
                lista.add(pub);
            } while (publico.moveToNext());
        }
        publico.close();

        banco.close();
        db.close();
        return lista;
    }

    public void adicionaParticular(String descricao, String tipo, String marca, String modelo, String cor) {
        long err = adicionaMeioDeTransporte(descricao, tipo);
        if (err != -1L) {
            ContentValues valores = new ContentValues();
            valores.put(CriaBancoCompleto.PARTICULAR_MEIODETRANSPORTE_ID,err);
            valores.put(CriaBancoCompleto.PARTICULAR_MARCA, marca);
            valores.put(CriaBancoCompleto.PARTICULAR_MODELO, modelo);
            valores.put(CriaBancoCompleto.PARTICULAR_MODELO, cor);

            SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
            long erro = banco.insert(CriaBancoCompleto.TABELA_PARTICULAR, null, valores);

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

    public void adicionaAlugado(String descricao, String tipo, String locadora, String marca, String modelo, String cor) {
        long err = adicionaMeioDeTransporte(descricao, tipo);
        if (err != -1L) {
            ContentValues valores = new ContentValues();
            valores.put(CriaBancoCompleto.ALUGADO_MEIODETRANSPORTE_ID,err);
            valores.put(CriaBancoCompleto.ALUGADO_LOCADORA, locadora);
            valores.put(CriaBancoCompleto.ALUGADO_MARCA, marca);
            valores.put(CriaBancoCompleto.ALUGADO_MODELO, modelo);
            valores.put(CriaBancoCompleto.ALUGADO_COR, cor);

            SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
            long erro = banco.insert(CriaBancoCompleto.TABELA_ALUGADO, null, valores);

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

    public void adicionaCompartilhado(String descricao, String tipo, String empresa) {
        long err = adicionaMeioDeTransporte(descricao, tipo);
        if (err != -1L) {
            ContentValues valores = new ContentValues();
            valores.put(CriaBancoCompleto.COMPARTILHADO_MEIODETRANSPORTE_ID,err);
            valores.put(CriaBancoCompleto.COMPARTILHADO_EMPRESA, empresa);

            SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
            long erro = banco.insert(CriaBancoCompleto.TABELA_COMPARTILHADO, null, valores);

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

    public void adicionaPublico(String descricao, String tipo, String empresa) {
        long err = adicionaMeioDeTransporte(descricao, tipo);
        if (err != -1L) {
            ContentValues valores = new ContentValues();
            valores.put(CriaBancoCompleto.PUBLICO_MEIODETRANSPORTE_ID, err);
            valores.put(CriaBancoCompleto.PUBLICO_EMPRESA, empresa);

            SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
            long erro = banco.insert(CriaBancoCompleto.TABELA_PUBLICO, null, valores);

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