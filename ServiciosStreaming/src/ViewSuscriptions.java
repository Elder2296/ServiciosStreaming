
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ViewSuscriptions extends javax.swing.JFrame {
    private DefaultTableModel model;
    private int rowSelected;
    private int indexService;
    private int indexCustomer;
    /**
     * Creates new form ViewSuscriptions
     */
    public ViewSuscriptions() {
        this.rowSelected=0;
        initComponents();
        nameLabel.setVisible(false);
        suscribeButton.setVisible(false);
        model=(DefaultTableModel)tableServices.getModel();
        llenarTable();
        setLocationRelativeTo(null);
        
    }
    private void llenarTable(){
        Server server=Server.getInstance();
        ResultSet result=server.getResult("SELECT * FROM Servicio;");
        
        try{
            while(result.next()){
                String[] row=new String[4];
                
                row[0]=String.valueOf(result.getInt(1));
                row[1]=result.getString(2);
                row[2]=String.valueOf(result.getInt(7));
                row[3]=String.valueOf(result.getInt(8));
                //System.out.println(result.getInt(1));
                
                
                
                this.model.addRow(row);
                
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            
        }
    }
    public void addSuscription(int idCustomer){
        System.out.println("index customer: "+idCustomer);
        this.indexCustomer=idCustomer;
        Server server=Server.getInstance();
        
        ResultSet result=server.getResult("SELECT C.nombre1, C.apellido1 FROM Clientes AS C WHERE id = "+idCustomer);
        
        try{
            if(result.next()){
                nameLabel.setText(result.getNString(1)+result.getNString(2));
                nameLabel.setVisible(true);
                suscribeButton.setVisible(true);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    private void Suscribe(){
        Server server=Server.getInstance();
        String sql="SELECT * FROM Servicio WHERE id ="+this.indexService;
        ResultSet rq = server.getResult(sql);
        try{
            while(rq.next()){
                if(rq.getInt(7)>rq.getInt(8)){
                    System.out.println("Si se puede agregar");
                    ConfirmForm confirm= new ConfirmForm();
                    confirm.setData(this.indexCustomer, this.indexService);
                    confirm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    dispose();
                    confirm.setVisible(true);
                    
                    
                }else{
                    System.out.println("No hay cupo");
                }
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
        tableServices = new javax.swing.JTable();
        suscribeButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableServices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Tipo de Servicios", "Activos", "Disponibilidad"
            }
        ));
        tableServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableServicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableServices);

        suscribeButton.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        suscribeButton.setText("SUSCRIBIR");
        suscribeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suscribeButtonActionPerformed(evt);
            }
        });

        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(suscribeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suscribeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableServicesMouseClicked
        // TODO add your handling code here:
        this.rowSelected = tableServices.rowAtPoint(evt.getPoint());
        int columna = tableServices.columnAtPoint(evt.getPoint());
        if ((this.rowSelected > -1) && (columna > -1))
            System.out.println("Fila: "+rowSelected);
            //System.out.println(modelo.getValueAt(fila,columna));
        //System.out.println("Value: "+ this.modelo.getValueAt(rowSelected, 1));
        System.out.println("Index: "+this.model.getValueAt(rowSelected, 0));
        try{
            this.indexService = Integer.valueOf(this.model.getValueAt(this.rowSelected, 0).toString());
        }catch(Exception e){
            System.out.println(e.getMessage());     
        }
        System.out.println(this.indexService);
    }//GEN-LAST:event_tableServicesMouseClicked

    private void suscribeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suscribeButtonActionPerformed
        // TODO add your handling code here:
        
        this.Suscribe();
        
        //System.out.println("indice: "+this.indexService);
        
    }//GEN-LAST:event_suscribeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton suscribeButton;
    private javax.swing.JTable tableServices;
    // End of variables declaration//GEN-END:variables
}