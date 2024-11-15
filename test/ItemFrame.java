import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javaasgm.FileHandler;
import javaasgm.Item;
import javaasgm.Supplier;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author angyi
 */
public class ItemFrame extends javax.swing.JFrame {
    
    private final FileHandler itemFileHandler;
    private final FileHandler supplierFileHandler;
    private List<Item> itemList;
    private Map<String, Supplier> supplierMap; // To store supplierId -> supplierName mappings

    /**
     * Creates new form Item
     */
    public ItemFrame() {
        initComponents();
        itemFileHandler = new FileHandler("C:\\Users\\angyi\\Documents\\APU\\SE Y2S1\\OODJ\\POTS Assignment\\ItemEntry.txt");
        supplierFileHandler = new FileHandler("C:\\Users\\angyi\\Documents\\APU\\SE Y2S1\\OODJ\\POTS Assignment\\SupplierEntry.txt");
        loadSuppliers(); // Load supplier names into combobox
        loadItems();     // Load item data into table
    }
    
    private void loadSuppliers() {
        // Use the FileHandler instance to get the file path
        
        if (supplierFileHandler != null) {
            supplierMap = Supplier.getSupplierMap(supplierFileHandler.getFilePath());

            // Populate the combo box with supplier names
            combboxSupplierName.removeAllItems();
        if (supplierMap != null) 
            {
            for (Supplier supplier : supplierMap.values()) 
                {
                combboxSupplierName.addItem(supplier.getSupplierName());
                }
            }
        } 
        else 
        {
            // Handle the case where supplierFileHandler is null
            System.out.println("Supplier file handler is not initialized.");
        }
           
    }

    // Load item data into the table
    private void loadItems() {
        itemList = Item.loadItemsFromFile(itemFileHandler, supplierMap);
        updateTable(itemList);
    }
    public void updateTable(List<Item> items) {
        DefaultTableModel model = (DefaultTableModel) tableItem.getModel();
        model.setRowCount(0);  // Clear existing rows
        for (Item item : items) {
            model.addRow(new Object[]{
                item.getItemId(),
                item.getItemName(),
                item.getSupplier().getSupplierId(), // Get supplierId from Supplier object
                item.getPrice(),
                item.getStockLevel()
            });
        }
    }
    private void clearFields() {
        txtItemID.setText("");
        txtItemName.setText("");
        txtItemPrice.setText("");
        lblStockAmount.setText("0");
        txtAmountedit.setText("");
        combboxSupplierName.setSelectedIndex(-1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblItemtitle = new javax.swing.JLabel();
        javax.swing.JLabel lblItemID = new javax.swing.JLabel();
        txtItemID = new javax.swing.JTextField();
        javax.swing.JLabel lblItemName = new javax.swing.JLabel();
        txtItemName = new javax.swing.JTextField();
        javax.swing.JLabel lblSupplier = new javax.swing.JLabel();
        combboxSupplierName = new javax.swing.JComboBox<>();
        javax.swing.JLabel lblStocklevel = new javax.swing.JLabel();
        lblStockAmount = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tableItem = new javax.swing.JTable();
        javax.swing.JButton btnAdd = new javax.swing.JButton();
        javax.swing.JButton btnClear = new javax.swing.JButton();
        javax.swing.JButton btnDelete = new javax.swing.JButton();
        lblPrice = new javax.swing.JLabel();
        txtItemPrice = new javax.swing.JTextField();
        txtAmountedit = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Item ");
        setBackground(java.awt.Color.darkGray);
        setMinimumSize(new java.awt.Dimension(759, 461));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblItemtitle.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        lblItemtitle.setText("ITEM");

        lblItemID.setText("ItemID");

        lblItemName.setText("Item Name");

        lblSupplier.setText("Supplier");

        combboxSupplierName.setModel(combboxSupplierName.getModel());

        lblStocklevel.setText("Stock Level");

        lblStockAmount.setText("(Stock Amount )");

        tableItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemID", "Item Name", "SupplierID", "Price", "Stock Level"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableItem);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        lblPrice.setText("Price");

        jLabel1.setText("Stock Amount:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel2.setText("Search:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblItemID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblItemName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStocklevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 210, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtItemName)
                            .addComponent(combboxSupplierName, 0, 255, Short.MAX_VALUE)
                            .addComponent(txtItemPrice)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblStockAmount))
                            .addComponent(txtAmountedit)
                            .addComponent(txtItemID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblItemtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblItemID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblItemName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combboxSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPrice)
                        .addGap(2, 2, 2)
                        .addComponent(txtItemPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStocklevel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAmountedit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStockAmount)
                            .addComponent(jLabel1))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnClear)
                            .addComponent(btnSave)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblItemtitle)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ok
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String itemId = txtItemID.getText();
        String itemName = txtItemName.getText();
        String supplierName = (String) combboxSupplierName.getSelectedItem();
        String stockLevel = txtAmountedit.getText();
        String price = txtItemPrice.getText();
        
        if (itemId.isEmpty() || itemName.isEmpty() || supplierName.isEmpty() || stockLevel.isEmpty() || price.isEmpty() || price.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
        }
        
        // Check for duplicate itemId
        for (Item item : itemList) {
            if (item.getItemId().equals(itemId)) {
                JOptionPane.showMessageDialog(this, "Item ID already exists!", "Duplicate Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        Supplier selectedSupplier = null;
        for (Supplier supplier : supplierMap.values()) {
            if (supplier.getSupplierName().equals(supplierName)) {
                selectedSupplier = supplier;
                break;
            }
        }
        
        if (selectedSupplier == null) {
            JOptionPane.showMessageDialog(this, "Selected supplier not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Item item = new Item(itemId, itemName, selectedSupplier, Double.parseDouble(price), Integer.parseInt(stockLevel));
        
        // Add to list and update table
        itemList.add(item);
        updateTable(itemList);
        itemFileHandler.addRecord(item.toString());

        // Display success message and clear fields
        JOptionPane.showMessageDialog(this, "Item added successfully!");
        clearFields();
        
    }//GEN-LAST:event_btnAddActionPerformed

    //ok
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    //ok
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        int row = tableItem.getSelectedRow();
        
        if (row < 0) {
            JOptionPane.showMessageDialog(this, 
                    "No row is selected! Please select one row",
                    "Select row",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String itemId = (String) tableItem.getValueAt(row, 0);
            itemList.removeIf(item -> item.getItemId().equals(itemId));
            updateTable(itemList);
            itemFileHandler.deleteRecord(itemId);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        itemList = Item.loadItemsFromFile(itemFileHandler, supplierMap);
        updateTable(itemList); 
    }//GEN-LAST:event_formWindowOpened

    //ok
    private void tableItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableItemMouseClicked
        int selectedRow = tableItem.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tableItem.getModel();

            // Get data from the selected row
            String itemId = (String) model.getValueAt(selectedRow, 0);
            String itemName = (String) model.getValueAt(selectedRow, 1);
            String supplierId = (String) model.getValueAt(selectedRow, 2);
            double price = (double) model.getValueAt(selectedRow, 3);
            int stockLevel = (int) model.getValueAt(selectedRow, 4);

            // Set data in the respective text fields
            txtItemID.setText(itemId);
            txtItemName.setText(itemName);
            txtItemPrice.setText(String.valueOf(price));
            txtAmountedit.setText(String.valueOf(stockLevel));
            lblStockAmount.setText(String.valueOf(stockLevel));
            
            // Find and select the supplier in combo box
            Supplier supplier = supplierMap.get(supplierId);
            if (supplier != null) {
                combboxSupplierName.setSelectedItem(supplier.getSupplierName());
            }
        } 
    }//GEN-LAST:event_tableItemMouseClicked
//ok
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int selectedRow = tableItem.getSelectedRow();
        if (selectedRow != -1) {
            String originalItemId = (String) tableItem.getValueAt(selectedRow, 0);  // Get original itemId from table
            String newItemId = txtItemID.getText();

            // Check if the user tries to change the itemId
            if (!originalItemId.equals(newItemId)) {
                JOptionPane.showMessageDialog(this, "Item ID is not allowed to be updated!", "Update Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop the update process
            } 
            String itemName = txtItemName.getText();
            String supplierName = (String) combboxSupplierName.getSelectedItem();
            String stockLevel = txtAmountedit.getText();
            String price = txtItemPrice.getText().replace("RM", "");

            if (itemName.isEmpty() || supplierName.isEmpty() || stockLevel.isEmpty() || price.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Find the Supplier object based on selected supplier name
            Supplier selectedSupplier = null;
            for (Supplier supplier : supplierMap.values()) {
                if (supplier.getSupplierName().equals(supplierName)) {
                    selectedSupplier = supplier;
                    break;
                }
            }

            if (selectedSupplier == null) {
                JOptionPane.showMessageDialog(this, "Supplier not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update the item in itemList
            Item item = itemList.get(selectedRow);
            item.setItemName(itemName);
            item.setSupplier(selectedSupplier);
            item.setPrice(Double.parseDouble(price));
            item.setStockLevel(Integer.parseInt(stockLevel));

            // Update table view
            updateTable(itemList);

            // Update the file using FileHandler
            itemFileHandler.updateRecord(originalItemId, item.toString());

            JOptionPane.showMessageDialog(this, "Item updated successfully!");
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "No item selected to update!", "Update Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        DefaultTableModel obj = (DefaultTableModel) tableItem.getModel();
        TableRowSorter<DefaultTableModel> obj1 = new TableRowSorter<> (obj);
        tableItem.setRowSorter(obj1);

        String searchText = txtSearch.getText();
        obj1.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
    }//GEN-LAST:event_txtSearchKeyReleased

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
            java.util.logging.Logger.getLogger(InventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
  
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> combboxSupplierName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblItemtitle;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblStockAmount;
    private javax.swing.JTable tableItem;
    private javax.swing.JTextField txtAmountedit;
    private javax.swing.JTextField txtItemID;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtItemPrice;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
