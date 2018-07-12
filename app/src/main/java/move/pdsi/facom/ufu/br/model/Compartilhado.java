package move.pdsi.facom.ufu.br.model;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Compartilhado extends MeioDeTransporte {
    private int     id;
    private String  descricao,
                    tipo,
                    empresa;

    public Compartilhado(int id, String descricao, String tipo, String empresa) {
        super(descricao);
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.empresa = empresa;
    }

    public Compartilhado() { super (); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDescricaoC() { return descricao; }

    public void setDescricaoC(String descricao) { this.descricao = descricao; }

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

    @Override
    public String toString() {
        return descricao+" ("+tipo+")";
    }
}
