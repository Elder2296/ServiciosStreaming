/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Script;

/**
 *
 * @author losa
 */
public class Generator {
    private static Generator generator;
    public Generator(){
    
    }
    
    public static Generator getInstance(){
        if(generator == null){
            generator = new Generator(); 
        }
        return generator;
    }
    
    
    public String getNewpassword(){
        String newpassword= "";
        int ncharacters = this.getLengthPassword();
        int contador = 0;
        int random = 0;
        Characters ch = new Characters(); 
        while(contador < ncharacters){
            random = (int)Math.floor(Math.random()*(67-0+1)+0);
            newpassword = newpassword + ch.getCharacter(random);
            contador++;
        }
        
        return newpassword;
    
    }
    private int getLengthPassword(){
        return (int)Math.floor(Math.random()*(11-8+1)+8);
        
    }
    
    
    
    
}
