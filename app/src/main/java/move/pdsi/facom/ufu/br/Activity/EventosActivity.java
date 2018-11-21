package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import move.pdsi.facom.ufu.br.DAO.EventosDAO;
import move.pdsi.facom.ufu.br.model.Evento;
import move.pdsi.facom.ufu.br.model.MeioDeTransporte;
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
        //TODO @Gabriel, fazer um método no EventosDAO buscaGastos() e outro buscaEventos() (que inclui viagens e gastos ordenados por data decrescente)
        recyclerView.setAdapter(new EventoAdapter(dao.buscaViagens(), new EventoAdapter.OnEventoClickListener(){//TODO Substituir o dao.buscaViagens() da linha abaixo para dao.buscaEventos() quando for criado
            @Override
            public void onItemClick(Evento item) {
                //TODO @Steffan chamar a tela de visualizar evento aqui
                Toast.makeText(getApplicationContext(), "Item clicado:" + item.getId(), Toast.LENGTH_SHORT).show(); //Só teste
            }
        } ,getApplicationContext()));
    }

    /**
     * Chamada ao clicar no botão de Eventos
     */
    public void addEvento(View view) {
        Intent intent = new Intent(this, addEventoViagem.class);
        startActivity(intent);
    }
}
