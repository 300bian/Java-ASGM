
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class manage_requisition extends javax.swing.JFrame {

    /**
     * Creates new form manage_requisition
     */
    public manage_requisition() {
        initComponents();
        loadTable("requisition.txt");
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
        requisitionTable = new javax.swing.JTable();
        MRcreateButton = new javax.swing.JButton();
        MRapproveButton = new javax.swing.JButton();
        MRrejectButton = new javax.swing.JButton();
        MRBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        requisitionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Requisition ID", "Item ID", "Item Name", "Quantity", "Unit Price", "Total Price", "Supplier ID", "Status"
            }
        ));
        jScrollPane1.setViewportView(requisitionTable);

        MRcreateButton.setBackground(new java.awt.Color(153, 255, 153));
        MRcreateButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MRcreateButton.setForeground(new java.awt.Color(0, 0, 0));
        MRcreateButton.setText("Create");
        MRcreateButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MRcreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRcreateButtonActionPerformed(evt);
            }
        });

        MRapproveButton.setBackground(new java.awt.Color(153, 204, 255));
        MRapproveButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MRapproveButton.setForeground(new java.awt.Color(0, 0, 0));
        MRapproveButton.setText("Approve");
        MRapproveButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MRapproveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRapproveButtonActionPerformed(evt);
            }
        });

        MRrejectButton.setBackground(new java.awt.Color(255, 204, 204));
        MRrejectButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MRrejectButton.setForeground(new java.awt.Color(0, 0, 0));
        MRrejectButton.setText("Reject");
        MRrejectButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MRrejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRrejectButtonActionPerformed(evt);
            }
        });

        MRBackButton.setBackground(new java.awt.Color(255, 153, 102));
        MRBackButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MRBackButton.setForeground(new java.awt.Color(0, 0, 0));
        MRBackButton.setText("Back");
        MRBackButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MRBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MRBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MRcreateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(MRrejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MRapproveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MRBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MRcreateButton)
                    .addComponent(MRapproveButton)
                    .addComponent(MRrejectButton)
                    .addComponent(MRBackButton))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MRcreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRcreateButtonActionPerformed
        this.dispose();
        AddRequisition arpage = new AddRequisition();
        arpage.setVisible(true);
    }//GEN-LAST:event_MRcreateButtonActionPerformed

    private void MRapproveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRapproveButtonActionPerformed
        int selectedRow = requisitionTable.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) requisitionTable.getModel();
            String requisitionId = (String) model.getValueAt(selectedRow, 0); // 
            String currentStatus = (String) model.getValueAt(selectedRow, 7);  

            if ("Pending".equals(currentStatus)) {
                model.setValueAt("Approved", selectedRow, 7);

                updateFile(requisitionId, "Approved");
                
                updateFile(requisitionId, "Approved");

                JOptionPane.showMessageDialog(this, "Requisition approved successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "This requisition has already been approved or rejected.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a requisition to approve.");
        }
    }//GEN-LAST:event_MRapproveButtonActionPerformed

    private void MRrejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRrejectButtonActionPerformed
        int selectedRow = requisitionTable.getSelectedRow();

        if (selectedRow != -1) 
        {

            DefaultTableModel model = (DefaultTableModel) requisitionTable.getModel();

            String requisitionId = (String) model.getValueAt(selectedRow, 0); 
            String currentStatus = (String) model.getValueAt(selectedRow, 7); 


            if ("Pending".equals(currentStatus)) {

                model.setValueAt("Rejected", selectedRow, 7);


                updateFile(requisitionId, "Rejected");
                
                updateFile(requisitionId, "Rejected");

                JOptionPane.showMessageDialog(this, "Requisition rejected successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "This requisition has already been rejected.");
            }
        }   else 
            {
                JOptionPane.showMessageDialog(this, "Please select a requisition to reject.");
            }
    }//GEN-LAST:event_MRrejectButtonActionPerformed

    private void MRBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MRBackButtonActionPerformed
        this.dispose();
        purchase_order_main_page pompage = new purchase_order_main_page();
        pompage.setVisible(true);
    }//GEN-LAST:event_MRBackButtonActionPerformed

    void updateFile(String requisitionId, String newStatus) {
        List<String> lines = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("requisition.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields[0].equals(requisitionId)) {
                    fields[7] = newStatus; // 更新 Status
                    line = String.join(",", fields); // 重建该行
                }
                lines.add(line);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("requisition.txt"))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating the file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
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
            java.util.logging.Logger.getLogger(manage_requisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manage_requisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manage_requisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manage_requisition.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage_requisition().setVisible(true);
            }
        });
    }
    
    // Method to load Items from ItemList.txt file to table 
//    private void loadTable(String filePath) {
//        DefaultTableModel tableModel = (DefaultTableModel) requisitionTable.getModel();
//        tableModel.setRowCount(0); 
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(",");
//
//                // 打印调试信息查看每行的内容
//                System.out.println("Read line: " + line);
//                System.out.println("Fields: " + Arrays.toString(fields));
//
//                if (fields.length == 8) {
//                    String[] selectedColumns = {
//                        fields[0], // Requisition ID
//                        fields[1], // Item ID
//                        fields[2], // Item Name
//                        fields[3], // Quantity
//                        fields[4], // Unit Price
//                        fields[5], // Total Price
//                        fields[6], // Supplier ID
//                        fields[7]  // Status
//                    };
//                    tableModel.addRow(selectedColumns);
//                } else {
//                    System.out.println("Invalid data format: " + line);
//                }
//            }
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(this, "Error loading data from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
//    private void loadTable(String filePath) {
//        DefaultTableModel tableModel = (DefaultTableModel) requisitionTable.getModel();
//        tableModel.setRowCount(0);
//        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split("\\s*,\\s*"); // 处理逗号和空格
//                System.out.println("Read line: " + line);
//                System.out.println("Fields: " + Arrays.toString(fields));
//                if (fields.length == 8) {
//                    String[] selectedColumns = {
//                        fields[0], // Requisition ID
//                        fields[1], // Item ID
//                        fields[2], // Item Name
//                        fields[3], // Quantity
//                        fields[4], // Unit Price
//                        fields[5], // Total Price
//                        fields[6], // Supplier ID
//                        fields[7]  // Status
//                    };
//                    tableModel.addRow(selectedColumns);
//                } else {
//                    System.out.println("Invalid data format: " + line);
//                }
//            }
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(this, "Error loading data from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    private void loadTable(String filePath) {
        // 设置表格模型
        DefaultTableModel tableModel = (DefaultTableModel) requisitionTable.getModel();
        tableModel.setRowCount(0); // 清空现有数据

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 处理CSV每一行数据，并去掉多余的空格
                String[] fields = line.split("\\s*,\\s*");

                // 调试信息：输出读取的行内容和解析结果
                System.out.println("Read line: " + line);
                System.out.println("Fields: " + Arrays.toString(fields));

                if (fields.length == 8) {
                    // 提取字段并添加到表格中
                    String[] selectedColumns = {
                        fields[0], // Requisition ID
                        fields[1], // Item ID
                        fields[2], // Item Name
                        fields[3], // Quantity
                        fields[4], // Unit Price
                        fields[5], // Total Price
                        fields[6], // Supplier ID
                        fields[7]  // Status
                    };
                    tableModel.addRow(selectedColumns);
                } else {
                    // 数据格式无效的处理
                    System.out.println("Invalid data format: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            // 文件未找到的错误提示
            JOptionPane.showMessageDialog(this, "File not found: " + filePath, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            // 读取文件错误的提示
            JOptionPane.showMessageDialog(this, "Error loading data from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MRBackButton;
    private javax.swing.JButton MRapproveButton;
    private javax.swing.JButton MRcreateButton;
    private javax.swing.JButton MRrejectButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable requisitionTable;
    // End of variables declaration//GEN-END:variables
}
