package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import move.pdsi.facom.ufu.br.DAO.EventosDAO;
import move.pdsi.facom.ufu.br.move.R;

public class EventosActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EventosDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        dao = new EventosDAO(getApplicationContext());

        recyclerView = (RecyclerView) findViewById(R.id.eventosLista);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new EventoAdapter(dao.buscaViagens(), getApplicationContext()));
    }

    /**
     * Chamada ao clicar no botão de Eventos
     */
    public void addEvento(View view) {
        Intent intent = new Intent(this, addEventoViagem.class);
        startActivity(intent);
    }
}
