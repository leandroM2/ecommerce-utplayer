package dao;

import dto.Comics;
import java.util.List;

public interface DaoComics {

    /**
     * SELECT (LEER) de la tabla Comics
     *
     * @return
     */
    List<Comics> ComicsSel();

    Comics ComicsGet(Integer id);

    /**
     * INSERT (CREAR) nuevo elemento de la tabla Comics
     *
     * @param C objeto de la clase Comics
     * @return mensaje de confirmación || excepción de error
     */
    String ComicsIns(Comics C);

    /**
     * UPDATE (ACTUALIZAR) elemento de la tabla Comics
     *
     * @param C objeto de la clase Comics
     * @return mensaje de confirmación || excepción de error
     */
    String ComicsUpd(Comics C);

    /**
     * DELETE (ELIMINAR) borrar elemento según id
     *
     * @param ids int del elemento
     * @return mensaje de confirmación || excepción de error
     */
    String ComicsDel(List<Integer> ids);

    /**
     * UTILITARIO
     *
     * @return excepción de error
     */

    String getMensaje();
}
