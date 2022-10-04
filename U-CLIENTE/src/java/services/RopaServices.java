package services;

import dao.DaoRopa;
import dao.impl.DaoRopaImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.Ropa;

@Named(value = "ropaP")
@ApplicationScoped
public class RopaServices {

    private DaoRopa DR;
    private Integer id = 0;
    private Ropa data = new Ropa();
    private String msg = null;

    @PostConstruct
    public void inicializarBean() {
        DR = new DaoRopaImpl();
    }

    public List<Ropa> ropaSel() {
        List<Ropa> lista = null;
        try {
            lista = DR.ropaSel();
        } catch (Exception e) {
            msg = DR.getMessage();
        }
        return lista;
    }

    public String ropaGet(Integer id) {
        try {
            data = DR.ropaGet(id);
        } catch (Exception e) {
            msg = DR.getMessage();
        }
        return "RopaActualizar?faces-redirect=true";
    }

    public Ropa ropaGet() {
        Ropa C = new Ropa();
        try {
            C = DR.ropaGet(id);
        } catch (Exception e) {
            msg = DR.getMessage();
        }
        return C;
    }

    public String ropaIns() {
        msg = null;
        try {
            msg = DR.ropaIns(data);
        } catch (Exception e) {
            msg = DR.getMessage();
        }
        return (msg == null) ? "Ropa?faces-redirect=true" : "RopaError?faces-redirect=true";
    }

    public String ropaUpd() {
        msg = null;
        try {
            msg = DR.ropaUpd(data);
        } catch (Exception e) {
            msg = DR.getMessage();
        }
        return (msg == null) ? "Ropa?faces-redirect=true" : "RopaError?faces-redirect=true";
    }

    public String ropaDel(Integer id) {
        msg = null;
        try {
            msg = DR.ropaDel(id);
        } catch (Exception e) {
            msg = DR.getMessage();
        }
        return (msg == null) ? "Ropa?faces-redirect=true" : "RopaError?faces-redirect=true";
    }
    /*
    public String listaDel(Integer id) {
        msg = null;
        List<Integer> L = null;
        try {
            L.add(id);
            msg=ropaDel(L);
        } catch (Exception e) {
            msg = DR.getMessage();
        }
        return msg;
    }
*/
    public String insertar() {
        data = new Ropa();
        return "RopaInsertar?faces-redirect=true";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ropa getData() {
        return data;
    }

    public void setData(Ropa data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
