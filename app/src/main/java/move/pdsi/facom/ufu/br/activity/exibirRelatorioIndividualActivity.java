package move.pdsi.facom.ufu.br.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import move.pdsi.facom.ufu.br.model.meiosdetransporte.Alugado;
import move.pdsi.facom.ufu.br.model.meiosdetransporte.Compartilhado;
import move.pdsi.facom.ufu.br.model.meiosdetransporte.MeioDeTransporte;
import move.pdsi.facom.ufu.br.model.meiosdetransporte.Particular;
import move.pdsi.facom.ufu.br.model.meiosdetransporte.Publico;
import move.pdsi.facom.ufu.br.model.relatorios.EstatisticasPorMeioDeTransporte;
import move.pdsi.facom.ufu.br.move.R;

import static android.graphics.Color.CYAN;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class exibirRelatorioIndividualActivity extends AppCompatActivity {

    EstatisticasPorMeioDeTransporte item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_relatorio_individual);
        Intent intent = getIntent();
        item = (EstatisticasPorMeioDeTransporte) intent.getSerializableExtra("item");
        MeioDeTransporte veiculo = item.getMeioDeTransporte();
        ImageView avatar = (ImageView) findViewById(R.id.estatisticasAvatar);

        //Cabeçalho
        TextView relatorioIndividualPeriodo = findViewById(R.id.relatorioIndividualPeriodo);
        relatorioIndividualPeriodo.setText(item.getDataInicialTxt() + " a " + item.getDataFinalTxt());
        TextView estatIndivVeicNome = findViewById(R.id.estatIndivVeicNome);
        estatIndivVeicNome.setText(veiculo.getDescricao());
        TextView estatIndivVeicCategoria = findViewById(R.id.estatIndivVeicCategoria);
        if (veiculo instanceof Alugado) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                avatar.setBackgroundTintList(getColorStateList(R.color.alugado));
            } else {
                avatar.setBackgroundTintList(ColorStateList.valueOf(GREEN));
            }
            Alugado alugado = (Alugado) veiculo;
            estatIndivVeicCategoria.setText("Alugado");
        } else {
            if (veiculo instanceof Publico) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    avatar.setBackgroundTintList(getColorStateList(R.color.publico));
                } else {
                    avatar.setBackgroundTintList(ColorStateList.valueOf(CYAN));
                }
                Publico publico = (Publico) veiculo;
                estatIndivVeicCategoria.setText("Público");
            } else {
                if (veiculo instanceof Compartilhado) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        avatar.setBackgroundTintList(getColorStateList(R.color.compartilhado));
                    } else {
                        avatar.setBackgroundTintList(ColorStateList.valueOf(RED));
                    }
                    Compartilhado compartilhado = (Compartilhado) veiculo;
                    estatIndivVeicCategoria.setText("Compartilhado");
                } else {
                    if (veiculo instanceof Particular) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            avatar.setBackgroundTintList(getColorStateList(R.color.particular));
                        } else {
                            avatar.setBackgroundTintList(ColorStateList.valueOf(YELLOW));
                        }
                        Particular particular = (Particular) veiculo;
                        estatIndivVeicCategoria.setText("Particular");
                    }
                }
            }
        }

        //Bolinhas
        TextView est2linhasViagem = findViewById(R.id.est2linhasViagem);
        est2linhasViagem.setText(item.getQtdViagens() + " viagens\n" + item.getTotalDistancia() + " Km");
        TextView est2LinhasGastos = findViewById(R.id.est2LinhasGastos);
        est2LinhasGastos.setText(item.getQtdServicos() + " serviços\nR$ " + item.getTotalGastos());
        TextView est2LinhasGasolina = findViewById(R.id.est2LinhasGasolina);
        //TODO limitar para 2 casas decimais
        est2LinhasGasolina.setText("Combustível\nR$ " + item.getMediaCombustivelPorKm() + " / Km");
        TextView est2LinhasGastos2 = findViewById(R.id.est2LinhasGastos2);
        est2LinhasGastos2.setText("Média de gastos\nR$ " + item.getMediaGastosPorKm() + " / Km");

        //Gráficos
        TextView textoGraphViagens = findViewById(R.id.textoGraphViagens);
        ImageView graphViagens = findViewById(R.id.graphViagens);
        graphViagens.getLayoutParams().width = (int) ((((View) graphViagens.getParent()).getWidth() - 32) / 100 * item.getProporcaoViagens());
        textoGraphViagens.setText(item.getProporcaoViagens() + "% em relação a todos os meios de transporte.");
        TextView textoGraphDespesas = findViewById(R.id.textoGraphDespesas);
        ImageView graphGastos = findViewById(R.id.graphGastos);
        graphGastos.getLayoutParams().width = (int) ((((View) graphGastos.getParent()).getWidth() - 32) / 100 * item.getProporcaoViagens());
        textoGraphDespesas.setText(item.getProporcaoGastos() + "% em relação a todos os meios de transporte.");

        //Lista de despesas
        TextView listaDeGastos = findViewById(R.id.listaDeGastos);
        listaDeGastos.setText(item.getListaDeGastosSet().toString().substring(1,item.getListaDeGastosSet().toString().length()-1).replace(", ","\n").replace("="," = R$ ")+"\n");
    }
}
