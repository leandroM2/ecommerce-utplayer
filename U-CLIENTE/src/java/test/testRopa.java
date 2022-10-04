package test;

import dao.DaoRopa;
import dao.impl.DaoRopaImpl;
import java.util.List;
import model.Ropa;

public class testRopa {

    public static void main(String[] args) {
        
        DaoRopa dao = new DaoRopaImpl();
        //INSERTAR
//        System.out.println("INSERTANDO");
//        Ropa ropa = new Ropa();
//        ropa.setNombre("PRUEBAJAVA");
//        ropa.setPrecio(15d);
//        ropa.setTalla("L");
//        ropa.setCategoria("PRUEBAJAVA");
//        ropa.setStock(100);
//        ropa.setImagen("imagen.jpg");
//        try {
//            String msg = dao.ropaIns(ropa);
//            System.out.println("Respuesta:" + msg);
//        } catch (Exception e) {
//            System.out.println(dao.getMessage() + " - " + e.getMessage());
//        }
        System.out.println("Listado");
        try {
            List<Ropa> lista = dao.ropaSel();
            lista.forEach(t -> {
                System.out.println(t.getId());
            });
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }

        System.out.println("INDIVIDUAL");
        try {
            Ropa R = dao.ropaGet(5);
            System.out.println(R.getImagen());
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }

    }

}
