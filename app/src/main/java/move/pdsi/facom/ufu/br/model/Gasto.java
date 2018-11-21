package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Gasto extends Evento {
    //TODO @Gabriel o meioDeTransporteID poderia ficar na classe pai
    private int id,
            meioDeTransporteID;
    private String tipo,
            observacao;
    private float valor;

    public Gasto(int id, int meioDeTransporteID, String tipo, float valor, String observacao) {
        super(id);
        this.meioDeTransporteID = meioDeTransporteID;
        this.tipo = tipo;
        this.valor = valor;
        this.observacao = observacao;
    }

    public Gasto() {
        super();
    }

    public int getId() {        return id;    }

    public void setId(int id) {        this.id = id;    }

    public int getMeioDeTransporteID() {        return meioDeTransporteID;    }

    public void setMeioDeTransporteID(int meioDeTransporteID) {        this.meioDeTransporteID = meioDeTransporteID;    }

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
