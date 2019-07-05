package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Pelicula;

public class PeliculaImpl extends Conexion implements ICRUD<Pelicula> {

    @Override
    public void registrar(Pelicula pelicula) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PELICULA(NOMPEL,GENPEL,RESPEL,NOMCOMPEL,SUBPEL,IDIOMA,FOTPEL) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, pelicula.getNOMPEL());
            ps.setString(2, pelicula.getGENPEL());
            ps.setString(3, pelicula.getTIPPEL());
            ps.setString(4, pelicula.getLENPEL());
            ps.setString(5, pelicula.getDURPEL());
            ps.setString(6, pelicula.getHORPEL());
            ps.setString(7, pelicula.getFECPEL());
            ps.setString(8, pelicula.getHORPEL());
            ps.setString(9, pelicula.getESTPEL());

        } catch (Exception e) {
        System.out.println("Error: " + e);
        e.printStackTrace();
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Pelicula pelicula) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PELICULA SET NOMPEL = ?,GENPEL=?,RESPEL=?,NOMCOMPEL=?,SUBPEL=?,IDIOMA=? FOTPEL=? WHERE IDPEL LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, pelicula.getNOMPEL());
            ps.setString(2, pelicula.getGENPEL());
            ps.setString(3, pelicula.getTIPPEL());
            ps.setString(4, pelicula.getLENPEL());
            ps.setString(5, pelicula.getDURPEL());
            ps.setString(6, pelicula.getHORPEL());
            ps.setString(7, pelicula.getFECPEL());
            ps.setString(8, pelicula.getHORPEL());
            ps.setString(9, pelicula.getESTPEL());
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Pelicula pelicula) throws Exception {
        try {
            this.conectar();
            String sql = "delete from PELICULA where IDCAR=?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, pelicula.getIDPEL());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Pelicula> listar() throws Exception {
        List<Pelicula> listado;
        Pelicula car;
        try {
            this.conectar();
            String sql = "select * from PELICULA WHERE ESTPEL='A'";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                car = new Pelicula();
                car.setIDPEL(rs.getString("IDPEL"));
                car.setNOMPEL(rs.getString("NOMPEL"));
                car.setGENPEL(rs.getString("GENPEL"));
                car.setTIPPEL(rs.getString("TIPPEL"));
                car.setLENPEL(rs.getString("LENPEL"));
                car.setDURPEL(rs.getString("DURPEL"));
                car.setHORPEL(rs.getString("HORPEL"));
                car.setFECPEL(rs.getString("FECPEL"));
                car.setESTPEL(rs.getString("ESTPEL"));
                car.setFOTPEL(rs.getString("FOTPEL"));
                listado.add(car);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    @Override
    public Pelicula filtrar(Pelicula gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
