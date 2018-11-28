package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Particular extends MeioDeTransporte {

    private String tipo;
    private String marca;
    private String modelo;
    private String cor;


    public Particular(int evento_id, String descricao, String marca, String modelo, String cor) {
        super(evento_id,descricao);
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Particular() {
        super();
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

    public String getDescricaoP() {
        return super.getDescricao();
    }

    public void setDescricaoP(String descricao) {
        super.setDescricao(descricao);
    }

    public String getTipo() {
        return super.getTipo();
    }

    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}