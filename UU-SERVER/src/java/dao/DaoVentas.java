package dao;

import dto.Detalle;
import java.util.List;

public interface DaoVentas {
    /**
     * 
     * @return 
     */
    List<Object[]> ventasSel();

    /**
     * Este método emite las boletas y actualiza los stocks tras la venta
     *
     * @param detalle con la lista de parametros del cliente
     * @param metodoPago efectivo || tarjeta
     * @return return mensaje vacío si todo salió bien || retorna excepción ante
     * errores
     */
    String ventasIns(List<Detalle> detalle, String metodoPago);

    /**
     * método utilitario
     *
     * @return mensaje para excepciones
     */
    String getMensaje();
}
