package br.com.DefesaAzul.entities;

import java.util.Date;

public class Fiscal {
    private int idFiscal;
    private String nome, email;
    private Date dataCadastrado;

    public Fiscal() {
    }

    public Fiscal(int idFiscal, String nome, String email, Date dataCadastrado) {
        this.idFiscal = idFiscal;
        this.nome = nome;
        this.email = email;
        this.dataCadastrado = dataCadastrado;
    }

    public int getIdFiscal() {
        return idFiscal;
    }

    public void setIdFiscal(int idFiscal) {
        this.idFiscal = idFiscal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastrado() {
        return dataCadastrado;
    }

    public void setDataCadastrado(Date dataCadastrado) {
        this.dataCadastrado = dataCadastrado;
    }

    @Override
    public String toString() {
        return "Fiscal{" +
                "ID Fiscal=" + idFiscal +
                ", Nome='" + nome + '\'' +
                ", Email='" + email + '\'' +
                ", Data Cadastrado=" + dataCadastrado +
                '}';
    }
}
