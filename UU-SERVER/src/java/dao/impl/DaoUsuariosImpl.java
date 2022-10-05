package dao.impl;

import dto.Usuarios;
import java.sql.*;
import util.ConectaBD;
import dao.DaoUsuarios;

public class DaoUsuariosImpl implements DaoUsuarios {

    private final ConectaBD BD;
    private String mensaje;

    public DaoUsuariosImpl() {
        this.BD = new ConectaBD();
    }
    @Override
    /**
     * ColabLogin: Comprueba el correo y contraseña para validad el login
     *
     * @param correo a validar
     * @param clave a validar
     * @return objecto usuarios cargado en caso se haa confirmado la
     * autorización
     */
    public Usuarios ColabLogin(String correo, String clave) {
        Usuarios user = new Usuarios();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("ape,")
                .append("correo,")
                .append("tipo")
                .append(" FROM usuarios ")
                .append(" WHERE correo= ? AND ")
                .append("clave=AES_ENCRYPT(?,?)");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, correo);
            ps.setString(2, clave);
            ps.setString(3, clave);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setApe(rs.getString(2));
                user.setCorreo(rs.getString(3));
                user.setTipo(rs.getString(4));    
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }

        return user;
    }
    /**
     * utilitario
     *
     * @return retorna excepciones.
     */
    @Override
    public String getMensaje() {
        return mensaje;
    }

}
