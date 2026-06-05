package br.com.DefesaAzul.dao;

import br.com.DefesaAzul.conexoes.ConexaoFactory;
import br.com.DefesaAzul.entities.Alerta;

import java.sql.*;
import java.util.ArrayList;

public class AlertaDao {

    public Connection minhaConexao;

    public AlertaDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(Alerta alerta) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_DA_ALERTAS (nivel_alertas, descricao_alertas, id_evento_pesca) values (?,?,?)");
        stmt.setString(1, alerta.getNivel());
        stmt.setString(2, alerta.getDescricao());
        stmt.setInt(3, alerta.getIdEvento());

        stmt.execute();
        stmt.close();

        return "Alerta Cadastrado";
    }

    // Deletar
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From T_DA_ALERTAS where ID_ALERTA =?");
        stmt.setInt(1, codigo);

        stmt.execute();
        stmt.close();

        return "Alerta Deletado";
    }

    // UpDate
    public String atualizar(Alerta alerta) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_DA_ALERTAS set nivel_alertas =?, descricao_alertas =?, status_alertas =?, id_evento_pesca =? where id_alerta =?");
        stmt.setString(1, alerta.getNivel());
        stmt.setString(2, alerta.getDescricao());
        stmt.setString(3, alerta.getStatus());
        stmt.setInt(4, alerta.getIdEvento());
        stmt.setInt(5, alerta.getIdAlerta());

        stmt.executeUpdate();
        stmt.close();

        return "Alerta Atualizado";
    }

    // Select
    public ArrayList<Alerta> selecionar() throws SQLException {
        ArrayList<Alerta> listaAlerta = new ArrayList<Alerta>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_DA_ALERTAS");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            Alerta objAlerta = new Alerta();
            objAlerta.setIdAlerta(rs.getInt(1));
            objAlerta.setNivel(rs.getString(2));
            objAlerta.setDescricao(rs.getString(3));
            objAlerta.setStatus(rs.getString(4));
            objAlerta.setDataGeracao(rs.getDate(5));
            objAlerta.setDataFechamento(rs.getDate(6));
            objAlerta.setIdEvento(rs.getInt(7));

            listaAlerta.add(objAlerta);
        }
        return listaAlerta;
    }

    // Select / Código
    public Alerta selecionarPorCodigo(int codigo) throws SQLException {
        Alerta objAlerta = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_DA_ALERTAS where id_alerta = ?");
        stmt.setInt(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            objAlerta = new Alerta();
            objAlerta.setIdAlerta(rs.getInt(1));
            objAlerta.setNivel(rs.getString(2));
            objAlerta.setDescricao(rs.getString(3));
            objAlerta.setStatus(rs.getString(4));
            objAlerta.setDataGeracao(rs.getDate(5));
            objAlerta.setDataFechamento(rs.getDate(6));
            objAlerta.setIdEvento(rs.getInt(7));
        }

        rs.close();
        stmt.close();

        return objAlerta;
    }
}
