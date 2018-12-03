package move.pdsi.facom.ufu.br.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import move.pdsi.facom.ufu.br.model.relatorios.EstatisticasGeral;
import move.pdsi.facom.ufu.br.model.relatorios.EstatisticasPorMeioDeTransporte;
import move.pdsi.facom.ufu.br.move.R;

public class exibirRelatorioGeralActivity extends AppCompatActivity {

    EstatisticasGeral item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_relatorio_geral);
        Intent intent = getIntent();
        item = (EstatisticasGeral) intent.getSerializableExtra("item");
    }
}
