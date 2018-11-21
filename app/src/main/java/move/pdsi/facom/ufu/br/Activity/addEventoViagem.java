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

        if (daoMeioTransporte.buscaMeiosDeTransporte().size() > 0) {

            Spinner tipoEventosSpinner = (Spinner) findViewById(R.id.tipoEventosSpinner);
            tipoEventosSpinner.setSelection(0);
            tipoEventosSpinner.setOnItemSelectedListener(this);

            Spinner meioTransporteEventoSpinner = (Spinner) findViewById(R.id.meioTransporteEventoSpinner);

            List<MeioDeTransporte> listaMeios = daoMeioTransporte.buscaMeiosDeTransporte();
            ArrayAdapter<MeioDeTransporte> adapter =
                    new ArrayAdapter<MeioDeTransporte>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, listaMeios);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            meioTransporteEventoSpinner.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Ainda não há nenhum Meio de Transporte cadastrado!", Toast.LENGTH_SHORT).show();
            finish();
        }
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
            try {
                //TODO @Gabriel corrigir método de adicionaViagem do EventosDAO pois não está salvando a DATA
                dao.adicionaViagem(horaInicial, horaFinal, Float.parseFloat(distanciaEvento.replace(",", ".")), daoMeioTransporte.buscaID(meioTransporteEventoSpinner.split(" - ")[1]));
                finish();
                Toast.makeText(this, "Evento registrado com sucesso!", Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Informe apenas números na distância e não coloque separação de milhares.", Toast.LENGTH_SHORT).show();
            }
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
