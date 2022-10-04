
package dao.impl;
import java.util.List;
import dao.DaoDetalle;
import model.Detalle;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
public class DaoDetalleImpl implements DaoDetalle {
 Client cliente = ClientBuilder.newClient();
    private String mensaje;
    String URL = "http://localhost:8080/UU-SERVER/services/Detalle/";

    public DaoDetalleImpl() {
    }

    @Override
    public List<Detalle> DetalleSel() {
       String target = URL;
        List<Detalle> list = null;
        try {
            list = cliente
                    .target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get((new GenericType<List<Detalle>>() {
                    }));
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    
    }

    @Override
    public Detalle DetalleGet(Integer id) {
    String target = URL + id.toString();
        Detalle C = new Detalle();
        try {
            C = cliente.target(target).request(MediaType.APPLICATION_JSON_TYPE)
                    .get(Detalle.class);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return C;
    }

    @Override
    public String DetalleIns(Detalle C) {
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
    public String DetalleUpd(Detalle C) {
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
    public String DetalleDel(Integer id) {
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
