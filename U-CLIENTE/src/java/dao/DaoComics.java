package dao;

import java.util.List;
import model.Comics;

public interface DaoComics {

    public List<Comics> comicsSel();

    public Comics comicsGet(Integer id);

    public String comicsIns(Comics C);

    public String comicsUpd(Comics C);

    public String comicsDel(Integer id);

    public String getMessage();
}
