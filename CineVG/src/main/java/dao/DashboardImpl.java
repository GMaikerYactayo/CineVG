package dao;

import dao.Conexion;
import dao.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.NPelicula;


public class DashboardImpl extends Conexion {

    public List<NPelicula> listarCantPeli() throws SQLException {
        List<NPelicula> listado;
        ResultSet rs;
        try {
            conectar();
            String sql = "select count(GENPEL)as GENCOUNT ,GENPEL from dbo.PELICULA where ESTPEL ='A'  group by GENPEL";
            listado = new ArrayList();
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NPelicula cant = new NPelicula();
                cant.setCOUNTPEL(rs.getInt("GENCOUNT"));
                cant.setIDPEL(rs.getString("GENPEL"));
                listado.add(cant);
            }
        } catch (SQLException e) {
            throw e;

        } finally {
            this.Cerrar();
        }
        return listado;

    }

 
}
