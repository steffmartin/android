package move.pdsi.facom.ufu.br.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Usuario {

    private String nome,
            sobrenome,
            email,
            senha,
            foto;
    private Boolean facebook;
    private int qtdMeiosDeTransporte;
    private Date ultimoLogin;
    private ArrayList<MeioDeTransporte> transportes;

    public Usuario() {
        this.nome = "Flavio";
        this.sobrenome = "Silva";
        this.email = "flavio@ufu.br";
        this.senha = "pdsi20181";
        this.qtdMeiosDeTransporte = 0;
        this.ultimoLogin = new Date();
        transportes = new ArrayList<MeioDeTransporte>();
        this.facebook = false;
    }

    private void atualizarUltimoLogin() {
        setUltimoLogin(new Date());
    }

    private void incluirMeioDeTransporte(MeioDeTransporte transporte) {
        this.transportes.add(transporte);
        int i = getQtdMeiosDeTransporte();
        i++;
        setQtdMeiosDeTransporte(i);
    }

    private void excluirMeioDeTransporte(MeioDeTransporte transporte) {

    }

    //getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Boolean getFacebook() {
        return facebook;
    }

    public void setFacebook(Boolean facebook) {
        this.facebook = facebook;
    }

    public int getQtdMeiosDeTransporte() {
        return qtdMeiosDeTransporte;
    }

    public void setQtdMeiosDeTransporte(int qtdMeiosDeTransporte) {
        this.qtdMeiosDeTransporte = qtdMeiosDeTransporte;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public ArrayList<MeioDeTransporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(ArrayList<MeioDeTransporte> transportes) {
        this.transportes = transportes;
    }
}
