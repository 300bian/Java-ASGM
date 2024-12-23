package javaasgm;


import javaasgm.purchase_order_main_page;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author admin
 */
public class purchase_order_list extends javax.swing.JFrame {

    /**
     * Creates new form purchase_order_list
     */
    public purchase_order_list() {
        initComponents();
        CBpurchaseOrderId_VPO.setSelectedIndex(-1);
        CBpaymentStatus_VPO.setSelectedIndex(-1);
        
        // 在窗口初始化时加载数据
        loadDataToTable();

        // 当 ComboBox 选择发生变化时重新加载表格数据
        CBpurchaseOrderId_VPO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loadDataToTable();  // 更新表格
            }
        });

        CBpaymentStatus_VPO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loadDataToTable();  // 更新表格
            }
        });


    }
    
    
    
    private void loadDataToTable() {
        DefaultTableModel tableModel = (DefaultTableModel) TableViewManagePurchaseOrder.getModel();
        tableModel.setRowCount(0); // 清空现有数据

        String filename = "purchaseorder.txt"; // purchaseorder.txt 文件路径
        String selectedOrderStatus = (String) CBpurchaseOrderId_VPO.getSelectedItem();  // 获取选择的订单状态
        String selectedPaymentStatus = (String) CBpaymentStatus_VPO.getSelectedItem();  // 获取选择的支付状态

        // 如果 ComboBox 没有选择任何项（即值为 null），则给它赋一个默认值
        if (selectedOrderStatus == null) {
            selectedOrderStatus = "Please Select";
        }
        if (selectedPaymentStatus == null) {
            selectedPaymentStatus = "Please Select";
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            // 遍历文件中的每一行
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // 按逗号分隔数据

                // 确保字段数量足够
                if (parts.length > 10) {
                    String orderStatus = parts[9]; // 获取第9个字段（订单状态）
                    String paymentStatus = parts[10]; // 获取第10个字段（支付状态）

                    // 过滤条件：根据ComboBox选项显示数据
                    boolean showOrderStatus = selectedOrderStatus.equals("Please Select") || selectedOrderStatus.equals(orderStatus);
                    boolean showPaymentStatus = selectedPaymentStatus.equals("Please Select") || selectedPaymentStatus.equals(paymentStatus);

                    // 如果两个条件都符合，添加该行到表格中
                    if (showOrderStatus && showPaymentStatus) {
                        // 提取字段并添加到表格中
                        String[] rowData = {
                            parts[0],  // Purchase Order ID
                            parts[1],  // Requisition ID
                            parts[2],  // Item ID
                            parts[3],  // Item Name
                            parts[4],  // Quantity
                            parts[5],  // Unit Price
                            parts[6],  // Total Price
                            parts[7],  // Supplier ID
                            parts[8],  // Requisition Status
                            parts[9],  // Order Status
                            parts[10]  // Payment Status
                        };
                        tableModel.addRow(rowData); // 添加到表格
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error occurs when reading purchase order file: " + e.getMessage());
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
        TableViewManagePurchaseOrder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CBpurchaseOrderId_VPO = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        CBpaymentStatus_VPO = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableViewManagePurchaseOrder.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TableViewManagePurchaseOrder);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Purchase Order Status :");

        CBpurchaseOrderId_VPO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Approved", "Rejected", " " }));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Payment Status :");

        CBpaymentStatus_VPO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unpaid", "Paid" }));

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBpurchaseOrderId_VPO, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CBpaymentStatus_VPO, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(341, 341, 341)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBpurchaseOrderId_VPO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(CBpaymentStatus_VPO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        purchase_order_main_page pompage = new purchase_order_main_page();
        pompage.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(purchase_order_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(purchase_order_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(purchase_order_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(purchase_order_list.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new purchase_order_list().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBpaymentStatus_VPO;
    private javax.swing.JComboBox<String> CBpurchaseOrderId_VPO;
    private javax.swing.JTable TableViewManagePurchaseOrder;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
