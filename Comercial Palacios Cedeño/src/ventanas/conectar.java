
package ventanas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José
 */
public class conectar {
    static ResultSet resultado;
    static Statement sentencia;
    static Connection conexion = null;
    //Connection conectar = null;
    //public Connection conexion(){
        //try {
            //Class.forName("com.mysql.jdbc.Driver");
            //conectar = DriverManager.getConnection("jdbc:mysql://localhost/bd_controlcv","root","");
        //} catch (Exception e) {
            //System.out.println(e.getMessage());
        //}
        //return conectar;
    //}
    public Connection conexion(){
        String ruta="jdbc:mysql://localhost/bd_controlcv";
        String user="root";
        String pass="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection(ruta,user,pass); 
            sentencia= conexion.createStatement();
            System.out.println("Conectado");
        } catch (Exception e) {
            System.out.println("No conectado");
        }
        return conexion;
    }
     
public static ArrayList<String>llenar_combo(){
    ArrayList<String> lista = new ArrayList<String>();
        String q = "SELECT * FROM proveedor";
        try {
            resultado = sentencia.executeQuery(q);
            System.out.println("Correcto");
        
    } catch (Exception e) {
            System.out.println("No Correcto");
    }
        try {
        while(resultado.next()){
            lista.add(resultado.getString("empresa"));
        }
    } catch (Exception e) {
    }
    return lista;
    }
}
