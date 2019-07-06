package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Empleado;

public class Login extends Conexion {

    public Empleado startSession(String USUEMP, String PWDEMP) throws Exception {
        this.conectar();
        ResultSet rs;
        Empleado empleado = null;
        try {
            String sql = "select NOMEMP, APEEMP, DNIEMP, DIREMP, TIPEMP, SEXEMP from EMPLEADO where USUEMP=? and PWDEMP=?";
            PreparedStatement ps = getCn().prepareStatement(sql);
            ps.setString(1, USUEMP);
            ps.setString(2, PWDEMP);
            rs = ps.executeQuery();
            if (rs.next()) {
                empleado = new Empleado();
                empleado.setNOMEMP(rs.getString("NOMEMP"));
                empleado.setAPEEMP(rs.getString("APEEMP"));
                empleado.setDNIEMP(rs.getString("DNIEMP"));
                empleado.setDIREMP(rs.getString("DIREMP"));
                empleado.setTIPEMP(rs.getString("TIPEMP"));
                empleado.setSEXEMP(rs.getString("SEXEMP"));
                empleado.setUSUEMP(USUEMP);
                empleado.setPWDEMP(PWDEMP);
            }
            return empleado;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

}
