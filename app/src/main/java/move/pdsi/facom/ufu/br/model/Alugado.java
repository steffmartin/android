package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Alugado extends MeioDeTransporte {
    private String tipo;
    private String locadora;
    private String marca;
    private String modelo;
    private String cor;

    public Alugado(int id, String descricao, String tipo, String locadora, String marca,
                   String modelo, String cor) {
        super(id,descricao);
        this.tipo = tipo;
        this.locadora = locadora;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Alugado() {
        super();
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

    public String getDescricaoA() {
        return super.getDescricao();
    }

    public void setDescricaoA(String descricao) {
        super.setDescricao(descricao);
    }

    public String getTipo() {
        return super.getTipo();
    }

    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    public String getLocadora() {
        return locadora;
    }

    public void setLocadora(String locadora) {
        this.locadora = locadora;
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