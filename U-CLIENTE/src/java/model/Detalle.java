package model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Detalle {

    private int IdDetalle;
    private int ID_producto;
    private int ID_boleta;
    private int det_cantidad;

    public int getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(int IdDetalle) {
        this.IdDetalle = IdDetalle;
    }

    public int getID_producto() {
        return ID_producto;
    }

    public void setID_producto(int ID_producto) {
        this.ID_producto = ID_producto;
    }

    public int getID_boleta() {
        return ID_boleta;
    }

    public void setID_boleta(int ID_boleta) {
        this.ID_boleta = ID_boleta;
    }

    public int getDet_cantidad() {
        return det_cantidad;
    }

    public void setDet_cantidad(int det_cantidad) {
        this.det_cantidad = det_cantidad;
    }

}
