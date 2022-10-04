package dao.impl;

import java.util.List;
import dao.DaoUsuarios;
import model.Usuarios;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DaoUsuariosImpl implements DaoUsuarios {

    Client cliente = ClientBuilder.newClient();
    private String mensaje;

    //String URL = "http://localhost:8084/U-SERVER/services/usuarios/";
    String URL = "http://localhost:8080/UU-SERVER/services/usuarios/";

    public DaoUsuariosImpl() {
    }

    @Override
    public Usuarios ColabLogin(String correo, String clave) {
        String target=URL+correo+"/"+clave;
        Usuarios U=new Usuarios();
        try {
            U = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Usuarios.class);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return U;
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

}
