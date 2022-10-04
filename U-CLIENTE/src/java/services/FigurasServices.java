package services;
import dao.DaoFiguras;
import dao.impl.DaoFigurasImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import model.Figuras;

@Named(value = "figurasP")
@ApplicationScoped

/**
 *
 * @author NICOLLE
 */
public class FigurasServices {
    

    private DaoFiguras DF;
    private Integer id = 0;
    private Figuras data = new Figuras();
    private String msg = null;

    @PostConstruct
    public void inicializarBean() {
        DF = new DaoFigurasImpl();
    }

    public List<Figuras> figurasSel() {
        List<Figuras> lista = null;
        try {
            lista = DF.figurasSel();
        } catch (Exception e) {
            msg = DF.getMessage();
        }
        return lista;
    }

    public String figurasGet(Integer id) {
        try {
            data = DF.figurasGet(id);
        } catch (Exception e) {
            msg = DF.getMessage();
        }
        return "FiguraActualizar?faces-redirect=true";
    }

    public Figuras figurasGet() {
        Figuras F = new Figuras();
        try {
            F = DF.figurasGet(id);
        } catch (Exception e) {
            msg = DF.getMessage();
        }
        return F;
    }

    public String figurasIns() {
        msg = null;
        try {
            msg = DF.figurasIns(data);
        } catch (Exception e) {
            msg = DF.getMessage();
        }
        return (msg == null) ? "Figura?faces-redirect=true" : "FiguraError?faces-redirect=true";
    }

    public String figurasUpd() {
        msg = null;
        try {
            msg = DF.figurasUpd(data);
        } catch (Exception e) {
            msg = DF.getMessage();
        }
        return (msg == null) ? "Figura?faces-redirect=true" : "FiguraError?faces-redirect=true";
    }

    public String figurasDel(Integer id) {
        msg = null;
        try {
            msg = DF.figurasDel(id);
        } catch (Exception e) {
            msg = DF.getMessage();
        }
        return (msg == null) ? "Figura?faces-redirect=true" : "FiguraError?faces-redirect=true";
    }
    public String insertar() {
        data = new Figuras();
        return "FiguraInsertar?faces-redirect=true";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Figuras getData() {
        return data;
    }

    public void setData(Figuras data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
