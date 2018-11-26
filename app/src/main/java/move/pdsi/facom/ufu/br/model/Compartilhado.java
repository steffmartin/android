package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Compartilhado extends MeioDeTransporte{
    private String tipo;
    private String empresa;

    public Compartilhado(int evento_id, String descricao, String tipo, String empresa) {
        super(evento_id, descricao);
        this.tipo = tipo;
        this.empresa = empresa;
    }

    public Compartilhado() {
        super();
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

    public String getDescricaoC() {
        return super.getDescricao();
    }

    public void setDescricaoC(String descricao) {
        super.setDescricao(descricao);
    }

    public char getTipo() {
        return super.getTipo();
    }

    public void setTipo(char tipo) {
        super.setTipo(tipo);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
