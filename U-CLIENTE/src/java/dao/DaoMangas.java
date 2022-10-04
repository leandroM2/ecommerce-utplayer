package dao;
import java.util.List;
import model.Mangas;

public interface DaoMangas {

    public List<Mangas> mangasSel();

    public Mangas mangasGet(Integer id);

    public String mangasIns(Mangas M);

    public String mangasUpd(Mangas M);

    public String mangasDel(Integer id);

    public String getMessage();
}
