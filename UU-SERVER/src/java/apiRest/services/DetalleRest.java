
package apiRest.services;
import dao.DaoDetalle;
import dao.impl.DaoDetalleImpl;
import dto.Detalle;
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

@Path("/Detalle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DetalleRest {
 @GET
    @Path("/{IdDetalle}")
    public Response BoletaGet(@PathParam("IdDetalle") int id) {
        DaoDetalle DB = new DaoDetalleImpl();
        Detalle C = DB.DetalleGet(id);
        if (C == null) {
            String msg = "Detalle no encontrado con ID: " + id;
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            return Response.ok(C).build();
        }
    }
    @GET
    public Response DetalleSel() {
        DaoDetalle DB = new DaoDetalleImpl();
        List<Detalle> d = DB.DetalleSel();
        if (d == null) {
            String msg = "Sin Detalle";
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            GenericEntity<List<Detalle>> objecto
                    = new GenericEntity<List<Detalle>>(d) {
            };
            return Response.ok(objecto).build();
        }
    }
     @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response DetalleIns(Detalle d) {
        DaoDetalle DB = new DaoDetalleImpl();
        String msg = DB.DetalleIns(d);
        return Response.ok(msg).build();
    }
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response DetalleUpd(Detalle d) {
        DaoDetalle DB = new DaoDetalleImpl();
        String msg = DB.DetalleUpd(d);
        return Response.ok(msg).build();
    }
    @DELETE
    @Path("/{ids}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public Response BoletaDel(@PathParam("ids") String ids) {
        List<Integer> list = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        DaoDetalle DB = new DaoDetalleImpl();
        String msg = DB.DetalleDel(list);
        return Response.ok(msg).build();
    }
}
