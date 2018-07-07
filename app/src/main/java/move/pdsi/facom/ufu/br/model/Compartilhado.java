package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Compartilhado extends MeioDeTransporte {
    private String tipo,
                   empresa;

    public Compartilhado(String descricao, String tipo, String empresa){
        super(descricao, 0f, 0f, 0f, 0);
        this.tipo    = tipo;
        this.empresa = empresa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
