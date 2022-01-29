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
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private static Server server;
    private static Statement st;
    private static PreparedStatement pst;
    
    
    private Server(){
        
    }
    public static Server getInstance() {
        if(server==null){
            server=new Server();
            try{
                
                Class.forName("org.mariadb.jdbc.Driver");
                
                Connection conection=null;
                conection = DriverManager.getConnection("jdbc:mysql://localhost/ServiciosStreaming", "Losa", "brC123abc");
                st = conection.createStatement();
                pst = conection.prepareStatement("UPDATE Suscriptores SET user =? WHERE id =?;");
                //pst = (PreparedStatement) conection.createStatement();
                
                
                
                
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
    public int getResultUpdate(String user, int idsuscription){
        
        try{
            pst.setString(1, user );
            pst.setInt(2, idsuscription);
            return pst.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    
    }
    
    
}
class ServerOnlyne{
    private static ServerOnlyne server;
    private static Statement st;
    private static PreparedStatement pst;
    
    
    private ServerOnlyne(){
        
    }
    public static ServerOnlyne getInstance() throws InstantiationException, IllegalAccessException {
        if(server==null){
            server=new ServerOnlyne();
            try{
                
                Class.forName("com.mysql.cj.jdbc.Drive").newInstance();
                
                /*Connection conection=null;
                String url = "jdbc:mysql://ugjkd1onkmyyvfte:vh0H4aBQbUcbXZVnBQOn@bvmtpurncngbraujawjj-mysql.services.clever-cloud.com:3306/bvmtpurncngbraujawjj";
                String user = "ugjkd1onkmyyvfte";
                String pass  = "vh0H4aBQbUcbXZVnBQOn";
                conection = DriverManager.getConnection(url,user,pass);
                st = conection.createStatement();*/
                //pst = conection.prepareStatement("UPDATE Suscriptores SET user =? WHERE id =?;");
                //pst = (PreparedStatement) conection.createStatement();
                
                
                
                
                System.out.println("Conexion Estable del servidor Onlyne");
                
            }catch(Exception ex){
                System.out.println("encontro un error");
                System.out.println(ex);
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
    public int getResultUpdate(String user, int idsuscription){
        
        try{
            pst.setString(1, user );
            pst.setInt(2, idsuscription);
            return pst.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return 0;
        }
    
    }



   
    
}
