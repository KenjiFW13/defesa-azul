package br.com.DefesaAzul.bo;

import br.com.DefesaAzul.dao.AlertaDao;
import br.com.DefesaAzul.entities.Alerta;

import java.sql.SQLException;
import java.util.ArrayList;

public class AlertaBo {

    AlertaDao alertaDao;

    // Inserir
    public String inserirBO(Alerta alerta) throws SQLException, ClassNotFoundException {
        AlertaDao alertaDao = new AlertaDao();

        return alertaDao.inserir(alerta);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        AlertaDao alertaDao = new AlertaDao();
        alertaDao.deletar(codigo);
    }

    // Update
    public String atualizarBO(Alerta alerta) throws SQLException, ClassNotFoundException {
        AlertaDao alertaDao = new AlertaDao();

        return alertaDao.atualizar(alerta);
    }

    // Select
    public ArrayList<Alerta> selecionarBO() throws SQLException, ClassNotFoundException {
        alertaDao = new AlertaDao();
        return (ArrayList<Alerta>) alertaDao.selecionar();
    }

    // Select / Código
    public Alerta selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        AlertaDao alertaDao = new AlertaDao();
        return alertaDao.selecionarPorCodigo(codigo);
    }
}
