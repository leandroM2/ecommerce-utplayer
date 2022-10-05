package apiRest.services;

import dao.DaoCatalogo;

import dao.impl.DaoCatalogoImpl;

import dto.Catalogo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/catalogo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CatalogoRest {

    @GET
    @Path("/{id}")
    public Response catalogoGet(@PathParam("id") int id) {
        DaoCatalogo DC = new DaoCatalogoImpl();
        Catalogo C = DC.CatalogoGet(id);
        if (C == null) {
            String msg = "Catalogo no encontrado con ID: " + id;
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            return Response.ok(C).build();
        }
    }

    @GET
    public Response catalogoSel() {
        DaoCatalogo DC = new DaoCatalogoImpl();
        List<Catalogo> C = DC.CatalogoSel();
        if (C == null) {
            String msg = "Sin catalogos";
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            GenericEntity<List<Catalogo>> objecto
                    = new GenericEntity<List<Catalogo>>(C) {
            };
            return Response.ok(objecto).build();
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response catalogoIns(Catalogo C) {
        DaoCatalogo DC = new DaoCatalogoImpl();
        String msg = DC.CatalogoIns(C);
        return Response.ok(msg).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response catalogoUpd(Catalogo C) {
        DaoCatalogo DC = new DaoCatalogoImpl();
        String msg = DC.CatalogoUpd(C);
        return Response.ok(msg).build();
    }

    @DELETE
    @Path("/{ids}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public Response catalogoDel(@PathParam("ids") String ids) {
        List<Integer> list = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        DaoCatalogo DC = new DaoCatalogoImpl();
        String msg = DC.CatalogoDel(list);
        return Response.ok(msg).build();
    }

}