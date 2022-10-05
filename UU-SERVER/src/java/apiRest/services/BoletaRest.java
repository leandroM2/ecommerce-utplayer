package apiRest.services;

import dao.DaoBoleta;
import dao.impl.DaoBoletaImpl;
import dto.Boleta;
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

@Path("/Boleta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BoletaRest {
 @GET
    @Path("/{id_boleta}")
    public Response BoletaGet(@PathParam("id_boleta") int id) {
        DaoBoleta DB = new DaoBoletaImpl();
        Boleta C = DB.BoletaGet(id);
        if (C == null) {
            String msg = "Boleta no encontrado con ID: " + id;
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            return Response.ok(C).build();
        }
    }
    
    @GET
    public Response BoletaSel() {
        DaoBoleta DB = new DaoBoletaImpl();
        List<Boleta> b = DB.BoletaSel();
        if (b == null) {
            String msg = "Sin Boleta";
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            GenericEntity<List<Boleta>> objecto
                    = new GenericEntity<List<Boleta>>(b) {
            };
            return Response.ok(objecto).build();
        }
    }
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response BoletaIns(Boleta b) {
        DaoBoleta DB = new DaoBoletaImpl();
        String msg = DB.BoletaIns(b);
        return Response.ok(msg).build();
    }
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response BoletaUpd(Boleta b) {
        DaoBoleta DB = new DaoBoletaImpl();
        String msg = DB.BoletaUpd(b);
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
        DaoBoleta DB = new DaoBoletaImpl();
        String msg = DB.BoletaDel(list);
        return Response.ok(msg).build();
    }
}
