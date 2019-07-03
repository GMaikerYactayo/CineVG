package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Conexion {
  
    public static Connection cnx = null;
    
    public static Connection conectar() throws  Exception{
        try {
            String url = "jdbc:sqlserver://34.73.201.76:1433;databaseName=CineVG";//Nombre del Usuario de la base de datos
            String pwd = "DevDB2019"; //User07-20199
            String user= "DevDB";  // driver de sql
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // la ip d de la bass datos cloud
            Class.forName(driver).newInstance();
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión, revise xfa");
            System.out.println("error de conexion " + e.getMessage());
            throw e;
        }
        return cnx;
    }
    
    public void cerrar() throws Exception{
        if(cnx !=null){
            cnx.close();
        }
    }

    public static void main(String[] args) throws Exception {
        conectar();
        if(cnx!=null){
            System.out.println("esta abierta, jojolete");
        }else{
            System.out.println("esta cerradita, fijate el driver, conexión, etc....monse");
        }
    }
    
}
