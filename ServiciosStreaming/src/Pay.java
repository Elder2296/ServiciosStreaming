
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author losa
 */
public class Pay {
    
    public Pay(){
        
    }
    public boolean processPay(String user,String service,Double amount, String today){
        Server server=Server.getInstance();
        String sql="SELECT S.nexpayday FROM Suscriptores AS S WHERE S.user = \'"+user+"\'";
        ResultSet result= server.getResult(sql);
        
        try{
            if(result.next()){
                 //Register the pay in Db.Pay
                sql="INSERT INTO Pay (user,service,amount,datepay) "
                        + "VALUES (\'"+user+"\',\'"+service+"\',"+amount+",\'"+today+"\');";
                
                System.out.println(sql);
                server.getResult(sql);
                
                
                Date date= result.getDate(1);
                
                int year=date.getYear()+1900;
                int month= date.getMonth()+2;
                int day = date.getDate();
                String newpayday= year + "-" + month + "-" + day;
                
               
                
                //Update nex pay day
                sql="UPDATE Suscriptores SET nexpayday = \'"+newpayday+"\' WHERE user = \'"+user+"\';";
                System.out.println("PAGO HECHO CON EXITO");
                server.getResult(sql);
                return true;
                
            }else{
                return false;
            }
        
        }catch(SQLException ex){
            ex.getMessage();
        
        }
        
        
        return false;
    }
    
}
