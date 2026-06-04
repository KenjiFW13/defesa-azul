package br.com.DefesaAzul.resource;

import br.com.DefesaAzul.bo.EmbarcacaoBo;
import br.com.DefesaAzul.entities.Embarcacao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import jakarta.ws.rs.ext.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

@Provider

@Path("/embarcacao")
public class EmbarcacaoResource {

    private EmbarcacaoBo embarcacaoBo = new EmbarcacaoBo();

    // Inserir
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Embarcacao embarcacao, @Context UriInfo uriInfo) throws SQLException, ClassNotFoundException {
        embarcacaoBo.inserirBO(embarcacao);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(embarcacao.getIdEmbarcacao());
        return Response.created(builder.build()).build();
    }

    // Deletar
    @DELETE
    @Path("{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("codigo") String codigo) throws SQLException, ClassNotFoundException {
        embarcacaoBo.deletarBO(codigo);
        return Response.ok().build();
    }

    // Update
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Embarcacao embarcacao, @PathParam("codigo") String codigo) throws SQLException, ClassNotFoundException {
        embarcacaoBo.atualizarBO(embarcacao);
        return Response.ok().build();
    }

    // Selecionar
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Embarcacao> selecionarRs() throws SQLException, ClassNotFoundException {
        return (ArrayList<Embarcacao>) embarcacaoBo.selecionarBO();
    }

    // Selecionar por código
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Embarcacao selecionarPorCodigoRs(@PathParam("codigo") String codigo) throws SQLException, ClassNotFoundException {
        return (Embarcacao) embarcacaoBo.selecionarPorCodigoBo(codigo);
    }
}
