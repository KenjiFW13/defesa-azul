package br.com.DefesaAzul.entities;

public class Regiao {
    private int idRegiao;
    private String tipo, codigo, nome, descricao;

    public Regiao() {
    }

    public Regiao(int idRegioes, String tipo, String codigo, String nome, String descricao) {
        this.idRegiao = idRegioes;
        this.tipo = tipo;
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getIdRegiao() {
        return idRegiao;
    }

    public void setIdRegiao(int idRegiao) {
        this.idRegiao = idRegiao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Região{" +
                "ID Região=" + idRegiao +
                ", Tipo='" + tipo + '\'' +
                ", Código='" + codigo + '\'' +
                ", Nome='" + nome + '\'' +
                ", Descrição='" + descricao + '\'' +
                '}';
    }
}
