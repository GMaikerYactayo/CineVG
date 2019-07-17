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
            String sql = "INSERT INTO PELICULA(NOMPEL,GENPEL,RESTPEL,TIPPEL,LENPEL,DURPEL,HORPEL,FECPEL) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, pelicula.getNOMPEL());
            ps.setString(2, pelicula.getGENPEL());
            ps.setString(3, pelicula.getRESTPEL());
            ps.setString(4, pelicula.getTIPPEL());
            ps.setString(5, pelicula.getLENPEL());
            ps.setString(6, pelicula.getDURPEL());
            ps.setString(7, pelicula.getHORPEL());
            ps.setString(8, pelicula.getFECPEL());
<<<<<<< HEAD
            ps.setString(9, pelicula.getFOTPEL());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            throw e;
=======

        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
>>>>>>> origin/master
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Pelicula pelicula) throws Exception {
        try {
            this.conectar();
<<<<<<< HEAD
            String sql = "UPDATE PELICULA SET NOMPEL = ?,GENPEL=?,RESTPEL=?,TIPPEL=?,LENPEL=?,DURPEL=?,HORPEL=?,FECPEL=?,ESTPEL=?,FOTPEL=? WHERE IDPEL LIKE ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
=======
            String sql = "UPDATE PELICULA SET NOMPEL=?,GENPEL=?,RESTPEL=?,TIPPEL=?,LENPEL=?,DURPEL=?,HORPEL=?,FECPEL=?,ESTPEL=? WHERE IDPEL LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
>>>>>>> origin/master
            ps.setString(1, pelicula.getNOMPEL());
            ps.setString(2, pelicula.getGENPEL());
            ps.setString(3, pelicula.getRESTPEL());
            ps.setString(4, pelicula.getTIPPEL());
            ps.setString(5, pelicula.getLENPEL());
            ps.setString(6, pelicula.getDURPEL());
            ps.setString(7, pelicula.getHORPEL());
            ps.setString(8, pelicula.getFECPEL());
            ps.setString(9, pelicula.getESTPEL());
            ps.setString(10, pelicula.getIDPEL());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
             System.out.println("error en update" + e.getMessage());
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
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, pelicula.getIDPEL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Pelicula> listar() throws Exception {
        List<Pelicula> listado;
        ResultSet rs;
        try {
            conectar();
            String sql = "select * from PELICULA WHERE ESTPEL='A'";
            listado = new ArrayList();
            PreparedStatement st = this.getCn().prepareCall(sql);
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Pelicula car = new Pelicula();
                car.setIDPEL(rs.getString("IDPEL"));
                car.setNOMPEL(rs.getString("NOMPEL"));
                car.setGENPEL(rs.getString("GENPEL"));
                car.setGENPEL(rs.getString("RESTPEL"));
                car.setTIPPEL(rs.getString("TIPPEL"));
                car.setLENPEL(rs.getString("LENPEL"));
                car.setDURPEL(rs.getString("DURPEL"));
                car.setHORPEL(rs.getString("HORPEL"));
                car.setFECPEL(rs.getString("FECPEL"));
                car.setESTPEL(rs.getString("ESTPEL"));
                listado.add(car);
<<<<<<< HEAD
=======

>>>>>>> origin/master
            }
<<<<<<< HEAD
=======
            return listado;
>>>>>>> origin/master
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public Pelicula filtrar(Pelicula gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
