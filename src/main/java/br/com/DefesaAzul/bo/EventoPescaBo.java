package br.com.DefesaAzul.bo;

import br.com.DefesaAzul.dao.EventoPescaDao;
import br.com.DefesaAzul.entities.EmbarcacaoMapaDTO;
import br.com.DefesaAzul.entities.EventoPesca;

import java.sql.SQLException;
import java.util.ArrayList;

public class EventoPescaBo {

    EventoPescaDao eventoPescaDao;

    // Inserir
    public String inserirBO(EventoPesca eventoPesca) throws SQLException, ClassNotFoundException {
        EventoPescaDao eventoPescaDao = new EventoPescaDao();

        return eventoPescaDao.inserir(eventoPesca);
    }

    // Deletar
    public void deletarBO(int codigo) throws SQLException, ClassNotFoundException {
        EventoPescaDao eventoPescaDao = new EventoPescaDao();
        eventoPescaDao.deletar(codigo);
    }

    // Update
    public String atualizarBO(EventoPesca eventoPesca) throws SQLException, ClassNotFoundException {
        EventoPescaDao eventoPescaDao = new EventoPescaDao();

        return eventoPescaDao.atualizar(eventoPesca);
    }

    // Select
    public ArrayList<EventoPesca> selecionarBO() throws SQLException, ClassNotFoundException {
        eventoPescaDao = new EventoPescaDao();
        return (ArrayList<EventoPesca>) eventoPescaDao.selecionar();
    }

    // Select / Código
    public EventoPesca selecionarPorCodigoBo(int codigo) throws SQLException, ClassNotFoundException {
        EventoPescaDao eventoPescaDao = new EventoPescaDao();
        return eventoPescaDao.selecionarPorCodigo(codigo);
    }

    // queryMapa
    public ArrayList<EmbarcacaoMapaDTO> queryMapa() throws SQLException, ClassNotFoundException {
        eventoPescaDao = new EventoPescaDao();
        return (ArrayList<EmbarcacaoMapaDTO>) eventoPescaDao.queryMapa();
    }
}
