/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hulkstore;
import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Angel Rodriguez
 */
public class Conexion {
    public Connection CrearBD(){
        Connection con;
        String barra = File.separator;
    String proyecto =System.getProperty("user.dir")+barra+"BD";
    File url =new File(proyecto);
    
    if (url.exists()){
        System.out.println("Ya Existe la Base de Datos");
    } 
    else {
           
               
                try {
                    
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                    String DB="jdbc:derby:"+proyecto+";create=true";
                    con=DriverManager.getConnection(DB);
                    
                    String tabla= "create table productos(PRODUCTOID int PRIMARY KEY,\n" +
"			NOMBREPRODUCTO  varchar(30),\n" +
"			DESCRIPCION varchar(30),\n" +
"			STOCK INT )";
                    
                 PreparedStatement ps = con.prepareStatement(tabla);
                 ps.execute();
                 ps.close();
                 System.out.print("Base de Datos Creada");
                 return con;
                
                
                    
                   } 
                catch ( ClassNotFoundException |SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Error"+ex);
                }
            
    }
        
        
        return null;
    }

    public Connection CargarBD(){
    
        Connection con;
        String barra = File.separator;
        String proyecto =System.getProperty("user.dir")+barra+"BD";
        try {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         String DB="jdbc:derby:"+proyecto;
         con=DriverManager.getConnection(DB);
         System.out.println("Base de datos Cargada");
         return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error:"+ex);
        }
        return null;
    }
}

