
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
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
public class UserSuscribe extends javax.swing.JPanel {

    private DefaultTableModel model;
    public UserSuscribe() {
        initComponents();
        this.model=(DefaultTableModel)suscribeTable.getModel();
        this.filltable();
    }
    public void filltable(){
        Server server=Server.getInstance();
        Calendar calendar=Calendar.getInstance();
        
        String day= Integer.toString(calendar.get(Calendar.DATE));
        String month=Integer.toString(calendar.get(Calendar.MONTH)+1);
        String year=Integer.toString(calendar.get(Calendar.YEAR));
                        
        String date=year+"-"+month+"-"+day;
        
        String sql="SELECT Ser.nombre, S.user, C.nombre1, C.apellido1, S.estado, S.nexpayday, "
                +" TIMESTAMPDIFF(DAY, S.nexpayday,\'"+date+"\') AS \'dias\'"//falta fecha final
                +" FROM Suscriptores as S "
                +" INNER JOIN Servicio AS Ser ON S.idservicios = Ser.id "
                +" INNER JOIN Clientes AS C ON S.idCliente = C.id "
                +"  ORDER BY dias DESC; ";
        
        ResultSet result=server.getResult(sql);
        try{
            while(result.next()){
                String[] row =new String[6];
                    
                row[0]=result.getString(1);
                row[1]=result.getString(2);
                row[2]=result.getString(3);
                row[3]=result.getString(4);
                row[4]=result.getString(5);
                row[5]=result.getString(6);
                
                this.model.addRow(row);
                
                
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        suscribeTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        suscribeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service", "User", "Name", "Last Name", "State", "Payment Day"
            }
        ));
        jScrollPane2.setViewportView(suscribeTable);

        jScrollPane1.setViewportView(jScrollPane2);

        jButton1.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        jButton1.setText("Pay");

        jButton2.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        jButton2.setText("Deactivete");

        updateButton.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(updateButton))
                .addContainerGap(35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        this.model.setRowCount(0);
        this.filltable();
    }//GEN-LAST:event_updateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable suscribeTable;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
