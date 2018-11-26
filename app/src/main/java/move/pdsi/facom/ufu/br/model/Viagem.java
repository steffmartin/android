package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Viagem extends Evento {
    private String inicio;
    private String fim;
    private float distancia;

    public Viagem(int evento_id, String data, String inicio, String fim, float distancia) {
        super(evento_id,data);
        this.inicio = inicio;
        this.fim = fim;
        this.distancia = distancia;
    }

    public Viagem() {
        super();
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }
    public String getData(){
        return this.getData();
    }
    public void setData(String data){
        this.setData(data);
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