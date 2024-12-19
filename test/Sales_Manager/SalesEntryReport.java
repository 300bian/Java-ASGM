package Sales_Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class SalesEntryReport extends javax.swing.JFrame {

    
    public SalesEntryReport() {
        initComponents();
        setupCbStock();
    }
    
    private void setupCbStock(){
            CbStock.addItem("Low Stock");
            CbStock.addItem("Out of Stock");
            CbStock.addItem("Reserved");
            CbStock.addItem("Pending Restock");
            CbStock.addItem("All");
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableSalesEntry = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnDisplay = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblStock = new javax.swing.JLabel();
        CbStock = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableSalesEntry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Item code", "Item_name", "Unit_price", "Sales_Quantity", "Sales_amount", "Stock_lvl"
            }
        ));
        TableSalesEntry.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TableSalesEntryPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(TableSalesEntry);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnDisplay.setText("Display");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblStock.setText("Stock:");

        CbStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        CbStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(btnDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblStock, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbStock, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStock)
                    .addComponent(CbStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnDisplay)
                    .addComponent(btnBack))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableSalesEntryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TableSalesEntryPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_TableSalesEntryPropertyChange

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
           
        // Get the selected row from the table
        int selectedRow = TableSalesEntry.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // File path to the text file
            String filePath = "C:\\Users\\user\\Documents\\NetBeansProjects\\Java-ASGM\\test\\Sales_Manager\\SalesList.txt";

            // Read the file and extract data (assuming readFile() method exists)
            List<String[]> rows = readFile(filePath);

            // Remove the selected row from the list (skip the header row)
            if (selectedRow > 0) {
                rows.remove(selectedRow); // Remove the selected row from the list
            }

//            // Write the updated data back to the file (using writeToFile() method)
            writeToFile(filePath, rows);

            // Update the table after deletion
            javax.swing.table.DefaultTableModel tableModel = (javax.swing.table.DefaultTableModel) TableSalesEntry.getModel();
            tableModel.setRowCount(0);  // Clear the table before re-adding the rows

            // Add the data back to the table
            if (!rows.isEmpty()) {
                for (int i = 1; i < rows.size(); i++) {
                    tableModel.addRow(rows.get(i));  // Add data rows to the table
                }
            }
        } else {
            // If no row is selected, show a message
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed
  
        // File path to the text file
        String filePath = "C:\\Users\\user\\Documents\\NetBeansProjects\\Java-ASGM\\test\\Sales_Manager\\SalesList.txt"; 

        // Read the file and extract data
        List<String[]> rows = readFile(filePath);

        // Set the table model
        javax.swing.table.DefaultTableModel tableModel = (javax.swing.table.DefaultTableModel) TableSalesEntry.getModel();
        tableModel.setRowCount(0);  // Clear existing rows before adding new data
        

        // Add data to the table
        if (!rows.isEmpty()) {
            
            // Get the selected stock level from the combo box
            String selectedStock = (String) CbStock.getSelectedItem();
          
            // Ensure that the selected stock level is not null and trim any extra spaces
            if (selectedStock != null) {
                selectedStock = selectedStock.trim();
            }

            // Loop through the rows and filter based on the stock level
            for (String[] row : rows) {
                // Assuming that the stock level is in the 6th column (index 5)
                String stockLevel = row[5].trim(); // Trim any leading/trailing spaces

                // If the selected stock level is "All", add all rows
                if ("All".equalsIgnoreCase(selectedStock)) {
                    tableModel.addRow(row);
                }
                // If the selected stock level is "Low Stock", add "Low Stock" rows
                else if ("Low Stock".equalsIgnoreCase(selectedStock) && "Low Stock".equalsIgnoreCase(stockLevel)) {
                    tableModel.addRow(row);
                }
                // If the selected stock level is "Out of Stock", add "Out of Stock" rows
                else if ("Out of Stock".equalsIgnoreCase(selectedStock) && "Out of Stock".equalsIgnoreCase(stockLevel)) {
                    tableModel.addRow(row);
                }
                // If the selected stock level is "Reserved", add "Reserved" rows
                else if ("Reserved".equalsIgnoreCase(selectedStock) && "Reserved".equalsIgnoreCase(stockLevel)) {
                    tableModel.addRow(row);
                }
                // If the selected stock level is "Pending Restock", add "Pending Restock" rows
                else if ("Pending Restock".equalsIgnoreCase(selectedStock) && "Pending Restock".equalsIgnoreCase(stockLevel)) {
                    tableModel.addRow(row);
                }
            }
  
        }

       
    }//GEN-LAST:event_btnDisplayActionPerformed



    private List<String[]> readFile(String filePath) {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] rowData = line.split(","); 
                rows.add(rowData);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rows;
    }
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Sales_Entry02 salesEntry02Frame = new Sales_Entry02();
        salesEntry02Frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void CbStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbStockActionPerformed
        String selectedStatus = (String)CbStock.getSelectedItem();
        if(selectedStatus!=null){
            System.out.println("User selected:"+ selectedStatus);
        }
    }//GEN-LAST:event_CbStockActionPerformed

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
            java.util.logging.Logger.getLogger(SalesEntryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesEntryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesEntryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesEntryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesEntryReport().setVisible(true);
            }
        });
    }

    private void writeToFile(String filePath, List<String[]> rows) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
        for (String[] row : rows) {
            String line = String.join("\t", row);  // Join the values with tabs
            bw.write(line);
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbStock;
    private javax.swing.JTable TableSalesEntry;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStock;
    // End of variables declaration//GEN-END:variables
}
