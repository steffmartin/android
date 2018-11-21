package move.pdsi.facom.ufu.br.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import move.pdsi.facom.ufu.br.model.Evento;
import move.pdsi.facom.ufu.br.model.Viagem;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class EventosDAO {
    private CriaBanco db;
    private Context mContext;

    public EventosDAO(Context context) {
        this.db = new CriaBanco(context);
        this.mContext = context;
    }

    public void adicionaViagem(String inicio, String fim, float distancia, int meioDeTransporteID) {
        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.KEY_INICIO, inicio);
        valores.put(CriaBanco.KEY_FIM, fim);
        valores.put(CriaBanco.KEY_DISTANCIA, distancia);
        valores.put(CriaBanco.KEY_MEIODETRANSPORTEID, meioDeTransporteID);

        SQLiteDatabase banco = db.getInstance(mContext).getWritableDatabase();
        long erro = banco.insert(CriaBanco.TABELA_VIAGEM, null, valores);

        if (erro != -1L) {
            Toast.makeText(mContext, "Dados salvos", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mContext, "Erro ao inserir dado no banco", Toast.LENGTH_LONG).show();
        }
        banco.close();
    }

    public List<Evento> buscaViagens() {
        List<Evento> lista = new ArrayList<Evento>();
        String busca = "SELECT * FROM Viagem";
        SQLiteDatabase banco = db.getInstance(mContext).getReadableDatabase();

        Cursor buscar = banco.rawQuery(busca, null);
        if (buscar.moveToFirst()) {
            do {
                Viagem v = new Viagem();
                v.setId(buscar.getInt(0));
                v.setInicio(buscar.getString(1));
                v.setFim(buscar.getString(2));
                v.setDistancia(buscar.getFloat(3));
                v.setMeioDeTransporteID(buscar.getInt(4));
                lista.add(v);
            } while (buscar.moveToNext());
        }
        buscar.close();
        banco.close();
        return lista;
    }
}