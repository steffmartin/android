package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Publico extends MeioDeTransporte {
    private String tipo;
    private String empresa;

    public Publico(int evento_id, String descricao, String tipo, String empresa) {
        super(evento_id, descricao);
        this.tipo = tipo;
        this.empresa = empresa;
    }

    public Publico() {
        super();
    }

    public String getDescricaoPub() {
        return super.getDescricao();
    }

    public void setDescricaoPub(String descricao) {
        super.setDescricao(descricao);
    }

    public String getTipo() {
        return super.getTipo();
    }

    public void setTipo(String tipo) {
        super.setTipo(tipo);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int id) {
        super.setId(id);
    }

}
