package control;

import dao.DashboardImpl;
import dao.PeliculaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.NPelicula;
import modelo.Pelicula;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.ChartSeries;

@Named(value = "peliculaC")
@SessionScoped
public class PeliculaC implements Serializable {

    private Pelicula pelicula = new Pelicula();
    private Pelicula selectedPelicula;
    private List<Pelicula> listadoPel;
    private BarChartModel barra;
    private List<NPelicula> NPelicula;

    @PostConstruct
    public void iniciar() {
        try {
            listar();
            lstCantPeli();
        } catch (Exception e) {
        }

    }

    public void limpiar() throws Exception {
        try {
            pelicula = new Pelicula();
        } catch (Exception e) {
            throw e;
        }

    }
    
     public void lstCantPeli() throws Exception {
        DashboardImpl dao;
        try {
            dao = new DashboardImpl();
            NPelicula = dao.listarCantPeli();
            createBarras();
        } catch (SQLException e) {
            throw e;
        }
    }
     
         private void createBarras() {
        try {
            barra = new BarChartModel();
            for (int i = 0; i < NPelicula.size(); i++) {
                ChartSeries serie = new BarChartSeries();
                serie.setLabel(NPelicula.get(i).getIDPEL());
                serie.set(NPelicula.get(i).getCOUNTPEL(), NPelicula.get(i).getCOUNTPEL());
                barra.addSeries(serie);
                barra.setLegendPosition("ne");
            }
            Axis xAxis = barra.getAxis(AxisType.X);
            xAxis.setLabel("CINE VG");
            barra = getBarra();
            barra.setTitle("NÚMERO DE PELÍCULAS POR GÉNERO");
            barra.setAnimate(true);
            
            Axis yAxis = barra.getAxis(AxisType.Y);
            yAxis.setMax(30);
        } catch (Exception e) {
            System.out.println("error" +e.getMessage());
        }
    }
    
    
    
    public void registrarPelicula() throws Exception {
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

    public void modificar() throws Exception {
        PeliculaImpl dao;
        try {
            dao = new PeliculaImpl();
            dao.modificar(pelicula);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizando", "Cargando..."));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminar() throws Exception {
        PeliculaImpl dao;
        try {
            dao = new PeliculaImpl();
            dao.eliminar(pelicula);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminando", "completado..."));
        } catch (Exception e) {
            throw e;
        }
    }

    public void listar() throws Exception {
        PeliculaImpl dao;
        try {
            dao = new PeliculaImpl();
            listadoPel = dao.listar();
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

    public List<Pelicula> getListadoPel() {
        return listadoPel;
    }

    public void setListadoPel(List<Pelicula> listadoPel) {
        this.listadoPel = listadoPel;
    }

    public Pelicula getSelectedPelicula() {
        return selectedPelicula;
    }

    public void setSelectedPelicula(Pelicula selectedPelicula) {
        this.selectedPelicula = selectedPelicula;
    }

    public BarChartModel getBarra() {
        return barra;
    }

    public void setBarra(BarChartModel barra) {
        this.barra = barra;
    }

    public List<NPelicula> getNPelicula() {
        return NPelicula;
    }

    public void setNPelicula(List<NPelicula> NPelicula) {
        this.NPelicula = NPelicula;
    }



    
    

}
