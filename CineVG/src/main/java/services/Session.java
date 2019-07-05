package services;

import javax.faces.context.FacesContext;
import modelo.Empleado;

public class Session {

    public static Empleado obtenerObjetoSesion() {
        return (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
    }

    public static String ObtenerNombreSesion() {
        Empleado us = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getUSUEMP();
        } else {
            return null;
        }
    }

    public static String ObtenerCodigoSesion() {
        Empleado us = (Empleado) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getNOMEMP();
        } else {
            return null;
        }
    }

}