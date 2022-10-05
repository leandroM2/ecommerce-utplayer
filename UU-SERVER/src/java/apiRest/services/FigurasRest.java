/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apiRest.services;

import dao.DaoFiguras;
import dao.impl.DaoFigurasImpl;
import dto.Figuras;
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
@Path("/figuras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
/**
 *
 * @author NICOLLE
 */
public class FigurasRest {
    
    @GET
    @Path("/{id}")
    public Response figurasGet(@PathParam("id") int id) {
        DaoFiguras DF = new DaoFigurasImpl();
        Figuras F = DF.FigurasGet(id);
        if (F == null) {
            String msg = "Figuras no encontrado con ID: " + id;
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            return Response.ok(F).build();
        }
    }

    @GET
    public Response figurasSel() {
        DaoFiguras DF = new DaoFigurasImpl();
        List<Figuras> F = DF.FigurasSel();
        if (F == null) {
            String msg = "Sin figuras";
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            GenericEntity<List<Figuras>> objecto
                    = new GenericEntity<List<Figuras>>(F) {
            };
            return Response.ok(objecto).build();
        }
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response figurasIns(Figuras F) {
        DaoFiguras DF = new DaoFigurasImpl();
        String msg = DF.FigurasIns(F);
        return Response.ok(msg).build();
    }

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response figurasUpd(Figuras F) {
        DaoFiguras DF = new DaoFigurasImpl();
        String msg = DF.FigurasUpd(F);
        return Response.ok(msg).build();
    }

    @DELETE
    @Path("/{ids}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public Response figurasDel(@PathParam("ids") String ids) {
        List<Integer> list = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        DaoFiguras DF = new DaoFigurasImpl();
        String msg = DF.FigurasDel(list);
        return Response.ok(msg).build();
    }

}
