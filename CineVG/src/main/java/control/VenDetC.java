package control;

import dao.VenDeImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.VenDetalle;

@Named(value = "venDetC")
@SessionScoped
public class VenDetC implements Serializable {

    private List<VenDetalle> listadoDet;
    private List<VenDetalle> listadoVista = new ArrayList();
    private VenDetalle modelo;
    private VenDetalle select;
    private VenDeImpl dao;

    public VenDetC() {
        modelo = new VenDetalle();
        select = new VenDetalle();
        listadoDet = new ArrayList();
        dao = new VenDeImpl();
    }

    @PostConstruct
    public void inicio() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void registrar() throws Exception {
        try {
            modelo.setIDDETVEN(listadoVista.size());
            this.listadoVista.add(modelo);
            System.out.println(listadoVista.size());
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(select);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }

    public void eliminar() throws Exception {
        try {

            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }

    public void newItem() {
        try {
            if (listadoVista.size() < 1) {
                modelo.setIDDETVEN(0);
            }else{
//                modelo.setIDDETVEN(listadoDet.);
            }
            System.out.println(modelo.getIDDETVEN());
            this.listadoVista.add(modelo);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
        }
    }
    
    public void deleteItem() throws Exception {
        try {
            listadoVista.remove(select.getIDDETVEN());
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Eliminación Exitosa."));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw ex;
        }
    }

    public void limpiar() throws Exception {
        try {
            modelo = new VenDetalle();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }

    public void listar() throws Exception {
        try {
            listadoDet = dao.listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }

    public List<VenDetalle> getListadoDet() {
        return listadoDet;
    }

    public void setListadoDet(List<VenDetalle> listadoDet) {
        this.listadoDet = listadoDet;
    }

    public VenDetalle getModelo() {
        return modelo;
    }

    public void setModelo(VenDetalle modelo) {
        this.modelo = modelo;
    }

    public VenDeImpl getDao() {
        return dao;
    }

    public void setDao(VenDeImpl dao) {
        this.dao = dao;
    }

    public List<VenDetalle> getListadoVista() {
        return listadoVista;
    }

    public void setListadoVista(List<VenDetalle> listadoVista) {
        this.listadoVista = listadoVista;
    }

    public VenDetalle getSelect() {
        return select;
    }

    public void setSelect(VenDetalle select) {
        this.select = select;
    }

}
