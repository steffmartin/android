package move.pdsi.facom.ufu.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import move.pdsi.facom.ufu.br.model.Viagem;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class EventosDAO {
    private CriaBanco db;
    private Context mContext;

    public EventosDAO(Context context){
        this.db = new CriaBanco(context);
        this.mContext = context;
    }

    private void adicionaViagem(String inicio, String fim, float distancia, int id){
        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.KEY_INICIO, inicio);
        valores.put(CriaBanco.KEY_FIM, fim);
        valores.put(CriaBanco.KEY_DISTANCIA, distancia);
        valores.put(CriaBanco.KEY_MEIODETRANSPORTEID, id);

        SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
        long erro = banco.insert(CriaBanco.TABELA_VIAGEM, null, valores);

        if (erro != -1L) {
            Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }
    }
}
