package services;

import dao.DaoMangas;
import dao.impl.DaoMangasImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.Mangas;

@Named(value = "mangasP")
@ApplicationScoped

/**
 *
 * @author NICOLLE
 */
public class MangasServices {
    
    private DaoMangas DM;
    private Integer id = 0;
    private Mangas data = new Mangas();
    private String msg = null;

    @PostConstruct
    public void inicializarBean() {
        DM = new DaoMangasImpl();
    }

    public List<Mangas> mangasSel() {
        List<Mangas> lista = null;
        try {
            lista = DM.mangasSel();
        } catch (Exception e) {
            msg = DM.getMessage();
        }
        return lista;
    }

    public String mangasGet(Integer id) {
        try {
            data = DM.mangasGet(id);
        } catch (Exception e) {
            msg = DM.getMessage();
        }
        return "MangaActualizar?faces-redirect=true";
    }

    public Mangas mangasGet() {
        Mangas M = new Mangas();
        try {
            M = DM.mangasGet(id);
        } catch (Exception e) {
            msg = DM.getMessage();
        }
        return M;
    }

    public String mangasIns() {
        msg = null;
        try {
            msg = DM.mangasIns(data);
        } catch (Exception e) {
            msg = DM.getMessage();
        }
        return (msg == null) ? "Manga?faces-redirect=true" : "MangaError?faces-redirect=true";
    }

    public String mangasUpd() {
        msg = null;
        try {
            msg = DM.mangasUpd(data);
        } catch (Exception e) {
            msg = DM.getMessage();
        }
        return (msg == null) ? "Manga?faces-redirect=true" : "MangaError?faces-redirect=true";
    }

    public String mangasDel(Integer id) {
        msg = null;
        try {
            msg = DM.mangasDel(id);
        } catch (Exception e) {
            msg = DM.getMessage();
        }
        return (msg == null) ? "Manga?faces-redirect=true" : "MangaError?faces-redirect=true";
    }
    public String insertar() {
        data = new Mangas();
        return "MangaInsertar?faces-redirect=true";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mangas getData() {
        return data;
    }

    public void setData(Mangas data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}