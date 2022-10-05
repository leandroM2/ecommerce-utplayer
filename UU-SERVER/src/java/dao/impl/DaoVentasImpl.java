/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoVentas;
import dto.Detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import util.ConectaBD;

public class DaoVentasImpl implements DaoVentas {

    private ConectaBD conectaDb;
    private String mensaje;

    public DaoVentasImpl() {
        this.conectaDb = new ConectaBD();
    }
    /**
     * CARGA DATOS DE LA TABLA VENTAS
     * @return lista de objetos
     */
    @Override
    public List<Object[]> ventasSel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override

    /**
     * Este método emite las boletas y actualiza los stocks tras la venta
     *
     * @param detalle con la lista de parametros del cliente
     * @param metodoPago efectivo || tarjeta
     * @return return mensaje vacío si todo salió bien || retorna excepción ante
     * errores
     */
    public String ventasIns(List<Detalle> detalle, String metodoPago) {
        String mensaje = "";
        StringBuilder sqlDet = new StringBuilder();
        StringBuilder sqlBol = new StringBuilder();
        sqlBol.append("INSERT INTO boleta (")
                .append("emp_RUC,")
                .append("bol_fecha,")
                .append("bol_metododepago")
                .append(") VALUES ('12876549354',current_timestamp,?)");
        sqlDet.append("INSERT INTO det_boleta (")
                .append("ID_producto,")
                .append("ID_boleta,")
                .append("det_cantidad")
                .append(") VALUES (?,?,?)");
        StringBuilder sqlProdGet = new StringBuilder();
        sqlProdGet.append("SELECT ")
                .append("stock")
                .append(" FROM producto WHERE id = ?");
        StringBuilder sqlProdUpd = new StringBuilder();
        sqlProdUpd.append("UPDATE producto SET ")
                .append("stock = ?")
                .append(" WHERE id = ?");
        try (Connection cn = conectaDb.getConnection();
                PreparedStatement psBol = cn.prepareStatement(sqlBol.toString(),
                        PreparedStatement.RETURN_GENERATED_KEYS);
                PreparedStatement psDet = cn.prepareStatement(sqlDet.toString());
                PreparedStatement psProdGet = cn.prepareStatement(sqlProdGet.toString());
                PreparedStatement psProdUpd = cn.prepareStatement(sqlProdUpd.toString());) {

            cn.setAutoCommit(false); // desactiva autoCommit
            boolean ok = true;
            Integer idBoleta = null;
            //cambios realizados
            psBol.setString(1, metodoPago);
            psBol.executeUpdate();

            try (ResultSet rs = psBol.getGeneratedKeys()) {
                if (rs.next()) {
                    idBoleta = rs.getInt(1);
                } else {
                    mensaje = "No se pudo crear la boleta: "
                            + sqlBol.toString();
                    ok = false;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage() + sqlBol.toString();
                ok = false;
            }

            for (int i = 0; i < detalle.size(); i++) {
                Detalle det = (Detalle) detalle.get(i);

                // se inserta el detalle
                psDet.setInt(1, det.getID_producto());
                psDet.setInt(2, idBoleta);
                psDet.setInt(3, det.getDet_cantidad());

                int ctos = psDet.executeUpdate();
                if (ctos == 0) {
                    mensaje = "No se pudo insertar detalle"
                            + sqlDet.toString();
                    ok = false;
                    break;
                }

                // se obtiene stock actual
                psProdGet.setInt(1, det.getID_producto());
                Integer stock = null;
                try (ResultSet rs = psProdGet.executeQuery()) {
                    if (rs.next()) {
                        stock = rs.getInt(1);
                    }
                } catch (SQLException e) {
                    mensaje = e.getMessage() + ": "
                            + sqlProdGet.toString();
                    ok = false;
                    break;
                }

                // se actualiza stock
                if (stock != null) {
                    stock -= det.getDet_cantidad();
                    psProdUpd.setInt(1, stock);
                    psProdUpd.setInt(2, det.getID_producto());
                    ctos = psProdUpd.executeUpdate();
                    if (ctos == 0) {
                        mensaje = "No se pudo actualizar stock "
                                + sqlProdUpd.toString();
                        ok = false;
                        break;
                    }
                }
                //stock vacio
                if (stock < 0) {
                    mensaje = "NO HAY STOCK PARA ESTE PRODUCTO";
                    cn.rollback();
                }

            }

            if (ok) {
                cn.commit();
            } else {
                mensaje = "ERROR";
                cn.rollback();
            }

            cn.setAutoCommit(true);

        } catch (SQLException e) {

            mensaje = e.getMessage();
        }
        return mensaje;
    }
    /**
     * método utilitario
     *
     * @return mensaje para excepciones
     */
    @Override
    public String getMensaje() {
        return mensaje;
    }

}
