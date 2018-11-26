package move.pdsi.facom.ufu.br.model;

public class EstatisticasMeioTransporte {
    private int meioDeTransporteId;
    private float media;
    private float maximo;
    private float minimo;

    public EstatisticasMeioTransporte(){
    }

    public EstatisticasMeioTransporte(int meioDeTransporteId){
        this.meioDeTransporteId = meioDeTransporteId;
    }

    public int getMeioDeTransporteId(){
        return this.meioDeTransporteId;
    }

    public void setMeioDeTransporteId(int meioDeTransporteId){
        this.meioDeTransporteId = meioDeTransporteId;
    }

    public float getMedia(){
        return this.media;
    }

    public void setMedia(float media){
        this.media = media;
    }

    public float getMaximo(){
        return this.maximo;
    }

    public void setMaximo(float maximo){
        this.maximo = maximo;
    }

    public float getMinimo(){
        return this.minimo;
    }

    public  void setMinimo(float minimo){
        this.minimo = minimo;
    }
}
