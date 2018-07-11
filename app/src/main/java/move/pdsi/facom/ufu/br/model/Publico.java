package move.pdsi.facom.ufu.br.model;

import java.util.ArrayList;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Publico {
    private int     id;
    private String  descricao,
                    tipo,
                    empresa;
    private ArrayList<Viagem> viagens;

    public Publico(int id, String descricao, String tipo, String empresa) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.empresa = empresa;
        this.viagens = new ArrayList<Viagem>();

    }

    private void incluirViagem(Viagem viagem){ this.viagens.add(viagem); }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public ArrayList<Viagem> getViagens() { return viagens; }

    public void setViagens(ArrayList<Viagem> viagens) { this.viagens = viagens; }

    @Override
    public String toString() {
        return descricao+" ("+tipo+")";
    }
}
