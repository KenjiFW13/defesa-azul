package br.com.DefesaAzul.entities;

import java.time.LocalDate;

public class Embarcacao {
    private String idEmbarcacao, nome, mmsi, bandeira, tipo;
    private LocalDate dataCadastrada;

    public Embarcacao() {
    }

    public Embarcacao(String idEmbarcacao, String nome, String mmsi, String bandeira, String tipo, LocalDate dataCadastrada) {
        this.idEmbarcacao = idEmbarcacao;
        this.nome = nome;
        this.mmsi = mmsi;
        this.bandeira = bandeira;
        this.tipo = tipo;
        this.dataCadastrada = dataCadastrada;
    }

    public String getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(String idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataCadastrada() {
        return dataCadastrada;
    }

    public void setDataCadastrada(LocalDate dataCadastrada) {
        this.dataCadastrada = dataCadastrada;
    }

    @Override
    public String toString() {
        return "Embarcação {" +
                "ID Embarcação='" + idEmbarcacao + '\'' +
                ", Nome='" + nome + '\'' +
                ", MMSI='" + mmsi + '\'' +
                ", Bandeira='" + bandeira + '\'' +
                ", Tipo='" + tipo + '\'' +
                ", Data Cadastrada=" + dataCadastrada +
                '}';
    }
}
