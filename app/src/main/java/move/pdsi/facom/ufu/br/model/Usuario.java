package move.pdsi.facom.ufu.br.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mirandagab on 07/07/2018.
 */
public class Usuario {

    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private String foto;
    private String facebook;
    private boolean sincronizar;
    private ArrayList<MeioDeTransporte> transportes;
    private EstatisticasConta statistics;

    public Usuario(int id) {
        this.transportes = new ArrayList<>(10);
        this.statistics = new EstatisticasConta(id,0,null);
    }

    public Usuario(int id, String nome, String sobrenome, String email, String senha){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.transportes = new ArrayList<>(10);
        this.statistics = new EstatisticasConta(id,0,null);
    }

    private void incluirMeioDeTransporte(MeioDeTransporte transporte) {
        this.transportes.add(transporte);
        this.statistics.incrementQtdMeioTransporte();
    }

    private void excluirMeioDeTransporte(MeioDeTransporte transporte) {
        this.transportes.remove(transporte);
        this.statistics.decrementQtdMeioTransporte();
    }

    //getters and setters
    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

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

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public boolean isSincronizar() {
        return sincronizar;
    }

    public void setSincronizar(boolean sincronizar){
        this.sincronizar = sincronizar;
    }

    public int getQtdMeiosDeTransporte() {
        return this.statistics.getQtdMeiosTransporte();
    }

    public void setQtdMeiosDeTransporte(int qtdMeiosDeTransporte) {
        this.statistics.setQtdMeiosTransporte(qtdMeiosDeTransporte);
    }

    public void setUltimoLogin(Timestamp ultimoLogin){
        this.statistics.setUltimoLogin(ultimoLogin);
    }

    public Timestamp getUltimoLogin(){
        return this.statistics.getUltimoLogin();
    }

    public ArrayList<MeioDeTransporte> getTransportes() {
        return transportes;
    }

}
