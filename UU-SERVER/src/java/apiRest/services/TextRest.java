
package apiRest.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/texto")
@Produces(MediaType.TEXT_PLAIN)
public class TextRest {
    
    @GET
    @Path("/prueba")
    public String dataGet(){
        return "Probando";
    }
    @GET
    @Path("/saludo")
    public String saludoGet(@QueryParam("nombre") String nombre){
        return "hola "+nombre;
    }
    
    
    
}
