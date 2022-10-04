package dao.impl;

import java.util.List;
import dao.DaoRopa;
import model.Ropa;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DaoRopaImpl implements DaoRopa {

    Client cliente = ClientBuilder.newClient();
    private String mensaje;

    //String URL = "http://localhost:8084/U-SERVER/services/comics/";
    String URL = "http://localhost:8080/UU-SERVER/services/ropa/";

    public DaoRopaImpl() {
    }

    @Override
    public List<Ropa> ropaSel() {
       String target = URL;
        List<Ropa> list = null;
        try {
            list = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get((new GenericType<List<Ropa>>() {
                    }));
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Ropa ropaGet(Integer id) {
        String target = URL + id.toString();
        Ropa R = new Ropa();
        try {
            R = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Ropa.class);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return R;
    }

    @Override
    public String ropaIns(Ropa R) {
        String target = URL;
        try {
            Response response = cliente.target(target).request().post(Entity.json(R));
            mensaje = (response.getStatus() == 200) ? null : response.getStatus() + " - "
                    + response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String ropaUpd(Ropa R) {
         String target = URL;
        try {
            Response response = cliente.target(target).request().put(Entity.json(R));
            mensaje = (response.getStatus() == 200) ? null : response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String ropaDel(Integer id) {
      String lista = id.toString();
        lista = lista.replace("[", "")
                .replace("]", "")
                .replace(" ", "");
        String target = URL + lista;
        try {
            Response response = cliente.target(target).request().delete();
            mensaje = (response.getStatus() == 200) ? null : response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String getMessage() {
        return mensaje;
    }
}
