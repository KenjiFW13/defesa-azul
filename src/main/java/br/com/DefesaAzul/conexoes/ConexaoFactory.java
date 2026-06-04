package br.com.DefesaAzul.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    public Connection conexao() throws ClassNotFoundException, SQLException {
    // Método de conexão

        Class.forName("oracle.jdbc.driver.OracleDriver");
        // Driver Oracle

        return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "rm568156", "250706");
        // Retornar conexão
    }
}
