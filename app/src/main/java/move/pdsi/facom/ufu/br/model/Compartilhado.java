package move.pdsi.facom.ufu.br.model;

import java.util.ArrayList;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Compartilhado {
    private int     id;
    private String  descricao,
                    tipo,
                    empresa;
    private ArrayList<Viagem> viagens;

    public Compartilhado(int id, String descricao, String tipo, String empresa) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.empresa = empresa;
        this.viagens = new ArrayList<Viagem>();
    }

    private void incluirViagem(Viagem viagem){ this.viagens.add(viagem); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

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
    @Override
    public String toString() {
        return descricao+" ("+tipo+")";
    }
}
