package move.pdsi.facom.ufu.br.Activity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import move.pdsi.facom.ufu.br.DAO.MeiosDeTransporteDAO;
import move.pdsi.facom.ufu.br.model.Evento;
import move.pdsi.facom.ufu.br.model.Gasto;
import move.pdsi.facom.ufu.br.model.Viagem;
import move.pdsi.facom.ufu.br.move.R;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class EventoAdapter extends RecyclerView.Adapter<TwoLineViewHolder> {

    public interface OnEventoClickListener {
        void onItemClick(Evento item);
    }

    private final List<Evento> lista;
    private final OnEventoClickListener listener;
    private MeiosDeTransporteDAO dao;

    public EventoAdapter(List<Evento> lista, OnEventoClickListener listener, Context context) {
        this.lista = lista;
        this.listener = listener;
        dao = new MeiosDeTransporteDAO(context);
    }

    @Override
    public TwoLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TwoLineViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.two_line_view_with_avatar, parent, false));
    }

    @Override
    public void onBindViewHolder(TwoLineViewHolder holder, int position) {
        final Evento item = lista.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(item);
            }
        });

        if (item instanceof Viagem) {
            holder.avatar.setBackgroundTintList(ColorStateList.valueOf(GREEN));
            holder.avatar_text.setText("V");

            Viagem it = (Viagem) item;

            String linha1 = "Viagem de ";
            linha1 += String.format("%1$,.2f", it.getDistancia());
            linha1 += " Km";
            holder.linha1.setText(linha1);

            if (dao.buscaMeioDeTransporte(it.getMeioDeTransporteID()) != null) {
                holder.linha2.setText(dao.buscaMeioDeTransporte(it.getMeioDeTransporteID()).toString());
            }

        } else if (item instanceof Gasto) {
            holder.avatar.setBackgroundTintList(ColorStateList.valueOf(RED));
            holder.avatar_text.setText("$");

            Gasto it = (Gasto) item;

            String linha1 = "Gasto de R$";
            linha1 += String.format("%1$,.2f", it.getValor());
            holder.linha1.setText(linha1);

            if (dao.buscaMeioDeTransporte(it.getMeioDeTransporteID()) != null) {
                holder.linha2.setText(dao.buscaMeioDeTransporte(it.getMeioDeTransporteID()).toString());
            }
        }
    }

    @Override
    public int getItemCount() {
        return lista != null ? lista.size() : 0;
    }
}
