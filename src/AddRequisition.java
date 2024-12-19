
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class AddRequisition extends javax.swing.JFrame 
{

    public AddRequisition() 
    {
        initComponents();
        CBitemName.setSelectedIndex(-1);
        LoadComboBox();
        
        String filePath = "requisition.txt";
        String newId = manageRequisition.autoGenerateId(filePath, "R");
        System.out.println("Generated ID: " + newId);
        TFrequisitionId.setText(newId);
        
        TFrequisitionId.setEnabled(false);
        TFitemId.setEnabled(false);
        TFunitPrice.setEnabled(false);
        TFsupplierId.setEnabled(false);
        TFtotalPrice.setEnabled(false);
        TFstatus.setEnabled(false);
        
        TFtotalPrice.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkTotalPrice();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkTotalPrice();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkTotalPrice();
            }

            private void checkTotalPrice() {
                String totalPriceText = TFtotalPrice.getText().trim();
                if (!totalPriceText.isEmpty()) {
                    try {
                        Double.parseDouble(totalPriceText);
                        TFstatus.setText("Pending"); 
                    } catch (NumberFormatException ex) {
                    }
                } else {
                    TFstatus.setText("");
                }
            }
        });
        
    }
    
    private void LoadComboBox()
    {
        String filename = "item";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) 
        {
            String line;

            CBitemName.removeAllItems();

            CBitemName.addItem("Please Select");

            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split(",");

                if (parts.length > 0) 
                {
                    String itemCode = parts[1]; 
                    CBitemName.addItem(itemCode); 
                }
            }
        } 
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(this, "Error occurs when reading item list: " + e.getMessage());
        }    
        
    CBitemName.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent evt) 
        {
            String selectedItem = (String) CBitemName.getSelectedItem();

            if (!"Please Select".equals(selectedItem)) {
                updateItemDetails(selectedItem);
            }
        }
    });
    
    }
    

    private void updateItemDetails(String selectedItem) 
    {
        String filename = "item";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length > 3 && parts[1].equals(selectedItem)) {
                    String itemId = parts[0]; 
                    String supplierId = parts[2];
                    String unitPrice = parts[3];

                    TFitemId.setText(itemId); 
                    TFsupplierId.setText(supplierId); 
                    TFunitPrice.setText(unitPrice);  
                    break;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error occurs when reading item list: " + e.getMessage());
        }
    
    CTconfirmQuantity.addActionListener(new ActionListener() 
    {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                String quantityText = TFquantity.getText();
                String unitPriceText = TFunitPrice.getText();

                int quantity = Integer.parseInt(quantityText);
                double unitPrice = Double.parseDouble(unitPriceText);

                double totalPrice = quantity * unitPrice;

                TFtotalPrice.setText(String.format("%.2f", totalPrice));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for quantity and unit price.");
            }
        }
    });
    
    
    
    }
    

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TFrequisitionId = new javax.swing.JTextField();
        TFitemId = new javax.swing.JTextField();
        TFunitPrice = new javax.swing.JTextField();
        TFquantity = new javax.swing.JTextField();
        TFtotalPrice = new javax.swing.JTextField();
        TFsupplierId = new javax.swing.JTextField();
        TFstatus = new javax.swing.JTextField();
        RFsaveButton = new javax.swing.JButton();
        RFbackButton = new javax.swing.JButton();
        CBitemName = new javax.swing.JComboBox<>();
        CTconfirmQuantity = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Requisition ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Item Name:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Item ID:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Unit Price:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Total Price:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Quantity:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Supplier ID:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Status:");

        TFrequisitionId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFrequisitionIdActionPerformed(evt);
            }
        });

        TFsupplierId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFsupplierIdActionPerformed(evt);
            }
        });

        RFsaveButton.setBackground(new java.awt.Color(153, 255, 153));
        RFsaveButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RFsaveButton.setForeground(new java.awt.Color(0, 0, 0));
        RFsaveButton.setText("Save");
        RFsaveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RFsaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RFsaveButtonActionPerformed(evt);
            }
        });

        RFbackButton.setBackground(new java.awt.Color(255, 153, 153));
        RFbackButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        RFbackButton.setForeground(new java.awt.Color(0, 0, 0));
        RFbackButton.setText("Back");
        RFbackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RFbackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RFbackButtonActionPerformed(evt);
            }
        });

        CBitemName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CTconfirmQuantity.setBackground(new java.awt.Color(255, 204, 255));
        CTconfirmQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CTconfirmQuantity.setForeground(new java.awt.Color(0, 0, 0));
        CTconfirmQuantity.setText(">");
        CTconfirmQuantity.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFrequisitionId)
                            .addComponent(TFitemId)
                            .addComponent(CBitemName, 0, 264, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(RFsaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RFbackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TFtotalPrice)
                                    .addComponent(TFsupplierId)
                                    .addComponent(TFstatus)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TFquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CTconfirmQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(71, 71, 71)
                        .addComponent(TFunitPrice)))
                .addGap(38, 38, 38))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TFrequisitionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBitemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFitemId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFunitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TFquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CTconfirmQuantity))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TFtotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TFsupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TFstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RFbackButton)
                    .addComponent(RFsaveButton))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Requisition Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabel2)
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFrequisitionIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFrequisitionIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFrequisitionIdActionPerformed

    private void TFsupplierIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFsupplierIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFsupplierIdActionPerformed

    private void RFbackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RFbackButtonActionPerformed
        this.dispose();
        manage_requisition mrpage = new manage_requisition();
        mrpage.setVisible(true);
    }//GEN-LAST:event_RFbackButtonActionPerformed

    private void RFsaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RFsaveButtonActionPerformed


        
        String requisitionId = TFrequisitionId.getText();
        String itemId = TFitemId.getText();
        String itemName = (String) CBitemName.getSelectedItem();
        int quantity = Integer.parseInt(TFquantity.getText());
        double unitPrice = Double.parseDouble(TFunitPrice.getText());
        double totalPrice = unitPrice * quantity; // 自动计算总价
        String supplierId = TFsupplierId.getText();
        String status = TFstatus.getText();

//        if (requisitionId.isEmpty() || itemId.isEmpty() || itemName == null || quantity.isEmpty() || unitPrice.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "All the order details must be filled in before saving.(except 'remarks')", 
//                    "Validation Error", JOptionPane.ERROR_MESSAGE);
//        } 

        //write new changes into the txtfile
        try{
            String filename = "requisition.txt";
            FileWriter fw = new FileWriter(filename, true);

            fw.write(
                requisitionId + "," +
                itemId + "," +
                itemName + "," +
                quantity + "," +
                unitPrice + "," +
                totalPrice + "," +
                supplierId + "," +
                status + "\n" 
            );

            fw.close();
            JOptionPane.showMessageDialog(null, "Requisition saved successfully.");
            
            this.dispose();
            manage_requisition mrpage = new manage_requisition();
            mrpage.setVisible(true);
        }catch (IOException e) {
            JOptionPane.showMessageDialog(this, "文件写入出错，请检查文件路径和权限。", "文件错误", JOptionPane.ERROR_MESSAGE);
        }   
        catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "请确保数量和单价输入的是有效数字！", "输入错误", JOptionPane.ERROR_MESSAGE);
        }
            
    }//GEN-LAST:event_RFsaveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRequisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRequisition().setVisible(true);
            }
        });
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBitemName;
    private javax.swing.JButton CTconfirmQuantity;
    private javax.swing.JButton RFbackButton;
    private javax.swing.JButton RFsaveButton;
    private javax.swing.JTextField TFitemId;
    private javax.swing.JTextField TFquantity;
    private javax.swing.JTextField TFrequisitionId;
    private javax.swing.JTextField TFstatus;
    private javax.swing.JTextField TFsupplierId;
    private javax.swing.JTextField TFtotalPrice;
    private javax.swing.JTextField TFunitPrice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    // End of variables declaration//GEN-END:variables
}
