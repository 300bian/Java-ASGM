/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaasgm;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author angyi
 */
public class Item {
    private String itemId;
    private String itemName;
    private Supplier supplier; 
    private double price;
    private int stockLevel;
      
    public Item(String itemId, String itemName, Supplier supplier, double price, int stockLevel) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.supplier = supplier;  
        this.price = price;
        this.stockLevel = stockLevel;
    }
    
     public String getItemId() {
        return itemId;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public Supplier getSupplier() {  
        return supplier;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getStockLevel() {
        return stockLevel;
    }
    
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public void setSupplier(Supplier supplier) {  // Updated to accept Supplier object
        this.supplier = supplier;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
    
    public String toString() {
        return itemId + "," + itemName + "," + supplier.getSupplierId() + "," + price + "," + stockLevel;
    }
    
    public static List<Item> loadItemsFromFile(FileHandler fileHandler, Map<String, Supplier> supplierMap) {
        List<Item> items = new ArrayList<>();
        List<String> records = fileHandler.readAll();

        for (String record : records) {
            String[] fields = record.split(",");
            if (fields.length == 5) {
                String itemId = fields[0];
                String itemName = fields[1];
                String supplierId = fields[2];
                double price = Double.parseDouble(fields[3]);
                int stockLevel = Integer.parseInt(fields[4]);

                Supplier supplier = supplierMap.get(supplierId);  // Fetch Supplier object from map
                if (supplier != null) {
                    Item item = new Item(itemId, itemName, supplier, price, stockLevel);
                    items.add(item);
                }
            }
        }
        return items;
    }

}

