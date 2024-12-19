
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;


public class createpurchaseorder extends javax.swing.JFrame {


    public createpurchaseorder() {
        initComponents();
        
        CBrequisitionId_POF.setSelectedIndex(-1);
        LoadComboBoxPO();
        getNewPOID();
        
//        String purchaseOrderFilePath = "purchaseorder.txt";
//        String newPOID = managePurchaseOrder.autoGenerateRequisitionId();
//        System.out.println("Generated ID: " + newPOID);
//        TFpurchaseOrderID.setText(newPOID);
        
        TFpurchaseOrderID.setEnabled(false);
        TFitemName_POF.setEnabled(false);
        TFitemId_PO.setEnabled(false);
        TFunitPrice_PO.setEnabled(false);
        TFtotalPrice_PO.setEnabled(false);
        TFquantity_PO.setEnabled(false);
        TFsupplierId_PO.setEnabled(false);
        TFrequisitionStatus_PO.setEnabled(false);
        TForderStatus_PO.setEnabled(false);
        TFpaymentStatus_PO.setEnabled(false);
        
        
//        String RequisitionfilePath = "requisition.txt";
//        String newId = managePurchaseOrder.autoGenerateRequisitionId(RequisitionfilePath, "R");
//        System.out.println("Generated ID: " + newId);
//        TFrequisitionID_POF.setText(newId);
        

    }
    
    public String autoGenerateRequisitionId(){
        String filename = "purchaseorder.txt";
        String lastPOID = "PO000";  // 默认值
        String newPOID;

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                lastPOID = line.split(",")[0];  // 提取 PO ID
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
        }

        // 确保提取数字部分
        String numericPart = lastPOID.substring(2);  // 提取 "001" 部分
        int POID = Integer.parseInt(numericPart) + 1;  // 转换为整数并加 1

        newPOID = String.format("PO%03d", POID);  // 格式化为 "PO001" 形式
        return newPOID;
    }
    
    
    private void LoadComboBoxPO() {
        String requisitionFile = "requisition.txt"; // requisition 文件路径
        String purchaseOrderFile = "purchaseorder.txt"; // purchaseorder 文件路径
        Set<String> existingRequisitionIds = new HashSet<>();

        // 读取 purchaseorder.txt 文件，找出所有已有的 requisitionId
        try (BufferedReader br = new BufferedReader(new FileReader(purchaseOrderFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 1) {
                    String requisitionId = parts[1]; // 获取purchaseorder.txt中的requisitionId（假设它是第2列）
                    existingRequisitionIds.add(requisitionId);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error occurs when reading purchase order list: " + e.getMessage());
        }

        // 读取 requisition.txt 文件并更新 ComboBox
        try (BufferedReader br = new BufferedReader(new FileReader(requisitionFile))) {
            String line;

            // 清空 ComboBox 现有选项
            CBrequisitionId_POF.removeAllItems();

            // 添加默认选项
            CBrequisitionId_POF.addItem("Please Select");

            // 遍历文件中的每一行
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // 按逗号分隔数据

                // 确保字段数量足够，并且 field(7) 为 "Approved"
                if (parts.length > 7 && "Approved".equals(parts[7])) {
                    String requisitionId = parts[0]; // 提取 Requisition ID (field 0)

                    // 如果该 requisitionId 已经存在于 purchaseorder.txt 文件中，跳过
                    if (!existingRequisitionIds.contains(requisitionId)) {
                        CBrequisitionId_POF.addItem(requisitionId); // 添加到 ComboBox
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error occurs when reading requisition list: " + e.getMessage());
        }

        // 添加 ActionListener 监听选项变化
        CBrequisitionId_POF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String selectedItem = (String) CBrequisitionId_POF.getSelectedItem();

                // 当用户选择了非默认选项时，更新详细信息
                if (!"Please Select".equals(selectedItem)) {
                    updateItemDetailsPO(selectedItem); // 调用更新方法
                }
            }
        });
    }
    
    
//    private void LoadComboBoxPO() {
//        String filename = "requisition.txt"; // 文件名更改为 requisition.txt
//
//        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            String line;
//
//            // 清空 ComboBox 现有选项
//            CBrequisitionId_POF.removeAllItems();
//
//            // 添加默认选项
//            CBrequisitionId_POF.addItem("Please Select");
//
//            // 遍历文件中的每一行
//            while ((line = br.readLine()) != null) {
//                String[] parts = line.split(","); // 按逗号分隔数据
//
//                // 确保字段数量足够，并且 field(7) 为 "Approved"
//                if (parts.length > 7 && "Approved".equals(parts[7])) {
//                    String requisitionId = parts[0]; // 提取 Requisition ID (field 0)
//                    CBrequisitionId_POF.addItem(requisitionId); // 添加到 ComboBox
//                }
//            }
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(this, "Error occurs when reading requisition list: " + e.getMessage());
//        }
//
//        // 添加 ActionListener 监听选项变化
//        CBrequisitionId_POF.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                String selectedItem = (String) CBrequisitionId_POF.getSelectedItem();
//
//                // 当用户选择了非默认选项时，更新详细信息
//                if (!"Please Select".equals(selectedItem)) {
//                    updateItemDetailsPO(selectedItem); // 调用更新方法
//                }
//            }
//        });
//    }

    
    public void getNewPOID(){
        String newPOID = autoGenerateRequisitionId();
        TFpurchaseOrderID.setText(newPOID); 
    }
    
    
    private void updateItemDetailsPO(String selectedItem) {
        String filename = "requisition.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length > 7 && parts[0].equals(selectedItem)) {
                    // 显示各字段数据
                    TFitemId_PO.setText(parts[1]);          // Field (1): Item ID
                    TFitemName_POF.setText(parts[2]);       // Field (2): Item Name
                    TFunitPrice_PO.setText(parts[4]);       // Field (4): Unit Price
                    TFquantity_PO.setText(parts[3]);       // Field (3): Quantity
                    TFtotalPrice_PO.setText(parts[5]);     // Field (5): Total Price
                    TFsupplierId_PO.setText(parts[6]);      // Field (6): Supplier ID
                    TFrequisitionStatus_PO.setText(parts[7]); // Field (7): Requisition Status

                    // 检查所有字段是否成功显示
                    if (areAllFieldsPopulated()) {
                        TForderStatus_PO.setText("Pending");
                        TFpaymentStatus_PO.setText("Unpaid");
                    }
                    break; // 找到匹配项后停止搜索
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error occurs when reading requisition list: " + e.getMessage());
        }
    }    
    private boolean areAllFieldsPopulated() 
    {
        return !TFitemId_PO.getText().trim().isEmpty()
                && !TFitemName_POF.getText().trim().isEmpty()
                && !TFunitPrice_PO.getText().trim().isEmpty()
                && !TFquantity_PO.getText().trim().isEmpty()
                && !TFtotalPrice_PO.getText().trim().isEmpty()
                && !TFsupplierId_PO.getText().trim().isEmpty()
                && !TFrequisitionStatus_PO.getText().trim().isEmpty();
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TFrequisitionStatus_PO = new javax.swing.JTextField();
        TForderStatus_PO = new javax.swing.JTextField();
        TFsupplierId_PO = new javax.swing.JTextField();
        TFtotalPrice_PO = new javax.swing.JTextField();
        TFquantity_PO = new javax.swing.JTextField();
        TFunitPrice_PO = new javax.swing.JTextField();
        TFitemId_PO = new javax.swing.JTextField();
        TFitemName_POF = new javax.swing.JTextField();
        TFpurchaseOrderID = new javax.swing.JTextField();
        CBrequisitionId_POF = new javax.swing.JComboBox<>();
        BTsave_PO = new javax.swing.JButton();
        BTback_PO = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        TFpaymentStatus_PO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Purchase Order Form");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Purchase Order ID :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Requisition ID :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Item Name :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Item ID :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Unit Price :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Quantity :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Total Price :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Supplier ID :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Requisition Status :");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Purchase Order Status :");

        CBrequisitionId_POF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BTsave_PO.setBackground(new java.awt.Color(204, 255, 204));
        BTsave_PO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTsave_PO.setForeground(new java.awt.Color(0, 0, 0));
        BTsave_PO.setText("Save");
        BTsave_PO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTsave_POActionPerformed(evt);
            }
        });

        BTback_PO.setBackground(new java.awt.Color(153, 204, 255));
        BTback_PO.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BTback_PO.setForeground(new java.awt.Color(0, 0, 0));
        BTback_PO.setText("Back");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Payment Status :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(BTsave_PO, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTback_PO, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TFrequisitionStatus_PO)
                            .addComponent(TForderStatus_PO, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(TFsupplierId_PO, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(TFtotalPrice_PO, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(TFunitPrice_PO, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(TFitemId_PO, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(TFitemName_POF, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(TFpurchaseOrderID, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(CBrequisitionId_POF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TFpaymentStatus_PO, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(TFquantity_PO))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFpurchaseOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CBrequisitionId_POF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TFitemName_POF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFitemId_PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TFunitPrice_PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TFquantity_PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TFtotalPrice_PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TFsupplierId_PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TFrequisitionStatus_PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TForderStatus_PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(TFpaymentStatus_PO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTsave_PO)
                    .addComponent(BTback_PO))
                .addGap(20, 20, 20))
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

    private void BTsave_POActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTsave_POActionPerformed
        String purchaseOrderId = TFpurchaseOrderID.getText();
        String requisitionId = (String) CBrequisitionId_POF.getSelectedItem();
        String itemId = TFitemId_PO.getText();
        String itemName = TFitemName_POF.getText();
        int quantity = Integer.parseInt(TFquantity_PO.getText());
        double unitPrice = Double.parseDouble(TFunitPrice_PO.getText());
        double totalPrice = Double.parseDouble(TFtotalPrice_PO.getText());
        String supplierId = TFsupplierId_PO.getText();
        String requisitionstatus = TFrequisitionStatus_PO.getText();
        String purchaseOrderstatus = TForderStatus_PO.getText();
        String paymentstatus = TFpaymentStatus_PO.getText();
        
        try{
           String filename = "purchaseorder.txt";
           FileWriter fw = new FileWriter(filename, true);

           fw.write(
               purchaseOrderId+","+
               requisitionId + "," +
               itemId + "," +
               itemName + "," +
               quantity + "," +
               unitPrice + "," +
               totalPrice + "," +
               supplierId + "," +
               requisitionstatus + ","+
               purchaseOrderstatus + ","+
               paymentstatus + "\n"
           );

           fw.close();
           JOptionPane.showMessageDialog(null, "Purchase Order saved successfully.");
            
           this.dispose();
           manage__purchaseorder mpopage = new manage__purchaseorder();
           mpopage.setVisible(true);
        }
        catch (IOException e) 
        {
            JOptionPane.showMessageDialog(this, "文件写入出错，请检查文件路径和权限。", "文件错误", JOptionPane.ERROR_MESSAGE);
        }   
        catch (NumberFormatException e) 
        {
        JOptionPane.showMessageDialog(this, "请确保数量和单价输入的是有效数字！", "输入错误", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_BTsave_POActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(createpurchaseorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createpurchaseorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createpurchaseorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createpurchaseorder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createpurchaseorder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTback_PO;
    private javax.swing.JButton BTsave_PO;
    private javax.swing.JComboBox<String> CBrequisitionId_POF;
    private javax.swing.JTextField TFitemId_PO;
    private javax.swing.JTextField TFitemName_POF;
    private javax.swing.JTextField TForderStatus_PO;
    private javax.swing.JTextField TFpaymentStatus_PO;
    private javax.swing.JTextField TFpurchaseOrderID;
    private javax.swing.JTextField TFquantity_PO;
    private javax.swing.JTextField TFrequisitionStatus_PO;
    private javax.swing.JTextField TFsupplierId_PO;
    private javax.swing.JTextField TFtotalPrice_PO;
    private javax.swing.JTextField TFunitPrice_PO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    // End of variables declaration//GEN-END:variables

    
}
