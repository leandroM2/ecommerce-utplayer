package test;
import dao.DaoComics;
import dao.impl.DaoComicsImpl;
import dto.Comics;
import java.util.ArrayList;
import java.util.List;
public class TestDaoCOMIC {
    public static void main(String[] args) {
        DaoComics dc=new DaoComicsImpl();
        List<Comics> lista=null;
        try {
            lista= dc.ComicsSel();
            lista.forEach(t->{
                System.out.println(
                        "ID: "+t.getId()+"\nNombre: "+t.getNombre()+"\nPrecio: "+t.getPrecio()
                        +"\nCategoria: "+t.getCategoria()+"\nEditorial: "+t.getEditorial()+"\nStock: "+t.getStock()
                );
            });
        } catch (Exception e) {
            dc.getMensaje();
        }
        
        Comics cat=null;
        try {
            cat=dc.ComicsGet(1);
            System.out.println("Nombre: "+cat.getNombre());
        } catch (Exception e) {
            dc.getMensaje();
        }
        Comics C=new Comics();
        C.setId(20);
        C.setNombre("Batman hush");
        C.setCategoria("heroes");
        C.setEditorial("DC");
        C.setPrecio(60d);
        C.setStock(25);
        C.setImagen("BH.jpg");
        try {
            dc.ComicsIns(C);
            System.out.println("Fila insertada");
        } catch (Exception e) {
            dc.getMensaje();
        }
        C.setId(20);
        C.setNombre("Batman ACTUALIZADO");
        C.setCategoria("heroes");
        C.setEditorial("DC");
        C.setPrecio(60d);
        C.setStock(25);
        C.setImagen("BH.jpg");
        try {
            dc.ComicsUpd(C);
            System.out.println("Fila actalizada");
        } catch (Exception e) {
            dc.getMensaje();
        } 
        List<Integer> L=new ArrayList<>();
        L.add(40);
        try {
            dc.ComicsDel(L);
            System.out.println("Registros eliminados");
        } catch (Exception e) {
            dc.getMensaje();
        }
    } 
}