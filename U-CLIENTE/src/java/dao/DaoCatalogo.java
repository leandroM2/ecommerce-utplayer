package dao;

import model.Catalogo;
import java.util.List;

public interface DaoCatalogo {

    /**
     * SELECT (LEER) de la tabla Catalogo
     *
     * @return
     */
    List<Catalogo> catalogoSel();

    /**
     * SELECT WHERE (LEER) un elemento según ID
     *
     * @param id tipo int para elegir elemento
     * @return objeto cargado con datos del elemento
     */
    Catalogo catalogoGet(Integer id);

    /**
     * INSERT (CREAR) nuevo elemento de la tabla Catalogo
     *
     * @param C objeto de la clase Catalogo
     * @return mensaje de confirmación || excepción de error
     */
    String catalogoIns(Catalogo C);

    /**
     * UPDATE (ACTUALIZAR) elemento de la tabla Catalogo
     *
     * @param C objeto de la clase Catalogo
     * @return mensaje de confirmación || excepción de error
     */
    String catalogoUpd(Catalogo C);

    /**
     * DELETE (ELIMINAR) borrar elemento según id
     *
     * @param ids int del elemento
     * @return mensaje de confirmación || excepción de error
     */
    String catalogoDel(Integer id);

    /**
     * UTILITARIO
     *
     * @return excepción de error
     */
    String getMessage();
}
