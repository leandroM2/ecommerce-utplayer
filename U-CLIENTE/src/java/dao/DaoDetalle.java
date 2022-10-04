package dao;


import java.util.List;
import model.Detalle;
public interface DaoDetalle {

    public List<Detalle> DetalleSel();

    public Detalle DetalleGet(Integer id);

    public String DetalleIns(Detalle C);

    public String DetalleUpd(Detalle C);

    public String DetalleDel(Integer id);

    public String getMessage();
  
}
