package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class conexion {

    static Connection con = null;
    static ResultSet respuesta = null;

    public static Connection getConexion() {
        try {
            String db = "jdbc:sqlserver://localhost:3306/licoreria";
            con = DriverManager.getConnection(db, "root", "");
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }

    public static ResultSet consulta(String consulta) {
        Connection con = getConexion();
        Statement declara = null;
        try {
            declara = con.createStatement();
            respuesta = declara.executeQuery(consulta);
            return respuesta;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al obtener datos");
        }
        return null;
    }

}
