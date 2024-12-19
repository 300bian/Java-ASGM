package javaasgm;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.axis.CategoryLabelPositions;


import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;

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
public class SupplierChartFrame extends javax.swing.JFrame {
    private final FileHandler itemFileHandler;
    private final FileHandler supplierFileHandler;
    
     public SupplierChartFrame() {
        // Initialize FileHandlers with file paths
        itemFileHandler = new FileHandler("C:\\Users\\angyi\\Documents\\APU\\SE Y2S1\\OODJ\\POTS Assignment\\ItemEntry.txt");
        supplierFileHandler = new FileHandler("C:\\Users\\angyi\\Documents\\APU\\SE Y2S1\\OODJ\\POTS Assignment\\SupplierEntry.txt");

        // Set up the frame
        setTitle("Item Count by Suppliers");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and add the chart panel
        ChartPanel chartPanel = createChartPanel();
        setContentPane(chartPanel);
    }

     private ChartPanel createChartPanel() {
        // Load suppliers and items
        Map<String, Supplier> supplierMap = Supplier.getSupplierMap(supplierFileHandler.getFilePath());
        List<Item> items = Item.loadItemsFromFile(itemFileHandler, supplierMap);

        // Create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        items.forEach(item -> {
            dataset.addValue(item.getStockLevel(), item.getItemName(), item.getSupplier().getSupplierName());
        });

        // Create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "Supplier and Item Details", // Title
                "Suppliers", // X-axis label
                "Count", // Y-axis label
                dataset // Dataset
        );

        // Customize the plot
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45 );// Rotate labels for clarity
        domainAxis.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 10));

        // Customize range axis
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(10, 400); // Set range for Y-axis (10 to 300)

        // Customize bar renderer
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.0); // Adjust spacing between bars
        renderer.setMaximumBarWidth(1.0);
        
        domainAxis.setCategoryMargin(-0.8); // Reduce margin between categories
        domainAxis.setMaximumCategoryLabelWidthRatio(0); // Adjust label size to fit better

        // Return chart panel
        return new ChartPanel(chart);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChartContainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout ChartContainerLayout = new javax.swing.GroupLayout(ChartContainer);
        ChartContainer.setLayout(ChartContainerLayout);
        ChartContainerLayout.setHorizontalGroup(
            ChartContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );
        ChartContainerLayout.setVerticalGroup(
            ChartContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(ChartContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(ChartContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
            java.util.logging.Logger.getLogger(SupplierChartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierChartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierChartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierChartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierChartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChartContainer;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

