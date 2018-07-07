package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Gasto extends Evento {
    private String tipo,
                   observacao;
    private float  valor;

    public  Gasto(MeioDeTransporte veiculo, String tipo, float valor, String observacao){
        super(veiculo);
        this.tipo       = tipo;
        this.valor      = valor;
        this.observacao = observacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
