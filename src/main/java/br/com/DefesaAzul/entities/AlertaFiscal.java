package br.com.DefesaAzul.entities;

public class AlertaFiscal {
    private int idAlerta, idFiscal;

    public AlertaFiscal() {
    }

    public AlertaFiscal(int idAlerta, int idFiscal) {
        this.idAlerta = idAlerta;
        this.idFiscal = idFiscal;
    }

    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public int getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(int idFiscal) {
        this.idFiscal = idFiscal;
    }

    @Override
    public String toString() {
        return "AlertaFiscal{" +
                "idAlerta=" + idAlerta +
                ", idFiscal=" + idFiscal +
                '}';
    }
}
