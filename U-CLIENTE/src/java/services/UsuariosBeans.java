package services;

import dao.DaoUsuarios;
import dao.impl.DaoUsuariosImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Usuarios;

@ManagedBean
@RequestScoped
public class UsuariosBeans {

    private String correo;
    private String clave;
    private DaoUsuarios DC;
    private Usuarios data = new Usuarios();
    private String msg = null;

    public UsuariosBeans() {
    }

    public String verificarDatos(String correo, String clave) {
        DaoUsuarios UD = new DaoUsuariosImpl();
        String result;
        try {
            data = UD.ColabLogin(correo, clave);
            if (data.getId() != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", data);
                if (data.getTipo().equals("ADMIN")) {
                    result = "intranet/admin/index?faces-redirect=true";
                } else if (data.getTipo().equals("CLIENT")) {
                    result = "intranet/client/index?faces-redirect=true";
                } else {
                    result = "error";
                }
            } else {
                result = "error";
            }
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }

    public boolean verificarSesion() {
        boolean estado;
        if (FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario") == null) {
            estado = false;
        } else {
            estado = true;
        }
        return estado;
    }

    public boolean verificarAdmin() {
        boolean estado;
        if (FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario") == null) {
            estado = false;
        } else {
            Usuarios data = new Usuarios();
            data = (Usuarios) FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().get("usuario");
            if (data.getTipo().equals("ADMIN")) {
                estado = true;
            } else {
                estado = false;
            }
        }
        return estado;
    }
    
        public boolean verificarClient() {
        boolean estado;
        if (FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap().get("usuario") == null) {
            estado = false;
        } else {
            Usuarios data = new Usuarios();
            data = (Usuarios) FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().get("usuario");
            if (data.getTipo().equals("CLIENT")) {
                estado = true;
            } else {
                estado = false;
            }
        }
        return estado;
    }
    public String cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return "/index?faces-redirect=true";

    }
    
        public String cerrarClient() {
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();
        return "/U-CLIENTE/faces/index?faces-redirect=true";

    }
    
    
    
        public String regresar() {
        return "/U-CLIENTE/faces/index?";
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public DaoUsuarios getDC() {
        return DC;
    }

    public void setDC(DaoUsuarios DC) {
        this.DC = DC;
    }

    public Usuarios getData() {
        return data;
    }

    public void setData(Usuarios data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
