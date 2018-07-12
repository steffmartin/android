package move.pdsi.facom.ufu.br.Activity;

import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import move.pdsi.facom.ufu.br.model.Alugado;
import move.pdsi.facom.ufu.br.model.Compartilhado;
import move.pdsi.facom.ufu.br.model.MeioDeTransporte;
import move.pdsi.facom.ufu.br.model.Particular;
import move.pdsi.facom.ufu.br.model.Publico;
import move.pdsi.facom.ufu.br.move.R;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

class MeioTransporteAdapter extends RecyclerView.Adapter<MeioTransporteViewHolder> {

    private final List<MeioDeTransporte> lista;

    public MeioTransporteAdapter(List<MeioDeTransporte> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public MeioTransporteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeioTransporteViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.two_line_view_with_avatar, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeioTransporteViewHolder holder, int position) {
        MeioDeTransporte item = lista.get(position);

        if (item.getDescricao() != null) {
            holder.linha1.setText(item.getDescricao());
            if (item.getDescricao().length() > 0) {
                holder.avatar_text.setText(item.getDescricao().substring(0, 1).toUpperCase());
            } else {
                holder.avatar_text.setText("");
            }
        } else {
            holder.linha1.setText("");
            holder.avatar_text.setText("");
        }

        if (item instanceof Alugado) {
            holder.linha2.setText("Alugado");
            holder.avatar.setBackgroundTintList(ColorStateList.valueOf(GREEN));
        } else {
            if (item instanceof Publico) {
                holder.linha2.setText("Público");
                holder.avatar.setBackgroundTintList(ColorStateList.valueOf(CYAN));
            } else {
                if (item instanceof Compartilhado) {
                    holder.linha2.setText("Compartilhado");
                    holder.avatar.setBackgroundTintList(ColorStateList.valueOf(RED));
                } else {
                    if (item instanceof Particular) {
                        holder.linha2.setText("Particular");
                        holder.avatar.setBackgroundTintList(ColorStateList.valueOf(YELLOW));
                    } else {
                        holder.linha2.setText("");
                    }
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return lista != null ? lista.size() : 0;
    }
}
