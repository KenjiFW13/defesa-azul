package br.com.DefesaAzul.entities;

public class RegiaoEvento {
    private int idRegiaoEvento, idRegiao, idEvento;

    public RegiaoEvento() {
    }

    public RegiaoEvento(int idRegiaoEvento, int idRegiao, int idEvento) {
        this.idRegiaoEvento = idRegiaoEvento;
        this.idRegiao = idRegiao;
        this.idEvento = idEvento;
    }

    public int getIdRegiaoEvento() {
        return idRegiaoEvento;
    }

    public void setIdRegiaoEvento(int idRegiaoEvento) {
        this.idRegiaoEvento = idRegiaoEvento;
    }

    public int getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "Região Evento{" +
                "ID Região Evento=" + idRegiaoEvento +
                ", ID Região=" + idRegiao +
                ", ID Evento=" + idEvento +
                '}';
    }
}
