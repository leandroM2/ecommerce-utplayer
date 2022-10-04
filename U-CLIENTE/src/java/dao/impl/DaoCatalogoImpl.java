package dao.impl;

import dao.DaoCatalogo;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Catalogo;

public class DaoCatalogoImpl implements DaoCatalogo {

    Client cliente = ClientBuilder.newClient();
    private String mensaje;

  
    String URL = "http://localhost:8080/UU-SERVER/services/catalogo/";

    public DaoCatalogoImpl() {
    }

    @Override
    public List<Catalogo> catalogoSel() {
        String target = URL;
        List<Catalogo> list = null;
        try {
            list = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get((new GenericType<List<Catalogo>>() {
                    }));
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Catalogo catalogoGet(Integer id) {
        String target = URL + id.toString();
        Catalogo C = new Catalogo();
        try {
            C = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Catalogo.class);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return C;
    }

    @Override
    public String catalogoIns(Catalogo C) {
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
    public String catalogoUpd(Catalogo C) {
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
    public String catalogoDel(Integer id) {
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
