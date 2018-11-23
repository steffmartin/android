package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import move.pdsi.facom.ufu.br.DAO.EventosDAO;
import move.pdsi.facom.ufu.br.DAO.MeiosDeTransporteDAO;
import move.pdsi.facom.ufu.br.model.Alugado;
import move.pdsi.facom.ufu.br.model.Compartilhado;
import move.pdsi.facom.ufu.br.model.Evento;
import move.pdsi.facom.ufu.br.model.Gasto;
import move.pdsi.facom.ufu.br.model.MeioDeTransporte;
import move.pdsi.facom.ufu.br.model.Particular;
import move.pdsi.facom.ufu.br.model.Publico;
import move.pdsi.facom.ufu.br.model.Viagem;
import move.pdsi.facom.ufu.br.move.R;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class readEventoActivity extends AppCompatActivity {

    EventosDAO dao;
    MeiosDeTransporteDAO meiosDeTransporteDAO;
    Evento item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_evento);
        dao = new EventosDAO(getApplicationContext());

        meiosDeTransporteDAO = new MeiosDeTransporteDAO(getApplicationContext());

        Intent intent = getIntent();
        item = (Evento) intent.getSerializableExtra("item2");

        ImageView avatar = (ImageView) findViewById(R.id.readAvatar2);
        TextView avatar_text = (TextView) findViewById(R.id.readAvatar_text2);
        TextView linha1 = (TextView) findViewById(R.id.readEventoTipo);
        TextView linha2 = (TextView) findViewById(R.id.readEventoMeioTransporte);
        TextView data = (TextView) findViewById(R.id.readEventoData);
        TextView labelCampo1 = (TextView) findViewById(R.id.readEventoCampo1Label);
        TextView campo1 = (TextView) findViewById(R.id.readEventoCampo1);
        TextView labelCampo2 = (TextView) findViewById(R.id.readEventoCampo2Label);
        TextView campo2 = (TextView) findViewById(R.id.readEventoCampo2);
        TextView labelCampo3 = (TextView) findViewById(R.id.readEventoCampo3Label);
        TextView campo3 = (TextView) findViewById(R.id.readEventoCampo3);

        if (item instanceof Viagem) {
            avatar.setBackgroundTintList(ColorStateList.valueOf(GREEN));
            avatar_text.setText("V");

            Viagem viagem = (Viagem) item;

            linha1.setText("Viagem");
            campo1.setText(viagem.getDistancia() + " Km");
            campo2.setText(viagem.getInicio());
            campo3.setText(viagem.getFim());

            if (meiosDeTransporteDAO.buscaMeioDeTransporte(viagem.getMeioDeTransporteID()) != null) {
                linha2.setText(meiosDeTransporteDAO.buscaMeioDeTransporte(viagem.getMeioDeTransporteID()).toString());
            }


        } else if (item instanceof Gasto) {
            avatar.setBackgroundTintList(ColorStateList.valueOf(RED));
            avatar_text.setText("$");

            Gasto gasto = (Gasto) item;

            linha1.setText("Gasto");
            labelCampo1.setText("R$");
            campo1.setText(gasto.getValor() + "");
            labelCampo2.setText("Categoria");
            campo2.setText(gasto.getTipo());
            labelCampo3.setText("Descrição");
            campo3.setText(gasto.getObservacao());

            if (meiosDeTransporteDAO.buscaMeioDeTransporte(gasto.getMeioDeTransporteID()) != null) {
                linha2.setText(meiosDeTransporteDAO.buscaMeioDeTransporte(gasto.getMeioDeTransporteID()).toString());
            }

        }

    }

    public void editar(View view) {
        Intent intent;
        if (item instanceof Viagem) {
            intent = new Intent(this, addEventoViagemActivity.class);
        } else {
            //Gasto
            intent = new Intent(this, addEventoDespesaActivity.class);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("data", item.getData());
        intent.putExtra("item", item);
        startActivity(intent);
        finish();

    }

    public void excluir(View view) {
        //TODO Implementar método de excluir no DAO de eventos (despesa e viagem)
        //dao.excluir(item.getId());
    }

}
