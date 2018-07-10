package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class MeioDeTransporte {
    private String descricao;
    private float media,
            maximo,
            minimo;
    private int qtd;

    public MeioDeTransporte(String descricao, float media, float maximo, float minimo, int qtd) {
        this.descricao = descricao;
        this.media = media;
        this.maximo = maximo;
        this.minimo = minimo;
        this.qtd = qtd;
    }

    public void MeioDeTransporte(String descricao) {
        this.descricao = descricao;
        this.media = 0;
        this.maximo = 0;
        this.minimo = 0;
    }

    //atualiza as estatisticas do meio de transporte
    //é passado um valor de média e os valores são atualizados
    private void atualizarEstatisticas(float valor) {
        if (valor > this.maximo) setMaximo(valor);
        else if (valor < this.minimo) setMinimo(valor);
        float media = getMedia();
        int qtd = getQtd();
        qtd++;
        media = (media + valor) / qtd;
        setQtd(qtd);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public float getMaximo() {
        return maximo;
    }

    public void setMaximo(float maximo) {
        this.maximo = maximo;
    }

    public float getMinimo() {
        return minimo;
    }

    public void setMinimo(float minimo) {
        this.minimo = minimo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
