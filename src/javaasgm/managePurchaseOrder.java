package javaasgm;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class managePurchaseOrder 
{
    private String purchaseOrderId;
    private String requisitionId;
    private String itemId;
    private String itemName;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private String supplierId;
    private String requisitionStatus;
    private String purchaseOrderStatus;
    private String paymentStatus;

    // Constructor
    public managePurchaseOrder(String purchaseOrderId, String requisitionId, String itemId, String itemName,  int quantity, double unitPrice, double totalPrice, String supplierId,  String requisitionStatus, String purchaseOrderStatus, String paymentStatus) {
        this.purchaseOrderId = purchaseOrderId;
        this.requisitionId = requisitionId;
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.supplierId = supplierId;
        this.requisitionStatus = requisitionStatus;
        this.purchaseOrderStatus = purchaseOrderStatus;
        this.paymentStatus = paymentStatus;
    }

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(String requisitionId) {
        this.requisitionId = requisitionId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getRequisitionStatus() {
        return requisitionStatus;
    }

    public void setRequisitionStatus(String requisitionStatus) {
        this.requisitionStatus = requisitionStatus;
    }

    public String getPurchaseOrderStatus() {
        return purchaseOrderStatus;
    }

    public void setPurchaseOrderStatus(String purchaseOrderStatus) {
        this.purchaseOrderStatus = purchaseOrderStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }


    
//    public static String autoGenerateRequisitionId(String requisitionFilePath, String prefix) {
//        Map<String, Integer> requisitionIds = new HashMap<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(requisitionFilePath))) {
//            String line;
//
//            // 读取 requisition.txt 文件，处理每一行
//            while ((line = br.readLine()) != null) {
//                // 去除可能的前后空格
//                line = line.trim();
//
//                // 确保行不为空并且拆分后的字段数大于 7
//                if (!line.isEmpty()) {
//                    String[] fields = line.split(",");
//                    if (fields.length > 7) {  // 确保字段数足够
//                        if ("Approved".equals(fields[7])) {  // 只有 Requisition Status 为 "Approved" 的行才处理
//                            String requisitionId = fields[0];  // 获取 Requisition ID
//                            // 对每个 requisitionId 分别生成递增的 Purchase Order ID
//                            requisitionIds.putIfAbsent(requisitionId, 1); // 如果 requisitionId 不存在则初始化
//                        }
//                    } else {
//                        // 打印格式错误的行以便调试
//                        System.err.println("Skipping line due to insufficient fields: " + line);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//        }
//
//        // 返回生成的 ID（不需要在此处递增）
//        return prefix + String.format("%03d", requisitionIds.size() > 0 ? requisitionIds.get(requisitionIds.keySet().iterator().next()) : 1);
//    }
    
    

    
    
    
    

    // 生成采购订单并写入文件
    public static void generatePurchaseOrders(String requisitionFilePath, String purchaseOrderFilePath) {
        Map<String, Integer> requisitionIds = new HashMap<>(); // 用于存储每个 requisitionId 的计数
        Set<String> existingPurchaseOrders = new HashSet<>(); // 用于检查是否已存在相同的 Purchase Order ID

        try (BufferedReader requisitionReader = new BufferedReader(new FileReader(requisitionFilePath));
             BufferedReader purchaseOrderReader = new BufferedReader(new FileReader(purchaseOrderFilePath)); 
             FileWriter purchaseOrderWriter = new FileWriter(purchaseOrderFilePath, true)) {

            // 读取已有的采购订单，确保不重复插入
            String existingLine;
            while ((existingLine = purchaseOrderReader.readLine()) != null) {
                String[] fields = existingLine.split(",");
                if (fields.length > 0) {
                    existingPurchaseOrders.add(fields[0]); // 将现有的 PO ID 存储到集合中
                }
            }

            // 读取 requisition.txt 文件，生成采购订单
            String line;
            while ((line = requisitionReader.readLine()) != null) {
                String[] fields = line.split(",");
                
                if (fields.length > 7 && "Approved".equals(fields[7])) { // 只有 "Approved" 状态才处理
                    String requisitionId = fields[0];  // 获取 Requisition ID
                    
                    // 获取每个 requisitionId 的当前计数，并递增
                    requisitionIds.putIfAbsent(requisitionId, 1);
                    int currentOrderNumber = requisitionIds.get(requisitionId);
                    
                    // 生成 Purchase Order ID
                    String purchaseOrderId = "PO" + String.format("%03d", currentOrderNumber);
                    
                    // 如果该 PO ID 已存在，则跳过
                    if (!existingPurchaseOrders.contains(purchaseOrderId)) {
                        // 生成 Purchase Order 数据
                        String purchaseOrderData = String.join(",",
                            purchaseOrderId,    // 自动生成的 Purchase Order ID
                            requisitionId,      // Requisition ID
                            fields[1],          // Item ID
                            fields[2],          // Item Name
                            fields[3],          // Quantity
                            fields[4],          // Unit Price
                            fields[5],          // Total Price
                            fields[6],          // Supplier ID
                            "Pending",          // Purchase Order Status
                            "Unpaid"            // Payment Status
                        ) + "\n";
                        
                        // 写入文件
                        purchaseOrderWriter.write(purchaseOrderData);
                        
                        // 更新 requisitionIds 中该 requisitionId 的计数
                        requisitionIds.put(requisitionId, currentOrderNumber + 1);
                    }
                }
            }

            System.out.println("Purchase orders generated successfully.");
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String requisitionFilePath = "requisition.txt";
        String purchaseOrderFilePath = "purchaseorder.txt";

        // 生成采购订单
        generatePurchaseOrders(requisitionFilePath, purchaseOrderFilePath);
    }
    
    
    
    
//   public static String autoGenerateRequisitionId(String requisitionFilePath, String prefix) {
//        Map<String, Integer> requisitionIds = new HashMap<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(requisitionFilePath))) {
//            String line;
//
//            // 读取 requisition.txt 文件，处理每一行
//            while ((line = br.readLine()) != null) {
//                // 去除可能的前后空格
//                line = line.trim();
//
//                // 确保行不为空并且拆分后的字段数大于 7
//                if (!line.isEmpty()) {
//                    String[] fields = line.split(",");
//                    if (fields.length > 7) {  // 确保字段数足够
//                        if ("Approved".equals(fields[7])) {  // 只有 Requisition Status 为 "Approved" 的行才处理
//                            String requisitionId = fields[0];  // 获取 Requisition ID
//                            if (!requisitionIds.containsKey(requisitionId)) {
//                                requisitionIds.put(requisitionId, 1); // 初始化计数
//                            }
//                        }
//                    } else {
//                        // 打印格式错误的行以便调试
//                        System.err.println("Skipping line due to insufficient fields: " + line);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//        }
//
//        // 生成 Purchase Order ID
//        for (String requisitionId : requisitionIds.keySet()) {
//            int currentNumber = requisitionIds.get(requisitionId);
//            requisitionIds.put(requisitionId, currentNumber + 1);
//        }
//
//        // 返回生成的 ID
//        return prefix + String.format("%03d", requisitionIds.size() > 0 ? requisitionIds.get(requisitionIds.keySet().iterator().next()) : 1);
//    }


    
    
    
//    public static String autoGenerateRequisitionId(String requisitionFilePath, String prefix) {
//        Map<String, Integer> requisitionIds = new HashMap<>();
//        
//        try (BufferedReader br = new BufferedReader(new FileReader(requisitionFilePath))) {
//            String line;
//            
//            // 读取 requisition.txt 文件，处理每一行
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(",");
//                
//                if (fields.length > 0 && "Approved".equals(fields[7])) {  // 只有 Requisition Status 为 "Approved" 的行才处理
//                    String requisitionId = fields[0];  // 获取 Requisition ID
//                    if (!requisitionIds.containsKey(requisitionId)) {
//                        requisitionIds.put(requisitionId, 1); // 初始化计数
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//        }
//
//        // 生成 Purchase Order ID
//        for (String requisitionId : requisitionIds.keySet()) {
//            int currentNumber = requisitionIds.get(requisitionId);
//            requisitionIds.put(requisitionId, currentNumber + 1);
//            return prefix + String.format("%03d", currentNumber); // 格式化为三位数 ID 并返回
//        }
//
//        // 如果 requisition.txt 是空的或没有符合条件的行，返回默认 ID
//        return prefix + "001";
//    }

    
//    public static String autoGenerateRequisitionId(String RequisitionfilePath, String prefix) 
//    {
//        String lastId = null; // 保存文件中最后的ID
//        try (BufferedReader br = new BufferedReader(new FileReader(RequisitionfilePath))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(",");
//                if (fields.length > 0 && fields[0].startsWith(prefix)) { 
//                    lastId = fields[0]; // 提取第一列的ID
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Error reading file: " + e.getMessage());
//        }
//
//        // 计算下一个ID
//        if (lastId != null && lastId.startsWith(prefix)) {
//            String numberPart = lastId.replace(prefix, ""); // 移除前缀，只保留数字部分
//            try {
//                int lastNumber = Integer.parseInt(numberPart); // 转换为整数
//                int newNumber = lastNumber + 1; // 递增
//                return prefix + String.format("%02d", newNumber); // 格式化为两位数ID
//            } catch (NumberFormatException e) {
//                System.err.println("Invalid ID format: " + lastId);
//            }
//        }
//
//        // 文件为空或无有效ID，返回默认的ID
//        return prefix + "01";
//    }
    
   
//   public static void generatePurchaseOrders(String requisitionFilePath, String purchaseOrderFilePath) {
//        try (
//            BufferedReader requisitionReader = new BufferedReader(new FileReader(requisitionFilePath));
//            BufferedReader purchaseOrderReader = new BufferedReader(new FileReader(purchaseOrderFilePath)); // 用于读取现有的 Purchase Order ID
//            FileWriter purchaseOrderWriter = new FileWriter(purchaseOrderFilePath, true) // 追加模式
//        ) {
//            String line;
//            int purchaseOrderCount = 0; // 用于生成连续的 Purchase Order ID，从 001 开始
//
//            // 获取当前 Purchase Order 文件中最大 Purchase Order ID
//            String poLine;
//            while ((poLine = purchaseOrderReader.readLine()) != null) {
//                String[] poFields = poLine.split(",");
//                if (poFields.length > 0 && poFields[0].startsWith("PO")) {
//                    int currentPoId = Integer.parseInt(poFields[0].substring(2)); // 提取 PO 后的数字
//                    purchaseOrderCount = Math.max(purchaseOrderCount, currentPoId);
//                }
//            }
//
//            while ((line = requisitionReader.readLine()) != null) {
//                String[] fields = line.split(",");
//
//                if (fields.length > 7 && fields[7].trim().equals("Approved")) { // 检查是否为 "Approved"
//                    purchaseOrderCount++; // 递增计数器
//                    String purchaseOrderId = String.format("PO%03d", purchaseOrderCount); // 生成三位数 ID
//
//                    // 准备 Purchase Order 数据
//                    String purchaseOrderData = String.join(",",
//                        purchaseOrderId,    // 自动生成的 Purchase Order ID
//                        fields[0],          // Requisition ID
//                        fields[1],          // Item ID
//                        fields[2],          // Item Name
//                        fields[3],          // Quantity
//                        fields[4],          // Unit Price
//                        fields[5],          // Total Price
//                        fields[6],          // Supplier ID
//                        "Pending",          // Purchase Order Status
//                        "Unpaid"            // Payment Status
//                    ) + "\n";
//
//                    // 写入 Purchase Order 数据到文件
//                    purchaseOrderWriter.write(purchaseOrderData);
//                }
//            }
//            System.out.println("Purchase orders generated successfully.");
//        } catch (IOException e) {
//            System.err.println("Error processing files: " + e.getMessage());
//        }
//    }

   
//    public static void generatePurchaseOrders(String requisitionFilePath, String purchaseOrderFilePath) {
//        try (
//            BufferedReader requisitionReader = new BufferedReader(new FileReader(requisitionFilePath));
//            FileWriter purchaseOrderWriter = new FileWriter(purchaseOrderFilePath, true) // 追加模式
//        ) {
//            String line;
//            int purchaseOrderCount = 0; // 用于生成连续的 Purchase Order ID，从 001 开始
//
//            while ((line = requisitionReader.readLine()) != null) {
//                String[] fields = line.split(",");
//
//                if (fields.length > 7 && fields[7].trim().equals("Approved")) { // 检查是否为 "Approved"
//                    purchaseOrderCount++; // 递增计数器
//                    String purchaseOrderId = String.format("PO%03d", purchaseOrderCount); // 生成三位数 ID
//
//                    // 准备 Purchase Order 数据
//                    String purchaseOrderData = String.join(",",
//                        purchaseOrderId,    // 自动生成的 Purchase Order ID
//                        fields[0],          // Requisition ID
//                        fields[1],          // Item ID
//                        fields[2],          // Item Name
//                        fields[3],          // Quantity
//                        fields[4],          // Unit Price
//                        fields[5],          // Total Price
//                        fields[6],          // Supplier ID
//                        "Pending",          // Purchase Order Status
//                        "Unpaid"            // Payment Status
//                    ) + "\n";
//
//                    // 写入 Purchase Order 数据到文件
//                    purchaseOrderWriter.write(purchaseOrderData);
//                }
//            }
//            System.out.println("Purchase orders generated successfully.");
//        } catch (IOException e) {
//            System.err.println("Error processing files: " + e.getMessage());
//        }
//    }

}
