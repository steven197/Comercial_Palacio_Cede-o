
package ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author José
 */
public class conexionPHP {
    Connection conexionPHP = null;
    
    //private String driver="com.mysql.jdbc.Driver";
    //private String cadenaConeccion="jdbc:mysql://127.0.0.1/bd_controlcv";
    //private String usuario="root";
    //private String contrasena="";
    //public Connection con;

    
    public Connection conexionPHP(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexionPHP = DriverManager.getConnection("jdbc:mysql://localhost/bd_controlcv","root","");
            JOptionPane.showMessageDialog(null, "Conexión establecida");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Conexión Fallida"+e.getMessage());
        }
        return conexionPHP;
    }
        
}

