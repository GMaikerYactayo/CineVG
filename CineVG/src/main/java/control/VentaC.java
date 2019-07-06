package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import dao.VentaImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Venta;

@Named(value = "salaC")
@SessionScoped
public class VentaC implements Serializable {
    List<Venta> lista;
    private Venta modelo;
    private VentaImpl dao;

    public VentaC() {
        modelo = new Venta();
        lista = new ArrayList();
        dao = new VentaImpl();
    }

    public void registrar() throws Exception{
        try {
            dao.registrar(modelo);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }
    
    /*Getter and Setter*/
    public Venta getModelo() {
        return modelo;
    }

    public void setModelo(Venta modelo) {
        this.modelo = modelo;
    }

    public VentaImpl getDao() {
        return dao;
    }

    public void setDao(VentaImpl dao) {
        this.dao = dao;
    }

}
