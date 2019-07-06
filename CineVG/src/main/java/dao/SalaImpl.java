package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Sala;

public class SalaImpl extends Conexion implements ICRUD<Sala> {

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
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Sala gen) throws Exception {
        this.conectar();
        String sql = "UPDATE SALA SET CAPSAL = ? WHERE IDSAL = ?";
        try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, gen.getIDSAL());
            ps.setInt(2, gen.getCAPSAL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Sala gen) throws Exception {
        this.conectar();
        String sql = "UPDATE SALA SET ESTSAL = ? WHERE IDSAL = ?";
        try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, gen.getESTSAL());
            ps.setInt(2, gen.getIDSAL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public List<Sala> listar() throws Exception {
        this.conectar();
        List<Sala> lista;
        Sala modelo;
        String sql = "SELECT * FROM dbo.SALA WHERE ESTSAL = 'A'";
        try {
            ResultSet rs = this.getCn().createStatement().executeQuery(sql);
            lista = new ArrayList();
            while (rs.next()) {
                modelo = new Sala();
                modelo.setIDSAL(rs.getInt("IDSAL"));
                modelo.setNUMSAL(rs.getInt("NUMSAL"));
                modelo.setCAPSAL(rs.getInt("CAPSAL"));
                modelo.setESTSAL(rs.getString("ESTSAL"));
                lista.add(modelo);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    public List<Sala> listar(String ESTSAL) throws Exception {
        this.conectar();
        List<Sala> lista;
        Sala modelo;
        String sql = "SELECT * FROM dbo.SALA WHERE ESTSAL = " + ESTSAL;
        try {
            ResultSet rs = this.getCn().createStatement().executeQuery(sql);
            lista = new ArrayList();
            while (rs.next()) {
                modelo = new Sala();
                modelo.setIDSAL(rs.getInt("IDSAL"));
                modelo.setNUMSAL(rs.getInt("NUMSAL"));
                modelo.setCAPSAL(rs.getInt("CAPSAL"));
                modelo.setESTSAL(rs.getString("ESTSAL"));
                lista.add(modelo);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return lista;
    }

    @Override
    public Sala filtrar(Sala gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
