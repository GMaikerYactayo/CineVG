package control;

import dao.PeliculaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Pelicula;


@Named(value = "peliculaC")
@SessionScoped
public class PeliculaC implements Serializable {
    
    private Pelicula pelicula = new Pelicula();
    private Pelicula select;
    private List<Pelicula> listadoPel;

    @PostConstruct
    public void iniciar(){
        try {
            listar();
        } catch (Exception e) {
        }
    
    }
    
    
    public PeliculaC() {
    }
    
    public void registrar() throws Exception{
    PeliculaImpl dao;
        try {
            dao = new PeliculaImpl();
            dao.registrar(pelicula);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "registrando", "Cargando.."));            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modificar() throws Exception{
    PeliculaImpl dao;
        try {
            dao = new PeliculaImpl();
            dao.modificar(pelicula);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Actualizando","Cargando..."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void eliminar() throws Exception{
    PeliculaImpl dao;
    try {
        dao = new PeliculaImpl();
        dao.eliminar(pelicula);
        listar();
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO,"Eliminando","completado..."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listar() throws Exception{
    PeliculaImpl dao;
        try {
            dao = new PeliculaImpl();
            listadoPel = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void limpiar() throws Exception{
        try {
            pelicula = new Pelicula();
        } catch (Exception e) {
            throw e;
        }
    
    }
    
    
    
    
        public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Pelicula getSelect() {
        return select;
    }

    public void setSelect(Pelicula select) {
        this.select = select;
    }

    public List<Pelicula> getListadoPel() {
        return listadoPel;
    }

    public void setListadoPel(List<Pelicula> listadoPel) {
        this.listadoPel = listadoPel;
    }
    
    
    
    
}
