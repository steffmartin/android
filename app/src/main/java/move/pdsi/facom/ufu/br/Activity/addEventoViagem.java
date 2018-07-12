package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import move.pdsi.facom.ufu.br.DAO.EventosDAO;
import move.pdsi.facom.ufu.br.DAO.MeiosDeTransporteDAO;
import move.pdsi.facom.ufu.br.model.MeioDeTransporte;
import move.pdsi.facom.ufu.br.move.R;

public class addEventoViagem extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    MeiosDeTransporteDAO daoMeioTransporte;
    EventosDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_evento_viagem);
        daoMeioTransporte = new MeiosDeTransporteDAO(getApplicationContext());
        dao = new EventosDAO(getApplicationContext());

        Intent intent = getIntent();
        String distancia = intent.getStringExtra("distancia");
        EditText editText = (EditText) findViewById(R.id.distanciaEvento);
        editText.setText(distancia);

        Spinner tipoEventosSpinner = (Spinner) findViewById(R.id.tipoEventosSpinner);
        tipoEventosSpinner.setSelection(0);
        tipoEventosSpinner.setOnItemSelectedListener(this);

        Spinner meioTransporteEventoSpinner = (Spinner) findViewById(R.id.meioTransporteEventoSpinner);

        List<MeioDeTransporte> listaMeios = daoMeioTransporte.buscaMeiosDeTransporte();
        ArrayAdapter<MeioDeTransporte> adapter =
                new ArrayAdapter<MeioDeTransporte>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, listaMeios);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        meioTransporteEventoSpinner.setAdapter(adapter);
    }

    /**
     * Chamada ao clicar no botão de Salvar
     */
    public void salvar(View view) {
        String horaInicial = ((EditText) findViewById(R.id.horaInicial)).getText().toString();
        String horaFinal = ((EditText) findViewById(R.id.horaFinal)).getText().toString();
        String dataEvento = ((EditText) findViewById(R.id.dataEvento)).getText().toString();
        String distanciaEvento = ((EditText) findViewById(R.id.distanciaEvento)).getText().toString();
        String meioTransporteEventoSpinner = ((Spinner) findViewById(R.id.meioTransporteEventoSpinner)).getSelectedItem().toString();
        if (horaInicial.equals("") || horaFinal.equals("") || dataEvento.equals("") || distanciaEvento.equals("") || meioTransporteEventoSpinner.equals("")) {
            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            dao.adicionaViagem(horaInicial, horaFinal, Float.parseFloat(distanciaEvento), daoMeioTransporte.buscaID(meioTransporteEventoSpinner.split(" - ")[1]));
            finish();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getItemAtPosition(position).toString()) {
            case "Despesa": {
                Intent intent = new Intent(this, addEventoDespesa.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
