package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Venta;

public class VentaImpl extends Conexion implements ICRUD{

    public void registrar(Venta venta) throws Exception {
        this.conectar();
            String sql = "insert into dbo.VENTA (IDVEN,TOTVEN,IDCLI,IDDETVEN,IDEMP,IDSAL,IDPEL) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, venta.getIDVEN());
            ps.setString(2, venta.getTOTVEN());
            ps.setString(3, venta.getIDCLI());
            ps.setString(4, venta.getIDDETVEN());
            ps.setString(5, venta.getIDEMP());
            ps.setString(6, venta.getIDSAL());
            ps.setString(7, venta.getIDPEL());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        }
        finally{
            this.Cerrar();
        }
    }

    public List<Venta> listarVenta() throws Exception {
    this.conectar();
        List<Venta> listado;
        Venta venta;
        String sql = "SELECT IDVEN,TOTVEN,CONCAT(NOMCLI,' ',APECLI)AS IDCLI, CATVEN AS IDDETVEN,CONCAT(NOMEMP,' ',APEEMP)AS IDEMP, NUMSAL AS IDSAL,NOMPEL AS IDPEL\n"
                + "                FROM dbo.VENTA\n"
                + "                INNER JOIN VENTA.CLIENTE\n"
                + "                ON VENTA.CLIENTE.IDCLI = CLIENTE.IDCLI\n"
                + "                INNER JOIN VENTA.DETALLE_VENTA\n"
                + "                ON VENTA.DETALLE_VENTA.IDDETVEN = VENTA.IDDETVEN\n"
                + "                INNER JOIN VENTA.EMPLEADO\n"
                + "                ON VENTA.EMPLEADO.IDEMP = VENTA.IDEMP"
                + "                INNER JOIN VENTA.SALA\n"
                + "                ON VENTA.SALA.IDSAL = VENTA.IDSAL"
                + "                INNER JOIN VENTA.PELICULA\n"
                + "                ON VENTA.PELICULA.IDPEL = VENTA.IDPEL";
        try {
            listado = new ArrayList();
            Statement st = getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                venta = new Venta();
                venta.setIDVEN(String.valueOf(rs.getInt("IDVEN")));
                venta.setTOTVEN(rs.getString("TOTVEN"));
                venta.setIDCLI(String.valueOf(rs.getInt("IDCLI")));
                venta.setIDDETVEN(rs.getString("IDDETVEN"));
                venta.setIDEMP(rs.getString("IDEMP"));
                venta.setIDSAL(rs.getString("IDSAL"));
                venta.setIDPEL(rs.getString("IDPEL"));
                listado.add(venta);
                System.out.println(venta.toString());
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
    public void registrar(Object gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Object gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Object gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object filtrar(Object gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
