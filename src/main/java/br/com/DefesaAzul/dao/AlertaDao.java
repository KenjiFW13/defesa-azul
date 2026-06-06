package br.com.DefesaAzul.dao;

import br.com.DefesaAzul.conexoes.ConexaoFactory;
import br.com.DefesaAzul.entities.Alerta;
import br.com.DefesaAzul.entities.AlertaDTO;

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

    // Query JOIN
    public ArrayList<AlertaDTO> queryJoin() throws SQLException {
        ArrayList<AlertaDTO> listaAlertaDto = new ArrayList<AlertaDTO>();
        PreparedStatement stmt = minhaConexao.prepareStatement("""
            SELECT
                a.id_alerta,
                emb.mmsi_embarcacao,
                emb.nm_embarcacao,
                pe.lat_posicao_evento,
                pe.lon_posicao_evento,
                r.nome_regioes,
                a.status_alertas,
                a.dt_geracao_alerta
            FROM T_DA_ALERTAS a
            JOIN T_DA_EVENTO_PESCA ep   ON a.id_evento_pesca    = ep.id_evento_pesca
            JOIN T_DA_EMBARCACAO emb    ON ep.id_embarcacao      = emb.id_embarcacao
            LEFT JOIN T_DA_POSICAO_EVENTO pe ON ep.id_evento_pesca = pe.id_evento_pesca
            LEFT JOIN T_DA_REGIOES_EVENTOS re ON ep.id_evento_pesca = re.id_evento_pesca
            LEFT JOIN T_DA_REGIOES r    ON re.id_regioes         = r.id_regioes
            ORDER BY a.dt_geracao_alerta DESC
            """);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            AlertaDTO objAlertaDTO = new AlertaDTO();
            objAlertaDTO.setIdAlertaDto(rs.getLong(1));
            objAlertaDTO.setMmsi(rs.getString(2));
            objAlertaDTO.setNomeEmbarcacao(rs.getString(3));
            objAlertaDTO.setLatitude(rs.getDouble(4));
            objAlertaDTO.setLongitude(rs.getDouble(5));
            objAlertaDTO.setAreaProtegida(rs.getString(6));
            objAlertaDTO.setStatus(rs.getString(7));
            objAlertaDTO.setTimestamp(rs.getString(8));

            listaAlertaDto.add(objAlertaDTO);
        }

        return listaAlertaDto;
    }

    // updateStatus
    public String updateStatus(AlertaDTO alertaDTO) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement
                ("Update T_DA_ALERTAS set status_alertas =? where id_alerta =?");
        stmt.setString(1, alertaDTO.getStatus());
        stmt.setLong(2, alertaDTO.getIdAlertaDto());

        stmt.executeUpdate();
        stmt.close();

        return "Status Atualizado";
    }
}
