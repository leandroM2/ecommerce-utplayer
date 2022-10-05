package dao;

import dto.Catalogo;
import java.util.List;

public interface DaoCatalogo {

    /**
     * SELECT (LEER) de la tabla Catalogo
     *
     * @return
     */
    List<Catalogo> CatalogoSel();

    /**
     * SELECT WHERE (LEER) un elemento según ID
     *
     * @param id tipo int para elegir elemento
     * @return objeto cargado con datos del elemento
     */
    Catalogo CatalogoGet(Integer id);

    /**
     * INSERT (CREAR) nuevo elemento de la tabla Catalogo
     *
     * @param C objeto de la clase Catalogo
     * @return mensaje de confirmación || excepción de error
     */
    String CatalogoIns(Catalogo C);

    /**
     * UPDATE (ACTUALIZAR) elemento de la tabla Catalogo
     *
     * @param C objeto de la clase Catalogo
     * @return mensaje de confirmación || excepción de error
     */
    String CatalogoUpd(Catalogo C);

    /**
     * DELETE (ELIMINAR) borrar elemento según id
     *
     * @param ids int del elemento
     * @return mensaje de confirmación || excepción de error
     */
    String CatalogoDel(List<Integer> ids);

    /**
     * UTILITARIO
     *
     * @return excepción de error
     */
    String getMensaje();
}
