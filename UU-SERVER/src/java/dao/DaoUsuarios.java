package dao;

import java.util.List;
import dto.Usuarios;

public interface DaoUsuarios {

    /**
     * ColabLogin: Comprueba el correo y contraseña para validad el login
     *
     * @param correo a validar
     * @param clave a validar
     * @return objecto usuarios cargado en caso se haa confirmado la
     * autorización
     */
    Usuarios ColabLogin(String correo, String clave);

    /**
     * utilitario
     *
     * @return retorna excepciones.
     */
    String getMensaje();
}
