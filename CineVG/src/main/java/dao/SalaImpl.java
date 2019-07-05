package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import modelo.Sala;

public class SalaImpl extends Conexion implements ICRUD<Sala>{

    @Override
    public void registrar(Sala gen) throws Exception {
            this.conectar();
            String sql = "INSERT INTO SALA (NUMSAL,CAPSAL) VALUES(?,?)";
        try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, gen.getNUMSAL());
            ps.setInt(2, gen.getCAPSAL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
        finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Sala gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Sala gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sala> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sala filtrar(Sala gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
