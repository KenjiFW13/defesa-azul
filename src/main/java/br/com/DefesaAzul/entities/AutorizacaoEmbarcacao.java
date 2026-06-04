package br.com.DefesaAzul.entities;

public class AutorizacaoEmbarcacao {
    private int idAutorizacaoEmbarcacao;
    private String rfmo;
    private boolean autorizada;
    private String idEmbarcacao;

    public AutorizacaoEmbarcacao() {
    }

    public AutorizacaoEmbarcacao(int idAutorizacaoEmbarcacao, String rfmo, boolean autorizada, String idEmbarcacao) {
        this.idAutorizacaoEmbarcacao = idAutorizacaoEmbarcacao;
        this.rfmo = rfmo;
        this.autorizada = autorizada;
        this.idEmbarcacao = idEmbarcacao;
    }

    public int getIdAutorizacaoEmbarcacao() {
        return idAutorizacaoEmbarcacao;
    }

    public void setIdAutorizacaoEmbarcacao(int idAutorizacaoEmbarcacao) {
        this.idAutorizacaoEmbarcacao = idAutorizacaoEmbarcacao;
    }

    public String getRfmo() {
        return rfmo;
    }

    public void setRfmo(String rfmo) {
        this.rfmo = rfmo;
    }

    public boolean isAutorizada() {
        return autorizada;
    }

    public void setAutorizada(boolean autorizada) {
        this.autorizada = autorizada;
    }

    public String getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(String idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }

    @Override
    public String toString() {
        return "Autorização Embarcação{" +
                "ID Autorização=" + idAutorizacaoEmbarcacao +
                ", RFMO='" + rfmo + '\'' +
                ", Autorizada=" + autorizada +
                ", ID Embarcação='" + idEmbarcacao + '\'' +
                '}';
    }
}
