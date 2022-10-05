package dao;

import dto.Detalle;
import java.util.List;

public interface DaoDetalle {

    /**
     * SELECT (LEER) de la tabla det_boleta
     *
     * @return
     */
    List<Detalle> DetalleSel();

    /**
     * SELECT WHERE (LEER) un elemento según ID
     *
     * @param id tipo int para elegir elemento
     * @return objeto cargado con datos del elemento
     */

    Detalle DetalleGet(Integer id);

    /**
     * INSERT (CREAR) nuevo elemento de la tabla det_boleta
     *
     * @param C objeto de la clase det_boleta
     * @return mensaje de confirmación || excepción de error
     */

    String DetalleIns(Detalle C);

    /**
     * UPDATE (ACTUALIZAR) elemento de la tabla det_boleta
     *
     * @param C objeto de la clase det_boleta
     * @return mensaje de confirmación || excepción de error
     */
    String DetalleUpd(Detalle C);

    /**
     * DELETE (ELIMINAR) borrar elemento según id
     *
     * @param ids int del elemento
     * @return mensaje de confirmación || excepción de error
     */

    String DetalleDel(List<Integer> ids);

    /**
     * UTILITARIO
     *
     * @return excepción de error
     */

    String getMensaje();
}
