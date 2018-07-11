package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import move.pdsi.facom.ufu.br.model.Alugado;
import move.pdsi.facom.ufu.br.model.MeioDeTransporte;
import move.pdsi.facom.ufu.br.move.R;

public class addEventoViagem extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_evento_viagem);

        Spinner tipoEventosSpinner = (Spinner) findViewById(R.id.tipoEventosSpinner);
        tipoEventosSpinner.setSelection(0);
        tipoEventosSpinner.setOnItemSelectedListener(this);

        Spinner meioTransporteEventoSpinner = (Spinner) findViewById(R.id.meioTransporteEventoSpinner);
        //TODO Trocar este pedaço pelo array verdadeiro e apagar o FOR
        ArrayList<MeioDeTransporte> listaMeios = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listaMeios.add(new MeioDeTransporte("Carro "+i));
        }
        ArrayAdapter<MeioDeTransporte> adapter =
                new ArrayAdapter<MeioDeTransporte>(getApplicationContext(),  android.R.layout.simple_spinner_dropdown_item, listaMeios);
        adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        meioTransporteEventoSpinner.setAdapter(adapter);
    }

    /**
     * Chamada ao clicar no botão de Salvar
     */
    public void salvar(View view) {
        //TODO método para salvar
        //Após salvar, volta para tela de listagem
        finish();
        Toast.makeText(this, "Viagem registrada com sucesso!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getItemAtPosition(position).toString()){
            case "Despesa":{
                Intent intent = new Intent(this, addEventoDespesa.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION |Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
                break;
            }
            default:break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
