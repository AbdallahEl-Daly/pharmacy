/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.sql.Date;

public class ImportingProcess {
    String ProductID, 
            ProductName, 
            ExpiredDate, 
            SupplierID, 
            SupplierName, 
            sellerID, 
            SellerName;
    String OperationDate;
    double Quantity, Price;

    public ImportingProcess(
            String ProductID, String ProductName,
            String ExpiredDate, String SupplierID,
            String SupplierName, String sellerID,
            String SellerName, String OperationDate, 
            double Quantity, double Price) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ExpiredDate = ExpiredDate;
        this.SupplierID = SupplierID;
        this.SupplierName = SupplierName;
        this.sellerID = sellerID;
        this.SellerName = SellerName;     
        this.OperationDate = OperationDate;   
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setExpiredDate(String ExpiredDate) {
        this.ExpiredDate = ExpiredDate;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public void setSupplierName(String SupplierName) {
        this.SupplierName = SupplierName;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    public void setSellerName(String SellerName) {
        this.SellerName = SellerName;
    }

    
    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getOperationDate() {
        return OperationDate;
    }

    public void setOperationDate(String OperationDate) {
        this.OperationDate = OperationDate;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getExpiredDate() {
        return ExpiredDate;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public String getSellerID() {
        return sellerID;
    }

    public String getSellerName() {
        return SellerName;
    }
    

    public double getQuantity() {
        return Quantity;
    }

    public double getPrice() {
        return Price;
    }
    
}
