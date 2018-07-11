package move.pdsi.facom.ufu.br.model;

import java.util.ArrayList;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Alugado {
    private int     id;
    private String  descricao,
                    tipo,
                    locadora,
                    marca,
                    modelo,
                    cor;
    private ArrayList<Viagem> viagens;

    public Alugado(int id, String descricao, String tipo, String locadora, String marca,
                   String modelo, String cor) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.locadora = locadora;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.viagens = new ArrayList<Viagem>();
    }

    private void incluirViagem(Viagem viagem){ this.viagens.add(viagem); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

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

    public ArrayList<Viagem> getViagens() { return viagens; }

    public void setViagens(ArrayList<Viagem> viagens) { this.viagens = viagens; }

    @Override
    public String toString() {
        return descricao+" ("+tipo+")";
    }
}
