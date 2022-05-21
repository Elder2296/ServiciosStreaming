package principal;


import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author losa
 */
public class Deactivate {
    
    public Deactivate(){
    
    }
    public Boolean deactivateSuscription(String user){
        
        Server server=Server.getInstance();
        String sql="SELECT S.idservicios FROM Suscriptores AS S WHERE S.user = \'"+user+"\';";
        
        ResultSet result= server.getResult(sql);

        try{
            if(result.next()){
                sql = "UPDATE Servicio  SET activos = activos - 1 WHERE id = "+result.getInt(1)+";";
                server.getResult(sql);
                
                sql ="UPDATE Suscriptores SET estado = \'desactivado\' WHERE user = \'"+user+"\';";
                
                server.getResult(sql);
                
                return true;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        return false;
        
    }
    
}
