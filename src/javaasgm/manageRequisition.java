package javaasgm;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class manageRequisition 
{
    private String requisitionId;
    private String itemId;
    private String itemName;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private String supplierId;
    private String status;
    
    public manageRequisition(String requisitionId, String itemiId, String itemName, int quantity, double unitPrice, double totalPrice, String supplierId, String status)
    {
        this.requisitionId = requisitionId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.supplierId = supplierId;
        this.status = status;
    }

    public String getRequisitionId() 
    {
        return requisitionId;
    }

    public void setRequisitionId(String requisitionId) 
    {
        this.requisitionId = requisitionId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) 
    {
        this.itemId = itemId;
    }

    public String getItemName() 
    {
        return itemName;
    }

    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    public double getUnitPrice() 
    {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() 
    {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public String getSupplierId() 
    {
        return supplierId;
    }

    public void setSupplierId(String supplierId) 
    {
        this.supplierId = supplierId;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }
    
   
    public static String autoGenerateId(String filePath, String prefix) {
        String lastId = null; // 保存文件中最后的ID
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 0 && fields[0].startsWith(prefix)) { 
                    lastId = fields[0]; // 提取第一列的ID
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // 计算下一个ID
        if (lastId != null && lastId.startsWith(prefix)) {
            String numberPart = lastId.replace(prefix, ""); // 移除前缀，只保留数字部分
            try {
                int lastNumber = Integer.parseInt(numberPart); // 转换为整数
                int newNumber = lastNumber + 1; // 递增
                return prefix + String.format("%02d", newNumber); // 格式化为两位数ID
            } catch (NumberFormatException e) {
                System.err.println("Invalid ID format: " + lastId);
            }
        }

        // 文件为空或无有效ID，返回默认的ID
        return prefix + "01";
    }
    
    public void updateFile(String requisitionId, String itemId, String itemName, String quantity, String unitPrice, String totalPrice, String supplierID, String status) 
    {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("requisition.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                // If the Requisition ID matches, update the entire line
                if (fields[0].equals(requisitionId)) {
                    // Update the line with the new data
                    line = String.join(",", requisitionId, itemId, itemName, quantity, unitPrice, totalPrice, supplierID, status);
                }
                lines.add(line);  // Add the (updated or unchanged) line to the list
            }

            // Write the updated lines back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("requisition.txt"))) {
                for (String updatedLine : lines) {
                    writer.write(updatedLine);
                    writer.newLine();  // Add a newline after each line
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error updating the file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void saveToFile(String filePath) {
        String currentDirectory = System.getProperty("user.dir");
        String fullFilePath = currentDirectory + "/" + filePath;
    
        // Display the generated file path in the system output (console)
        System.out.println("File path: " + fullFilePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Prepare the requisition details as a comma-separated string
            String requisitionDetails = requisitionId + "," + itemId + "," + itemName + "," + quantity + ","
                    + unitPrice + "," + totalPrice + "," + supplierId + "," + status;

            // Write the details to the file
            writer.write(requisitionDetails);
            writer.newLine(); // Add a newline after each entry

            JOptionPane.showMessageDialog(null, "Requisition details saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error saving requisition details.");
        }
    }

    
}
    
    
    


    
    



