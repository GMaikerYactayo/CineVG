package control;

import dao.ClienteImpl;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Cliente;

/**
 *
 * @author Ctorres
 */
@Named(value = "ClienteC")
@SessionScoped
public class ClienteC implements Serializable {

    Cliente persona = new Cliente();
    Cliente personaEdit = new Cliente();
    ClienteImpl dao;
    List<Cliente> listper;

    @PostConstruct
    public void inicio() {
        try {
            listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void registrar() {
        dao = new ClienteImpl();
        try {
            dao.registrar(persona);
            listar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Completo", ""));
            limpiar();
        } catch (Exception e) {
        }
    }

    public void listar() {
        dao = new ClienteImpl();
        try {
            listper = dao.listarcli();
        } catch (Exception e) {
            System.out.println("Erroe: " + e);
        }
    }

    public void limpiar() {
        persona = new Cliente();
    }

    public Cliente getPersona() {
        return persona;
    }

    public void setPersona(Cliente persona) {
        this.persona = persona;
    }

    public ClienteImpl getDao() {
        return dao;
    }

    public void setDao(ClienteImpl dao) {
        this.dao = dao;
    }

    public List<Cliente> getListper() {
        return listper;
    }

    public void setListper(List<Cliente> listper) {
        this.listper = listper;
    }

    public Cliente getPersonaEdit() {
        return personaEdit;
    }

    public void setPersonaEdit(Cliente personaEdit) {
        this.personaEdit = personaEdit;
    }

}
