package move.pdsi.facom.ufu.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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

    private void adicionaParticular(Particular particular){
        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.KEY_DESCRICAO, particular.getDescricao());
        valores.put(CriaBanco.KEY_TIPO, particular.getTipo());
        valores.put(CriaBanco.KEY_MARCA, particular.getMarca());
        valores.put(CriaBanco.KEY_MODELO, particular.getModelo());
        valores.put(CriaBanco.KEY_COR, particular.getCor());
        valores.put(CriaBanco.KEY_MEDIA, particular.getMedia());
        valores.put(CriaBanco.KEY_MAXIMO, particular.getMaximo());
        valores.put(CriaBanco.KEY_MINIMO, particular.getMinimo());

        SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
        long erro = banco.insert(CriaBanco.TABELA_PARTICULAR, null, valores);
        banco.close();

        if (erro == -1L){
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
        }
    }

    private void adicionaAlugado(Alugado alugado){
        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.KEY_DESCRICAO, alugado.getDescricao());
        valores.put(CriaBanco.KEY_TIPO, alugado.getTipo());
        valores.put(CriaBanco.KEY_LOCADORA, alugado.getLocadora());
        valores.put(CriaBanco.KEY_MARCA, alugado.getMarca());
        valores.put(CriaBanco.KEY_MODELO, alugado.getModelo());
        valores.put(CriaBanco.KEY_COR, alugado.getCor());

        SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
        long erro = banco.insert(CriaBanco.TABELA_ALUGADO, null, valores);
        banco.close();

        if (erro == -1L){
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
        }
    }

    private void adicionaCompartilhado(Compartilhado compartilhado){
        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.KEY_DESCRICAO, compartilhado.getDescricao());
        valores.put(CriaBanco.KEY_TIPO, compartilhado.getTipo());
        valores.put(CriaBanco.KEY_EMPRESA, compartilhado.getEmpresa());

        SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
        long erro = banco.insert(CriaBanco.TABELA_COMPARTILHADO, null, valores);
        banco.close();

        if (erro == -1L){
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
        }
    }

    private void adicionaPublico(Publico publico){
        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.KEY_DESCRICAO, publico.getDescricao());
        valores.put(CriaBanco.KEY_TIPO, publico.getTipo());
        valores.put(CriaBanco.KEY_EMPRESA, publico.getEmpresa());

        SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
        long erro = banco.insert(CriaBanco.TABELA_PUBLICO, null, valores);
        banco.close();

        if (erro == -1L){
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
        }
    }
}