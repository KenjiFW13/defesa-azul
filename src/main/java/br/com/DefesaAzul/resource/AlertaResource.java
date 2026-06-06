package br.com.DefesaAzul.resource;

import br.com.DefesaAzul.bo.AlertaBo;
import br.com.DefesaAzul.entities.Alerta;
import br.com.DefesaAzul.entities.AlertaDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/alerta")
public class AlertaResource {

    private AlertaBo alertaBo = new AlertaBo();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Alerta alerta, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        alertaBo.inserirBO(alerta);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(alerta.getIdAlerta()));
        return Response.created(builder.build()).build();
    }

    // Deletar
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        alertaBo.deletarBO(codigo);
        return Response.ok().build();
    }

    // PUT atualizar completo
    @PUT
    @Path("/atualizar/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Alerta alerta, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        alertaBo.atualizarBO(alerta);
        return Response.ok().build();
    }

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Alerta> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Alerta>) alertaBo.selecionarBO();
    }

    // Selecionar por Id
    @GET
    @Path("/buscar/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Alerta selecionarPorCodigoRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        return (Alerta) alertaBo.selecionarPorCodigoBo(codigo);
    }

    // Query Join
    @GET
    @Path("/queryJoin")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<AlertaDTO> queryJoinRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<AlertaDTO>) alertaBo.queryJoinBo();
    }

    @PUT
    @Path("/status/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStatusRs(AlertaDTO alertaDTO, @PathParam("codigo") Long codigo) throws SQLException, ClassNotFoundException {
        alertaDTO.setIdAlertaDto(codigo);
        alertaBo.updateStatusBo(alertaDTO);
        return Response.ok().build();
    }
}
