package principal;


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
        String sql="SELECT S.nexpayday,S.id FROM Suscriptores AS S WHERE S.user = \'"+user+"\'";
        ResultSet result= server.getResult(sql);
        
        try{
            if(result.next()){
                 //Register the pay in Db.Pay
                int npays = this.getResult(amount, service);
                int abono = this.getAbono(amount, service);
              
                
                sql="INSERT INTO Pay (idSuscription,service,amount,datepay) "
                        + "VALUES ("+result.getInt(2)+",\'"+service+"\',"+amount+",\'"+today+"\');";
                
                System.out.println(sql);
                server.getResult(sql);
                
                
                Date date= result.getDate(1);
                int nexmountpay = date.getMonth()+1+npays;
                
                int year= 2000;
                int month = 0;
                int day = date.getDate();
                
                if(nexmountpay <= 12){
                    year=date.getYear()+1900;
                    month= nexmountpay;
                    
                
                }else{
                    year = date.getYear() + 1900 + 1;
                    month = nexmountpay - 12;
                   
                }
                
                String newpayday = year+"-"+month+"-"+day;
                
                //Update nex pay day
                
                sql="UPDATE Suscriptores SET nexpayday = \'"+newpayday+"\' WHERE user = \'"+user+"\';";
                System.out.println("PAGO HECHO CON EXITO");
                server.getResult(sql);
                System.out.println("El abono es de: "+abono);    
                if(abono != 0){
                    sql = "INSERT INTO Abonos (user,amount,state) VALUES (\'"+user+"\',"+abono+", Pendiente);";
                }
                server.getResult(sql);
                System.out.println("ABONO REALIZADO");
                    
                    
                   
                
                
                return true;
                
            }else{
                return false;
            }
        
        }catch(SQLException ex){
            ex.getMessage();
        
        }
        
        
        return false;
    }
    private int getResult(Double amount, String service){
        int result=0;
        if(service.equals("Netflix")){
            result = (int) (amount/35.0);
        }else if(service.equals("Disney Plus") || service.equals("Spotify") || service.equals("HBO Max") ){
            result = (int) (amount/25);
        }
    
        return result;
    }
    private int getAbono(Double amount, String service){
        int result = 0;
        if(service.equals("Netflix")){
            result = (int) (amount % 35);
        }else if(service.equals("Disney Plus") || service.equals("Spotify") || service.equals("HBO Max") ){
            result = (int) (amount % 25);
        }
        
        return result;
    }
    
}
