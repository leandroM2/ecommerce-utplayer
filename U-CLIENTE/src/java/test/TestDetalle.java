
package test;

import dao.DaoDetalle;
import dao.impl.DaoDetalleImpl;
import model.Detalle;
import java.util.List;
public class TestDetalle {
     public static void main(String[] args) {
        DaoDetalle dao = new DaoDetalleImpl();

        System.out.println("INSERTANDO");
        Detalle Detalle = new Detalle();
        Detalle.setID_boleta(66);
        Detalle.setID_producto(20);
        Detalle.setDet_cantidad(65);
        try {
            String msg = dao.DetalleIns(Detalle);
            System.out.println("Respuesta:" + msg);
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }
  System.out.println("Listado");
        try {
            List<Detalle> lista = dao.DetalleSel();
            lista.forEach(t -> {
                System.out.println(t.getIdDetalle());
            });
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }

        System.out.println("INDIVIDUAL");
        try {
            Detalle C = dao.DetalleGet(1);
            System.out.println(C.getID_boleta());
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }

    }

}
