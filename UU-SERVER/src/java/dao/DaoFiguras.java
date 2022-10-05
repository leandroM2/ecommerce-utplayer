package dao;

import dto.Figuras;
import java.util.List;

public interface DaoFiguras {

    /**
     * SELECT (LEER) de la tabla figuras
     *
     * @return
     */
    List<Figuras> FigurasSel();

    /**
     * SELECT WHERE (LEER) un elemento según ID
     *
     * @param id tipo int para elegir elemento
     * @return objeto cargado con datos del elemento
     */
    Figuras FigurasGet(Integer id);

    /**
     * INSERT (CREAR) nuevo elemento de la tabla figuras
     *
     * @param C objeto de la clase figuras
     * @return mensaje de confirmación || excepción de error
     */
    String FigurasIns(Figuras C);

    /**
     * UPDATE (ACTUALIZAR) elemento de la tabla figuras
     *
     * @param C objeto de la clase figuras
     * @return mensaje de confirmación || excepción de error
     */
    String FigurasUpd(Figuras C);

    /**
     * DELETE (ELIMINAR) borrar elemento según id
     *
     * @param ids int del elemento
     * @return mensaje de confirmación || excepción de error
     */
    String FigurasDel(List<Integer> ids);

    /**
     * UTILITARIO
     *
     * @return excepción de error
     */

    String getMensaje();
}
