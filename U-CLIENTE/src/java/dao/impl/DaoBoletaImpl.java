package dao.impl;

import java.util.List;
import dao.DaoBoleta;
import model.Boleta;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DaoBoletaImpl implements DaoBoleta {

    Client cliente = ClientBuilder.newClient();
    private String mensaje;
    String URL = "http://localhost:8080/UU-SERVER/services/Boleta/";

    public DaoBoletaImpl() {
    }

    @Override
    public List<Boleta> BoletaSel() {
        String target = URL;
        List<Boleta> list = null;
        try {
            list = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get((new GenericType<List<Boleta>>() {
                    }));
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Boleta BoletaGet(Integer id) {
        String target = URL + id.toString();
        Boleta C = new Boleta();
        try {
            C = cliente.target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Boleta.class);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return C;
    }

    @Override
    public String BoletaIns(Boleta C) {
        String target = URL;
        try {
            Response response = cliente.target(target).request().post(Entity.json(C));
            mensaje = (response.getStatus() == 200) ? null : response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String BoletaUpd(Boleta C) {
        String target = URL;
        try {
            Response response = cliente.target(target).request().put(Entity.json(C));
            mensaje = (response.getStatus() == 200) ? null : response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String BoletaDel(Integer id) {
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
