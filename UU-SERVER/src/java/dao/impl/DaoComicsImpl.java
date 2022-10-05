package dao.impl;

import dto.Comics;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;
import dao.DaoComics;

public class DaoComicsImpl implements DaoComics {

    private final ConectaBD BD;
    private String mensaje;

    public DaoComicsImpl() {
        this.BD = new ConectaBD();
    }

    /**
     * SELECT (LEER) de la tabla Comics
     *
     * @return
     */
    @Override
    public List<Comics> ComicsSel() {
        List<Comics> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre, ")
                .append("editorial, ")
                .append("categoria, ")
                .append("precio, ")
                .append("stock, ")
                .append("imagen ")
                .append(" FROM comics");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Comics C = new Comics();
                C.setId(rs.getInt(1));
                C.setNombre(rs.getString(2));
                C.setEditorial(rs.getNString(3));
                C.setCategoria(rs.getString(4));
                C.setPrecio(rs.getDouble(5));
                C.setStock(rs.getInt(6));
                C.setImagen(rs.getString(7));
                list.add(C);
            }

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * SELECT WHERE (LEER) un elemento según ID
     *
     * @param id tipo int para elegir elemento
     * @return objeto cargado con datos del elemento
     */
    @Override
    public Comics ComicsGet(Integer id) {
        Comics C = new Comics();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre, ")
                .append("editorial, ")
                .append("categoria, ")
                .append("precio, ")
                .append("stock, ")
                .append("imagen ")
                .append(" FROM comics ")
                .append("WHERE id= ?");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                C.setId(rs.getInt(1));
                C.setNombre(rs.getString(2));
                C.setEditorial(rs.getNString(3));
                C.setCategoria(rs.getString(4));
                C.setPrecio(rs.getDouble(5));
                C.setStock(rs.getInt(6));
                C.setImagen(rs.getString(7));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return C;
    }

    /**
     * INSERT (CREAR) nuevo elemento de la tabla Comics
     *
     * @param C objeto de la clase Comics
     * @return mensaje de confirmación || excepción de error
     */
    @Override
    public String ComicsIns(Comics C) {
        mensaje = null;
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO comics( ")
                .append("nombre, ")
                .append("editorial, ")
                .append("categoria, ")
                .append("precio, ")
                .append("stock, ")
                .append("imagen ")
                .append(") VALUES (?,?,?,?,?,?) ");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, C.getNombre().toUpperCase().replaceAll("\\s+", " "));
            ps.setString(2, C.getEditorial());
            ps.setString(3, C.getCategoria());
            ps.setDouble(4, C.getPrecio());
            ps.setInt(5, C.getStock());
            ps.setString(6, C.getImagen());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas insertadas";
            }

        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * UPDATE (ACTUALIZAR) elemento de la tabla Comics
     *
     * @param C objeto de la clase Comics
     * @return mensaje de confirmación || excepción de error
     */
    @Override
    public String ComicsUpd(Comics C) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE comics SET ")
                .append("nombre = ?, ")
                .append("editorial = ?, ")
                .append("categoria = ?, ")
                .append("precio = ?, ")
                .append("stock = ?, ")
                .append("imagen = ? ")
                .append("WHERE id = ?");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, C.getNombre().toUpperCase().replaceAll("\\s+", " "));
            ps.setString(2, C.getEditorial());
            ps.setString(3, C.getCategoria());
            ps.setDouble(4, C.getPrecio());
            ps.setInt(5, C.getStock());
            ps.setString(6, C.getImagen());
            ps.setInt(7, C.getId());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "Cero filas actualizadas";
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * DELETE (ELIMINAR) borrar elemento según id
     *
     * @param ids int del elemento
     * @return mensaje de confirmación || excepción de error
     */
    @Override
    public String ComicsDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM comics WHERE ")
                .append("id= ? ");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            cn.setAutoCommit(false);
            boolean ok = true;
            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(1, ids.get(i));
                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    ok = false;
                    mensaje = "Cero filas actualizadas";
                }
                if (ok) {
                    cn.commit();
                } else {
                    cn.rollback();
                }
            }
            cn.setAutoCommit(true);
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * UTILITARIO
     *
     * @return excepción de error
     */
    @Override
    public String getMensaje() {
        return mensaje;
    }

}
