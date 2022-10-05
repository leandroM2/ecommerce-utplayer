package dao.impl;

import dto.Boleta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBD;
import dao.DaoBoleta;

public class DaoBoletaImpl implements DaoBoleta {

    private final ConectaBD BD;
    private String mensaje;

    public DaoBoletaImpl() {
        this.BD = new ConectaBD();
    }

    /**
     * SELECT (LEER) de la tabla Catalogo
     *
     * @return
     */
    @Override
    public List<Boleta> BoletaSel() {
        List<Boleta> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_boleta,")
                .append("emp_RUC, ")
                .append("bol_fecha, ")
                .append("bol_metododepago ")
                .append(" FROM boleta");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Boleta C = new Boleta();
                C.setId_boleta(rs.getInt(1));
                C.setEmp_RUC(rs.getString(2));
                C.setBol_fecha(rs.getString(3));
                C.setBol_metododepago(rs.getString(4));
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
    public Boleta BoletaGet(Integer id) {
        Boleta C = new Boleta();
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id_boleta,")
                .append("emp_RUC, ")
                .append("bol_fecha, ")
                .append("bol_metododepago ")
                .append(" FROM boleta")
                .append("WHERE id_boleta= ?");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                C.setId_boleta(rs.getInt(1));
                C.setEmp_RUC(rs.getString(2));
                C.setBol_fecha(rs.getString(3));
                C.setBol_metododepago(rs.getString(4));
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return C;
        
    }
     

    /**
     * INSERT (CREAR) nuevo elemento de la tabla Catalogo
     *
     * @param C objeto de la clase Catalogo
     * @return mensaje de confirmación || excepción de error
     */
    @Override
    public String BoletaIns(Boleta C) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO boleta( ")
                .append("emp_RUC, ")
                .append("bol_fecha, ")
                .append("bol_metododepago ")
                .append(") VALUES (?,?,?) ");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, C.getEmp_RUC());
            ps.setString(2, C.getBol_fecha());
            ps.setString(3, C.getBol_metododepago());
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
     * UPDATE (ACTUALIZAR) elemento de la tabla Catalogo
     *
     * @param C objeto de la clase Catalogo
     * @return mensaje de confirmación || excepción de error
     */
    @Override
    public String BoletaUpd(Boleta C) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE boleta SET ")
                .append("emp_RUC = ?, ")
                .append("ID_colaborador = ?, ")
                .append("bol_metododepago = ? ")
                .append("WHERE id_boleta = ?");
        try (Connection cn = BD.getConnection()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, C.getEmp_RUC());
            ps.setString(2, C.getBol_fecha());
            ps.setString(3, C.getBol_metododepago());
            ps.setInt(4, C.getId_boleta());
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
    public String BoletaDel(List<Integer> ids) {
        String mm="";
        mm=DetalleDel(ids);
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM boleta WHERE ")
                .append("id_boleta=? ");
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
 public String DetalleDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM det_boleta WHERE ")
                .append("ID_boleta=? ");
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
