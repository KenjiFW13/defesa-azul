package br.com.DefesaAzul.entities;

import java.time.LocalDate;
import java.util.Date;

public class EventoPesca {
    private int idEvento;
    private String codigo, tipo, idEmbarcacao;
    private LocalDate dataInicio, dataFim, dataCarga;

    public EventoPesca() {
    }

    public EventoPesca(int idEvento, String codigo, String tipo, String idEmbarcacao, LocalDate dataInicio, LocalDate dataFim, LocalDate dataCarga) {
        this.idEvento = idEvento;
        this.codigo = codigo;
        this.tipo = tipo;
        this.idEmbarcacao = idEmbarcacao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataCarga = dataCarga;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(String idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public LocalDate getDataCarga() {
        return dataCarga;
    }

    public void setDataCarga(LocalDate dataCarga) {
        this.dataCarga = dataCarga;
    }

    @Override
    public String toString() {
        return "Eventos de Pesca{" +
                "ID Evento=" + idEvento +
                ", Código='" + codigo + '\'' +
                ", Tipo='" + tipo + '\'' +
                ", ID Embarcação='" + idEmbarcacao + '\'' +
                ", Data de Início=" + dataInicio +
                ", Data de Fim=" + dataFim +
                ", Data de Carga=" + dataCarga +
                '}';
    }
}
