/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaasgm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author angyi
 */
public class Supplier {
    private String supplierId;
    private String supplierName;
    private String email;
    private String phoneNum;
    private String address;
         
    public Supplier(String supplierId, String supplierName, String email, String phoneNum, String address) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
    }
    
     public String getSupplierId() {
        return supplierId;
    }
    
    public String getSupplierName() {
        return supplierName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
    
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    //override, convert to string for file writing
    public String toString() {
        return supplierId + "," + supplierName + "," + email + "," + phoneNum + "," + address;
    }
    // Static method to load suppliers from a file
    public static Map<String, Supplier> getSupplierMap(String supplierFilePath) {
        Map<String, Supplier> supplierMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(supplierFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                
                // Ensure there are enough fields to create a Supplier object
                if (fields.length >= 5) {
                    String supplierId = fields[0];
                    String supplierName = fields[1];
                    String email = fields[2];
                    String phoneNum = fields[3];
                    String address = fields[4];
                    
                // Create Supplier object and add to the map
                Supplier supplier = new Supplier(supplierId, supplierName, email, phoneNum, address);
                supplierMap.put(supplierId, supplier);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading supplier file: " + e.getMessage());
        }
        return supplierMap;
    }
    
    public static List<Supplier> loadSuppliersFromFile(FileHandler fileHandler) {
    List<Supplier> suppliers = new ArrayList<>();
    List<String> records = fileHandler.readAll();

    for (String record : records) {
        String[] fields = record.split(",");
        if (fields.length == 5) {
            String supplierId = fields[0];
            String supplierName = fields[1];
            String email = fields[2];
            String phoneNum = fields[3];
            String address = fields[4];

            Supplier supplier = new Supplier(supplierId, supplierName, email, phoneNum, address);
            suppliers.add(supplier);
        }
    }
    return suppliers;
    }

    
    
    
}
