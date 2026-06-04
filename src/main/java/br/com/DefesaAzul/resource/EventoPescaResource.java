package br.com.DefesaAzul.resource;

import br.com.DefesaAzul.bo.EventoPescaBo;
import br.com.DefesaAzul.entities.EventoPesca;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("evento")
public class EventoPescaResource {

    private EventoPescaBo eventoPescaBo = new EventoPescaBo();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(EventoPesca eventoPesca, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        eventoPescaBo.inserirBO(eventoPesca);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(eventoPesca.getIdEvento()));
        return Response.created(builder.build()).build();
    }

    // Deletar
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        eventoPescaBo.deletarBO(codigo);
        return Response.ok().build();
    }

    // Update
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(EventoPesca eventoPesca, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        eventoPescaBo.atualizarBO(eventoPesca);
        return Response.ok().build();
    }

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<EventoPesca> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<EventoPesca>) eventoPescaBo.selecionarBO();
    }

    // Selecionar por código
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public EventoPesca selecionarPorCodigoRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        return (EventoPesca) eventoPescaBo.selecionarPorCodigoBo(codigo);
    }
}
