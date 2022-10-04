package dao.impl;

import java.util.List;
import dao.DaoMangas;
import model.Mangas;
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
public class DaoMangasImpl implements DaoMangas {

    Client cliente = ClientBuilder.newClient();

    private String mensaje;
    String URL = "http://localhost:8080/UU-SERVER/services/mangas/";

    public DaoMangasImpl() {
    }

    @Override
    public List<Mangas> mangasSel() {
        String target = URL;
        List<Mangas> list = null;
        try {
            list = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get((new GenericType<List<Mangas>>() {
                    }));
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public Mangas mangasGet(Integer id) {

        String target = URL + id.toString();
        Mangas M = new Mangas();
        try {
            M = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Mangas.class);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return M;
    }

    @Override
    public String mangasIns(Mangas M) {

        String target = URL;
        try {
            Response response = cliente.target(target).request().post(Entity.json(M));
            mensaje = (response.getStatus() == 200) ? null : response.getStatus() + " - "
                    + response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String mangasUpd(Mangas M) {
        String target = URL;
        try {
            Response response = cliente.target(target).request().put(Entity.json(M));
            mensaje = (response.getStatus() == 200) ? null : response.getStatusInfo().toString();
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    @Override
    public String mangasDel(Integer id) {
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
