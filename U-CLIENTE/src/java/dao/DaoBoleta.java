package dao;

import java.util.List;
import model.Boleta;

public interface DaoBoleta {

    public List<Boleta> BoletaSel();

    public Boleta BoletaGet(Integer id);

    public String BoletaIns(Boleta C);

    public String BoletaUpd(Boleta C);

    public String BoletaDel(Integer id);

    public String getMessage();
}
