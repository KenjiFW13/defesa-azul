package br.com.DefesaAzul.dao;

import br.com.DefesaAzul.conexoes.ConexaoFactory;
import br.com.DefesaAzul.entities.Embarcacao;

import java.sql.*;
import java.util.ArrayList;

public class EmbarcacaoDao {

    public Connection minhaConexao;

    public EmbarcacaoDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(Embarcacao embarcacao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_DA_EMBARCACAO values (?,?,?,?,?,?)");
        stmt.setString(1, embarcacao.getIdEmbarcacao());
        stmt.setString(2, embarcacao.getNome());
        stmt.setString(3, embarcacao.getMmsi());
        stmt.setString(4, embarcacao.getBandeira());
        stmt.setString(5, embarcacao.getTipo());
        stmt.setDate(6, Date.valueOf(embarcacao.getDataCadastrada()));

        stmt.execute();
        stmt.close();

        return "Embarcação Cadastrada";
    }

    // Deletar
    public String deletar(String codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From T_DA_EMBARCACAO where MMSI_EMBARCACAO =?");
        stmt.setString(1, codigo);

        stmt.execute();
        stmt.close();

        return "Embarcação Deletada";
    }

    // UpDate
    public String atualizar(Embarcacao embarcacao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_DA_EMBARCACAO set ID_EMBARCACAO =?, NM_EMBARACACAO =?, MMSI_EMBARCACAO =?, BANDEIRA_EMBARACACAO =?, TIPO_EMBARCACAO =? where MMSI_EMBARCACAO =?");
        stmt.setString(1, embarcacao.getIdEmbarcacao());
        stmt.setString(2, embarcacao.getNome());
        stmt.setString(3, embarcacao.getMmsi());
        stmt.setString(4, embarcacao.getBandeira());
        stmt.setString(5, embarcacao.getTipo());
        stmt.setString(6, embarcacao.getMmsi());

        stmt.executeUpdate();
        stmt.close();

        return "Embarcação Atualizada";
    }

    // Select
    public ArrayList<Embarcacao> selecionar() throws SQLException {
        ArrayList<Embarcacao> listaEmbarcacao = new ArrayList<Embarcacao>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_DA_EMBARCACAO");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Embarcacao objEmbarcacao = new Embarcacao();
            objEmbarcacao.setIdEmbarcacao(rs.getString(1));
            objEmbarcacao.setNome(rs.getString(2));
            objEmbarcacao.setMmsi(rs.getString(3));
            objEmbarcacao.setBandeira(rs.getString(4));
            objEmbarcacao.setTipo(rs.getString(5));
            objEmbarcacao.setDataCadastrada(rs.getDate(6).toLocalDate());

            listaEmbarcacao.add(objEmbarcacao);
        }
        return listaEmbarcacao;
    }

    // Select / Código
    public Embarcacao selecionarPorCodigo(String codigo) throws SQLException {
        Embarcacao objEmbarcacao = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_DA_EMBARCACAO where MMSI_EMBARCACAO = ?");
        stmt.setString(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            objEmbarcacao = new Embarcacao();
            objEmbarcacao.setIdEmbarcacao(rs.getString(1));
            objEmbarcacao.setNome(rs.getString(2));
            objEmbarcacao.setMmsi(rs.getString(3));
            objEmbarcacao.setBandeira(rs.getString(4));
            objEmbarcacao.setTipo(rs.getString(5));
            objEmbarcacao.setDataCadastrada(rs.getDate(6).toLocalDate());
        }

        rs.close();
        stmt.close();

        return objEmbarcacao;
    }
}
