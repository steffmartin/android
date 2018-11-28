package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import move.pdsi.facom.ufu.br.DAO.MeiosDeTransporteDAO;
import move.pdsi.facom.ufu.br.model.Alugado;
import move.pdsi.facom.ufu.br.model.Compartilhado;
import move.pdsi.facom.ufu.br.model.MeioDeTransporte;
import move.pdsi.facom.ufu.br.model.Particular;
import move.pdsi.facom.ufu.br.model.Publico;
import move.pdsi.facom.ufu.br.move.R;

public class addMeioDeTransportePublicoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    MeiosDeTransporteDAO dao;
    MeioDeTransporte item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meio_de_transporte_publico);
        dao = new MeiosDeTransporteDAO(getApplicationContext());

        Spinner categoriaSpinnerPublico = (Spinner) findViewById(R.id.categoriaSpinnerPublico);
        categoriaSpinnerPublico.setSelection(2);
        categoriaSpinnerPublico.setOnItemSelectedListener(this);

        Intent intent = getIntent();
        String descricao = intent.getStringExtra("descricao");
        EditText editText = (EditText) findViewById(R.id.descricaoPublico);
        editText.setText(descricao);

        item = (MeioDeTransporte) intent.getSerializableExtra("item");
        EditText empresa = (EditText) findViewById(R.id.empresaPublico);
        Spinner tipo = (Spinner) findViewById(R.id.tipoSpinnerPublico);
        if (item != null) {
            Button button = (Button) findViewById(R.id.btnCriarMeioPublico);
            button.setText("Confirmar Alterações");
            if (item instanceof Alugado) {
                Alugado alugado = (Alugado) item;
                empresa.setText(alugado.getLocadora());
                tipo.setSelection(getIndex(tipo, alugado.getTipo()+""));
            } else {
                if (item instanceof Publico) {
                    Publico publico = (Publico) item;
                    empresa.setText(publico.getEmpresa());
                    tipo.setSelection(getIndex(tipo, publico.getTipo()+""));
                } else {
                    if (item instanceof Compartilhado) {
                        Compartilhado compartilhado = (Compartilhado) item;
                        empresa.setText(compartilhado.getEmpresa());
                        tipo.setSelection(getIndex(tipo, compartilhado.getTipo()+""));
                    } else {
                        //Particular
                        Particular particular = (Particular) item;
                        tipo.setSelection(getIndex(tipo, particular.getTipo()+""));
                    }
                }
            }
        }
    }

    /**
     * Chamada ao clicar no botão de Salvar
     */
    public void salvar(View view) {
        String descricao = ((EditText) findViewById(R.id.descricaoPublico)).getText().toString();
        String tipo = ((Spinner) findViewById(R.id.tipoSpinnerPublico)).getSelectedItem().toString();
        String empresa = ((EditText) findViewById(R.id.empresaPublico)).getText().toString();
        if (descricao.equals("") || empresa.equals("")) {
            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            if (item == null) {
                dao.adicionaPublico(descricao, tipo, empresa);
            } else {
                //TODO Criar método de editar meio de transporte publico no MeiosDeTransporteDAO
                //dao.editar(parametros...);
            }
            setResult(getResources().getInteger(R.integer.SUCESS));
            finish();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getItemAtPosition(position).toString()) {
            case "Particular": {
                //Particular
                Intent intent = new Intent(this, addMeioDeTranporteParticularActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                EditText editText = (EditText) findViewById(R.id.descricaoPublico);
                String message = editText.getText().toString();
                intent.putExtra("descricao", message);
                intent.putExtra("item", item);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
                break;
            }
            case "Alugado": {
                //Alugado
                Intent intent = new Intent(this, addMeioDeTransporteAlugadoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                EditText editText = (EditText) findViewById(R.id.descricaoPublico);
                String message = editText.getText().toString();
                intent.putExtra("descricao", message);
                intent.putExtra("item", item);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
                break;
            }
            case "Compartilhado": {
                //Compartilhado
                Intent intent = new Intent(this, addMeioDeTransporteCompartilhadoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION  | Intent.FLAG_ACTIVITY_FORWARD_RESULT);
                EditText editText = (EditText) findViewById(R.id.descricaoPublico);
                String message = editText.getText().toString();
                intent.putExtra("descricao", message);
                intent.putExtra("item", item);
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

    private int getIndex(Spinner spinner, String myString) {
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)) {
                return i;
            }
        }

        return 0;
    }
}
