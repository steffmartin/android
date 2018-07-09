package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import move.pdsi.facom.ufu.br.move.R;

public class MeiosDeTransporteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meios_de_transporte);
    }

    /** Chamada ao clicar no botão de Eventos */
    public void addMeioDeTranporte(View view) {
        Intent intent = new Intent(this, addMeioDeTranporte.class);
        startActivity(intent);
    }
}
