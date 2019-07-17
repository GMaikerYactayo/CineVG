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

@Named(value = "ventaC")
@SessionScoped
public class VentaC implements Serializable {
    private List<Venta> listadoVen;
    private Venta modelo;
    private VentaImpl dao;

    public VentaC() {
        modelo = new Venta();
        listadoVen = new ArrayList();
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
    
    public void modificar() throws Exception{
        try {
            dao.modificar(modelo);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }
    
    public void eliminar() throws Exception{
        try {
            dao.eliminar(modelo);
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }
    
    public void limpiar() throws Exception{
        try {
            dao = new VentaImpl();
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }
    public void listar() throws Exception{
        try {
            listadoVen = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }
    
    
    /*Getter and Setter*/

    public List<Venta> getListadoVen() {
        return listadoVen;
    }

    public void setListadoVen(List<Venta> listadoVen) {
        this.listadoVen = listadoVen;
    }

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
