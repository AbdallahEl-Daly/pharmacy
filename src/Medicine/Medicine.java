package Medicine;

import java.text.DecimalFormat;

public class Medicine {

    String MedicineID, Name, ExpiredDate;
    double price, quantity, RibbonPrice;
    int Ribbon;

    DecimalFormat oneDicemal = new DecimalFormat("#.#");

    public Medicine(String MedicineID, String Name, String ExpiredDate,
            double price, double quantity, double RibbonPrice, int Ribbon) {
        this.MedicineID = MedicineID;
        this.Name = Name;
        this.ExpiredDate = ExpiredDate;
        this.price = price;
        this.quantity = quantity;
        this.RibbonPrice = RibbonPrice;
        this.Ribbon = Ribbon;
        this.quantity = Double.parseDouble(oneDicemal.format(quantity));
    }

    public Medicine() {

    }

    public int getRibbon() {
        return Ribbon;
    }

    public void setRibbon(int Ribbon) {
        this.Ribbon = Ribbon;
    }

    public void setRibbonPrice(double RibbonPrice) {
        this.RibbonPrice = RibbonPrice;
    }

    public double getRibbonPrice() {
        return RibbonPrice;
    }

    public String getMedicineID() {
        return MedicineID;
    }

    public String getName() {
        return Name;
    }

    public String getExpiredDate() {
        return ExpiredDate;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setMedicineID(String MedicineID) {
        this.MedicineID = MedicineID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setExpiredDate(String ExpiredDate) {
        this.ExpiredDate = ExpiredDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
