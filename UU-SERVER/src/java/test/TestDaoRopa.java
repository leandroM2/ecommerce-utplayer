package test;
import dao.DaoRopa;
import dao.impl.DaoRopaImpl;
import dto.Ropa;
import java.util.ArrayList;
import java.util.List;
public class TestDaoRopa {
    public static void main(String[] args) {
        DaoRopa dc=new DaoRopaImpl();
        List<Ropa> lista=null;
        try {
            lista= dc.RopaSel();
            lista.forEach(t->{
                System.out.println(
                        "ID: "+t.getId()+"\nNombre: "+t.getNombre()+"\nPrecio: "+t.getPrecio()
                        +"\nCategoria: "+t.getCategoria()+"\nTalla: "+t.getTalla()+"\nStock: "+t.getStock()
                );
            });
        } catch (Exception e) {
            dc.getMensaje();
        }
        
        Ropa cat=null;
        try {
            cat=dc.RopaGet(1);
            System.out.println("Nombre: "+cat.getNombre());
        } catch (Exception e) {
            dc.getMensaje();
        }
        Ropa C=new Ropa();
        C.setId(666);
        C.setNombre("Yogger black panther");
        C.setCategoria("Pantalon");
        C.setTalla("L");
        C.setPrecio(60d);
        C.setStock(25);
        C.setImagen("PBP.jpg");
        try {
            dc.RopaUpd(C);
            System.out.println("Fila actualizada");
        } catch (Exception e) {
            dc.getMensaje();
        }
        List<Integer> L=new ArrayList<>();
        L.add(40);
        try {
            dc.RopaDel(L);
            System.out.println("Registros eliminados");
        } catch (Exception e) {
            dc.getMensaje();
        }
    } 
}