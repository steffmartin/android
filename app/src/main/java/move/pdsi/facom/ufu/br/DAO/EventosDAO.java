package move.pdsi.facom.ufu.br.DAO;

import android.content.Context;

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


}
