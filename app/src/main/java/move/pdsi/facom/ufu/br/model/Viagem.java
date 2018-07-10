package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Viagem extends Evento {
    private float inicio,
            fim,
            distancia;

    public Viagem(MeioDeTransporte veiculo, float inicio, float fim) {
        super(veiculo);
        this.inicio = inicio;
        this.fim = fim;
        this.distancia = calcularDistancia(inicio, fim);
    }

    private float calcularDistancia(float inicio, float fim) {
        float distancia = (fim - inicio);
        return distancia;
    }

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
