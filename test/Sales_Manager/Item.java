package Sales_Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private String itemCode;
    private String itemName;
    private String itemQuantity;
    private String salesQuantity;
    private String salesAmount;
    private String unitPrice;
    private String cbStatus;

    // Constructor
    public Item(String itemCode, String itemName, String itemQuantity, String salesQuantity, String salesAmount, String unitPrice, String cbStatus) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.salesQuantity = salesQuantity;
        this.salesAmount = salesAmount;
        this.unitPrice = unitPrice;
        this.cbStatus = cbStatus;
    }

    // Getters
    public String getItemCode() {
        return itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public String getSalesQuantity() {
        return salesQuantity;
    }

    public String getSalesAmount() {
        return salesAmount;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getCbStatus() {
        return cbStatus;
    }

    // To String (optional for debugging)
    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity='" + itemQuantity + '\'' +
                ", salesQuantity='" + salesQuantity + '\'' +
                ", salesAmount='" + salesAmount + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", cbStatus='" + cbStatus + '\'' +
                '}';
    }

    // Static method to read items from the file
    public static List<Item> readItemsFromFile(String filePath) {
        List<Item> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    // Create Item object and add to the list
                    items.add(new Item(
                            parts[0].trim(), // Item Code
                            parts[1].trim(), // Item Name
                            parts[2].trim(), // Item Quantity
                            parts[3].trim(), // Sales Quantity
                            parts[4].trim(), // Sales Amount
                            parts[5].trim(), // Unit Price
                            parts.length > 6 ? parts[6].trim() : "" // Status (optional)
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
}

