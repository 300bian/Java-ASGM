/*We put our data read/write here*/
package javaasgm;

/**
 *
 * @author user
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private String filePath;

    // Constructor to initialize the file path for each specific file
    public FileHandler(String filePath) {
        this.filePath = filePath;
    }
    
    public String getFilePath() {
        return this.filePath;
    }

    // Read all lines from the file
    public List<String> readAll() {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return records;
    }
    
    // Add a new record to the file
    public void addRecord(String record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(record);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
    
    // Update a specific record based on a unique identifier
    public void updateRecord(String identifier, String updatedRecord) {
        List<String> records = readAll();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String record : records) {
                if (record.contains(identifier)) {
                    bw.write(updatedRecord);  // Write updated record
                } else {
                    bw.write(record);  // Write existing record
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error updating file: " + e.getMessage());
        }
    }
    
    public void deleteRecord(String identifier) {
        List<String> records = readAll();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String record : records) {
                if (!record.contains(identifier)) {
                    bw.write(record);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error deleting from file: " + e.getMessage());
        }
    }
    
    public void displayAllRecords() {
        List<String> records = readAll();
        for (String record : records) {
            System.out.println(record);
        }
    }
    
    public String findRecord(String identifier) {
        List<String> records = readAll();
        for (String record : records) {
            if (record.contains(identifier)) {
                return record;
            }
        }
        return null;  // Return null if record not found
    }
}
