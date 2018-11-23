package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import move.pdsi.facom.ufu.br.DAO.EventosDAO;
import move.pdsi.facom.ufu.br.model.Evento;
import move.pdsi.facom.ufu.br.move.R;

public class listEventoActivity extends AppCompatActivity {

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
        //TODO Criar um método no EventosDAO buscaEventos() (que inclui viagens e gastos ordenados por data decrescente), Substituir o dao.buscaViagens() da linha abaixo para dao.buscaEventos() quando for criado
        recyclerView.setAdapter(new EventoAdapter(dao.buscaViagens(), new EventoAdapter.OnEventoClickListener(){
            @Override
            public void onItemClick(Evento item) {
                Intent intent = new Intent(getApplicationContext(), readEventoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("item2", item);
                startActivity(intent);
            }
        } ,getApplicationContext()));
    }

    /**
     * Chamada ao clicar no botão de Eventos
     */
    public void addEvento(View view) {
        Intent intent = new Intent(this, addEventoViagemActivity.class);
        startActivity(intent);
    }
}
