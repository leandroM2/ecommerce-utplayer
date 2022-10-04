package services;

import dao.DaoBoleta;
import dao.impl.DaoBoletaImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.Boleta;

@Named(value = "BoletaP")
@ApplicationScoped
public class BoletaServices {

    private DaoBoleta DB;
    private Integer id = 0;
    private Boleta data = new Boleta();
    private String msg = null;

    @PostConstruct
    public void inicializarBean() {
        DB = new DaoBoletaImpl();
    }

    public List<Boleta> BoletaSel() {
        List<Boleta> lista = null;
        try {
            lista = DB.BoletaSel();
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return lista;
    }

    public String BoletaGet(Integer id) {
        try {
            data = DB.BoletaGet(id);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return "Boleta?faces-redirect=true";
    }

    public Boleta BoletaGet() {
        Boleta C = new Boleta();
        try {
            C = DB.BoletaGet(id);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return C;
    }

    public String BoletaIns() {
        msg = null;
        try {
            msg = DB.BoletaIns(data);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return (msg == null) ? "Boleta?faces-redirect=true" : "BoletaError?faces-redirect=true";
    }

    public String BoletaUpd() {
        msg = null;
        try {
            msg = DB.BoletaUpd(data);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return (msg == null) ? "Boleta?faces-redirect=true" : "BoletaError?faces-redirect=true";
    }
 public String BoletaDel(Integer id) {
        msg = null;
        try {
            msg = DB.BoletaDel(id);
        } catch (Exception e) {
            msg = DB.getMessage();
        }
        return (msg == null) ? "Boleta?faces-redirect=true" : "BoletaError?faces-redirect=true";
    }
    public String insertarB() {
        data = new Boleta();
        return "BoletaInsertar?faces-redirect=true";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boleta getData() {
        return data;
    }

    public void setData(Boleta data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
