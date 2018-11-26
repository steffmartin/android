package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Gasto extends Evento {
    private String tipo;
    private String observacao;
    private float valor;

    public Gasto(int evento_id, String data, String tipo, float valor, String observacao) {
        super(evento_id,data);
        this.tipo = tipo;
        this.valor = valor;
        this.observacao = observacao;
    }

    public Gasto() {
        super();
    }

    public int getId() {        return super.getId();    }

    public void setId(int id) {        super.setId(id);   }

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
