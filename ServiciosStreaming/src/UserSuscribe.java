
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
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
public class UserSuscribe extends javax.swing.JPanel {
    private int rowSelected;
    private DefaultTableModel model;
    private String user;
    private String service;
    private String name;
    private String lasname;
            
    public UserSuscribe() {
        initComponents();
        TextPrompt placeholder = new TextPrompt("Search", searchField);
        placeholder.changeAlpha(0.75f);
        placeholder.changeStyle(Font.ITALIC);
        
        this.rowSelected=0;
        this.user = "";
        this.service="";
        this.name="";
        this.lasname="";
        this.model=(DefaultTableModel)suscribeTable.getModel();
        this.filltable();
    }
    private void filter(String pattern,String type){
        Server server=Server.getInstance();
        Calendar calendar=Calendar.getInstance();
        
        String day= Integer.toString(calendar.get(Calendar.DATE));
        String month=Integer.toString(calendar.get(Calendar.MONTH)+1);
        String year=Integer.toString(calendar.get(Calendar.YEAR));
                        
        String date=year+"-"+month+"-"+day;
        
        String sql="SELECT Ser.nombre, S.user, C.nombre1, C.apellido1, S.estado, "
                +" TIMESTAMPDIFF(DAY,\'"+date+"\' ,S.nexpayday) AS \'dias\'"//falta fecha final
                +" FROM Suscriptores as S "
                +" INNER JOIN Servicio AS Ser ON S.idservicios = Ser.id "
                +" INNER JOIN Clientes AS C ON S.idCliente = C.id "
                +" WHERE " + type +" LIKE \""+pattern+"%\" ";
        
        
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
        
        this.suscribeTable.setDefaultRenderer(Object.class, new Painter() );
    
    }
    private void filltable(){
        Server server=Server.getInstance();
        Calendar calendar=Calendar.getInstance();
        
        String day= Integer.toString(calendar.get(Calendar.DATE));
        String month=Integer.toString(calendar.get(Calendar.MONTH)+1);
        String year=Integer.toString(calendar.get(Calendar.YEAR));
                        
        String date=year+"-"+month+"-"+day;
        
        String sql="SELECT Ser.nombre, S.user, C.nombre1, C.apellido1, S.estado, "
                +" TIMESTAMPDIFF(DAY,\'"+date+"\' ,S.nexpayday) AS \'dias\'"//falta fecha final
                +" FROM Suscriptores as S "
                +" INNER JOIN Servicio AS Ser ON S.idservicios = Ser.id "
                +" INNER JOIN Clientes AS C ON S.idCliente = C.id "
                +" WHERE S.estado = \'activo\' ORDER BY dias ASC; ";
        
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
        
        this.suscribeTable.setDefaultRenderer(Object.class, new Painter() );
    }
    private void getUser(){
        
        ContactForm contact=new ContactForm();
        contact.filled(this.user,1);
        contact.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        contact.setVisible(true);
        
        
        
        
    }
    private void showpay(){
        PayForm payform=new PayForm();
        payform.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        payform.setLayout(this.user, this.service,this.name,this.lasname);
        payform.setVisible(true);
        
    }
    
    
    private void showUsers(){
        Server server = Server.getInstance();
        String sql = "SELECT idservicios FROM Suscriptores WHERE user = \'"+this.user+"\';";
        ResultSet result = server.getResult(sql);
        
        try{
            if(result.next()){
                ShowUsers show = new ShowUsers(result.getInt(1));
                show.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                show.setVisible(true);
            }
            
        
        }catch(SQLException ex){
            
        
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
        jButton2 = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        suscribeTable = new javax.swing.JTable();
        contactButton = new javax.swing.JButton();
        showUsersButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        searchFor = new javax.swing.JComboBox<>();
        updateServiceButton = new javax.swing.JButton();

        jButton1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jButton1.setText("Pay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jButton2.setText("Deactivete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        updateButton.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        updateButton.setText("Update table");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        suscribeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service", "User", "Name", "Last Name", "State", "next payment will be in (days)"
            }
        ));
        suscribeTable.setAutoscrolls(false);
        suscribeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suscribeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(suscribeTable);

        contactButton.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        contactButton.setText("Contact");
        contactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactButtonActionPerformed(evt);
            }
        });

        showUsersButton.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        showUsersButton.setText("Show Users");
        showUsersButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUsersButtonActionPerformed(evt);
            }
        });

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        searchFor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search for", "User", "Name" }));

        updateServiceButton.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        updateServiceButton.setText("Update data");
        updateServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateServiceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchFor, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showUsersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(contactButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showUsersButton)
                    .addComponent(updateServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        this.model.setRowCount(0);
        this.filltable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void contactButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactButtonActionPerformed
        // TODO add your handling code here:
        this.getUser();
    }//GEN-LAST:event_contactButtonActionPerformed

    private void suscribeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suscribeTableMouseClicked
        // TODO add your handling code here:
        this.rowSelected = suscribeTable.rowAtPoint(evt.getPoint());
        int columna = suscribeTable.columnAtPoint(evt.getPoint());
        if ((this.rowSelected > -1) && (columna > -1))
            System.out.println("Fila: "+rowSelected);
            //System.out.println(modelo.getValueAt(fila,columna));
        //System.out.println("Value: "+ this.modelo.getValueAt(rowSelected, 1));
        //System.out.println("Index: "+this.modelo.getValueAt(rowSelected, 0));
        
        try{
            this.user = this.model.getValueAt(this.rowSelected, 1).toString();
            this.service=this.model.getValueAt(this.rowSelected, 0).toString();
            this.name=this.model.getValueAt(this.rowSelected, 2).toString();
            this.lasname=this.model.getValueAt(this.rowSelected, 3).toString();
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());     
        }
        System.out.println(this.user);
        
    }//GEN-LAST:event_suscribeTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.showpay();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(this, "Seguro que quiere desactivar a: "+this.name+" "+this.lasname);
        System.out.println("option: "+opt);
        if(opt == 0){
            Deactivate deactivate= new Deactivate();
            if(deactivate.deactivateSuscription(this.user)){
                JOptionPane.showMessageDialog(this, "Process succesful");
            }
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void showUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUsersButtonActionPerformed
        // TODO add your handling code here:
        
        this.showUsers();
    }//GEN-LAST:event_showUsersButtonActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchFieldKeyPressed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
        System.out.println(searchField.getText());
        String typeSearch = searchFor.getSelectedItem().toString();
        
        System.out.println(typeSearch);
        
        if(searchField.getText().equals("")){
            this.model.setRowCount(0);
            this.filltable();
        }else{
            if(!typeSearch.equals("Search for")){
                this.model.setRowCount(0);
                String opt = "";
                if (typeSearch.equals("User")){
                    opt ="S.user";
                }else if(typeSearch.equals("Name")){
                    opt = "C.nombre1";
                }
                this.filter(searchField.getText(),opt);
 
            }
            
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void updateServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateServiceButtonActionPerformed
        // TODO add your handling code here:
        FormUpdateService form = new FormUpdateService(this.user);
        form.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        form.setVisible(true);
        
        
    }//GEN-LAST:event_updateServiceButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contactButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> searchFor;
    private javax.swing.JButton showUsersButton;
    private javax.swing.JTable suscribeTable;
    private javax.swing.JButton updateButton;
    private javax.swing.JButton updateServiceButton;
    // End of variables declaration//GEN-END:variables
}
