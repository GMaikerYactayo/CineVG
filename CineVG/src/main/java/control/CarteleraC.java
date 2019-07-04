package control;

import dao.CarteleraImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Cartelera;

@Named(value = "carteleraC")
@SessionScoped
public class CarteleraC implements Serializable {

    private Cartelera cartelera = new Cartelera();
    private Cartelera select;
    private List<Cartelera> listadoCar;
   
    @PostConstruct
    public void iniciar() {
        try {
            listar();
        } catch (Exception e) {
        }
    }
    
    public CarteleraC() {
    }
    
    public void registrar() throws Exception {
        CarteleraImpl dao;
        try {
            dao = new CarteleraImpl();
            dao.registrar(cartelera);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado..."));
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar() throws Exception {
        CarteleraImpl dao;
        try {
            dao = new CarteleraImpl();
            dao.modificar(cartelera);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualización", "Completado.."));
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar() throws Exception {
        CarteleraImpl dao;
        try {
            dao = new CarteleraImpl();
            dao.eliminar(cartelera);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Eliminación", "Completado.."));
        } catch (SQLException e) {
            throw e;
        }
    }
    
    
    public void listar() throws Exception {
        CarteleraImpl dao;
        try {
            dao = new CarteleraImpl();
            listadoCar = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void limpiar() throws Exception {
        try {
            cartelera = new Cartelera();
        } catch (Exception e) {
            throw e;
        }
    }

    public Cartelera getCartelera() {
        return cartelera;
    }

    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }

    public Cartelera getSelect() {
        return select;
    }

    public void setSelect(Cartelera select) {
        this.select = select;
    }

    public List<Cartelera> getListadoCar() {
        return listadoCar;
    }

    public void setListadoCar(List<Cartelera> listadoCar) {
        this.listadoCar = listadoCar;
    }
    
    
    
}
