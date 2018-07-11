package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Alugado extends MeioDeTransporte {
    private int     id;
    private String  descricao,
                    tipo,
                    locadora,
                    marca,
                    modelo,
                    cor;

    public Alugado(int id, String descricao, String tipo, String locadora, String marca,
                   String modelo, String cor) {
        super(descricao);
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.locadora = locadora;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Alugado(){ super(); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescricaoA() { return descricao; }

    public void setDescricaoA(String descricao) { this.descricao = descricao; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

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

    @Override
    public String toString() {
        return descricao+" ("+tipo+")";
    }
}