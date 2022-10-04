
package dao;
import java.util.List;
import model.Figuras;
public interface DaoFiguras {

    public List<Figuras> figurasSel();

    public Figuras figurasGet(Integer id);

    public String figurasIns(Figuras F);

    public String figurasUpd(Figuras F);

    public String figurasDel(Integer id);

    public String getMessage();
}
