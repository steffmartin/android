package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Particular extends MeioDeTransporte {
    private int     id;
    private String  descricao,
                    tipo,
                    marca,
                    modelo,
                    cor;
    private float   media,  //media geral do veículo Particular
                    maximo, //melhor média
                    minimo; //pior média


    public Particular(int id, String descricao, String marca, String modelo, String cor) {
        super(descricao);
        this.id = id;
        this.descricao = descricao;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.media = this.maximo = this.minimo = 0F;
    }

    public Particular () { super(); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescricaoP() { return descricao; }

    public void setDescricaoP(String descricao) { this.descricao = descricao; super.setDescricao(descricao); }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public float getMedia() { return media; }

    public void setMedia(float media) { this.media = media; }

    public float getMaximo() { return maximo; }

    public void setMaximo(float maximo) { this.maximo = maximo; }

    public float getMinimo() { return minimo; }

    public void setMinimo(float minimo) { this.minimo = minimo; }

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
        return "Particular - " + descricao;
    }
}