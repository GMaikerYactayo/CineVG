package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Sala;
import dao.SalaImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "salaC")
@SessionScoped
public class SalaC implements Serializable {
    List<Sala> lista;
    private Sala modelo;
    private SalaImpl dao;

    public SalaC() {
        modelo = new Sala();
        lista = new ArrayList();
        dao = new SalaImpl();
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
    public Sala getModelo() {
        return modelo;
    }

    public void setModelo(Sala modelo) {
        this.modelo = modelo;
    }

    public SalaImpl getDao() {
        return dao;
    }

    public void setDao(SalaImpl dao) {
        this.dao = dao;
    }

}
