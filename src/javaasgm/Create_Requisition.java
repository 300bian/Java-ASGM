package javaasgm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Create_Requisition extends javax.swing.JFrame {

    private Object txtDate_needed;

   
    public Create_Requisition() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtItem_code = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtDateNeeded = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Item_code:");

        jLabel2.setText("Quantity:");

        jLabel3.setText("Date_needed:");

        txtItem_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtItem_code(evt);
            }
        });

        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantity(evt);
            }
        });

        txtDateNeeded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDate_needed(evt);
            }
        });

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome(evt);
            }
        });

        jButton2.setText("CREATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtItem_code, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDateNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(297, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtItem_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDateNeeded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(32, 32, 32))
        );

        txtItem_code.getAccessibleContext().setAccessibleName("txtItem_code");
        txtQuantity.getAccessibleContext().setAccessibleName("txtQuantity");
        txtDateNeeded.getAccessibleContext().setAccessibleName("txtDate_needed");
        jButton2.getAccessibleContext().setAccessibleName("btnCreate");

        getAccessibleContext().setAccessibleName("Create_Requisition");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHome(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome
        Sales_Manager salesManagerFrame = new Sales_Manager();
        salesManagerFrame.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnHome

    private void txtDate_needed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDate_needed
        String dateStr = txtDateNeeded.getText();
        String regex = "^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateStr);
        
        if (!matcher.matches()) {
        JOptionPane.showMessageDialog(this, "Please enter a valid date in dd/MM/yyyy format.", "Invalid Date Format", JOptionPane.ERROR_MESSAGE);
        txtDateNeeded.requestFocus();
        return;
    }
    
    // If format is valid, try to parse the date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // This prevents invalid dates (like 31/02/2024)
    
        try {
            Date date = sdf.parse(dateStr);
        // If parsing is successful, date is valid
        // Proceed with further actions
        } catch (Exception e) {
        // If parsing fails, it's an invalid date
            JOptionPane.showMessageDialog(this, "The date is invalid! Please enter a valid date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
            txtDateNeeded.requestFocus();
        }
    }//GEN-LAST:event_txtDate_needed

    private void txtQuantity(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantity
        
    }//GEN-LAST:event_txtQuantity

    private void txtItem_code(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtItem_code
        
    }//GEN-LAST:event_txtItem_code

    private void btnCreate(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate
        String itemCode = txtItem_code.getText();
        String quantity = txtQuantity.getText();
        String dateNeeded = txtDateNeeded.getText();

    if (itemCode.isEmpty() || quantity.isEmpty() || dateNeeded.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "All fields are required!", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    } else {
        // Save or process the requisition
        javax.swing.JOptionPane.showMessageDialog(this, "Requisition created successfully!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        // Clear fields
        txtItem_code.setText("");
        txtQuantity.setText("");
        txtDateNeeded.setText("");
    }
    }//GEN-LAST:event_btnCreate

    
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
            java.util.logging.Logger.getLogger(Create_Requisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create_Requisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create_Requisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create_Requisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create_Requisition().setVisible(true);
            }
        });
    
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDateNeeded;
    private javax.swing.JTextField txtItem_code;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
