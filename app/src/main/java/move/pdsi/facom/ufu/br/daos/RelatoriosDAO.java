package move.pdsi.facom.ufu.br.daos;

import java.sql.Timestamp;

import move.pdsi.facom.ufu.br.model.meiosdetransporte.MeioDeTransporte;
import move.pdsi.facom.ufu.br.model.relatorios.EstatisticasGeral;
import move.pdsi.facom.ufu.br.model.relatorios.EstatisticasPorMeioDeTransporte;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class RelatoriosDAO {

    public EstatisticasPorMeioDeTransporte relatorioIndividual(MeioDeTransporte meioDeTransporte,
                                                               Timestamp dataInicial, Timestamp datafinal) {
        //TODO implementar método e retornar este objeto preechido.
        return new EstatisticasPorMeioDeTransporte();
    }

    public EstatisticasGeral relatorioGeral(Timestamp dataInicial, Timestamp datafinal) {
        //TODO implementar método e retornar este objeto preechido.
        return new EstatisticasGeral();
    }
}
