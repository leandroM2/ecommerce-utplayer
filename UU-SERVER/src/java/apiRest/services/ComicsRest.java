package apiRest.services;

import dao.DaoComics;
import dao.impl.DaoComicsImpl;
import dto.Comics;
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

@Path("/comics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComicsRest {

    @GET
    @Path("/{id}")
    public Response comicsGet(@PathParam("id") int id) {
        DaoComics DC = new DaoComicsImpl();
        Comics C = DC.ComicsGet(id);
        if (C == null) {
            String msg = "Comics no encontrado con ID: " + id;
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            return Response.ok(C).build();
        }
    }

    @GET
    public Response comicsSel() {
        DaoComics DC = new DaoComicsImpl();
        List<Comics> C = DC.ComicsSel();
        if (C == null) {
            String msg = "Sin comics";
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            GenericEntity<List<Comics>> objecto
                    = new GenericEntity<List<Comics>>(C) {
            };
            return Response.ok(objecto).build();
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response comicsIns(Comics C) {
        DaoComics DC = new DaoComicsImpl();
        String msg = DC.ComicsIns(C);
        return Response.ok(msg).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response comicsUpd(Comics C) {
        DaoComics DC = new DaoComicsImpl();
        String msg = DC.ComicsUpd(C);
        return Response.ok(msg).build();
    }

    @DELETE
    @Path("/{ids}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public Response comicsDel(@PathParam("ids") String ids) {
        List<Integer> list = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        DaoComics DC = new DaoComicsImpl();
        String msg = DC.ComicsDel(list);
        return Response.ok(msg).build();
    }

}
