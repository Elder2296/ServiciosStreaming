
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
public class Contact {
    
    private String userFacebook;
    private String message;
    private String wasap;
    
    public Contact(){
        this.userFacebook="";
        this.message="";
        this.wasap="";
        
    }
    
    public void workData(String user,int opt){
        
        
        Server server=Server.getInstance();
        
        String sql="SELECT C.UsuarioFacebook, C.nombre1, Ser.nombre, S.nexpayday, C.whatsapp, Ser.email, Ser.contrasenia FROM Suscriptores AS S "
                + "INNER JOIN Clientes AS C ON  S.idCliente = C.id "
                + "INNER JOIN Servicio AS Ser ON S.idservicios = Ser.id "
                + " WHERE S.user = \'"+user+"\'; ";
        
        ResultSet result=server.getResult(sql);
        try{
            if(result.next()){
                this.userFacebook=result.getString(1);
                
                String ms = "";
                if(opt==1){
                    ms = this.getMessageNotice(result.getString(2), result.getString(3), result.getString(4));
                }else{
                    ms = this.getMessageUpdateData(result.getString(2), result.getString(3), result.getString(6), result.getString(7));
                }
                
                this.message=ms;
                this.wasap=result.getString(5);
                
            }
            
        }catch(SQLException ex){
        }
        
        
        
    }
    private String getMessageNotice(String name,String service, String date){
        return "ESTE ES UN MENSAJE DE RECORDATORIO\n\nQue tal, espero este bien "+name+", ahí molestandol@ con el servicio de "+service
                +" ya que este  vence el "+date+". De continuar con el servicio por favor confirmar la continuidad del mismo. "
                +"Cualquier duda o inconveniente con la cuenta,  me lo puede hacer llegar por este medio, GRACIAS";
    
    }
    private String getMessageUpdateData(String name,String service, String email,String pass){
        return "ACTUALIZACION DE DATOS\n\nQue tal, "+name+" espero este bien. Disculpe el inconveniente le comparto los nuevos datos de la cuenta de"
                + service + " Correo:"+email+"     contraseña:"+pass+"     Cualquier inconveniente me puede escribir por este medio.";
    }
    public String getUser(){
        return this.userFacebook;
    }
    public String getMessage(){
        return this.message;
    }
    public String getWhatsapp(){
        return this.wasap;
    }
    
}
