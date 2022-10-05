/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DaoVentas;
import dao.impl.DaoVentasImpl;
import dto.Detalle;
import java.util.ArrayList;
import java.util.List;

public class testVentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DaoVentas dv = new DaoVentasImpl();
        String metodoPago = "EFECTIVO";
        Detalle det01= new Detalle();
        det01.setID_producto(1);
        det01.setDet_cantidad(1);
        
//        Detalle det02= new Detalle();
//        det02.setIdProducto(2);
//        det02.setDetCantidad(1);
        List<Detalle> list = new ArrayList<>();
        list.add(det01);
       // list.add(det02);
        
        try {
            String a=dv.ventasIns(list,metodoPago);
            System.out.println("Exito");
            System.out.println(a);

        } catch (Exception e) {
            System.out.println(dv.getMensaje());
            
        }

    }
    
}
