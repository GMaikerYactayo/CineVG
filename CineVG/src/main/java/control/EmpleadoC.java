/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EmpleadoImpl;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Empleado;

@Named(value = "empleadoC")
@SessionScoped
public class EmpleadoC implements Serializable {

    private Empleado empleado = new Empleado();
    private EmpleadoImpl dao;
    private List<Empleado> listadoEmp;
    private List<Empleado> filterEmp;
    private String accionEmp;

    @PostConstruct
    public void init() {
        try {
            listar();
        } catch (Exception e) {
            System.out.println("error init Apoderado " + e.getMessage());
        }
    }

    public void listar() throws Exception {
        EmpleadoImpl Conexion;
        try {
            Conexion = new EmpleadoImpl();
            listadoEmp = Conexion.listar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() throws Exception {
        try {
            empleado = new Empleado();
        } catch (Exception e) {
            throw e;
        }
    }

    public void operarEmpleado() throws Exception {
        switch (accionEmp) {
            case "Registrar":
                registrar();
                break;
            case "Modificar":
                modificar();
                break;
        }
    }

    public void registrar() throws Exception {
        EmpleadoImpl dao;
        try {
            dao = new EmpleadoImpl();
            empleado.setCODUBI(dao.obtenerCodigoEmpleado(empleado.getAutUbi()));
            dao.registrar(empleado);
            listar();
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Completado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificar() throws Exception {

        try {
            dao = new EmpleadoImpl();
            empleado.setCODUBI(dao.obtenerCodigoEmpleado(empleado.getAutUbi()));
            dao.modificar(empleado);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Modificado"));
            listar();
            limpiar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Al Modificar"));
            throw e;
        }
    }

    public void eliminar(Empleado emp) throws Exception {
        try {
            dao = new EmpleadoImpl();
            dao.eliminar(emp);
            listar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro", "Eliminado"));
        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> completeTextUbigeo(String query) throws SQLException, Exception {
        EmpleadoImpl daoEmp = new EmpleadoImpl();
        return daoEmp.autocompleteUbigeo(query);
    }

    //CÓDIGO GENEREDO
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public EmpleadoImpl getDao() {
        return dao;
    }

    public void setDao(EmpleadoImpl dao) {
        this.dao = dao;
    }

    public List<Empleado> getListadoEmp() {
        return listadoEmp;
    }

    public void setListadoEmp(List<Empleado> listadoEmp) {
        this.listadoEmp = listadoEmp;
    }

    public List<Empleado> getFilterEmp() {
        return filterEmp;
    }

    public void setFilterEmp(List<Empleado> filterEmp) {
        this.filterEmp = filterEmp;
    }

    public String getAccionEmp() {
        return accionEmp;
    }

    public void setAccionEmp(String accionEmp) {
        this.accionEmp = accionEmp;
    }

}
