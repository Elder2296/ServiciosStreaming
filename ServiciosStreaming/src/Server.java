/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author losa
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Server {
    private static Server server;
    private static Statement st;
    
    
    private Server(){
        
    }
    public static Server getInstance() {
        if(server==null){
            server=new Server();
            try{
                
                Class.forName("org.mariadb.jdbc.Driver");
                
                Connection conection=null;
                conection=DriverManager.getConnection("jdbc:mysql://localhost/ServiciosStreaming", "Losa", "brC123abc");
                st=conection.createStatement();
                
                
                
                
                System.out.println("Conexion Estable");
                
            }catch(ClassNotFoundException ex){
                System.out.println(ex.getMessage());
            
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            
            }
        }
        return server;
            
    }
    public ResultSet getResult(String sqlinstruction) {
        try{
            return st.executeQuery(sqlinstruction);
        }catch(SQLException ex){
                System.out.println(ex.getMessage());
                return null;
            
        }
        
        
    
    }
    
    
}
