package Sales_Manager;


public class Sales_Entry03 extends javax.swing.JFrame {

   
    public Sales_Entry03() {
        initComponents();
        txtSalesQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtSalesQuantityKeyReleased(evt);
        }
    });

        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        txtUnitPrice = new javax.swing.JTextField();
        txtSalesQuantity = new javax.swing.JTextField();
        txtSalesAmount = new javax.swing.JTextField();
        txtItemQuantity = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        CbStock = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Item Code: ");

        jLabel2.setText("Item Name:");

        jLabel3.setText("Unit Price:");

        jLabel4.setText("Sales Quantity:");

        jLabel5.setText("Sales Amount:");

        jLabel6.setText("Item Quantity:");

        txtSalesQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSalesQuantityKeyReleased(evt);
            }
        });

        txtSalesAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalesAmountActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
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

        jLabel7.setText("Stock:");

        CbStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Low Stock", "Out of Stock", "Reserved", "Pending Restock","All" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSalesQuantity)
                            .addComponent(txtSalesAmount)
                            .addComponent(txtItemQuantity)
                            .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtItemName)
                            .addComponent(txtUnitPrice))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHome))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnSubmit)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDisplay)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtItemCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnHome))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(CbStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSalesQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSalesAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtItemQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnClear)
                    .addComponent(btnDisplay))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSalesAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalesAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalesAmountActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
        SalesEntryReport salesEntryReportFrame = new SalesEntryReport();
        salesEntryReportFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDisplayActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        Sales_Manager02 salesManager02Frame = new Sales_Manager02();
        salesManager02Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtItemCode.setText("");
        txtItemName.setText("");
        txtUnitPrice.setText("");
        txtSalesQuantity.setText("");
        txtSalesAmount.setText("");
        txtItemQuantity.setText("");
        CbStock.setSelectedIndex(0);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String itemCode = txtItemCode.getText().trim(); // Get the Item Code input
        if (itemCode.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter an Item Code!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader("C:\\Users\\user\\Documents\\NetBeansProjects\\Java-ASGM\\test\\Sales_Manager\\SalesList.txt"))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if ( parts.length == 7 && parts[0].equals(itemCode)) {
                    // Populate the fields
                    txtItemName.setText(parts[1]);
                    txtUnitPrice.setText(parts[2]);
                    txtSalesQuantity.setText(parts[3]);
                    txtSalesAmount.setText(parts[4]);
                    txtItemQuantity.setText(parts[5]);
                    CbStock.setSelectedItem(parts [6]);
                    found = true;
                    break;
                }
            }
            

            if (!found) {
                javax.swing.JOptionPane.showMessageDialog(this, "Item Code not found!", "Error", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } catch (java.io.IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error reading SalesList.txt file: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
                                          
        String itemCode = txtItemCode.getText().trim();
        String itemName = txtItemName.getText().trim();
        String unitPrice = txtUnitPrice.getText().trim();
        String salesQuantity = txtSalesQuantity.getText().trim();
        String salesAmount = txtSalesAmount.getText().trim();
        String itemQuantity = txtItemQuantity.getText().trim();
        String stockStatus = CbStock.getSelectedItem().toString();

        // Validate input fields
        if (itemCode.isEmpty() || itemName.isEmpty() || unitPrice.isEmpty() || salesQuantity.isEmpty() ||
            salesAmount.isEmpty() || itemQuantity.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please fill all fields.", "Input Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Read the file and update or add the record
            java.io.File file = new java.io.File("C:\\Users\\user\\Documents\\NetBeansProjects\\Java-ASGM\\test\\Sales_Manager\\SalesList.txt");
            java.util.ArrayList<String> lines = new java.util.ArrayList<>();
            boolean updated = false;

            if (file.exists()) {
                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts[0].equals(itemCode)) { // If itemCode matches, update the record
                        line = itemCode + ";" + itemName + ";" + unitPrice + ";" + salesQuantity + ";" +
                               salesAmount + ";" + itemQuantity + ";" + stockStatus;
                        updated = true;
                    }
                    lines.add(line);
                }

                reader.close();
            }

            // If the record was not found, add a new line
            if (!updated) {
                String newLine = itemCode + ";" + itemName + ";" + unitPrice + ";" + salesQuantity + ";" +
                                 salesAmount + ";" + itemQuantity + ";" + stockStatus;
                lines.add(newLine);
            }

            // Write the updated or new content back to the file
            java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(file));
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();

            javax.swing.JOptionPane.showMessageDialog(this, "Submitted successfully.", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (java.io.IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error writing to the file: " + e.getMessage(), "File Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }  

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void txtSalesQuantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalesQuantityKeyReleased

        try {
            // Get the values from the fields
            double unitPrice = Double.parseDouble(txtUnitPrice.getText().trim());
            int salesQuantity = Integer.parseInt(txtSalesQuantity.getText().trim());
            int itemQuantity = Integer.parseInt(txtItemQuantity.getText().trim());

            // Calculate sales amount
            double salesAmount = unitPrice * salesQuantity;

            // Update the sales amount field
            txtSalesAmount.setText(String.valueOf(salesAmount));

            // Calculate remaining item quantity
            int remainingQuantity = itemQuantity - salesQuantity;

            // Update the item quantity field
            txtItemQuantity.setText(String.valueOf(remainingQuantity));

            // Optional: Warn if the item quantity goes below zero
            if (remainingQuantity < 0) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Warning: Sales quantity exceeds available stock!", 
                    "Stock Warning", javax.swing.JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
           
        }
    }//GEN-LAST:event_txtSalesQuantityKeyReleased

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
            java.util.logging.Logger.getLogger(Sales_Entry03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales_Entry03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales_Entry03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales_Entry03.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales_Entry03().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbStock;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemQuantity;
    private javax.swing.JTextField txtSalesAmount;
    private javax.swing.JTextField txtSalesQuantity;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
}
