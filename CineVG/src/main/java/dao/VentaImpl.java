package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Venta;

public class VentaImpl extends Conexion implements ICRUD<Venta> {

    @Override
    public void registrar(Venta venta) throws Exception {
        this.conectar();
        String sql = "insert into VENTA (TOTVEN,IDCLI,IDEMP,ESTVEN) values (?,?,?,?)";
        try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, venta.getTOTVEN());
            ps.setString(2, venta.getIDCLI());
            ps.setString(3, venta.getIDEMP());
            ps.setString(4, "A");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Venta venta) throws Exception {
        this.conectar();
        String sql = "update VENTA set TOTVEN=?,IDCLI=?,IDEMP=?,ESTVEN=? where IDVENTA=?)";
        try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, venta.getTOTVEN());
            ps.setString(2, venta.getIDCLI());
            ps.setString(3, venta.getIDEMP());
            ps.setString(4, venta.getESTVEN());
            ps.setString(5, venta.getIDVEN());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Venta venta) throws Exception {
        this.conectar();
        String sql = "update VENTA set ESTVEN='I' where IDVENTA=?)";
        try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, venta.getIDVEN());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Venta> listar() throws Exception {
        List<Venta> listado;
        Venta ven;
        try {
            this.conectar();
            String sql = "select * from VENTA where ESTVEN='A'";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ven = new Venta();
                ven.setIDVEN(rs.getString("IDVEN"));
                ven.setTOTVEN(rs.getString("TOTVEN"));
                ven.setIDCLI(rs.getString("IDCLI"));
                ven.setIDEMP(rs.getString("IDEMP"));
                ven.setESTVEN(rs.getString("ESTVEN"));
                listado.add(ven);
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
    public Venta filtrar(Venta gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
