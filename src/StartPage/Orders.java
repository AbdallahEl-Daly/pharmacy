package StartPage;

public class Orders {
    String ProductID, ProductName;
    double Quantity, Price;

    public Orders(String ProductID, String ProductName, double Quantity, double Price) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setQuantity(double Quantity) {
        this.Quantity = Quantity;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public String getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public double getQuantity() {
        return Quantity;
    }

    public double getPrice() {
        return Price;
    }
    
}
