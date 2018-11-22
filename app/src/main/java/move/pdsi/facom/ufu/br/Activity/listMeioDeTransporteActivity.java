package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import move.pdsi.facom.ufu.br.DAO.MeiosDeTransporteDAO;
import move.pdsi.facom.ufu.br.model.MeioDeTransporte;
import move.pdsi.facom.ufu.br.move.R;

public class listMeioDeTransporteActivity extends AppCompatActivity {

    MeiosDeTransporteDAO dao;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meios_de_transporte);
        dao = new MeiosDeTransporteDAO(getApplicationContext());

        recyclerView = (RecyclerView) findViewById(R.id.listaDeMeiosTransporte);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MeioTransporteAdapter(dao.buscaMeiosDeTransporte(), new MeioTransporteAdapter.OnMeioDeTransporteClickListener() {
            @Override
            public void onItemClick(MeioDeTransporte item) {
                Intent intent = new Intent(getApplicationContext(), readMeioDeTransporteActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("item", item);
                startActivity(intent);
            }
        }));
    }

    /**
     * Chamada ao clicar no botão de Eventos
     */
    public void addMeioDeTranporte(View view) {
        Intent intent = new Intent(this, addMeioDeTranporteParticularActivity.class);
        startActivity(intent);
    }

}
