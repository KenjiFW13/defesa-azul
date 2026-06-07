package br.com.DefesaAzul.dao;

import br.com.DefesaAzul.conexoes.ConexaoFactory;
import br.com.DefesaAzul.entities.EmbarcacaoMapaDTO;
import br.com.DefesaAzul.entities.EventoPesca;

import java.sql.*;
import java.util.ArrayList;

public class EventoPescaDao {

    public Connection minhaConexao;

    public EventoPescaDao() throws SQLException, ClassNotFoundException {
        this.minhaConexao = new ConexaoFactory().conexao();
    }

    // Inserir
    public String inserir(EventoPesca eventoPesca) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Insert Into T_DA_EVENTO_PESCA values (?,?,?,?,?,?)");
        stmt.setString(1, eventoPesca.getCodigo());
        stmt.setString(2, eventoPesca.getTipo());
        stmt.setDate(3, Date.valueOf(eventoPesca.getDataInicio()));
        stmt.setDate(4, Date.valueOf(eventoPesca.getDataFim()));
        stmt.setDate(5, Date.valueOf(eventoPesca.getDataCarga()));
        stmt.setString(6, eventoPesca.getIdEmbarcacao());


        stmt.execute();
        stmt.close();

        return "Evento cadastrado";
    }

    // Deletar
    public String deletar(int codigo) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("Delete From T_DA_EVENTO_PESCA where ID_EVENTO_PESCA =?");
        stmt.setInt(1, codigo);

        stmt.execute();
        stmt.close();

        return "Evento deletado";
    }

    // UpDate
    public String atualizar(EventoPesca eventoPesca) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_DA_EVENTO_PESCA set ID_EVENTOS_PESCA =?, TIPO_EVENTOS_PESCA =?, DT_INICIO_EVENTOS_PESCA =?, DT_FIM_EVENTOS_PESCA =?, DT_CARGA =?, ID_EMBARCACAO=? where ID_EVENTO_PESCA =?");
        stmt.setString(1, eventoPesca.getCodigo());
        stmt.setString(2, eventoPesca.getTipo());
        stmt.setDate(3, Date.valueOf(eventoPesca.getDataInicio()));
        stmt.setDate(4, Date.valueOf(eventoPesca.getDataFim()));
        stmt.setDate(5, Date.valueOf(eventoPesca.getDataCarga()));
        stmt.setString(6, eventoPesca.getIdEmbarcacao());
        stmt.setInt(7, eventoPesca.getIdEvento());

        stmt.executeUpdate();
        stmt.close();

        return "Evento Atualizado";
    }

    // Select
    public ArrayList<EventoPesca> selecionar() throws SQLException {
        ArrayList<EventoPesca> listaEvento = new ArrayList<EventoPesca>();
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_DA_EVENTO_PESCA");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            EventoPesca objEventoPesca = new EventoPesca();
            objEventoPesca.setIdEvento(rs.getInt(1));
            objEventoPesca.setCodigo(rs.getString(2));
            objEventoPesca.setTipo(rs.getString(3));
            objEventoPesca.setDataInicio(rs.getDate(4).toLocalDate());
            objEventoPesca.setDataFim(rs.getDate(5).toLocalDate());
            objEventoPesca.setDataCarga(rs.getDate(6).toLocalDate());
            objEventoPesca.setIdEmbarcacao(rs.getString(7));

            listaEvento.add(objEventoPesca);
        }
        return listaEvento;
    }

    // Select / Código
    public EventoPesca selecionarPorCodigo(int codigo) throws SQLException {
        EventoPesca objEventoPesca = null;
        PreparedStatement stmt = minhaConexao.prepareStatement("select * from T_DA_EVENTO_PESCA where ID_EVENTO_PESCA = ?");
        stmt.setInt(1, codigo);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            objEventoPesca = new EventoPesca();
            objEventoPesca.setIdEvento(rs.getInt(1));
            objEventoPesca.setCodigo(rs.getString(2));
            objEventoPesca.setTipo(rs.getString(3));
            objEventoPesca.setDataInicio(rs.getDate(4).toLocalDate());
            objEventoPesca.setDataFim(rs.getDate(5).toLocalDate());
            objEventoPesca.setDataCarga(rs.getDate(6).toLocalDate());
            objEventoPesca.setIdEmbarcacao(rs.getString(7));
        }

        rs.close();
        stmt.close();

        return objEventoPesca;
    }

    public ArrayList<EmbarcacaoMapaDTO> queryMapa() throws SQLException {
        ArrayList<EmbarcacaoMapaDTO> listaEmbarcacaoMapa = new ArrayList<EmbarcacaoMapaDTO>();
        PreparedStatement stmt = minhaConexao.prepareStatement("""
            SELECT
                emb.mmsi_embarcacao,
                emb.nm_embarcacao,
                pe.lat_posicao_evento,
                pe.lon_posicao_evento,
                mp.velocidade_media_nos_metricas_pesca,
                MAX(CASE WHEN ae.autorizada_autorizacoes_embarcacao = 'S' THEN 1 ELSE 0 END) AS autorizada
            FROM T_DA_EVENTO_PESCA ep
            JOIN T_DA_EMBARCACAO emb
                ON ep.id_embarcacao = emb.id_embarcacao
            LEFT JOIN T_DA_POSICAO_EVENTO pe
                ON ep.id_evento_pesca = pe.id_evento_pesca
            LEFT JOIN T_DA_METRICAS_PESCA mp
                ON ep.id_evento_pesca = mp.id_evento_pesca
            LEFT JOIN T_DA_AUTORIZACOES_EMBARCACAO ae
                ON emb.id_embarcacao = ae.id_embarcacao
            WHERE pe.lat_posicao_evento IS NOT NULL
              AND pe.lon_posicao_evento IS NOT NULL
            GROUP BY
                emb.mmsi_embarcacao,
                emb.nm_embarcacao,
                pe.lat_posicao_evento,
                pe.lon_posicao_evento,
                mp.velocidade_media_nos_metricas_pesca""");

        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            EmbarcacaoMapaDTO objEmbarcacaoMapaDTO = new EmbarcacaoMapaDTO();
            objEmbarcacaoMapaDTO.setMmsi(rs.getString(1));
            objEmbarcacaoMapaDTO.setNome(rs.getString(2));
            objEmbarcacaoMapaDTO.setLatitude(rs.getDouble(3));
            objEmbarcacaoMapaDTO.setLongitude(rs.getDouble(4));
            objEmbarcacaoMapaDTO.setVelocidade(rs.getDouble(5));
            objEmbarcacaoMapaDTO.setAutorizada(rs.getInt(6) == 1);  // MAX retorna 0 ou 1

            listaEmbarcacaoMapa.add(objEmbarcacaoMapaDTO);
        }
        return listaEmbarcacaoMapa;
    }
}
