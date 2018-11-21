package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
//TODO @Gabriel falta atributo DATA nesta classe
public class Evento {
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
