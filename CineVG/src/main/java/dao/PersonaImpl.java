package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;

/**
 *
 * @author Ctorres
 */
public class PersonaImpl extends Conexion implements ICRUD<Persona>{

    @Override
    public void registrar(Persona per) throws Exception {
        this.conectar();
        try {
            String sql = "insert into persona.persona (NOMPER,APEPER,DNIPER,USUPER,PSWPER) values (?,?,?,?,?)";
            PreparedStatement ps = getCn().prepareStatement(sql);
            ps.setString(1, per.getNOMPER());
            ps.setString(2, per.getAPEPER());
            ps.setInt(3, per.getDNIPER());
            ps.setString(4, per.getUSUPER());
            ps.setString(5, per.getPSWPER());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Persona gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Persona gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> listar() throws Exception {
        List<Persona> listper = null;
        Persona per;
        this.conectar();
        try {
            listper = new ArrayList();
            String sql = "select*from persona.persona";
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                per = new  Persona();
                per.setNOMPER(rs.getString("NOMPER"));
                per.setAPEPER(rs.getString("APEPER"));
                per.setDNIPER(rs.getInt("DNIPER"));
                per.setUSUPER(rs.getString("USUPER"));
                per.setPSWPER(rs.getString("PSWPER"));
                per.setNOMPER(rs.getString("NOMPER"));
                listper.add(per);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e);
        }finally{
            this.Cerrar();
        }
        return listper;
    }

    @Override
    public Persona filtrar(Persona gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
