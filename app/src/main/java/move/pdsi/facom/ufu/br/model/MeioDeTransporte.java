package move.pdsi.facom.ufu.br.model;

import java.io.Serializable;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class MeioDeTransporte implements Serializable {
    private int id;
    private String descricao;


    public MeioDeTransporte(String descricao) {
        this.descricao = descricao;
    }

    public MeioDeTransporte() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
