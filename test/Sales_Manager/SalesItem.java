package Sales_Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesItem {
    private String itemCode;
    private String itemName;
    private String itemQuantity;
    private String salesQuantity;
    private String salesAmount;
    private String unitPrice;
    private String salesID;
    private String salesDate;
    private String salesManagerid;

    // Constructor
    public SalesItem(String itemCode, String itemName, String itemQuantity, String salesQuantity,
                     String salesAmount, String unitPrice, String salesID, String salesDate,
                     String salesManagerid) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.salesQuantity = salesQuantity;
        this.salesAmount = salesAmount;
        this.unitPrice = unitPrice;
        this.salesID = salesID;
        this.salesDate = salesDate;
        this.salesManagerid = salesManagerid;
    }
 
    // Getters and setters
    public String getItemCode() { 
        return itemCode; 
    }
    public void setItemCode(String itemCode) { 
        this.itemCode = itemCode; 
    }

    public String getItemName() { 
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName; 
    }

    public String getItemQuantity() { 
        return itemQuantity;
    }
    public void setItemQuantity(String itemQuantity) { 
        this.itemQuantity = itemQuantity; 
    }

    public String getSalesQuantity() {
        return salesQuantity; 
    }
    public void setSalesQuantity(String salesQuantity) { 
        this.salesQuantity = salesQuantity;
    }

    public String getSalesAmount() { 
        return salesAmount; 
    }
    public void setSalesAmount(String salesAmount) { 
        this.salesAmount = salesAmount;
    }

    public String getUnitPrice() {
        return unitPrice; 
    }
    public void setUnitPrice(String unitPrice) { 
        this.unitPrice = unitPrice;
    }

    public String getSalesID() { 
        return salesID;
    }
    public void setSalesID(String salesID) { 
        this.salesID = salesID;
    }

    public String getSalesDate() {
        return salesDate; 
    }
    public void setSalesDate(String salesDate) { 
        this.salesDate = salesDate;
    }

    public String getSalesManagerid() { 
        return salesManagerid;
    }
    public void setSalesManagerid(String salesManagerid) { 
        this.salesManagerid = salesManagerid;
    }

    @Override
    public String toString() {
        return "SalesItem{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemQuantity='" + itemQuantity + '\'' +
                ", salesQuantity='" + salesQuantity + '\'' +
                ", salesAmount='" + salesAmount + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", salesID='" + salesID + '\'' +
                ", salesDate='" + salesDate + '\'' +
                ", salesManagerid='" + salesManagerid + '\'' +
                '}';
    }

    // Method to load sales data from the file
    public static List<SalesItem> SalesList(String filename) throws IOException {
        List<SalesItem> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length >= 9) { // Ensure we have all the fields
                    String itemCode = fields[0];
                    String itemName = fields[1];
                    String itemQuantity = fields[2];
                    String salesQuantity = fields[3];
                    String salesAmount = fields[4];
                    String unitPrice = fields[5];
                    String salesID = fields[6];
                    String salesDate = fields[7];
                    String salesManagerid = fields[8];

                    // Add item to the list
                    items.add(new SalesItem(itemCode, itemName, itemQuantity, salesQuantity,
                            salesAmount, unitPrice, salesID, salesDate, salesManagerid));
                } else {
                    System.out.println("Invalid line format: " + line);
                }
            }
        }
        return items;
    }
    
   
        
}

