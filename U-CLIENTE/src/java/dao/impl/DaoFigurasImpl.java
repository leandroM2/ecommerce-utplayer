package dao.impl;

import java.util.List;
import dao.DaoFiguras;
import model.Figuras;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author NICOLLE
 */
public class DaoFigurasImpl implements DaoFiguras {

    Client cliente = ClientBuilder.newClient();
    private String mensaje;
    String URL = "http://localhost:8080/UU-SERVER/services/figuras/";

    public DaoFigurasImpl() {
    }

    @Override
    public List<Figuras> figurasSel() {
        String target = URL;
        List<Figuras> list = null;
        try {
            list = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get((new GenericType<List<Figuras>>() {
                    }));
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Figuras figurasGet(Integer id) {
        String target = URL + id.toString();
        Figuras F = new Figuras();
        try {
            F = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Figuras.class);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return F;
    }

    @Override
    public String figurasIns(Figuras F) {
        String target = URL;
        try {
            Response response = cliente.target(target).request().post(Entity.json(F));
            mensaje = (response.getStatus() == 200) ? null : response.getStatus() + " - "
                    + response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String figurasUpd(Figuras F) {
        String target = URL;
        try {
            Response response = cliente.target(target).request().put(Entity.json(F));
            mensaje = (response.getStatus() == 200) ? null : response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String figurasDel(Integer id) {
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
