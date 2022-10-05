package test;
import dao.DaoCatalogo;
import dao.impl.DaoCatalogoImpl;
import dto.Catalogo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class TestDaoCatalogo {
    public static void main(String[] args) {
        DaoCatalogo dc=new DaoCatalogoImpl();
        List<Catalogo> lista=null;
        try {
            lista= dc.CatalogoSel();
            lista.forEach(t->{
                System.out.println(
                        "ID: "+t.getId()+"\nNombre: "+t.getNombre()+"\nPrecio: "+t.getPrecio()
                        +"\nCategoria: "+t.getCategoria()+"\nPlataforma: "+t.getPlataforma()+"\nStock: "+t.getStock()
                );
            });
        } catch (Exception e) {
            dc.getMensaje();
        }
        
        Catalogo cat=null;
        try {
            cat=dc.CatalogoGet(1);
            System.out.println("Nombre: "+cat.getNombre());
        } catch (Exception e) {
            dc.getMensaje();
        }
        Catalogo C=new Catalogo();
        C.setId(666);
        C.setNombre("Batman Arkham");
        C.setCategoria("Digital");
        C.setPlataforma("PC");
        C.setPrecio(60d);
        C.setStock(25);
        C.setImagen("BA.jpg");
        try {
            dc.CatalogoUpd(C);
            System.out.println("Fila actualizada");
        } catch (Exception e) {
            dc.getMensaje();
        }
        List<Integer> L=new ArrayList<>();
        L.add(40);
        try {
            dc.CatalogoDel(L);
            System.out.println("Registros eliminados");
        } catch (Exception e) {
            dc.getMensaje();
        }
    } 
}