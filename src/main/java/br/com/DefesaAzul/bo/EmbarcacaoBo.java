package br.com.DefesaAzul.bo;

import br.com.DefesaAzul.dao.EmbarcacaoDao;
import br.com.DefesaAzul.entities.Embarcacao;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmbarcacaoBo {

    EmbarcacaoDao embarcacaoDao;

    // Inserir
    public String inserirBO(Embarcacao embarcacao) throws SQLException, ClassNotFoundException {
        EmbarcacaoDao embarcacaoDao = new EmbarcacaoDao();

        return embarcacaoDao.inserir(embarcacao);
    }

    // Deletar
    public void deletarBO(String codigo) throws SQLException, ClassNotFoundException {
        EmbarcacaoDao embarcacaoDao = new EmbarcacaoDao();
        embarcacaoDao.deletar(codigo);
    }

    // Update
    public String atualizarBO(Embarcacao embarcacao) throws SQLException, ClassNotFoundException {
        EmbarcacaoDao embarcacaoDao = new EmbarcacaoDao();

        return embarcacaoDao.atualizar(embarcacao);
    }

    // Select
    public ArrayList<Embarcacao> selecionarBO() throws SQLException, ClassNotFoundException {
        embarcacaoDao = new EmbarcacaoDao();
        return (ArrayList<Embarcacao>) embarcacaoDao.selecionar();
    }

    // Select / Código
    public Embarcacao selecionarPorCodigoBo(String codigo) throws SQLException, ClassNotFoundException {
        EmbarcacaoDao embarcacaoDao = new EmbarcacaoDao();
        return embarcacaoDao.selecionarPorCodigo(codigo);
    }
}
