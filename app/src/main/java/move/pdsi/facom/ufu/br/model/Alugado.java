package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Alugado extends MeioDeTransporte {
    private String locadora,
                   marca,
                   modelo,
                   cor;
    private float kmRodados;

    public Alugado (String descricao, String locadora, String marca, String modelo, String cor){
        super(descricao, 0f, 0f, 0f, 0);
        this.locadora = locadora;
        this.marca    = marca;
        this.modelo   = modelo;
        this.cor      = cor;
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

    public float getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(float kmRodados) {
        this.kmRodados = kmRodados;
    }
}
