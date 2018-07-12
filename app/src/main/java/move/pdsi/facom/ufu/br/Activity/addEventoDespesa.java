package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import move.pdsi.facom.ufu.br.move.R;

public class addEventoDespesa extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_evento_despesa);

        Spinner tipoEventosSpinner2 = (Spinner) findViewById(R.id.tipoEventosSpinner2);
        tipoEventosSpinner2.setSelection(1);

        tipoEventosSpinner2.setOnItemSelectedListener(this);
    }

    /**
     * Chamada ao clicar no botão de Salvar
     */
    public void salvar(View view) {
        //fazer método para salvar
        //Após salvar, volta para tela de listagem
        finish();
        Toast.makeText(this, "Despesa registrada com sucesso!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getItemAtPosition(position).toString()) {
            case "Viagem": {
                Intent intent = new Intent(this, addEventoViagem.class);
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
