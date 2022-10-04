package test;

import dao.DaoComics;
import dao.impl.DaoComicsImpl;
import java.util.List;
import model.Comics;

public class testComics {

    public static void main(String[] args) {
        
        DaoComics dao = new DaoComicsImpl();
        
        System.out.println("INSERTANDO");
        Comics comics = new Comics();
        comics.setNombre("PRUEBAJAVA");
        comics.setCategoria("PRUEBAJAVA");
        comics.setEditorial("PRUEBAJAVA");
        comics.setStock(100);
        comics.setPrecio(20d);
        comics.setImagen("imagen.jpg");
        try {
            String msg = dao.comicsIns(comics);
            System.out.println("Respuesta:" + msg);
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }
        System.out.println("Listado");
        try {
            List<Comics> lista = dao.comicsSel();
            lista.forEach(t -> {
                System.out.println(t.getId());
            });
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }

        System.out.println("INDIVIDUAL");
        try {
            Comics C = dao.comicsGet(1);
            System.out.println(C.getNombre());
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }

    }

}
