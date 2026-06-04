package br.com.DefesaAzul.bo;

import br.com.DefesaAzul.dao.RegiaoDao;
import br.com.DefesaAzul.entities.Regiao;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegiaoBo {

    RegiaoDao regiaoDao;

    // Inserir
    public String inserirBO(Regiao regiao) throws SQLException, ClassNotFoundException {
        RegiaoDao regiaoDao = new RegiaoDao();

        return regiaoDao.inserir(regiao);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        RegiaoDao regiaoDao = new RegiaoDao();
        regiaoDao.deletar(codigo);
    }

    // Update
    public String atualizarBO(Regiao regiao) throws SQLException, ClassNotFoundException {
        RegiaoDao regiaoDao = new RegiaoDao();

        return regiaoDao.atualizar(regiao);
    }

    // Select
    public ArrayList<Regiao> selecionarBO() throws SQLException, ClassNotFoundException {
        regiaoDao = new RegiaoDao();
        return (ArrayList<Regiao>) regiaoDao.selecionar();
    }

    // Select / Código
    public Regiao selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        RegiaoDao regiaoDao = new RegiaoDao();
        return regiaoDao.selecionarPorCodigo(codigo);
    }
}
