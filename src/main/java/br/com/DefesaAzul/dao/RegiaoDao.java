package br.com.DefesaAzul.dao;

import br.com.DefesaAzul.conexoes.ConexaoFactory;
import br.com.DefesaAzul.entities.Regiao;

import java.sql.*;
import java.util.ArrayList;

public class RegiaoDao {

    public Connection minhaConexao;

    public RegiaoDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(Regiao regiao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_DA_REGIOES values (?,?,?,?,?)");
        stmt.setInt(1, regiao.getIdRegiao());
        stmt.setString(2, regiao.getNome());
        stmt.setString(3, regiao.getTipo());
        stmt.setString(4, regiao.getCodigo());
        stmt.setString(5, regiao.getDescricao());

        stmt.execute();
        stmt.close();

        return "Região Cadastrada";
    }

    // Deletar
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From T_DA_REGIOES where ID_REGIOES =?");
        stmt.setInt(1, codigo);

        stmt.execute();
        stmt.close();

        return "Região Deletada";
    }

    // UpDate
    public String atualizar(Regiao regiao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_DA_REGIOES set NOME_REGIOES =?, TIPO_REGIOES =?, COD_REGIOES =?, DESC_REGIOES =? where ID_REGIOES =?");
        stmt.setString(1, regiao.getNome());
        stmt.setString(2, regiao.getTipo());
        stmt.setString(3, regiao.getCodigo());
        stmt.setString(4, regiao.getDescricao());
        stmt.setInt(5, regiao.getIdRegiao());

        stmt.executeUpdate();
        stmt.close();

        return "Região Atualizada";
    }

    // Select
    public ArrayList<Regiao> selecionar() throws SQLException {
        ArrayList<Regiao> listaRegiao = new ArrayList<Regiao>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_DA_REGIOES");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Regiao objRegiao = new Regiao();
            objRegiao.setIdRegiao(rs.getInt(1));
            objRegiao.setNome(rs.getString(2));
            objRegiao.setTipo(rs.getString(3));
            objRegiao.setCodigo(rs.getString(4));
            objRegiao.setDescricao(rs.getString(5));

            listaRegiao.add(objRegiao);
        }
        return listaRegiao;
    }

    // Select / Código
    public Regiao selecionarPorCodigo(int codigo) throws SQLException {
        Regiao objRegiao = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_DA_REGIOES where ID_REGIOES = ?");
        stmt.setInt(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            objRegiao = new Regiao();
            objRegiao.setIdRegiao(rs.getInt(1));
            objRegiao.setNome(rs.getString(2));
            objRegiao.setTipo(rs.getString(3));
            objRegiao.setCodigo(rs.getString(4));
            objRegiao.setDescricao(rs.getString(5));
        }

        rs.close();
        stmt.close();

        return objRegiao;
    }
}

