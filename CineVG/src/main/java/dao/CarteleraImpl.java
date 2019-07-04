package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cartelera;

public class CarteleraImpl extends Conexion implements ICRUD<Cartelera>{

    @Override
    public void registrar(Cartelera cartelera) throws Exception {
        this.conectar();
        try {
            String sql = "insert into ASIGNACION.CARTELERA (IDPEL,SALPEL,FECHINIPEL,FECHFINPEL,PRECCAR,ESTCAR) "
                    + "values (?,?,?,?,?,?)";
            PreparedStatement ps = getCn().prepareStatement(sql);
            ps.setString(1, cartelera.getIDPEL());
            ps.setString(2, cartelera.getSALPEL());
            ps.setString(3, cartelera.getFECHINIPEL());
            ps.setString(4, cartelera.getFECHFINPEL());
            ps.setString(5, cartelera.getPRECCAR());
            ps.setString(6, cartelera.getESTCAR());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            throw e;
        }finally{
            this.Cerrar();
        }
    }

    @Override
    public void modificar(Cartelera cartelera) throws Exception {
        try {
            this.conectar();
            String sql = "update ASIGNACION.CARTELERA set IDPEL=?,SALPEL=?,FECHINIPEL=?,FECHFINPEL=?,PRECCAR=?,ESTCAR=? where IDCAR=?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, cartelera.getIDPEL());
            ps.setString(2, cartelera.getSALPEL());
            ps.setString(3, cartelera.getFECHINIPEL());
            ps.setString(4, cartelera.getFECHFINPEL());
            ps.setString(5, cartelera.getPRECCAR());
            ps.setString(6, cartelera.getESTCAR());
            ps.setString(7, cartelera.getIDCAR());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public void eliminar(Cartelera cartelera) throws Exception {
        try {
            this.conectar();
            String sql = "delete from ASIGNACION.CARTELERA where IDCAR=?";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, cartelera.getIDCAR());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    @Override
    public List<Cartelera> listar() throws Exception {
        List<Cartelera> listado;
        Cartelera car;
        try {
            this.conectar();
            String sql = "select * from ASIGNACION.CARTELERA";
            listado = new ArrayList();
            Statement st = this.getCn().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                car = new Cartelera();
                car.setIDCAR(rs.getString("IDCAR"));
                car.setIDPEL(rs.getString("IDPEL"));
                car.setFECHINIPEL(rs.getString("FECHINIPEL"));
                car.setFECHFINPEL(rs.getString("FECHFINPEL"));
                car.setPRECCAR(rs.getString("PRECCAR"));
                car.setESTCAR(rs.getString("ESTCAR"));
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
    public Cartelera filtrar(Cartelera gen) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
