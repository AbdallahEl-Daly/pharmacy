
package storePills;

public class StoringData {
    String SellerId,SellerName,SupplierID,SupplierName,ProductId,ProductName,ExpiredDate;
    double Quantity,Price;

    public StoringData(String SellerId, String SellerName, String SupplierID, String SupplierName, String ProductId, String ProductName, String ExpiredDate, double Quantity, double Price) {
        this.SellerId = SellerId;
        this.SellerName = SellerName;
        this.SupplierID = SupplierID;
        this.SupplierName = SupplierName;
        this.ProductId = ProductId;
        this.ProductName = ProductName;
        this.ExpiredDate = ExpiredDate;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public String getSellerId() {
        return SellerId;
    }

    public String getSellerName() {
        return SellerName;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public String getProductId() {
        return ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getExpiredDate() {
        return ExpiredDate;
    }

    public double getQuantity() {
        return Quantity;
    }

    public double getPrice() {
        return Price;
    }
    
}
