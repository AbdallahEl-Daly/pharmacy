package Customers;

public class Customer {
    String id,Name,phone1,phone2,Address;
//
    public Customer(String id, String Name, String phone1, String phone2, String Address) {
        this.id = id;
        this.Name = Name;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.Address = Address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getAddress() {
        return Address;
    }
    
    
}
