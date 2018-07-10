package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import move.pdsi.facom.ufu.br.move.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Chamada ao clicar no botão de Banco de Dados
     */
    public void criarBD(View view) {
        //TODO chamar método para criar BD
    }

    /**
     * Chamada ao clicar no botão de Meios de Transporte
     */
    public void gerenciarMeios(View view) {
        Intent intent = new Intent(this, MeiosDeTransporteActivity.class);
        startActivity(intent);
    }

    /**
     * Chamada ao clicar no botão de Eventos
     */
    public void gerenciarEventos(View view) {
        Intent intent = new Intent(this, EventosActivity.class);
        startActivity(intent);
    }
}
