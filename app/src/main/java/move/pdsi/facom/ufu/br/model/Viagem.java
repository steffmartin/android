package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Viagem{
    private int     id,
                    meioDeTransporteID;
    private float   inicio,
                    fim,
                    distancia;

    public Viagem(int id, int meioDeTransporteID, float inicio, float fim) {
        this.id = id;
        this.meioDeTransporteID = meioDeTransporteID;
        this.inicio = inicio;
        this.fim = fim;
        this.distancia = calcularDistancia(inicio, fim);
    }

    public Viagem(int id, int meioDeTransporteID, float distancia){
        this.id = id;
        this.meioDeTransporteID = meioDeTransporteID;
        this.distancia = distancia;
        this.inicio = this.fim = 0f;
    }

    private float calcularDistancia(float inicio, float fim) {
        float distancia = (fim - inicio);
        return distancia;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getMeioDeTransporteID() { return meioDeTransporteID; }

    public void setMeioDeTransporteID(int meioDeTransporteID) { this.meioDeTransporteID = meioDeTransporteID; }

    public float getInicio() {
        return inicio;
    }

    public void setInicio(float inicio) {
        this.inicio = inicio;
    }

    public float getFim() {
        return fim;
    }

    public void setFim(float fim) {
        this.fim = fim;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }
}
