package br.com.DefesaAzul.resource;

import br.com.DefesaAzul.bo.RegiaoBo;
import br.com.DefesaAzul.entities.Regiao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/regiao")
public class RegiaoResource {

    private RegiaoBo regiaoBo = new RegiaoBo();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Regiao regiao, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        regiaoBo.inserirBO(regiao);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(regiao.getIdRegiao()));
        return Response.created(builder.build()).build();
    }

    // Deletar
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        regiaoBo.deletarBO(codigo);
        return Response.ok().build();
    }

    // Update
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Regiao regiao, @PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        regiaoBo.atualizarBO(regiao);
        return Response.ok().build();
    }

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Regiao> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Regiao>) regiaoBo.selecionarBO();
    }

    // Selecionar por código
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Regiao selecionarPorCodigoRs(@PathParam("codigo") int codigo) throws SQLException, ClassNotFoundException {
        return (Regiao) regiaoBo.selecionarPorCodigoBo(codigo);
    }
}
