package dao.impl;

import dto.Detalle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;
import dao.DaoDetalle;

public class DaoDetalleImpl implements DaoDetalle {

    private final ConectaBD BD;
    private String mensaje;

    public DaoDetalleImpl() {
        this.BD = new ConectaBD();
    }

    /**
     * SELECT (LEER) de la tabla det_boleta
     *
     * @return
     */
    @Override
    public List<Detalle> DetalleSel() {
        List<Detalle> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IdDetalle,")
                .append("ID_producto, ")
                .append("ID_boleta, ")
                .append("det_cantidad ")
                .append(" FROM det_boleta");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Detalle C = new Detalle();
                C.setIdDetalle(rs.getInt(1));
                C.setID_producto(rs.getInt(2));
                C.setID_boleta(rs.getInt(3));
                C.setDet_cantidad(rs.getInt(4));
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
    public Detalle DetalleGet(Integer id) {
        Detalle C = new Detalle();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("IdDetalle,")
                .append("ID_producto, ")
                .append("ID_boleta, ")
                .append("det_cantidad ")
                .append(" FROM det_boleta")
                .append("WHERE IdDetalle= ?");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                C.setIdDetalle(rs.getInt(1));
                C.setID_producto(rs.getInt(2));
                C.setID_boleta(rs.getInt(3));
                C.setDet_cantidad(rs.getInt(4));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return C;
    }

    /**
     * INSERT (CREAR) nuevo elemento de la tabla det_boleta
     *
     * @param C objeto de la clase det_boleta
     * @return mensaje de confirmación || excepción de error
     */
    @Override
    public String DetalleIns(Detalle C) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO det_boleta( ")
                .append("ID_producto, ")
                .append("ID_boleta, ")
                .append("det_cantidad ")
                .append(") VALUES (?,?,?) ");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, C.getID_producto());
            ps.setInt(2, C.getID_boleta());
            ps.setInt(3, C.getDet_cantidad());
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
     * UPDATE (ACTUALIZAR) elemento de la tabla det_boleta
     *
     * @param C objeto de la clase det_boleta
     * @return mensaje de confirmación || excepción de error
     */
    @Override
    public String DetalleUpd(Detalle C) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE det_boleta SET ")
                .append("ID_producto = ?, ")
                .append("ID_boleta = ?, ")
                .append("det_cantidad = ? ")
                .append("WHERE IdDetalle = ?");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, C.getID_producto());
            ps.setInt(2, C.getID_boleta());
            ps.setInt(3, C.getDet_cantidad());
            ps.setInt(4, C.getIdDetalle());
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
    public String DetalleDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM boleta WHERE ")
                .append("id_boleta= ? ");
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
