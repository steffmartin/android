package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import move.pdsi.facom.ufu.br.move.R;

public class EventosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
    }

    /**
     * Chamada ao clicar no botão de Eventos
     */
    public void addEvento(View view) {
        Intent intent = new Intent(this, addEvento.class);
        startActivity(intent);
    }
}
