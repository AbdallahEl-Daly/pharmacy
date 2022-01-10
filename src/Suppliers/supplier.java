/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suppliers;

public class supplier {

    String ID, Name, Phone1, Phone2, Phone3, Phone4, Address;

    public supplier(String ID, String Name, String Phone1, String Phone2,
            String Phone3, String Phone4, String Address) {
        this.ID = ID;
        this.Name = Name;
        this.Phone1 = Phone1;
        this.Phone2 = Phone2;
        this.Phone3 = Phone3;
        this.Phone4 = Phone4;
        this.Address = Address;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone1(String Phone1) {
        this.Phone1 = Phone1;
    }

    public void setPhone2(String Phone2) {
        this.Phone2 = Phone2;
    }

    public void setPhone3(String Phone3) {
        this.Phone3 = Phone3;
    }

    public void setPhone4(String Phone4) {
        this.Phone4 = Phone4;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getPhone1() {
        return Phone1;
    }

    public String getPhone2() {
        return Phone2;
    }

    public String getPhone3() {
        return Phone3;
    }

    public String getPhone4() {
        return Phone4;
    }

    public String getAddress() {
        return Address;
    }
    
}
