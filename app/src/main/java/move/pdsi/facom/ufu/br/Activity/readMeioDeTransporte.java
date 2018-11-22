package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import move.pdsi.facom.ufu.br.DAO.MeiosDeTransporteDAO;
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

public class readMeioDeTransporte extends AppCompatActivity {

    MeiosDeTransporteDAO dao;
    MeioDeTransporte item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_meio_de_transporte);
        dao = new MeiosDeTransporteDAO(getApplicationContext());

        Intent intent = getIntent();
        item = (MeioDeTransporte) intent.getSerializableExtra("item");

        ImageView avatar = (ImageView) findViewById(R.id.readAvatar);
        TextView avatar_text = (TextView) findViewById(R.id.readAvatar_text);
        TextView linha1 = (TextView) findViewById(R.id.readDescricao);
        TextView linha2 = (TextView) findViewById(R.id.readCategoria);
        TextView tipo = (TextView) findViewById(R.id.readTipo);
        TextView marca = (TextView) findViewById(R.id.readMarca);
        TextView modelo = (TextView) findViewById(R.id.readModelo);
        TextView cor = (TextView) findViewById(R.id.readCor);
        TextView locEmpresa = (TextView) findViewById(R.id.readLocEmpresa);

        if (item.getDescricao() != null) {
            linha1.setText(item.getDescricao());
            if (item.getDescricao().length() > 0) {
                avatar_text.setText(item.getDescricao().substring(0, 1).toUpperCase());
            } else {
                avatar_text.setText("");
            }
        } else {
            linha1.setText("");
            avatar_text.setText("");
        }

        if (item instanceof Alugado) {
            linha2.setText("Alugado");
            avatar.setBackgroundTintList(ColorStateList.valueOf(GREEN));
            Alugado alugado = (Alugado) item;
            tipo.setText(alugado.getTipo());
            marca.setText(alugado.getMarca());
            modelo.setText(alugado.getModelo());
            cor.setText(alugado.getCor());
            locEmpresa.setText(alugado.getLocadora());
            TextView labelLocEmpresa = (TextView) findViewById(R.id.readEmpresaLabel);
            labelLocEmpresa.setText("Locadora");
        } else {
            if (item instanceof Publico) {
                linha2.setText("Público");
                avatar.setBackgroundTintList(ColorStateList.valueOf(CYAN));
                Publico publico = (Publico) item;
                tipo.setText(publico.getTipo());
                locEmpresa.setText(publico.getEmpresa());
            } else {
                if (item instanceof Compartilhado) {
                    linha2.setText("Compartilhado");
                    avatar.setBackgroundTintList(ColorStateList.valueOf(RED));
                    Compartilhado compartilhado = (Compartilhado) item;
                    tipo.setText(compartilhado.getTipo());
                    locEmpresa.setText(compartilhado.getEmpresa());
                } else {
                    if (item instanceof Particular) {
                        linha2.setText("Particular");
                        avatar.setBackgroundTintList(ColorStateList.valueOf(YELLOW));
                        Particular particular = (Particular) item;
                        tipo.setText(particular.getTipo());
                        marca.setText(particular.getMarca());
                        modelo.setText(particular.getModelo());
                        cor.setText(particular.getCor());
                    } else {
                        linha2.setText("");
                    }
                }
            }
        }

    }

    public void editar(View view) {
        //TODO após criar tela de edição, implementar este metodo chamando ela
    }

    public void excluir() {
        //TODO @Steffan implementar método de excluir
    }

}
