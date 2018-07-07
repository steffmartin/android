package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Particular extends MeioDeTransporte {
    private String marca,
                   modelo,
                   cor;

    public Particular(String descricao, float media, float maximo, float minimo, int qtd,
                      String marca, String modelo, String cor){
        super(descricao, media, maximo, minimo, qtd);
        this.marca  = marca;
        this.modelo = modelo;
        this.cor    = cor;
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
