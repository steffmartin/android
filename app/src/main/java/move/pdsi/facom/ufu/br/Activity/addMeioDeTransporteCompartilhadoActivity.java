package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import move.pdsi.facom.ufu.br.move.R;

public class addMeioDeTransporteCompartilhadoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meio_de_transporte_compartilhado);

        Spinner categoriaSpinnerCompartilhado = (Spinner) findViewById(R.id.categoriaSpinnerCompartilhado);
        categoriaSpinnerCompartilhado.setSelection(3);
        categoriaSpinnerCompartilhado.setOnItemSelectedListener(this);

        Intent intent = getIntent();
        String categoria = intent.getStringExtra("categoria");
        EditText editText = (EditText) findViewById(R.id.descricaoCompartilhado);
        editText.setText(categoria);
    }

    /**
     * Chamada ao clicar no botão de Salvar
     */
    public void salvar(View view) {
        //TODO método para salvar
        //Após salvar, volta para tela de listagem
        finish();
        Toast.makeText(this, "Meio de Transporte Compartilhado adicionado com sucesso!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getItemAtPosition(position).toString()) {
            case "Particular": {
                //Particular
                Intent intent = new Intent(this, addMeioDeTranporteParticularActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION |Intent.FLAG_ACTIVITY_NEW_TASK);
                EditText editText = (EditText) findViewById(R.id.descricaoCompartilhado);
                String message = editText.getText().toString();
                intent.putExtra("categoria", message);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
                break;
            }
            case "Alugado": {
                //Alugado
                Intent intent = new Intent(this, addMeioDeTransporteAlugadoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION |Intent.FLAG_ACTIVITY_NEW_TASK);
                EditText editText = (EditText) findViewById(R.id.descricaoCompartilhado);
                String message = editText.getText().toString();
                intent.putExtra("categoria", message);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
                break;
            }
            case "Público": {
                //Público
                Intent intent = new Intent(this, addMeioDeTransportePublicoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION |Intent.FLAG_ACTIVITY_NEW_TASK);
                EditText editText = (EditText) findViewById(R.id.descricaoCompartilhado);
                String message = editText.getText().toString();
                intent.putExtra("categoria", message);
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
