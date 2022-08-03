package principal;


import java.sql.Date;
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
public class PayForm extends javax.swing.JFrame {

    /**
     * Creates new form PayForm
     */
    private String hour;
    private String minute;
    private String time;
    public PayForm() {
        initComponents();
        this.hour ="00";
        this.minute ="00";
        this.time ="PM";
        TextPrompt placeholder= new TextPrompt("00000000000000",refField);
        placeholder.changeAlpha(0.75f);
        setLocationRelativeTo(null);
        
        
    }
    public void setLayout(String user,String service,String name, String lastname){
        this.userField.setText(user);
        this.serviceLabel.setText(service);
        this.nameLabel.setText(name + " "+lastname);
        
    }
    
    public int payState(){
                    
        java.util.Date fecha = (java.util.Date) calendar.getDatoFecha();
            
        int day=fecha.getDate();
        int month=fecha.getMonth()+1;
        int anio=fecha.getYear()+1900;
        String date=anio+"-"+month+"-"+day;
        
        
        Pay pay = new Pay();
        String option = this.typePay.getSelectedItem().toString();
        if(option.equals("Deposito")){
            String datePay = this.hour+":"+this.minute+" "+this.time;
            pay.setCodigoRef(this.refField.getText());  pay.setTimeofPay(datePay);
        }
        Boolean process = pay.processPay(this.userField.getText(), this.serviceLabel.getText(), Double.parseDouble(amoutField.getText()), date,option);
        if(process){
            JOptionPane.showMessageDialog(this, "Pay processed");
            dispose();
            return 0;
        }else{
            JOptionPane.showMessageDialog(this, "Failed Process");
            return 1;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userField = new javax.swing.JLabel();
        serviceLabel = new javax.swing.JLabel();
        calendar = new rojeru_san.componentes.RSDateChooser();
        amoutField = new javax.swing.JTextField();
        alertLabel = new javax.swing.JLabel();
        payButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        typePay = new javax.swing.JComboBox<>();
        refField = new javax.swing.JTextField();
        hoursField = new javax.swing.JComboBox<>();
        doubleDot = new javax.swing.JLabel();
        minutesField = new javax.swing.JComboBox<>();
        timeField = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("Service:");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("User:");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Amount:");

        userField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        serviceLabel.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        calendar.setColorBackground(new java.awt.Color(102, 102, 102));
        calendar.setColorForeground(new java.awt.Color(102, 102, 102));
        calendar.setPlaceholder("Date pay");

        amoutField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        amoutField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amoutFieldKeyTyped(evt);
            }
        });

        alertLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        alertLabel.setForeground(new java.awt.Color(255, 0, 0));
        alertLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        payButton.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        payButton.setText("Pay");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        nameLabel.setBackground(new java.awt.Color(51, 255, 102));
        nameLabel.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(204, 51, 0));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        typePay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Pago", "Efectivo", "Deposito" }));
        typePay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typePayItemStateChanged(evt);
            }
        });
        typePay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                typePayMousePressed(evt);
            }
        });

        refField.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        refField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        refField.setEnabled(false);
        refField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                refFieldKeyTyped(evt);
            }
        });

        hoursField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        hoursField.setEnabled(false);
        hoursField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hoursFieldItemStateChanged(evt);
            }
        });
        hoursField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hoursFieldActionPerformed(evt);
            }
        });

        doubleDot.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        doubleDot.setText(":");
        doubleDot.setEnabled(false);

        minutesField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        minutesField.setEnabled(false);
        minutesField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                minutesFieldItemStateChanged(evt);
            }
        });
        minutesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minutesFieldActionPerformed(evt);
            }
        });

        timeField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        timeField.setEnabled(false);
        timeField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                timeFieldItemStateChanged(evt);
            }
        });
        timeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(amoutField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(serviceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hoursField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doubleDot)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minutesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(typePay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refField)
                                .addComponent(alertLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serviceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(amoutField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(typePay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(refField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoursField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doubleDot)
                    .addComponent(minutesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(alertLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(payButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amoutFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amoutFieldKeyTyped

        char validate=evt.getKeyChar();
        if(Character.isLetter(validate)){
            getToolkit().beep();
            evt.consume();
            //JOptionPane.showMessageDialog(null,"Input only numbers!!!");
            alertLabel.setText("Input only numbers!!!");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_amoutFieldKeyTyped

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        // TODO add your handling code here:
        
        
        this.payState();
        
    }//GEN-LAST:event_payButtonActionPerformed

    private void refFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_refFieldKeyTyped

    private void typePayMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typePayMousePressed
        // TODO add your handling code here:
//        System.out.println("opcion elegida");
//        System.out.println(typePay.getSelectedItem().toString());
    }//GEN-LAST:event_typePayMousePressed

    private void typePayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typePayItemStateChanged
        // TODO add your handling code here:
        //System.out.println("opcion elegida");
        System.out.println(typePay.getSelectedItem().toString());
        String option = typePay.getSelectedItem().toString();
        if(option.equals("Deposito")){refField.setEnabled(true); timeField.setEnabled(true); hoursField.setEnabled(true); minutesField.setEnabled(true); doubleDot.setEnabled(true);}
        else{refField.setEnabled(false); timeField.setEnabled(false); hoursField.setEnabled(false); minutesField.setEnabled(false); doubleDot.setEnabled(false);}
    }//GEN-LAST:event_typePayItemStateChanged

    private void hoursFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hoursFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hoursFieldActionPerformed

    private void minutesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minutesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minutesFieldActionPerformed

    private void timeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeFieldActionPerformed

    private void hoursFieldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hoursFieldItemStateChanged
        this.hour = hoursField.getSelectedItem().toString();
    }//GEN-LAST:event_hoursFieldItemStateChanged

    private void minutesFieldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_minutesFieldItemStateChanged
        this.minute = minutesField.getSelectedItem().toString();
    }//GEN-LAST:event_minutesFieldItemStateChanged

    private void timeFieldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_timeFieldItemStateChanged
        this.time = timeField.getSelectedItem().toString();
    }//GEN-LAST:event_timeFieldItemStateChanged

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertLabel;
    private javax.swing.JTextField amoutField;
    private rojeru_san.componentes.RSDateChooser calendar;
    private javax.swing.JLabel doubleDot;
    private javax.swing.JComboBox<String> hoursField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> minutesField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton payButton;
    private javax.swing.JTextField refField;
    private javax.swing.JLabel serviceLabel;
    private javax.swing.JComboBox<String> timeField;
    private javax.swing.JComboBox<String> typePay;
    private javax.swing.JLabel userField;
    // End of variables declaration//GEN-END:variables
}
