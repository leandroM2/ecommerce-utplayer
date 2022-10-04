package services;

import dao.DaoCatalogo;
import dao.impl.DaoCatalogoImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.Catalogo;

@Named(value = "catalogo")
@ApplicationScoped
public class CatalogoServices {

    private DaoCatalogo DC;
    private Integer id = 0;
    private Catalogo dataC = new Catalogo();
    private String msg = null;
    private String link;

    @PostConstruct
    public void inicializarBean() {
        DC = new DaoCatalogoImpl();
    }

    public List<Catalogo> catalogoSel() {
        List<Catalogo> lista = null;
        try {
            lista = DC.catalogoSel();
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return lista;
    }

    public String probando() {
        msg = null;
        try {
            msg = DC.catalogoIns(dataC);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return (msg == null) ? "/U-CLIENTE/faces/Catalogo?faces-redirect=true" : "CatalogoError?faces-redirect=true";
    }

    public Catalogo catalogoGet() {
        Catalogo C = new Catalogo();
        try {
            C = DC.catalogoGet(id);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return C;
    }

    public String catalogoGet(Integer id) {
        try {
            dataC = DC.catalogoGet(id);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return "CatalogoActualizar?faces-redirect=true";
    }

    public String catalogoDel(Integer id) {
        msg = null;
        try {
            msg = DC.catalogoDel(id);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return (msg == null) ? "Catalogo?faces-redirect=true" : "CatalogoError?faces-redirect=true";
    }

    public String catalogoIns() {
        msg = null;
        try {
            msg = DC.catalogoIns(dataC);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return (msg == null) ? "Catalogo?faces-redirect=true" : "CatalogoError?faces-redirect=true";
    }

    public String catalogoUpd() {
        msg = null;
        try {
            msg = DC.catalogoUpd(dataC);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return (msg == null) ? "Catalogo?faces-redirect=true" : "CatalogoError?faces-redirect=true";
    }

    public String insertar() {
        dataC = new Catalogo();
        return "CatalogoInsertar?faces-redirect=true";
    }

    public DaoCatalogo getDC() {
        return DC;
    }

    public void setDC(DaoCatalogo DC) {
        this.DC = DC;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Catalogo getDataC() {
        return dataC;
    }

    public void setDataC(Catalogo dataC) {
        this.dataC = dataC;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
