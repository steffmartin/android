package move.pdsi.facom.ufu.br.model.relatorios;

import java.sql.Timestamp;

public class EstatisticasGeral {

    private Timestamp dataInicial, dataFinal; //Já criei get's que retornam em String formatada
    int QtdViagens, QtdServicos; //Contar as quantidades para todos veiculo
    float totalDistancia, totalGastos; //Somar os valores para todos veiculo

}
