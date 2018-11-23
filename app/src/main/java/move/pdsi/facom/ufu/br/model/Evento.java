package move.pdsi.facom.ufu.br.model;

import java.io.Serializable;

/**
 * Created by mirandagab on 07/07/2018.
 */

public class Evento implements Serializable {
    private int id;
    private String data;

    public Evento(int id, String data) {
        this.id = id;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
