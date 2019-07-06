package control;

import dao.Login;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import modelo.Empleado;
import services.Session;

@Named(value = "loginC")
@SessionScoped
public class LoginC implements Serializable {

    private Empleado empleado = new Empleado();
    //Logeo
    private String USUEMP;
    private String PWDEMP;

    public void startSession() throws Exception {
        Login dao;
        try {
            dao = new Login();
            empleado = dao.startSession(USUEMP, PWDEMP);
            if (empleado != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", empleado);
                switch (empleado.getTIPEMP()) {
                    case "1":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/CineVG/faces/vistas/cliente/Cliente.xhtml.");
                        break;
                    case "2":
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No eres un empleado >:v", "no lo intentes"));
                        System.out.println("Error porque no es profesor");
                        break;
                }
            } else {
                setPWDEMP(null);
                empleado = new Empleado();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contraseña/Usuario Incorrecto"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void securityLogin() throws IOException {
        Empleado us = Session.obtenerObjetoSesion();
        if (us != null) {
            switch (us.getTIPEMP()) {
                case "1":
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/DocVG/faces/vistas/login/LoginT.xhtml");
                    break;
                case "2":
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/DocVG/faces/vistas/login/LoginT.xhtml");
                    break;
            }
        }
    }

    public void securitySession() throws IOException {
        if (Session.obtenerObjetoSesion() == null) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/DocVG/faces/vistas/login/LoginT.xhtml");
        }
    }

    public void obtenerDatos() {
        System.out.println(Session.ObtenerCodigoSesion());
        System.out.println(Session.ObtenerNombreSesion());
    }

    public void cerrar() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/vistas/login/LoginT.xhtml");
    }

    public void logout() {
        ExternalContext ctx
                = FacesContext.getCurrentInstance().getExternalContext();
        String ctxPath
                = ((ServletContext) ctx.getContext()).getContextPath();
        try {
            ((HttpSession) ctx.getSession(false)).invalidate();
            ctx.redirect(ctxPath + "/faces/vistas/login/LoginT.xhtml  ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getUSUEMP() {
        return USUEMP;
    }

    public void setUSUEMP(String USUEMP) {
        this.USUEMP = USUEMP;
    }

    public String getPWDEMP() {
        return PWDEMP;
    }

    public void setPWDEMP(String PWDEMP) {
        this.PWDEMP = PWDEMP;
    }

    

}