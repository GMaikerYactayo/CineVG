package control;

import dao.PersonaImpl;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Persona;

/**
 *
 * @author Ctorres
 */
@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable{

    Persona personaM =  new Persona();
    List<Persona> perlist;
    
    public PersonaC() {
    }
    
    public void registrar()throws Exception{
        PersonaImpl dao;
        dao = new PersonaImpl();
        try {
            dao.registrar(personaM);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro completo", null));
            limpiar();
        } catch (Exception e) {
            System.out.println("Error al registar en el contradolr: "+e);
        }
    }
    
    public void listar()throws Exception{
        PersonaImpl dao;
        dao = new PersonaImpl();
        try {
            perlist = dao.listar();
        } catch (Exception e) {
            System.out.println("Error al listar en el contrador: " + e);
            throw e;
        }
    }
    
    public void limpiar(){
        personaM = new Persona();
    }
}
