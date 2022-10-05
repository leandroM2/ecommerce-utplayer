package dao;

import dto.Boleta;
import java.util.List;

public interface DaoBoleta {

    /**
     * SELECT (LEER) de la tabla Catalogo
     *
     * @return
     */
    List<Boleta> BoletaSel();

    /**
     * SELECT WHERE (LEER) un elemento según ID
     *
     * @param id tipo int para elegir elemento
     * @return objeto cargado con datos del elemento
     */

    Boleta BoletaGet(Integer id);

    /**
     * INSERT (CREAR) nuevo elemento de la tabla Catalogo
     *
     * @param C objeto de la clase Catalogo
     * @return mensaje de confirmación || excepción de error
     */

    String BoletaIns(Boleta C);

    /**
     * UPDATE (ACTUALIZAR) elemento de la tabla Catalogo
     *
     * @param C objeto de la clase Catalogo
     * @return mensaje de confirmación || excepción de error
     */
    String BoletaUpd(Boleta C);

    /**
     * DELETE (ELIMINAR) borrar elemento según id
     *
     * @param ids int del elemento
     * @return mensaje de confirmación || excepción de error
     */

    String BoletaDel(List<Integer> ids);

    /**
     * UTILITARIO
     *
     * @return excepción de error
     */

    String getMensaje();
}
