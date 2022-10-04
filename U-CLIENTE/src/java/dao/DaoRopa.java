package dao;

import model.Ropa;
import java.util.List;

public interface DaoRopa {
public List<Ropa> ropaSel();

    public Ropa ropaGet(Integer id);

    public String ropaIns(Ropa C);

    public String ropaUpd(Ropa C);

    public String ropaDel(Integer id);

    public String getMessage();
}
