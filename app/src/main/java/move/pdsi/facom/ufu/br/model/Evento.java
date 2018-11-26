package move.pdsi.facom.ufu.br.model;

import java.io.Serializable;

/**
 * Created by mirandagab on 07/07/2018.
 */

public class Evento implements Serializable {
    private int id;
    private String data;
    private int meiodetransporte_id;

    public Evento(int id, String data) {
        this.id = id;
        this.data = data;
    }

    public Evento() {
    }

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

    public int getMeiodetransporte_id(){return this.meiodetransporte_id;}

    public void setMeiodetransporte_id(int meiodetransporte_id){this.meiodetransporte_id = meiodetransporte_id;}
}
