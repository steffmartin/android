package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Evento {
    private MeioDeTransporte veiculo;

    public  Evento (MeioDeTransporte veiculo){
        this.veiculo = veiculo;
    }

    public MeioDeTransporte getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(MeioDeTransporte veiculo) {
        this.veiculo = veiculo;
    }
}
