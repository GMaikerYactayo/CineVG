package dao;

import java.sql.PreparedStatement;
import java.util.List;
import modelo.Pelicula;

public class PeliculaImpl extends Conexion implements ICRUD<Pelicula> {

    @Override
    public void registrar(Pelicula pelicula) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO PELICULA(NOMPEL,GENPEL,RESPEL,NOMCOMPEL,SUBPEL,IDIOMA) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, pelicula.getNOMPEL());
            ps.setString(2, pelicula.getGENPEL());
            ps.setString(3, pelicula.getRESPEL());
            ps.setString(4, pelicula.getNOMCOMPEL());
            ps.setString(5, pelicula.getSUBPEL());
            ps.setString(6, pelicula.getIDIOMA());

        } catch (Exception e) {
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Pelicula pelicula) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE PELICULA SET NOMPEL = ?,GENPEL=?,RESPEL=?,NOMCOMPEL=?,SUBPEL=?,IDIOMA=? WHERE IDPEL LIKE ?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, pelicula.getNOMPEL());
            ps.setString(1, pelicula.getGENPEL());
            ps.setString(1, pelicula.getRESPEL());
            ps.setString(1, pelicula.getNOMCOMPEL());
            ps.setString(1, pelicula.getSUBPEL());
            ps.setString(1, pelicula.getIDIOMA());
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Pelicula gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pelicula> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pelicula filtrar(Pelicula gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
