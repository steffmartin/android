package move.pdsi.facom.ufu.br.model;

import java.io.Serializable;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class MeioDeTransporte implements Serializable {
    private int id;
    private String descricao;
    private char tipo;
    private EstatisticasMeioTransporte statistics;

    public MeioDeTransporte() {
        this.statistics = new EstatisticasMeioTransporte();
    }
    public MeioDeTransporte(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
        this.statistics = new EstatisticasMeioTransporte(id);
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

    public char getTipo(){return this.tipo;}

    public void setTipo(char tipo) {
        if(!"APCU".contains(""+tipo)){
            throw new IllegalArgumentException("Tipo Invalido");
        }
        this.tipo = tipo;
    }

    public float getMedia(){
        return this.statistics.getMedia();
    }

    public float getMaximo(){
        return  this.statistics.getMaximo();
    }

    public float getMinimo(){
        return this.statistics.getMinimo();
    }

    public void setMedia(float media){
        this.statistics.setMedia(media);
    }

    public void setMaximo(float maximo){
        this.statistics.setMaximo(maximo);
    }

    public void setMinimo(float minimo){
        this.statistics.setMinimo(minimo);
    }
}
