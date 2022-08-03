/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotions;

/**
 *
 * @author e-ari
 */
public class Promotion {
    private String message1;
    private String message2;
    

    public Promotion(String name) {
        this.message1="";
        this.setMessage1(name);
    }
    public Promotion() {
    }
    
    
    private void setMessage1(String name){
        this.message1="Que tal "+name+" que este de lo mejor.\n\n"
                + "En SERVICIOS STREAMING queremos que sigas con nosotros"
                + "y brindarte un mejor servicio, con contenido económico y de calidad.\n\n"
                + "Y queremos invitarte a una PRUEBA GRATUITA, "
                + "de nuestros nuevos servicios.\n\n"
                + "AMAZON  VIDEO\n\n"
                + "Y\n\n"
                + "PARAMOUNT+\n\n"
                + "¿Quieres formar parte de está PRUEBA GRATUITA?";
        
        
                
    
    }
    
    public void setMessage2(){
        this.message2="Gracias por aceptar nuestra propuesta.\n\n"
                + "A continuación te dejamos los links de descargas para Amazon Video y Paramount+\n\n"
                + "\n\n"
                + "DATOS DE INICIO DE SESION PARA AMBOS SERVICIOS\n\n"
                + "AMAZON VIDEO\n\n"
                + "Correo:elLosa20200@gmail.com\n"
                + "Contraseña:prueba_Gratuita2022\n\n"
                + "PARAMOUNT+\n\n"
                + "Correo:elLosa20200@gmail.com\n"
                + "Contraseña:prueba_Gratuita2022\n\n"
                + "Cualquier duda o comentario, estamos a la orden.";
    }

    public String getMessage1() {
        return message1;
    }

    public String getMessage2() {
        return message2;
    }
    
    
    
}
