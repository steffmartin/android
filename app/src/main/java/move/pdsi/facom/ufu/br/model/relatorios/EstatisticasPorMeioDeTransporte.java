package move.pdsi.facom.ufu.br.model.relatorios;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import move.pdsi.facom.ufu.br.model.meiosdetransporte.MeioDeTransporte;

public class EstatisticasPorMeioDeTransporte {

    private MeioDeTransporte meioDeTransporte;
    private Timestamp dataInicial, dataFinal; //Já criei get's que retornam em String formatada
    int QtdViagens, QtdServicos; //Contar as quantidades para esse veiculo
    float totalDistancia, totalGastos; //Somar os valores para esse veiculo
    float mediaCombustivelPorKm, mediaGastosPorKm; // Dividir total de combustivel pelo total distancia, depois total dos outros gastos (desconsiderando combustivel) dividido pela distancia total
    float proporcaoViagens, proporcaoGastos; // Percentual (de 0 a 100%) deste veículo em relação a todos os veículos
    HashMap<String,Float> listaDeGastos;//Soma dos gastos de cada categoria (não trazer Strings zeradas - sem valor associado)
    //Exemplo:
    //[{Combustivel,150.56},
    // {Pedágio,24.00},
    // {Oficina,150.00}]

    private static SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

    public EstatisticasPorMeioDeTransporte() {
    }

    public MeioDeTransporte getMeioDeTransporte() {
        return meioDeTransporte;
    }

    public void setMeioDeTransporte(MeioDeTransporte meioDeTransporte) {
        this.meioDeTransporte = meioDeTransporte;
    }

    public Timestamp getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Timestamp dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Timestamp getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Timestamp dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int getQtdViagens() {
        return QtdViagens;
    }

    public void setQtdViagens(int qtdViagens) {
        QtdViagens = qtdViagens;
    }

    public int getQtdServicos() {
        return QtdServicos;
    }

    public void setQtdServicos(int qtdServicos) {
        QtdServicos = qtdServicos;
    }

    public float getTotalDistancia() {
        return totalDistancia;
    }

    public void setTotalDistancia(float totalDistancia) {
        this.totalDistancia = totalDistancia;
    }

    public float getTotalGastos() {
        return totalGastos;
    }

    public void setTotalGastos(float totalGastos) {
        this.totalGastos = totalGastos;
    }

    public float getProporcaoViagens() {
        return proporcaoViagens;
    }

    public void setProporcaoViagens(float proporcaoViagens) {
        this.proporcaoViagens = proporcaoViagens;
    }

    public float getProporcaoGastos() {
        return proporcaoGastos;
    }

    public void setProporcaoGastos(float proporcaoGastos) {
        this.proporcaoGastos = proporcaoGastos;
    }

    public HashMap<String, Float> getListaDeGastos() {
        return listaDeGastos;
    }

    public void setListaDeGastos(HashMap<String, Float> listaDeGastos) {
        this.listaDeGastos = listaDeGastos;
    }

    public float getMediaCombustivelPorKm() {
        return mediaCombustivelPorKm;
    }

    public void setMediaCombustivelPorKm(float mediaCombustivelPorKm) {
        this.mediaCombustivelPorKm = mediaCombustivelPorKm;
    }

    public float getMediaGastosPorKm() {
        return mediaGastosPorKm;
    }

    public void setMediaGastosPorKm(float mediaGastosPorKm) {
        this.mediaGastosPorKm = mediaGastosPorKm;
    }

    public Set getListaDeGastosSet(){
        return listaDeGastos.entrySet();
    }

    public String getDataInicialTxt() {
        return out.format(new Date(this.dataInicial.getTime()));
    }

    public String getDataFinalTxt() {
        return out.format(new Date(this.dataFinal.getTime()));
    }
}
