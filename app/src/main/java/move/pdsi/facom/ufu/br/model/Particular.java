package move.pdsi.facom.ufu.br.model;

import java.util.ArrayList;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Particular {
    private int     id;
    private String  descricao,
                    tipo,
                    marca,
                    modelo,
                    cor;
    private float   media,  //media geral do veículo Particular
                    maximo, //melhor média
                    minimo; //pior média
    private ArrayList<Viagem> viagens;


    public Particular(int id, String descricao, String marca, String modelo, String cor) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.media = this.maximo = this.minimo = 0f;
        this.viagens = new ArrayList<Viagem>();
    }

    private void incluirViagem(Viagem viagem){ this.viagens.add(viagem); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

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
}
