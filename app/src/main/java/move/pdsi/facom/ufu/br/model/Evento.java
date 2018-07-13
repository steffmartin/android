package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Evento {
    private int veiculo;

    public Evento(int veiculo) {
        this.veiculo = veiculo;
    }

    public Evento(){};

    public int getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(int veiculo) {
        this.veiculo = veiculo;
    }
}
