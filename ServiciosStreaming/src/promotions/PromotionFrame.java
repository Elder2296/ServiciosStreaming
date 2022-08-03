/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotions;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author e-ari
 */
public class PromotionFrame extends javax.swing.JFrame {

    /**
     * Creates new form PromotionFrame
     */
    private String user;
    private Promotion promotion;
    public PromotionFrame(String user) {
        initComponents();
        setLocationRelativeTo(null);
        this.user = user; 
        promotion =new  Promotion(user);
        
    }
    private void copyMessage1(){
        String textcopy = promotion.getMessage1();
        StringSelection ss = new StringSelection(textcopy);
        Toolkit tool = Toolkit.getDefaultToolkit();
        Clipboard clip = tool.getSystemClipboard();
        clip.setContents(ss,null);
        
        dispose();
    }
    
    private void copyMessage2(){
        promotion.setMessage2();
        String textcopy = promotion.getMessage2();
        StringSelection ss = new StringSelection(textcopy);
        Toolkit tool = Toolkit.getDefaultToolkit();
        Clipboard clip = tool.getSystemClipboard();
        clip.setContents(ss,null);
        
        dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        message1Button = new javax.swing.JButton();
        message2Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        message1Button.setText("Message 1");
        message1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message1ButtonActionPerformed(evt);
            }
        });

        message2Button.setText("Message 2");
        message2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                message2ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(message1Button)
                .addGap(53, 53, 53)
                .addComponent(message2Button)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(message1Button)
                    .addComponent(message2Button))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void message1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message1ButtonActionPerformed
        // TODO add your handling code here:
        this.copyMessage1();
    }//GEN-LAST:event_message1ButtonActionPerformed

    private void message2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_message2ButtonActionPerformed
        this.copyMessage2();        // TODO add your handling code here:
    }//GEN-LAST:event_message2ButtonActionPerformed

    /**
     * @param args the command line arguments
     */
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton message1Button;
    private javax.swing.JButton message2Button;
    // End of variables declaration//GEN-END:variables
}
