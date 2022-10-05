package test;
import dao.DaoFiguras;
import dao.impl.DaoFigurasImpl;
import dto.Figuras;
import java.util.ArrayList;
import java.util.List;
public class TestDaoFiguras {
    public static void main(String[] args) {
        DaoFiguras dc=new DaoFigurasImpl();
        List<Figuras> lista=null;
        try {
            lista= dc.FigurasSel();
            lista.forEach(t->{
                System.out.println(
                        "ID: "+t.getId()+"\nNombre: "+t.getNombre()+"\nPrecio: "+t.getPrecio()
                        +"\nCategoria: "+t.getCategoria()+"\nMarca: "+t.getMarca()+"\nStock: "+t.getStock()
                );
            });
        } catch (Exception e) {
            dc.getMensaje();
        }
        
        Figuras cat=null;
        try {
            cat=dc.FigurasGet(1);
            System.out.println("Nombre: "+cat.getNombre());
        } catch (Exception e) {
            dc.getMensaje();
        }
        Figuras C=new Figuras();
        C.setId(666);
        C.setNombre("Funko pop! Ironman");
        C.setCategoria("pop!");
        C.setMarca("Funko");
        C.setPrecio(60d);
        C.setStock(25);
        C.setImagen("IMF.jpg");
        try {
            dc.FigurasUpd(C);
            System.out.println("Fila actualizada");
        } catch (Exception e) {
            dc.getMensaje();
        }
        List<Integer> L=new ArrayList<>();
        L.add(40);
        try {
            dc.FigurasDel(L);
            System.out.println("Registros eliminados");
        } catch (Exception e) {
            dc.getMensaje();
        }
    } 
}