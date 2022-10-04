package test;

import dao.DaoBoleta;
import dao.impl.DaoBoletaImpl;
import model.Boleta;
import java.util.List;
public class TestBoleta {

    public static void main(String[] args) {
        DaoBoleta dao = new DaoBoletaImpl();

        System.out.println("INSERTANDO");
        Boleta Boleta = new Boleta();
        Boleta.setEmp_RUC("12876549354");
        Boleta.setBol_fecha("2029-10-12");
        Boleta.setBol_metododepago("visa");
        try {
            String msg = dao.BoletaIns(Boleta);
            System.out.println("Respuesta:" + msg);
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }
  System.out.println("Listado");
        try {
            List<Boleta> lista = dao.BoletaSel();
            lista.forEach(t -> {
                System.out.println(t.getId_boleta());
            });
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }

        System.out.println("INDIVIDUAL");
        try {
            Boleta C = dao.BoletaGet(1);
            System.out.println(C.getBol_metododepago());
        } catch (Exception e) {
            System.out.println(dao.getMessage() + " - " + e.getMessage());
        }

    }

}
