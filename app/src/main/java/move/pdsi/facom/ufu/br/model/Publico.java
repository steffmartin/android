package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Publico extends MeioDeTransporte {
    private int     id;
    private String  descricao,
                    tipo,
                    empresa;

    public Publico(int id, String descricao, String tipo, String empresa) {
        super(descricao);
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.empresa = empresa;
    }

    public Publico(){ super(); }

    public String getDescricaoPub() { return descricao; }

    public void setDescricaoPub(String descricao) { this.descricao = descricao; super.setDescricao(descricao); }

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

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    @Override
    public String toString() {
        return "Público - " + descricao;
    }
}
