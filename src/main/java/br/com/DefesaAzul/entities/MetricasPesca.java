package br.com.DefesaAzul.entities;

public class MetricasPesca {
    private boolean flagRisco;
    private String idMetricas, statusAutorizacao;
    private float distInicioPortoKm, distFimPortoKm, distTotalKm, velocidadeMediaNos, distInicioCostaKm, distFimCostaKm;
    private int idEvento;

    public MetricasPesca() {
    }

    public MetricasPesca(boolean flagRisco, String idMetricas, String statusAutorizacao, float distInicioPortoKm, float distFimPortoKm, float distTotalKm, float velocidadeMediaNos, float distInicioCostaKm, float distFimCostaKm, int idEvento) {
        this.flagRisco = flagRisco;
        this.idMetricas = idMetricas;
        this.statusAutorizacao = statusAutorizacao;
        this.distInicioPortoKm = distInicioPortoKm;
        this.distFimPortoKm = distFimPortoKm;
        this.distTotalKm = distTotalKm;
        this.velocidadeMediaNos = velocidadeMediaNos;
        this.distInicioCostaKm = distInicioCostaKm;
        this.distFimCostaKm = distFimCostaKm;
        this.idEvento = idEvento;
    }

    public boolean isFlagRisco() {
        return flagRisco;
    }

    public void setFlagRisco(boolean flagRisco) {
        this.flagRisco = flagRisco;
    }

    public String getIdMetricas() {
        return idMetricas;
    }

    public void setIdMetricas(String idMetricas) {
        this.idMetricas = idMetricas;
    }

    public String getStatusAutorizacao() {
        return statusAutorizacao;
    }

    public void setStatusAutorizacao(String statusAutorizacao) {
        this.statusAutorizacao = statusAutorizacao;
    }

    public float getDistInicioPortoKm() {
        return distInicioPortoKm;
    }

    public void setDistInicioPortoKm(float distInicioPortoKm) {
        this.distInicioPortoKm = distInicioPortoKm;
    }

    public float getDistFimPortoKm() {
        return distFimPortoKm;
    }

    public void setDistFimPortoKm(float distFimPortoKm) {
        this.distFimPortoKm = distFimPortoKm;
    }

    public float getDistTotalKm() {
        return distTotalKm;
    }

    public void setDistTotalKm(float distTotalKm) {
        this.distTotalKm = distTotalKm;
    }

    public float getVelocidadeMediaNos() {
        return velocidadeMediaNos;
    }

    public void setVelocidadeMediaNos(float velocidadeMediaNos) {
        this.velocidadeMediaNos = velocidadeMediaNos;
    }

    public float getDistInicioCostaKm() {
        return distInicioCostaKm;
    }

    public void setDistInicioCostaKm(float distInicioCostaKm) {
        this.distInicioCostaKm = distInicioCostaKm;
    }

    public float getDistFimCostaKm() {
        return distFimCostaKm;
    }

    public void setDistFimCostaKm(float distFimCostaKm) {
        this.distFimCostaKm = distFimCostaKm;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "MetricasPesca{" +
                "flagRisco=" + flagRisco +
                ", idMetricas='" + idMetricas + '\'' +
                ", statusAutorizacao='" + statusAutorizacao + '\'' +
                ", distInicioPortoKm=" + distInicioPortoKm +
                ", distFimPortoKm=" + distFimPortoKm +
                ", distTotalKm=" + distTotalKm +
                ", velocidadeMediaNos=" + velocidadeMediaNos +
                ", distInicioCostaKm=" + distInicioCostaKm +
                ", distFimCostaKm=" + distFimCostaKm +
                ", idEvento=" + idEvento +
                '}';
    }
}
