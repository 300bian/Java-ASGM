
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
import java.io.File;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author admin
 */
public class manage__purchaseorder extends javax.swing.JFrame {
    private DefaultTableModel tableModel;

    public manage__purchaseorder() 
    {
        initComponents();
        String[] columnNames = {
            "Purchase Order ID", "Requisition ID", "Item ID", "Item Name", 
            "Quantity", "Unit Price", "Total Price", "Supplier ID", 
            "Requisition Status", "Purchase Order Status", "Payment Status"
        };
        
        tableModel = new DefaultTableModel(columnNames, 0);
        TableManagePurchaseOrder.setModel(tableModel);
        
        String filePath = "purchaseorder.txt"; //
        loadPurchaseOrderTable(filePath);
//        loadPurchaseOrderTableafterAdded();
    }
    
    
    private void loadPurchaseOrderTable(String filePath) {
        // 设置表格模型
        DefaultTableModel tableModel = (DefaultTableModel) TableManagePurchaseOrder.getModel();
        tableModel.setRowCount(0); // 清空现有数据

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // 处理CSV每一行数据，并去掉多余的空格
                String[] fields = line.split("\\s*,\\s*"); // 使用逗号分隔字段

                // 调试信息：输出读取的行内容和解析结果
                System.out.println("Read line: " + line);
                System.out.println("Fields: " + Arrays.toString(fields));

                // 确保字段数量正确，假设文件每行有11个字段
                if (fields.length == 11) {
                    // 提取字段并添加到表格中
                    String[] selectedColumns = {
                        fields[0],  // Purchase Order ID (PO001)
                        fields[1],  // Requisition ID (R04)
                        fields[2],  // Item ID (I002)
                        fields[3],  // Item Name (Headphones)
                        fields[4],  // Quantity (10)
                        fields[5],  // Unit Price (1399.0)
                        fields[6],  // Total Price (13990.0)
                        fields[7],  // Supplier ID (S001)
                        fields[8],  // Requisition Status (Approved)
                        fields[9],  // Order Status (Pending)
                        fields[10]  // Payment Status (Unpaid)
                    };
                    // 将数据添加到表格模型
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
    
    private void deletePurchaseOrderFromFile(String purchaseOrderId) {
        String filename = "purchaseorder.txt";
        File tempFile = new File("purchaseorder_temp.txt");  // 临时文件，用于保存更新后的数据

        try (
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && !purchaseOrderId.equals(parts[0])) {
                    // 如果 purchaseOrderId 不匹配，则写入临时文件
                    writer.write(line + System.lineSeparator());
                }
            }

            // 删除原始文件并将临时文件重命名为原文件名
            File originalFile = new File(filename);
            if (originalFile.delete()) {
                tempFile.renameTo(originalFile);
            } else {
                JOptionPane.showMessageDialog(this, "Error deleting original purchase order file.");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error occurred while updating the file: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableManagePurchaseOrder = new javax.swing.JTable();
        BPOadd = new javax.swing.JButton();
        BPOdelete = new javax.swing.JButton();
        BPOback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableManagePurchaseOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Purchase Order ID", "Requisition ID", "Item ID", "Item Name", "Quantity", "Unit Price", "Total Price", "Supplier ID", "Status", "Purchase Order Status", "Payment Status"
            }
        ));
        jScrollPane1.setViewportView(TableManagePurchaseOrder);

        BPOadd.setBackground(new java.awt.Color(153, 255, 153));
        BPOadd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BPOadd.setForeground(new java.awt.Color(0, 0, 0));
        BPOadd.setText("Add");
        BPOadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPOaddActionPerformed(evt);
            }
        });

        BPOdelete.setBackground(new java.awt.Color(255, 153, 153));
        BPOdelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BPOdelete.setForeground(new java.awt.Color(0, 0, 0));
        BPOdelete.setText("Delete");
        BPOdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPOdeleteActionPerformed(evt);
            }
        });

        BPOback.setBackground(new java.awt.Color(255, 204, 204));
        BPOback.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BPOback.setForeground(new java.awt.Color(0, 0, 0));
        BPOback.setText("Back");
        BPOback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPObackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BPOadd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(BPOdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BPOback, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BPOadd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BPOdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BPOback, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BPOaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPOaddActionPerformed
        this.dispose();
        createpurchaseorder cpopage = new createpurchaseorder();
        cpopage.setVisible(true);
    }//GEN-LAST:event_BPOaddActionPerformed

    private void BPOdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPOdeleteActionPerformed
        // select row from table
        int selectedRow = TableManagePurchaseOrder.getSelectedRow();

        if (selectedRow == -1) {
            // if not select any row, show message
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        // 获取表格中选中行的数据（假设第一列是 purchaseOrderId）
        String purchaseOrderId = TableManagePurchaseOrder.getValueAt(selectedRow, 0).toString(); 

        // 确认删除操作
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected purchase order?",  "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // 从表格中删除该行
            DefaultTableModel model = (DefaultTableModel) TableManagePurchaseOrder.getModel();
            model.removeRow(selectedRow);

            // 更新 purchaseorder.txt 文件，删除对应的行
            deletePurchaseOrderFromFile(purchaseOrderId);
        }
    }//GEN-LAST:event_BPOdeleteActionPerformed

    private void BPObackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPObackActionPerformed
        this.dispose();
        purchase_order_main_page pompage = new purchase_order_main_page();
        pompage.setVisible(true);
    }//GEN-LAST:event_BPObackActionPerformed

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
            java.util.logging.Logger.getLogger(manage__purchaseorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manage__purchaseorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manage__purchaseorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manage__purchaseorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manage__purchaseorder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BPOadd;
    private javax.swing.JButton BPOback;
    private javax.swing.JButton BPOdelete;
    private javax.swing.JTable TableManagePurchaseOrder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
