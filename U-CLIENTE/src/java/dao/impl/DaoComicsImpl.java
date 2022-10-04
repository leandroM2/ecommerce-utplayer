package dao.impl;

import java.util.List;
import dao.DaoComics;
import model.Comics;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DaoComicsImpl implements DaoComics {

    Client cliente = ClientBuilder.newClient();
    private String mensaje;

    //String URL = "http://localhost:8084/U-SERVER/services/comics/";
    String URL = "http://localhost:8080/UU-SERVER/services/comics/";

    public DaoComicsImpl() {
    }

    @Override
    public List<Comics> comicsSel() {
        String target = URL;
        List<Comics> list = null;
        try {
            list = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get((new GenericType<List<Comics>>() {
                    }));
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Comics comicsGet(Integer id) {
        String target = URL + id.toString();
        Comics C = new Comics();
        try {
            C = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Comics.class);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return C;
    }

    @Override
    public String comicsIns(Comics C) {
        String target = URL;
        try {
            Response response = cliente.target(target).request().post(Entity.json(C));
            mensaje = (response.getStatus() == 200) ? null : response.getStatus() + " - "
                    + response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String comicsUpd(Comics C) {
        String target = URL;
        try {
            Response response = cliente.target(target).request().put(Entity.json(C));
            mensaje = (response.getStatus() == 200) ? null : response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /*
    @Override
    public String comicsDel(List<Integer> ids) {
        String lista = ids.toString();
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
     */
    @Override
    public String comicsDel(Integer id) {
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
