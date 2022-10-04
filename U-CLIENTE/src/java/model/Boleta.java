package model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Boleta {

    private String emp_RUC;
    private Integer id_boleta;
    private String bol_fecha;
    private String bol_metododepago;

    public String getEmp_RUC() {
        return emp_RUC;
    }

    public void setEmp_RUC(String emp_RUC) {
        this.emp_RUC = emp_RUC;
    }

    public Integer getId_boleta() {
        return id_boleta;
    }

    public void setId_boleta(Integer id_boleta) {
        this.id_boleta = id_boleta;
    }

    public String getBol_fecha() {
        return bol_fecha;
    }

    public void setBol_fecha(String bol_fecha) {
        this.bol_fecha = bol_fecha;
    }

    public String getBol_metododepago() {
        return bol_metododepago;
    }

    public void setBol_metododepago(String bol_metododepago) {
        this.bol_metododepago = bol_metododepago;
    }
 
}
