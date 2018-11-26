package move.pdsi.facom.ufu.br.model;

import java.sql.Time;
import java.sql.Timestamp;

public class EstatisticasConta {
    private int usuario_id;
    private int qtdMeiosTransporte;
    private Timestamp ultimoLogin;

    public EstatisticasConta(){
    }

    public EstatisticasConta(int usuario_id, int qtdMeiosTransporte, Timestamp ultimoLogin){
        this.usuario_id = usuario_id;
        this.qtdMeiosTransporte = qtdMeiosTransporte;
        this.ultimoLogin = ultimoLogin;
    }

    public void setUsuario_id(int usuario_id){
        this.usuario_id = usuario_id;
    }

    public int getUsuario_id(){
        return this.usuario_id;
    }

    public void setQtdMeiosTransporte(int qtdMeiosTransporte){
        this.qtdMeiosTransporte = qtdMeiosTransporte;
    }

    public  int getQtdMeiosTransporte(){
        return this.qtdMeiosTransporte;
    }

    public void setUltimoLogin(Timestamp ultimoLogin){
        this.ultimoLogin = ultimoLogin;
    }

    public Timestamp getUltimoLogin(){
        return this.ultimoLogin;
    }

    public void incrementQtdMeioTransporte(){
        this.qtdMeiosTransporte++;
    }

    public void decrementQtdMeioTransporte(){
        this.qtdMeiosTransporte--;
    }
}
