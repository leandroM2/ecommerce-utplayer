package dao;

import dto.Mangas;
import java.util.List;

public interface DaoMangas {

    /**
     * SELECT (LEER) de la tabla mangas
     *
     * @return
     */
    List<Mangas> MangasSel();

    /**
     * SELECT WHERE (LEER) un elemento según ID
     *
     * @param id tipo int para elegir elemento
     * @return objeto cargado con datos del elemento
     */

    Mangas MangasGet(Integer id);

    /**
     * INSERT (CREAR) nuevo elemento de la tabla mangas
     *
     * @param C objeto de la clase mangas
     * @return mensaje de confirmación || excepción de error
     */
    String MangasIns(Mangas C);

    /**
     * UPDATE (ACTUALIZAR) elemento de la tabla mangas
     *
     * @param C objeto de la clase mangas
     * @return mensaje de confirmación || excepción de error
     */
    String MangasUpd(Mangas C);

    /**
     * DELETE (ELIMINAR) borrar elemento según id
     *
     * @param ids int del elemento
     * @return mensaje de confirmación || excepción de error
     */
    String MangasDel(List<Integer> ids);

    /**
     * UTILITARIO
     *
     * @return excepción de error
     */

    String getMensaje();
}
