package apiRest.services;

import dao.DaoUsuarios;
import dao.impl.DaoUsuariosImpl;
import dto.Usuarios;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosRest {

    @GET
    @Path("/{correo}/{clave}")
    public Response comicsIns(@PathParam("correo") String correo, @PathParam("clave") String clave) {
        DaoUsuarios DC = new DaoUsuariosImpl();
        Usuarios U = DC.ColabLogin(correo, clave);
        if (U == null) {
            String msg = "Contraseña o correo incorrectos. Intente de nuevo";
            return Response.ok(msg, MediaType.TEXT_PLAIN).build();
        } else {
            return Response.ok(U).build();
        }
    }
}
