
package services;

import dao.DaoDetalle;
import dao.impl.DaoDetalleImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.Detalle;

@Named(value = "DetalleP")
@ApplicationScoped
public class DetalleServices {
   private DaoDetalle DB;
    private Integer id = 0;
    private Detalle data = new Detalle();
    private String msg = null;

    @PostConstruct
    public void inicializarBean() {
        DB = new DaoDetalleImpl();
    }   
      public List<Detalle> DetalleSel() {
        List<Detalle> lista = null;
        try {
            lista = DB.DetalleSel();
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return lista;
    }
      
    public String DetalleGet(Integer id) {
        try {
            data = DB.DetalleGet(id);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return "Detalle?faces-redirect=true";
    }
     public Detalle DetalleGet() {
        Detalle C = new Detalle();
        try {
            C = DB.DetalleGet(id);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return C;
    }
  public String DetalleIns() {
        msg = null;
        try {
            msg = DB.DetalleIns(data);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return (msg == null) ? "Detalle?faces-redirect=true" : "DetalleError?faces-redirect=true";
    }
  public String DetalleUpd() {
        msg = null;
        try {
            msg = DB.DetalleUpd(data);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return (msg == null) ? "Detalle?faces-redirect=true" : "DetalleError?faces-redirect=true";
    }
  public String DetalleDel(Integer id) {
        msg = null;
        try {
            msg = DB.DetalleDel(id);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return (msg == null) ? "Detalle?faces-redirect=true" : "DetalleError?faces-redirect=true";
    }
   public String insertarD() {
        data = new Detalle();
        return "DetalleInsertar?faces-redirect=true";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Detalle getData() {
        return data;
    }

    public void setData(Detalle data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
