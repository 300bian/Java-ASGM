package Sales_Manager;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class CreateData {
    
    public static void main(String[] args) {
        String filePath = "C:\\Users\\user\\Documents\\NetBeansProjects\\Java-ASGM\\test\\Sales_Manager\\SalesList.txt"; // Path to save the text file
        int numberOfRows = 100; // Number of rows to generate

        // Column names
        String[] columnNames = {"item code", "item name", "unit price", "sales quantity", "sales amount", "stock level"};
        
        // Stock levels
        String[] stockLevels = {"Low Stock", "Out of Stock", "Reserved", "Pending Restock"};
        
        // Random data generator
        Random random = new Random();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write the column names to the file
            writer.write(String.join(";", columnNames));
            writer.newLine();

            // Generate 100 rows of random data
            for (int i = 1; i <= numberOfRows; i++) {
                String itemCode = String.format("ITEM%03d", i); // ITEM001, ITEM002, ...
                String itemName = "Item-" + (random.nextInt(500) + 1); // Item-1 to Item-500
                double unitPrice = Math.round((5 + (95 * random.nextDouble())) * 100.0) / 100.0; // Price between $5 and $100
                int salesQuantity = random.nextInt(50) + 1; // Quantity between 1 and 50
                double salesAmount = Math.round(unitPrice * salesQuantity * 100.0) / 100.0; // Amount = unit_price * sales_quantity
                String stockLevel = stockLevels[random.nextInt(stockLevels.length)]; // Randomly select stock level

                // Combine the values into a semicolon-separated row
                String row = String.join(";",
                        itemCode,
                        itemName,
                        String.format("%.2f", unitPrice),
                        String.valueOf(salesQuantity),
                        String.format("%.2f", salesAmount),
                        stockLevel);

                // Write the row to the file
                writer.write(row);
                writer.newLine();
            }

            System.out.println("100 rows of sales data have been written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
