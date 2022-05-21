
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author losa
 */
public class RegisterService extends javax.swing.JPanel {

    /**
     * Creates new form RegisterService
     */
    public RegisterService() {
        initComponents();
    }
    private void registerService(){
        
        if(typeService.getSelectedItem().toString().equals("Elejir Servicio")){
            alertLabel.setText("Elejir Servicio!!!");
        }
        else if(payField.getText().equals("") && passwordField.getText().equals("") && representativeField.getText().equals("")
                && maxactivesField.getText().equals("")){
            alertLabel.setText("Debe llenar todos los campos!!!");
        }else{
            Server server=Server.getInstance();
            String name= typeService.getSelectedItem().toString();
            String email=emailField.getText();
            String sqlInstruccion="SELECT * FROM Servicio WHERE email = \""+email+"\" and  nombre = \""+name+"\"";
            ResultSet result=server.getResult(sqlInstruccion);
            try{
                if(result.next()){
                    alertLabel.setText("E-mail Registrado");
                }else{
                    String day=payField.getText();
                    String pass=passwordField.getText();
                    String rep=representativeField.getText();
                    int maxAct =Integer.parseInt( maxactivesField.getText());
                    sqlInstruccion="INSERT INTO Servicio (nombre,fechaPago,email,contrasenia,representante,maxactivos,activos)"
                            + " VALUES(\'"+name+"\',\'"+day+"\',\'"+email+"\',\'"+pass+"\',\'"+rep+"\',"+maxAct+",0);";
                    
                    result = server.getResult(sqlInstruccion);
                    if(!result.rowInserted()){
                    alertLabel.setText("No se hizo el Registro !!!");
                    }else{
                        alertLabel.setText("Registro exitoso!!!");

                        emailField.setText("");
                        payField.setText("");
                        passwordField.setText("");
                        representativeField.setText("");
                        maxactivesField.setText("");
                    }
                    
                }
            }catch(SQLException ex){
                alertLabel.setText("Hubo un error!!!");
            }
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

        passwordField = new javax.swing.JTextField();
        representativeField = new javax.swing.JTextField();
        maxactivesField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        payField = new javax.swing.JTextField();
        alertLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        typeService = new javax.swing.JComboBox<>();

        passwordField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        representativeField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        maxactivesField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        maxactivesField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                maxactivesFieldKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Name:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Payment Day:");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Email:");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Representative:");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Max Actives:");

        payField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        payField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                payFieldKeyTyped(evt);
            }
        });

        alertLabel.setForeground(new java.awt.Color(204, 51, 0));
        alertLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        registerButton.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        registerButton.setText("Registrar");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel7.setText("Password:");

        emailField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        typeService.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        typeService.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elejir Servicio", "Disney Plus", "Spotify", "Netflix", "HBO Max", "Star Plus", "Amazon Video" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(408, 408, 408)
                                .addComponent(typeService, 0, 168, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alertLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(representativeField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maxactivesField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(payField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(registerButton)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(139, 139, 139))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(typeService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(payField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(representativeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(maxactivesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alertLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerButton)
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void maxactivesFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_maxactivesFieldKeyTyped
        // TODO add your handling code here:
        char validate=evt.getKeyChar();
        if(Character.isLetter(validate)){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Input only numbers!!!");
            alertLabel.setText("Input only numbers!!!");
        }
    }//GEN-LAST:event_maxactivesFieldKeyTyped

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
        registerService();
    }//GEN-LAST:event_registerButtonActionPerformed

    private void payFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payFieldKeyTyped
        
        char validate=evt.getKeyChar();
        if(Character.isLetter(validate)){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Input only numbers!!!");
            alertLabel.setText("Input only numbers!!!");
        }
    }//GEN-LAST:event_payFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField maxactivesField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTextField payField;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField representativeField;
    private javax.swing.JComboBox<String> typeService;
    // End of variables declaration//GEN-END:variables
}
