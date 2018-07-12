package move.pdsi.facom.ufu.br.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import move.pdsi.facom.ufu.br.move.R;

public class MeioTransporteViewHolder extends RecyclerView.ViewHolder {

    final ImageView avatar;
    final TextView avatar_text;
    final TextView linha1;
    final TextView linha2;


    public MeioTransporteViewHolder(View view) {
        super(view);
        avatar = (ImageView) view.findViewById(R.id.avatar);
        avatar_text = (TextView) view.findViewById(R.id.avatar_text);
        linha1 = (TextView) view.findViewById(R.id.linha1);
        linha2 = (TextView) view.findViewById(R.id.linha2);
    }
}
