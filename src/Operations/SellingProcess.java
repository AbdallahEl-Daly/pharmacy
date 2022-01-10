/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

public class SellingProcess {

    String SellerID ,
            SellerName	,
            CustomerID ,
            ProductID ,
            ProductName	,
            Date;
    double Quantity, Price;

    public SellingProcess(String SellerID, String SellerName, String CustomerID, String ProductID, String ProductName, String Date, double Quantity, double Price) {
        this.SellerID = SellerID;
        this.SellerName = SellerName;
        this.CustomerID = CustomerID;
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Date = Date;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public void setSellerID(String SellerID) {
        this.SellerID = SellerID;
    }

    public void setSellerName(String SellerName) {
        this.SellerName = SellerName;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getSellerID() {
        return SellerID;
    }

    public String getSellerName() {
        return SellerName;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getDate() {
        return Date;
    }

    public double getQuantity() {
        return Quantity;
    }

    public double getPrice() {
        return Price;
    }

    
}
