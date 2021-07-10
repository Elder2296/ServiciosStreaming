
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
    
    public Contact(String user){
        this.userFacebook="";
        this.message="";
        this.wasap="";
        this.workData(user);
    }
    
    private void workData(String user){
        
        
        Server server=Server.getInstance();
        
        String sql="SELECT C.UsuarioFacebook, C.nombre1, Ser.nombre, S.nexpayday, C.whatsapp FROM Suscriptores AS S "
                + "INNER JOIN Clientes AS C ON  S.idCliente = C.id "
                + "INNER JOIN Servicio AS Ser ON S.idservicios = Ser.id "
                + " WHERE S.user = \'"+user+"\'; ";
        
        ResultSet result=server.getResult(sql);
        try{
            if(result.next()){
                this.userFacebook=result.getString(1);
                String ms= "Que tal, espero estes bien "+result.getString(2)+",\nahí molestandol@ con el servicio \nde "
                        + result.getString(3)+ " ya que este mismo\n vence el: "+result.getString(4)+". Cualquier \nduda o problema con la cuenta "
                        + "me lo puede hacer llegar \npor este medio, GRACIAS!!!.";
                this.message=ms;
                this.wasap=result.getString(5);
                
            }
            
        }catch(SQLException ex){
        }
        
        
        
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
