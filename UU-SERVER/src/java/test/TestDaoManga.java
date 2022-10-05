package test;
import dao.DaoMangas;
import dao.impl.DaoMangasImpl;
import dto.Mangas;
import java.util.ArrayList;
import java.util.List;
public class TestDaoManga {
    public static void main(String[] args) {
        DaoMangas dc=new DaoMangasImpl();
        List<Mangas> lista=null;
        try {
            lista= dc.MangasSel();
            lista.forEach(t->{
                System.out.println(
                        "ID: "+t.getId()+"\nNombre: "+t.getNombre()+"\nPrecio: "+t.getPrecio()
                        +"\nCategoria: "+t.getCategoria()+"\nPublisher: "+t.getPublisher()+"\nStock: "+t.getStock()
                );
            });
        } catch (Exception e) {
            dc.getMensaje();
        }
        
        Mangas cat=null;
        try {
            cat=dc.MangasGet(1);
            System.out.println("Nombre: "+cat.getNombre());
        } catch (Exception e) {
            dc.getMensaje();
        }
        Mangas C=new Mangas();
        C.setId(666);
        C.setNombre("Dragon Ball 1");
        C.setCategoria("Shonen");
        C.setPublisher("Toei");
        C.setPrecio(60d);
        C.setStock(25);
        C.setImagen("DBZ.jpg");
        try {
            dc.MangasUpd(C);
            System.out.println("Fila actualizada");
        } catch (Exception e) {
            dc.getMensaje();
        }
        List<Integer> L=new ArrayList<>();
        L.add(40);
        try {
            dc.MangasDel(L);
            System.out.println("Registros eliminados");
        } catch (Exception e) {
            dc.getMensaje();
        }
    } 
}