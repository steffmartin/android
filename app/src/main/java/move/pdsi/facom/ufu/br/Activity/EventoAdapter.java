package move.pdsi.facom.ufu.br.Activity;

import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import move.pdsi.facom.ufu.br.model.Evento;
import move.pdsi.facom.ufu.br.model.Gasto;
import move.pdsi.facom.ufu.br.model.Viagem;
import move.pdsi.facom.ufu.br.move.R;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class EventoAdapter extends RecyclerView.Adapter<TwoLineViewHolder> {

    private final List<Evento> lista;

    public EventoAdapter(List<Evento> lista){
        this.lista = lista;
    }
    @Override
    public TwoLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TwoLineViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.two_line_view_with_avatar, parent, false));
    }

    @Override
    public void onBindViewHolder(TwoLineViewHolder holder, int position) {
        Evento item = lista.get(position);

        if (item instanceof Viagem){
            holder.avatar.setBackgroundTintList(ColorStateList.valueOf(GREEN));
            holder.avatar_text.setText("V");

            Viagem it = (Viagem) item;

            String linha1 = "Viagem de ";
            linha1 += String.format("%1$,.2f", it.getDistancia());
            linha1 += " Km";
            holder.linha1.setText(linha1);

            //TODO pegar carro pelo ID e colocar a descrição
            holder.linha2.setText("Descrição do Carro");

        } else if(item instanceof Gasto){
            holder.avatar.setBackgroundTintList(ColorStateList.valueOf(RED));
            holder.avatar_text.setText("G");

            String linha1 = "Gasto de R$";
            linha1 += String.format("%1$,.2f", 0);
            holder.linha1.setText(linha1);

            holder.linha2.setText("Descrição do Gasto");
        }
    }

    @Override
    public int getItemCount() {
        return lista != null ? lista.size() : 0;
    }
}
