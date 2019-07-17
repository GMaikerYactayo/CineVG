package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.VenDetalle;

public class VenDeImpl extends Conexion implements ICRUD<VenDetalle> {

    @Override
    public void registrar(VenDetalle vendet) throws Exception {
        this.conectar();
        try {
            String sql = "insert into DETALLE_VENTA (CATVEN,IDCAR,IDVEN,IDSAL,ESTDETVEN) values (?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, vendet.getCATVEN());
            ps.setString(2, vendet.getIDCAR());
            ps.setString(3, vendet.getIDVEN());
            ps.setString(4, vendet.getIDSAL());
            ps.setString(5, "A");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(VenDetalle vendet) throws Exception {
        this.conectar();
        try {
            String sql = "update DETALLE_VENTA set CATVEN=?,IDCAR=?,IDVEN=?,IDSAL=?,ESTDETVEN=? where IDDETVEN=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, vendet.getCATVEN());
            ps.setString(2, vendet.getIDCAR());
            ps.setString(3, vendet.getIDVEN());
            ps.setString(4, vendet.getIDSAL());
            ps.setString(5, vendet.getESTDETVEN());
            ps.setInt(6, vendet.getIDDETVEN());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(VenDetalle vendet) throws Exception {
        this.conectar();
        try {
            String sql = "update DETALLE_VENTA set ESTDETVEN='I' where IDDETVEN=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setInt(1, vendet.getIDDETVEN());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<VenDetalle> listar() throws Exception {
        List<VenDetalle> listado;
        VenDetalle vendet;
        try {
            this.conectar();
            String sql = "select * from DETALLE_VENTA where ESTDETVEN='A'";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                vendet = new VenDetalle();
                vendet.setIDDETVEN(rs.getInt("IDDETVEN"));
                vendet.setCATVEN(rs.getString("CATVEN"));
                vendet.setIDCAR(rs.getString("IDCAR"));
                vendet.setIDVEN(rs.getString("IDVEN"));
                vendet.setIDSAL(rs.getString("IDSAL"));
                vendet.setESTDETVEN(rs.getString("ESTDETVEN"));
                listado.add(vendet);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
        return listado;
    }

    @Override
    public VenDetalle filtrar(VenDetalle gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
