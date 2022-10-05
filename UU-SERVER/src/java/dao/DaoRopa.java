package dao;

import dto.Ropa;
import java.util.List;

public interface DaoRopa {

    /**
     * SELECT (LEER) de la tabla ropa
     *
     * @return
     */
    List<Ropa> RopaSel();

    /**
     * SELECT WHERE (LEER) un elemento según ID
     *
     * @param id tipo int para elegir elemento
     * @return objeto cargado con datos del elemento
     */

    Ropa RopaGet(Integer id);

    /**
     * INSERT (CREAR) nuevo elemento de la tabla ropa
     *
     * @param C objeto de la clase ropa
     * @return mensaje de confirmación || excepción de error
     */
    String RopaIns(Ropa C);

    /**
     * UPDATE (ACTUALIZAR) elemento de la tabla ropa
     *
     * @param C objeto de la clase ropa
     * @return mensaje de confirmación || excepción de error
     */
    String RopaUpd(Ropa C);

    /**
     * DELETE (ELIMINAR) borrar elemento según id
     *
     * @param ids int del elemento
     * @return mensaje de confirmación || excepción de error
     */
    String RopaDel(List<Integer> ids);

    /**
     * UTILITARIO
     *
     * @return excepción de error
     */

    String getMensaje();
}
