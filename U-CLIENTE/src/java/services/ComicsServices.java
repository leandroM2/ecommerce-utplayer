package services;

import dao.DaoComics;
import dao.impl.DaoComicsImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import model.Comics;

@Named(value = "comicsP")
@ApplicationScoped
public class ComicsServices {

    private DaoComics DC;
    private Integer id = 0;
    private Comics data = new Comics();
    private String msg = null;

    @PostConstruct
    public void inicializarBean() {
        DC = new DaoComicsImpl();
    }

    public List<Comics> comicsSel() {
        List<Comics> lista = null;
        try {
            lista = DC.comicsSel();
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return lista;
    }

    public String comicsGet(Integer id) {
        data = new Comics();
        try {
            data = DC.comicsGet(id);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return "ComicsActualizar?faces-redirect=true";
    }

    public Comics comicsGet() {
        Comics C = new Comics();
        try {
            C = DC.comicsGet(id);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return C;
    }

    public String comicsIns() {
        msg = null;
        try {
            msg = DC.comicsIns(data);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return (msg == null) ? "Comics?faces-redirect=true" : "ComicsError?faces-redirect=true";
    }

    public String comicsUpd() {
        msg = null;
        try {
            msg = DC.comicsUpd(data);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return (msg == null) ? "Comics?faces-redirect=true" : "ComicsError?faces-redirect=true";
    }

    public String comicsDel(Integer id) {
        msg = null;
        try {
            msg = DC.comicsDel(id);
        } catch (Exception e) {
            msg = DC.getMessage();
        }
        return (msg == null) ? "Comics?faces-redirect=true" : "ComicsError?faces-redirect=true";
    }

    public String insertar() {
        data = new Comics();
        return "ComicsInsertar?faces-redirect=true";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comics getData() {
        return data;
    }

    public void setData(Comics data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
