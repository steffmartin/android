package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Viagem extends Evento {
    //TODO @Gabriel o meioDeTransporteID poderia ficar na classe pai
    private int id,
            meioDeTransporteID;
    private String inicio,
            fim;
    private float distancia;

    public Viagem(int id, String data, int meioDeTransporteID, String inicio, String fim, float distancia) {
        super(id,data);
        this.id = id;
        this.meioDeTransporteID = meioDeTransporteID;
        this.inicio = inicio;
        this.fim = fim;
        this.distancia = distancia;
    }

    public Viagem() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeioDeTransporteID() {
        return meioDeTransporteID;
    }

    public void setMeioDeTransporteID(int meioDeTransporteID) {
        this.meioDeTransporteID = meioDeTransporteID;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }
}