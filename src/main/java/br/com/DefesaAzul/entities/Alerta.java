package br.com.DefesaAzul.entities;

import java.util.Date;

public class Alerta {
    private int idEvento, idAlerta;
    private String status, nivel, descricao;
    private Date dataGeracao, dataFechamento;

    public Alerta() {
    }

    public Alerta(int idEvento, int idAlerta, String status, String nivel, String descricao, Date dataGeracao, Date dataFechamento) {
        this.idEvento = idEvento;
        this.idAlerta = idAlerta;
        this.status = status;
        this.nivel = nivel;
        this.descricao = descricao;
        this.dataGeracao = dataGeracao;
        this.dataFechamento = dataFechamento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdAlerta() {
        return idAlerta;
    }

    public void setIdAlerta(int idAlerta) {
        this.idAlerta = idAlerta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    @Override
    public String toString() {
        return "Alerta{" +
                "ID Evento =" + idEvento +
                ", ID Alerta=" + idAlerta +
                ", Status='" + status + '\'' +
                ", Nível='" + nivel + '\'' +
                ", Descrição='" + descricao + '\'' +
                ", Data de Geração=" + dataGeracao +
                ", Data de Fechamento=" + dataFechamento +
                '}';
    }
}
