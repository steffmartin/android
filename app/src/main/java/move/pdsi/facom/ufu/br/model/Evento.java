package move.pdsi.facom.ufu.br.model;

import java.io.Serializable;

/**
 * Created by mirandagab on 07/07/2018.
 */
//TODO @Gabriel falta atributo DATA nesta classe
public class Evento implements Serializable {
    private int id;

    public Evento(int id) {
        this.id = id;
    }

    public Evento() {
    }

    ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
