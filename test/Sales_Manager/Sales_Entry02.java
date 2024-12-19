package Sales_Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


public class Sales_Entry02 extends javax.swing.JFrame {

    
    public Sales_Entry02() {
        initComponents();
        setupCbStatus();
        setupTextField();
    }
    private void setupCbStatus(){
            CbStatus.addItem("Low Stock");
            CbStatus.addItem("Out of Stock");
            CbStatus.addItem("Reserved");
            CbStatus.addItem("Pending Restock");
            CbStatus.addItem("All");
        }
    private void setupTextField(){
        
        txtItemName.setEditable(false);
        txtItemName.setFocusable(false);
    
        txtSalesQuantity.setEditable(false);
        txtSalesQuantity.setFocusable(false);
    
        txtSalesAmount.setEditable(false);
        txtSalesAmount.setFocusable(false);
    
        txtUnitPrice.setEditable(false);
        txtUnitPrice.setFocusable(false);

        // Allow these fields to remain editable
        txtItemCode.setEditable(true);
        txtItemQuantity.setEditable(true);

        // Optional tooltips
        txtItemName.setToolTipText("This field is read-only.");
        txtSalesQuantity.setToolTipText("This field is read-only.");

        }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHome = new javax.swing.JButton();
        lblItemCode = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        lblItemQuantity = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        CbStatus = new javax.swing.JComboBox<>();
        txtItemQuantity = new javax.swing.JTextField();
        lblSalesAmount = new javax.swing.JLabel();
        lblUnitPrice = new javax.swing.JLabel();
        lblItemName = new javax.swing.JLabel();
        lblSalesQuantity = new javax.swing.JLabel();
        txtSalesQuantity = new javax.swing.JTextField();
        txtSalesAmount = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        CbItemCode = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        lblItemCode.setText("Item code:");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDisplay.setText("Display");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        lblItemQuantity.setText("Item Quantity:");

        txtItemName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItemNameActionPerformed(evt);
            }
        });

        lblStock.setText("Stock:");

        CbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        CbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbStatusActionPerformed(evt);
            }
        });

        lblSalesAmount.setText("Sales_Amount:");

        lblUnitPrice.setText("Unit_Price:");

        lblItemName.setText("Item Name:");

        lblSalesQuantity.setText("Sales Quantity:");

        txtSalesQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalesQuantityActionPerformed(evt);
            }
        });

        CbItemCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        CbItemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbItemCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblUnitPrice)
                                        .addComponent(lblSalesAmount))
                                    .addGap(269, 269, 269))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(153, 153, 153)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(310, 310, 310)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(CbItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblSalesQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtItemQuantity)
                                .addComponent(txtSalesQuantity)
                                .addComponent(txtSalesAmount)
                                .addComponent(txtUnitPrice)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblItemCode)
                            .addComponent(btnSearch)
                            .addComponent(btnHome)
                            .addComponent(CbItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblItemName)
                            .addComponent(lblStock)
                            .addComponent(CbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblItemQuantity)
                    .addComponent(txtItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSalesAmount)
                            .addComponent(txtSalesAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSalesQuantity)
                            .addComponent(txtSalesQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnitPrice)
                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnDisplay)
                    .addComponent(btnClear))
                .addGap(75, 75, 75))
        );

        getAccessibleContext().setAccessibleName("Sales_Entry02");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Sales_Manager02 salesManagerFrame = new Sales_Manager02();
        salesManagerFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        SalesEntryReport salesEntryReportFrame = new SalesEntryReport();
        salesEntryReportFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDisplayActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        //CbItemCode.setSelectedItemCode("");
        txtItemName.setText("");
        txtItemQuantity.setText("");
        txtSalesQuantity.setText("");
        txtSalesAmount.setText("");
        txtUnitPrice.setText("");
        CbStatus.setSelectedItem("ALL Stock"); // Resets to "ALL Stock"
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
          String itemCode = (String)CbItemCode.getSelectedItem();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\Documents\\NetBeansProjects\\Java-ASGM\\test\\Sales_Manager\\SalesList.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(itemCode)) {
                    txtItemName.setText(parts[1]);
                    txtSalesQuantity.setText(parts[2]);
                    txtSalesAmount.setText(parts[3]);
                    txtUnitPrice.setText(parts[4]);
                    CbStatus.setSelectedItem(parts[5]);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Item not found.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading data.");
        }  
           
    }//GEN-LAST:event_btnSearchActionPerformed
   


    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String itemCode = (String)CbItemCode.getSelectedItem();
        String itemName = txtItemName.getText();
        String itemQuantity = txtItemQuantity.getText();
        String salesQuantity = txtSalesQuantity.getText();
        String salesAmount = txtSalesAmount.getText();
        String unitPrice = txtUnitPrice.getText();
        String status = (String) CbStatus.getSelectedItem();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\user\\Documents\\NetBeansProjects\\Java-ASGM\\test\\Sales_Manager\\SalesList.txt", true))) {
            writer.write(itemCode + "," + itemName + "," + itemQuantity + "," + salesQuantity + "," + salesAmount + "," + unitPrice + "," + status);
            writer.newLine(); // Adds a new line after the record
            JOptionPane.showMessageDialog(this, "Data submitted successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data.");
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtItemNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItemNameActionPerformed
        
    }//GEN-LAST:event_txtItemNameActionPerformed

    private void CbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbStatusActionPerformed
        String selectedStatus = (String)CbStatus.getSelectedItem();
        if(selectedStatus!=null){
            System.out.println("User selected:"+ selectedStatus);
        }
    }//GEN-LAST:event_CbStatusActionPerformed

    private void txtSalesQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalesQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalesQuantityActionPerformed

    private void CbItemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbItemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbItemCodeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sales_Entry02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_Entry02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_Entry02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_Entry02.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales_Entry02().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbItemCode;
    private javax.swing.JComboBox<String> CbStatus;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblItemCode;
    private javax.swing.JLabel lblItemName;
    private javax.swing.JLabel lblItemQuantity;
    private javax.swing.JLabel lblSalesAmount;
    private javax.swing.JLabel lblSalesQuantity;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblUnitPrice;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemQuantity;
    private javax.swing.JTextField txtSalesAmount;
    private javax.swing.JTextField txtSalesQuantity;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
