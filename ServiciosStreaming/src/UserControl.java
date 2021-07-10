
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author losa
 */
public class UserControl extends javax.swing.JPanel {
    private DefaultTableModel modelo;
    private int rowSelected;
    private int indexUser;

    /**
     * Creates new form UserControl
     */
    public UserControl() {
        initComponents();
        this.rowSelected=0;
        this.indexUser=1;
        this.modelo=(DefaultTableModel)tableofusers.getModel();
        this.llenarTable();
        
        
    }
    
    private void llenarTable(){
       
        
        Server server=Server.getInstance();
        ResultSet result=server.getResult("SELECT * FROM Clientes;");
        try{
            
                while(result.next()){
                    
                    
                    String[] row=new String[6];
                    //System.out.println(result.next());
                    row[0]=String.valueOf(result.getString(1));
                    row[1]=result.getString(2);
                    row[2]=result.getString(3);
                    row[3]=result.getString(4);
                    row[4]=result.getString(5);
                    row[5]=result.getString(6);
                    this.modelo.addRow(row);
                    
                }
                
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        suscribirButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableofusers = new javax.swing.JTable();

        jButton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton1.setText("ACTUALIZAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        suscribirButton.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        suscribirButton.setText("SUSCRIBIR");
        suscribirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suscribirButtonActionPerformed(evt);
            }
        });

        tableofusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Nombre", "Apellido", "Facebook", "Whatsapp", "E-mail"
            }
        ));
        tableofusers.setAutoscrolls(false);
        tableofusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableofusersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableofusers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addComponent(suscribirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(suscribirButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.modelo.setRowCount(0);
        this.llenarTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void suscribirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suscribirButtonActionPerformed
        // TODO add your handling code here:
        
        //this.modelo.ge
        ViewSuscriptions viewSus=new ViewSuscriptions();
        viewSus.addSuscription(this.indexUser);
        viewSus.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        viewSus.setVisible(true);
        
    }//GEN-LAST:event_suscribirButtonActionPerformed

    private void tableofusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableofusersMouseClicked
        // TODO add your handling code here:
        this.rowSelected = tableofusers.rowAtPoint(evt.getPoint());
        int columna = tableofusers.columnAtPoint(evt.getPoint());
        if ((this.rowSelected > -1) && (columna > -1))
            System.out.println("Fila: "+rowSelected);
            //System.out.println(modelo.getValueAt(fila,columna));
        //System.out.println("Value: "+ this.modelo.getValueAt(rowSelected, 1));
        System.out.println("Index: "+this.modelo.getValueAt(rowSelected, 0));
        try{
            this.indexUser = Integer.valueOf(this.modelo.getValueAt(this.rowSelected, 0).toString());
        }catch(Exception e){
            System.out.println(e.getMessage());     
        }
        System.out.println(this.indexUser);
    }//GEN-LAST:event_tableofusersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton suscribirButton;
    private javax.swing.JTable tableofusers;
    // End of variables declaration//GEN-END:variables
}
