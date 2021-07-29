
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author losa
 */
public class Painter extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected,boolean hasFocus,int row, int column){
        int n_days=Integer.parseInt( table.getValueAt(row, 5).toString());
        
        if(n_days<=3){
        
            setBackground(Color.RED);
            
        }else if(n_days>3 && n_days < 6){
            
            setBackground(Color.MAGENTA);
        
        }else if(n_days > 5 && n_days <= 10){
          
            setBackground(Color.YELLOW);
        
        }else{
            if(row % 2 == 0){
                setBackground(Color.GRAY);
            }else{  
                setBackground(Color.CYAN);
            }
            
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
    
}


class Painter2 extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected,boolean hasFocus,int row, int column){
        String name =table.getValueAt(row, 1).toString();
        
        if(name.equals("Netflix")){
        
            setBackground(Color.RED);                             
            
        }else if(name.equals("Disney Plus")){
            
            setBackground(Color.CYAN);
        
        }else if(name.equals("HBO Max")){
          
            setBackground(Color.MAGENTA);
        
        }else if (name.equals("Spotify")){
            setBackground(Color.GREEN);
            
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
    
}