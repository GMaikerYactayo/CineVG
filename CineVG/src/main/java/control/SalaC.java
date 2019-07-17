package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import modelo.Sala;
import dao.SalaImpl;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "salaC")
@SessionScoped
public class SalaC implements Serializable {

    private List<Sala> lista;
    private Sala modelo;
    private Sala select;
    private SalaImpl dao;
    private String estado;

    @PostConstruct
    public void init() {
        try {
            listar();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public SalaC() {
        select = new Sala();
        modelo = new Sala();
        dao = new SalaImpl();
    }

    public void registrar() throws Exception {
        try {
            dao.registrar(modelo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Registro Exitoso."));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(modelo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exitoso", "Modificado Exitosamente."));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }

    public void eliminar() throws Exception {
        try {
            if (estado.equals("A")) {
                modelo.setESTSAL("I");
            } else {
                modelo.setESTSAL("A");
            }
            dao.eliminar(modelo);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exitoso", "Operación Exitosa."));
            listar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error del Sistema", "Estamos trabajando en ello."));
            throw e;
        }
    }

    public void listar() throws Exception {
        try {
            if (estado == null) {
                estado = "A";
            }
            lista = dao.listar("'" + estado + "'");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public void limpiar() {
        modelo = new Sala();
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

    public List<Sala> getLista() {
        return lista;
    }

    public void setLista(List<Sala> lista) {
        this.lista = lista;
    }

    public Sala getSelect() {
        return select;
    }

    public void setSelect(Sala select) {
        this.select = select;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
