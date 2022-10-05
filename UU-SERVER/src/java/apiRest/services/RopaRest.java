package apiRest.services;

import dao.DaoRopa;
import dao.impl.DaoRopaImpl;
import dto.Ropa;
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

@Path("/ropa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RopaRest {
    
    @GET
    @Path("/{id}")
    public Response ropaGet(@PathParam("id") int id) {
        DaoRopa DR = new DaoRopaImpl();
        Ropa R = DR.RopaGet(id);
        if (R == null) {
            String msg = "Ropa no encontrado con ID: " + id;
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            return Response.ok(R).build();
        }
    }
    
    @GET
    public Response ropaSel() {
        DaoRopa DR = new DaoRopaImpl();
        List<Ropa> R = DR.RopaSel();
        if (R == null) {
            String msg = "Sin Ropas";
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            GenericEntity<List<Ropa>> objecto
                    = new GenericEntity<List<Ropa>>(R) {
            };
            return Response.ok(objecto).build();
        }
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response ropaIns(Ropa R) {
        DaoRopa DR = new DaoRopaImpl();
        String msg = DR.RopaIns(R);
        return Response.ok(msg).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response ropaUpd(Ropa R) {
        DaoRopa DR = new DaoRopaImpl();
        String msg = DR.RopaUpd(R);
        return Response.ok(msg).build();
    }
    
    @DELETE
    @Path("/{ids}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public Response ropaDel(@PathParam("ids") String ids) {
        List<Integer> list = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        DaoRopa DR = new DaoRopaImpl();
        String msg = DR.RopaDel(list);
        return Response.ok(msg).build();
    }
    
}
