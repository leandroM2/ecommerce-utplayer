package apiRest.services;

import dao.DaoMangas;
import dao.impl.DaoMangasImpl;
import dto.Mangas;
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

@Path("/mangas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


/**
 *
 * @author NICOLLE
 */
public class MangasRest {
    
    @GET
    @Path("/{id}")
    public Response mangasGet(@PathParam("id") int id) {
        DaoMangas DM = new DaoMangasImpl();
        Mangas M = DM.MangasGet(id);
        if (M == null) {
            String msg = "Manga no encontrado con ID: " + id;
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            return Response.ok(M).build();
        }
    }

    @GET
    public Response mangasSel() {
        DaoMangas DM = new DaoMangasImpl();
        List<Mangas> M = DM.MangasSel();
        if (M == null) {
            String msg = "Sin mangas";
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            GenericEntity<List<Mangas>> objecto
                    = new GenericEntity<List<Mangas>>(M) {
            };
            return Response.ok(objecto).build();
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response mangasIns(Mangas M) {
        DaoMangas DM = new DaoMangasImpl();
        String msg = DM.MangasIns(M);
        return Response.ok(msg).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response mangasUpd(Mangas M) {
        DaoMangas DM = new DaoMangasImpl();
        String msg = DM.MangasUpd(M);
        return Response.ok(msg).build();
    }

    @DELETE
    @Path("/{ids}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public Response mangasDel(@PathParam("ids") String ids) {
        List<Integer> list = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        DaoMangas DM = new DaoMangasImpl();
        String msg = DM.MangasDel(list);
        return Response.ok(msg).build();
    }
}
