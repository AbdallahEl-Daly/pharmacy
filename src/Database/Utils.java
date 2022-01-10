package Database;

import Customers.Customer;
import HomePage.HomePageController;
import Medicine.Medicine;
import Operations.ImportingProcess;
import Operations.SellingProcess;
import Suppliers.supplier;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

public class Utils {

    public static String url = "";
    public static String dbName = "pharmacy_inventory";
    public static String dbUser = "root";
    public static String dbPass = "";
    public static Connection Con;

    /**
     * This Function Connecting the Program with MySQL Database
     */
    public static void setConnection() {
        try {
            url = "jdbc:mysql://localhost:3306/"
                    + dbName + "?useUnicode=true&characterEncoding="
                    + "UTF-8&useJDBCCompliantTimezoneShift=true&useLegacy"
                    + "DatetimeCode=false&serverTimezone=UTC";
            Con = DriverManager.getConnection(url, dbUser, dbPass);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Open Xampp To reach Database!!");

        }
    }

    /**
     * This function Takes these parameters and add them to the user table in
     * the database
     *
     * @param SellerId
     * @param Pass
     * @param Name
     * @param Phone1
     * @param Phone2
     * @param Department
     */
    public static void insertUser(String SellerId, String Pass, String Name,
            String Phone1, String Phone2, String Department) {
        String sql = "INSERT INTO `users`(`SellerID`, `Password`, `Name`,"
                + " `Phone1`, `Phone2`, `department`) VALUES (?,?,?,?,?,?)";
        try {
            setConnection();
            PreparedStatement st = Con.prepareStatement(sql);
            st.setString(1, SellerId);
            st.setString(2, Pass);
            st.setString(3, Name);
            st.setString(4, Phone1);
            st.setString(5, Phone2);
            st.setString(6, Department);
            st.executeUpdate();
            Con.close();
        } catch (Exception ex) {
            System.out.println("ERROR!!!" + ex.getMessage());
        }
    }

    public static void insertCustomer(String CustomerId, String Name,
            String Phone1, String Phone2, String Address) {
        String sql = "INSERT INTO `customer`(`CustomerID`, `Name`, `Phone1`,"
                + " `Phone2`, `Address`) VALUES (?,?,?,?,?)";
        try {
            setConnection();
            PreparedStatement st = Con.prepareStatement(sql);
            st.setString(1, CustomerId);
            st.setString(2, Name);
            st.setString(3, Phone1);
            st.setString(4, Phone2);
            st.setString(5, Address);
            st.executeUpdate();
            Con.close();
        } catch (Exception ex) {
            System.out.println("ERROR!!!" + ex.getMessage());
        }
    }

    public static boolean CustomerExist(String CustomerId) {
        String sql = "SELECT * From `customer` where CustomerID= ?";
        try {
            setConnection();
            PreparedStatement st = Con.prepareStatement(sql);
            st.setString(1, CustomerId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
            Con.close();
        } catch (Exception ex) {
            System.out.println("ERROR!!!" + ex.getMessage());
        }
        return false;
    }

    /**
     * This Function takes username and password from user and verify them to
     * the database
     *
     * @param Username
     * @param Password
     * @return
     */
    public static boolean loginVerfication(String Username, String Password) {
        try {
            setConnection();
            PreparedStatement ps, st;
            ps = Con.prepareStatement("select `SellerID` from users where BINARY"
                    + " SellerID =? and BINARY Password=? and department='Admin'");
            ps.setString(1, Username);
            ps.setString(2, Password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                st = Con.prepareStatement("UPDATE `users` SET statues = 'LogedIn' WHERE `SellerID`=?");
                st.setString(1, Username);
                st.executeUpdate();
                return true;
            }
            Con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void loginedOut() {
        try {
            setConnection();
            PreparedStatement st;
            st = Con.prepareStatement("UPDATE `users` SET `statues`='LogedOut' WHERE `statues`='LogedIn'");
            st.executeUpdate();
            Con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static String getSignedInSellerData(String Choice) {
        String Value = null;
        if (Choice.equals("ID")) {
            try {
                setConnection();
                PreparedStatement st;
                st = Con.prepareStatement("Select * From `users` Where `statues`= 'LogedIn'");
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    Value = rs.getString("SellerID");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                setConnection();
                PreparedStatement st1;
                st1 = Con.prepareStatement("Select * From `users` Where `statues`= 'LogedIn'");
                ResultSet rs1 = st1.executeQuery();
                if (rs1.next()) {
                    Value = rs1.getString("Name");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return Value;
    }

    /**
     * This Function takes medicine data and add it to the database
     *
     * @param ProductId
     * @param ProductName
     * @param Character
     * @param Quantity
     * @param Price
     * @param NoOfRibbon
     * @param RibbonPrice
     * @param ExpiredDate
     */
    public static void addMedicine(String ProductId, String ProductName, char Character,
            double Quantity, double Price, int NoOfRibbon, double RibbonPrice,
            String ExpiredDate) {
        String Char = String.valueOf(Character);
        String sql = "INSERT INTO `product`(`ProductId`, `ProductName`, `Char`,"
                + " `Quantity`, `TotalPrice`,`Ribbon`,`RibbonPrice`, `ExpireDate`)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try {
            setConnection();
            PreparedStatement st = Con.prepareStatement(sql);
            st.setString(1, ProductId);
            st.setString(2, ProductName);
            st.setString(3, Char);
            st.setDouble(4, Quantity);
            st.setDouble(5, Price);
            st.setInt(6, NoOfRibbon);
            st.setDouble(7, RibbonPrice);
            st.setString(8, ExpiredDate);
            st.executeUpdate();
            Con.close();
        } catch (Exception ex) {
            System.out.println("ERROR!!!" + ex.getMessage());
        }
    }

    /**
     * This function takes name of medicine from user and returns all its data
     *
     * @param Name
     * @return all its data
     */
    public static String[] findMedicinebyName(String Name) {
        String data[] = new String[7];
        try {
            setConnection();
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `product` WHERE `ProductName`=?;");
            ps.setString(1, Name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data[0] = rs.getString("ProductID");
                data[1] = rs.getString("ProductName");
                data[2] = String.valueOf(rs.getDouble("Quantity"));
                data[3] = String.valueOf(rs.getDouble("TotalPrice"));
                data[4] = rs.getString("Ribbon");
                data[5] = String.valueOf(rs.getDouble("RibbonPrice"));
                data[6] = rs.getString("ExpireDate");
            } else {
                data[0] = "notExist";
            }
            Con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public static String[] findMedicinebyId(String ID) {
        String data[] = new String[7];
        try {
            setConnection();
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `product` WHERE `ProductID`=?;");
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                data[0] = rs.getString("ProductID");
                data[1] = rs.getString("ProductName");
                data[2] = String.valueOf(rs.getDouble("Quantity"));
                data[3] = String.valueOf(rs.getDouble("TotalPrice"));
                data[4] = rs.getString("Ribbon");
                data[5] = String.valueOf(rs.getDouble("RibbonPrice"));
                data[6] = rs.getString("ExpireDate");
            } else {
                data[0] = "notExist";
            }
            Con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    /**
     * This Function allows user to edit medicine data
     *
     * @param ProductID
     * @param Price
     * @param NoOfRibbon
     * @param RibbonPrice
     * @param ExpiredDate
     */
    public static void editMedicine(String ProductID, double Price, int NoOfRibbon, double RibbonPrice,
            String ExpiredDate) {
        String sql = "UPDATE `product` SET `TotalPrice`=?,`Ribbon`=?,`RibbonPrice`=?,`ExpireDate`=? WHERE `ProductID`=?;";
        try {
            setConnection();
            PreparedStatement st = Con.prepareStatement(sql);
            st.setDouble(1, Price);
            st.setInt(2, NoOfRibbon);
            st.setDouble(3, RibbonPrice);
            st.setString(4, ExpiredDate);
            st.setString(5, ProductID);
            st.executeUpdate();
            Con.close();
        } catch (Exception ex) {
            System.out.println("ERROR!!!" + ex.getMessage());
        }
    }

    /**
     * This Function returns all medicine data in Medicine Class
     *
     * @return
     */
    public static ObservableList<Medicine> getMedicineTable() {
        setConnection();
        ObservableList<Medicine> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `product`");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("ExpireDate"),
                        rs.getDouble("TotalPrice"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("RibbonPrice"),
                        rs.getInt("Ribbon")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<Medicine> getShortcomingsTable() {
        setConnection();
        ObservableList<Medicine> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `product` WHERE `Quantity` < 11");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("ExpireDate"),
                        rs.getDouble("TotalPrice"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("RibbonPrice"),
                        rs.getInt("Ribbon")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<Customer> getCustomersTable() {
        setConnection();
        ObservableList<Customer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `customer`");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(
                        String.valueOf(rs.getInt("CustomerID")),
                        rs.getString("Name"),
                        rs.getString("Phone1"),
                        rs.getString("Phone2"),
                        rs.getString("Address")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<supplier> getSuppliersTable() {
        setConnection();
        ObservableList<supplier> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `supplier`");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new supplier(
                        rs.getString("SupplierID"),
                        rs.getString("CompanyName"),
                        rs.getString("Phone1"),
                        rs.getString("Phone2"),
                        rs.getString("Phone3"),
                        rs.getString("Phone4"),
                        rs.getString("Address")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static void deleteCustomer(String CustomerID) {
        try {
            setConnection();
            PreparedStatement ps;
            ps = Con.prepareStatement("DELETE FROM `customer` WHERE `CustomerID`=?");
            ps.setString(1, CustomerID);
            ps.executeUpdate();
            Con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void UpdateCustomer(String CustomerID, String Name,
            String Phone1, String Phone2, String Address) {
        try {
            setConnection();
            PreparedStatement ps;
            ps = Con.prepareStatement("UPDATE `customer` set "
                    + "`Name`=?,`Phone1`=?,`Phone2`=?,`Address`=?"
                    + " WHERE `CustomerID`=?");
            ps.setString(1, Name);
            ps.setString(2, Phone1);
            ps.setString(3, Phone2);
            ps.setString(4, Address);
            ps.setString(5, CustomerID);
            ps.executeUpdate();
            Con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ObservableList<Medicine> searchMedicineByID(int ID) {
        setConnection();
        ObservableList<Medicine> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `product` where CONCAT(ProductID) LIKE ?");
            ps.setString(1, "%" + ID + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("ExpireDate"),
                        rs.getDouble("TotalPrice"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("RibbonPrice"),
                        rs.getInt("Ribbon")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<Medicine> searchMedicineByName(String Name) {
        setConnection();
        ObservableList<Medicine> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `product` where CONCAT(ProductName) LIKE ?");
            ps.setString(1, "%" + Name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("ExpireDate"),
                        rs.getDouble("TotalPrice"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("RibbonPrice"),
                        rs.getInt("Ribbon")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<Medicine> searchMedicineByExpiredDate(String Month) {
        setConnection();
        ObservableList<Medicine> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM product WHERE CONCAT(MONTH(`ExpireDate`)) = ?");
            ps.setString(1, Month);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("ExpireDate"),
                        rs.getDouble("TotalPrice"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("RibbonPrice"),
                        rs.getInt("Ribbon")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<Medicine> searchMedicineByValue(String Val) {
        setConnection();
        ObservableList<Medicine> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM product WHERE CONCAT(`ProductID`,`ProductName`) LIKE  ?");
            ps.setString(1, "%" + Val + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Medicine(
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("ExpireDate"),
                        rs.getDouble("TotalPrice"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("RibbonPrice"),
                        rs.getInt("Ribbon")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static boolean medicineExist_Name_ID(String Val) {
        setConnection();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `product` where CONCAT(ProductName,ProductID) LIKE ?");
            ps.setString(1, "%" + Val + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {

        }

        return false;
    }

    public static ObservableList<Customer> getCustomerByName(String Name) {
        setConnection();
        ObservableList<Customer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `customer` where CONCAT(Name) LIKE ?");
            ps.setString(1, "%" + Name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(
                        rs.getString("CustomerID"),
                        rs.getString("Name"),
                        rs.getString("phone1"),
                        rs.getString("phone2"),
                        rs.getString("Address")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<Customer> getCustomerByID(String ID) {
        setConnection();
        ObservableList<Customer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `customer` where CONCAT(CustomerID) LIKE ?");
            ps.setString(1, "%" + ID + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(
                        rs.getString("CustomerID"),
                        rs.getString("Name"),
                        rs.getString("phone1"),
                        rs.getString("phone2"),
                        rs.getString("Address")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<Customer> getCustomerByPhone(String Phone) {
        setConnection();
        ObservableList<Customer> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `customer` where CONCAT(`Phone1`, `Phone2`) LIKE ?");
            ps.setString(1, "%" + Phone + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(
                        rs.getString("CustomerID"),
                        rs.getString("Name"),
                        rs.getString("phone1"),
                        rs.getString("phone2"),
                        rs.getString("Address")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static void insertSupplier(String Id, String Name, String Phone1,
            String Phone2, String Phone3, String Phone4, String Address) {
        String sql = "INSERT INTO `supplier`(`SupplierID`, `CompanyName`,"
                + " `Phone1`, `Phone2`, `Phone3`, `Phone4`, `Address`) "
                + " VALUES (?,?,?,?,?,?,?)";
        try {
            setConnection();
            PreparedStatement st = Con.prepareStatement(sql);
            st.setString(1, Id);
            st.setString(2, Name);
            st.setString(3, Phone1);
            st.setString(4, Phone2);
            st.setString(5, Phone3);
            st.setString(6, Phone4);
            st.setString(7, Address);
            st.executeUpdate();
            Con.close();
        } catch (Exception ex) {
            System.out.println("ERROR!!!" + ex.getMessage());
        }
    }

    public static boolean SupplierExist_ID(String Val) {
        setConnection();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `supplier` where SupplierID = ?");
            ps.setString(1, Val);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception ex) {

        }

        return false;
    }

    public static ObservableList<supplier> searchSupplierByName(String Name) {
        setConnection();
        ObservableList<supplier> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `supplier` where CONCAT(CompanyName) LIKE ?");
            ps.setString(1, "%" + Name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new supplier(
                        rs.getString("SupplierID"),
                        rs.getString("CompanyName"),
                        rs.getString("Phone1"),
                        rs.getString("Phone2"),
                        rs.getString("Phone3"),
                        rs.getString("Phone4"),
                        rs.getString("Address")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<supplier> searchSupplierByID(String ID) {
        setConnection();
        ObservableList<supplier> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `supplier` where CONCAT(SupplierID) LIKE ?");
            ps.setString(1, "%" + ID + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new supplier(
                        rs.getString("SupplierID"),
                        rs.getString("CompanyName"),
                        rs.getString("Phone1"),
                        rs.getString("Phone2"),
                        rs.getString("Phone3"),
                        rs.getString("Phone4"),
                        rs.getString("Address")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<supplier> searchSupplierByPhone(String Phone) {
        setConnection();
        ObservableList<supplier> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `supplier` where CONCAT(Phone1,Phone2,Phone3,Phone4) LIKE ?");
            ps.setString(1, "%" + Phone + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new supplier(
                        rs.getString("SupplierID"),
                        rs.getString("CompanyName"),
                        rs.getString("Phone1"),
                        rs.getString("Phone2"),
                        rs.getString("Phone3"),
                        rs.getString("Phone4"),
                        rs.getString("Address")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static void UpdateSupplier(String ID, String Name, String Phone1,
            String Phone2, String Phone3, String Phone4, String Address) {
        try {
            setConnection();
            PreparedStatement ps;
            ps = Con.prepareStatement("UPDATE `supplier` set "
                    + "`CompanyName`=?,`Phone1` = ?,`Phone2` = ?"
                    + " ,`Phone3` = ?,`Phone4` = ?,`Address` = ?"
                    + " WHERE `SupplierID`=?");
            ps.setString(1, Name);
            ps.setString(2, Phone1);
            ps.setString(3, Phone2);
            ps.setString(4, Phone3);
            ps.setString(5, Phone4);
            ps.setString(6, Address);
            ps.setString(7, ID);
            ps.executeUpdate();
            Con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static ObservableList<String> getSupplierComboBox() {
        setConnection();
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;//SELECT * FROM `customer` WHERE CONCAT (`CustomerID`, `Name`, `Phone1`, `Phone2`, `Address`)LIKE ?
            ps = Con.prepareStatement("SELECT * FROM `supplier`");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("CompanyName"));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static void deleteSupplier(String ID) {
        setConnection();
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("DELETE FROM `supplier` WHERE `SupplierID`=?");
            ps.setString(1, ID);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("ERROR!!!" + ex.getMessage());
        }

    }
//UPDATE `product` SET `Quantity`=`Quantity`+? WHERE `ProductID`=?;

    public static void ImportingProcess(String SupplierName, String ProductId,
            String ProductName, String ExpiredDate, double Quantity, double Price) {
        String SellerId = null, SellerName = null, SupplierId = null;
        setConnection();
        try {
            PreparedStatement Seller, Supplier, Insert, AddQuantity;
            Seller = Con.prepareStatement("SELECT * FROM `users` WHERE `statues`='LogedIn'");
            ResultSet rs = Seller.executeQuery();
            while (rs.next()) {
                SellerId = rs.getString("SellerID");
                SellerName = rs.getString("Name");
            }
            //------------------------------------------------------
            Supplier = Con.prepareStatement("SELECT * FROM `supplier` WHERE `CompanyName`=?");
            Supplier.setString(1, SupplierName);
            ResultSet rsSup = Supplier.executeQuery();
            while (rsSup.next()) {
                SupplierId = rsSup.getString("SupplierID");
            }
            //------------------------------------------------------
            Insert = Con.prepareStatement("INSERT INTO `importingprocess`"
                    + "(`SellerID`, `SellerName`, `Quantity`, `Price`,"
                    + " `SupplierID`, `SupplierName`, `ProductID`, `ProductName`,"
                    + " `ExpireDate`) VALUES (?,?,?,?,?,?,?,?,?)");
            Insert.setString(1, SellerId);
            Insert.setString(2, SellerName);
            Insert.setDouble(3, Quantity);
            Insert.setDouble(4, Price);
            Insert.setString(5, SupplierId);
            Insert.setString(6, SupplierName);
            Insert.setString(7, ProductId);
            Insert.setString(8, ProductName);
            Insert.setString(9, ExpiredDate);
            Insert.executeUpdate();
            //------------------------------------------------------
            AddQuantity = Con.prepareStatement("UPDATE `product` SET `Quantity`=`Quantity`+? WHERE `ProductID`=?;");
            AddQuantity.setDouble(1, Quantity);
            AddQuantity.setString(2, ProductId);
            AddQuantity.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static ObservableList<ImportingProcess> getImportingsTable() {
        setConnection();
        ObservableList<ImportingProcess> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `importingprocess`");
            ResultSet rs = ps.executeQuery();
            //String ProductID, String ProductName, String ExpiredDate,
            //String SupplierID, String SupplierName, String sellerID,
            //String SellerName, String DateOfCreation,String Date, double Quantity, double Price
            while (rs.next()) {//getDouble
                list.add(new ImportingProcess(
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("ExpireDate"),
                        rs.getString("SupplierID"),
                        rs.getString("SupplierName"),
                        rs.getString("SellerID"),
                        rs.getString("SellerName"),
                        rs.getString("Date"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("Price")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<SellingProcess> getSellingTable() {
        setConnection();
        ObservableList<SellingProcess> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `sellingprocess`");
            ResultSet rs = ps.executeQuery();
            //String ProductID, String ProductName, String ExpiredDate,
            //String SupplierID, String SupplierName, String sellerID,
            //String SellerName, String DateOfCreation,String Date, double Quantity, double Price
            while (rs.next()) {//getDouble
                list.add(new SellingProcess(
                        rs.getString("SellerID"),
                        rs.getString("SellerName"),
                        rs.getString("CustomerID"),
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Date"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("Price")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<ImportingProcess> sortImportingsTable(String Start, String End) {
        setConnection();
        ObservableList<ImportingProcess> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `importingprocess` WHERE "
                    + "`Date` >= ? AND `Date` <= ?");
            ps.setString(1, Start);
            ps.setString(2, End);
            ResultSet rs = ps.executeQuery();
            //String ProductID, String ProductName, String ExpiredDate,
            //String SupplierID, String SupplierName, String sellerID,
            //String SellerName, String DateOfCreation,String Date, double Quantity, double Price
            while (rs.next()) {//getDouble
                list.add(new ImportingProcess(
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("ExpireDate"),
                        rs.getString("SupplierID"),
                        rs.getString("SupplierName"),
                        rs.getString("SellerID"),
                        rs.getString("SellerName"),
                        rs.getString("Date"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("Price")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static ObservableList<SellingProcess> sortsellingTable(String Start, String End) {
        setConnection();
        ObservableList<SellingProcess> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `sellingprocess` WHERE "
                    + " `Date` >= ? AND `Date` <= ?");
            ps.setString(1, Start);
            ps.setString(2, End);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {//getDouble
                list.add(new SellingProcess(
                        rs.getString("SellerID"),
                        rs.getString("SellerName"),
                        rs.getString("CustomerID"),
                        rs.getString("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Date"),
                        rs.getDouble("Quantity"),
                        rs.getDouble("Price")
                ));
            }
        } catch (Exception ex) {

        }

        return list;
    }

    public static String getCustomerNamebyID(String id) {
        setConnection();
        String Name = "";
        try {
            PreparedStatement ps;
            ps = Con.prepareStatement("SELECT * FROM `customer` WHERE `CustomerID`=?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Name = rs.getString("Name");
            }
        } catch (Exception ex) {

        }

        return Name;
    }

    public static void InsertsellingProcess(String SellerID, String SellerName, String CustomerID,
            String ProductID, String ProductName, double Quantity, double Price,
            String statues) {
        String sql = "INSERT INTO `sellingprocess`(`SellerID`, `SellerName`,"
                + " `CustomerID`, `ProductID`, `ProductName`, `Quantity`,"
                + " `Price`, `statues`) VALUES (?,?,?,?,?,?,?,?)";
        String UpdateQuery = "UPDATE `product` SET `Quantity`=`Quantity`-? WHERE `ProductID`=?;";
        try {
            setConnection();
            PreparedStatement st = Con.prepareStatement(sql);
            st.setString(1, SellerID);
            st.setString(2, SellerName);
            st.setString(3, CustomerID);
            st.setString(4, ProductID);
            st.setString(5, ProductName);
            st.setDouble(6, Quantity);
            st.setDouble(7, Price);
            st.setString(8, statues);
            st.executeUpdate();
            PreparedStatement ps = Con.prepareStatement(UpdateQuery);
            ps.setDouble(1, Quantity);
            ps.setString(2, ProductID);
            ps.executeUpdate();
            Con.close();
        } catch (Exception ex) {
            System.out.println("ERROR!!!" + ex.getMessage());
        }
    }

    public static int[] ordersNum() {
        int Delivery = 0, InPharmacy = 0;
        int[] OrderArray = new int[2];
        String sql_InPharmacy = "SELECT * FROM `sellingprocess` WHERE `Date` >= CURDATE() AND `statues` = 'In Pharmacy' ";
        String sql_Delivery = "SELECT * FROM `sellingprocess` WHERE `Date` >= CURDATE() AND `statues` = 'Delivery' ";
        try {
            setConnection();
            PreparedStatement st = Con.prepareStatement(sql_InPharmacy);
            PreparedStatement ps = Con.prepareStatement(sql_Delivery);
            ResultSet rs = st.executeQuery();
            ResultSet rs1 = ps.executeQuery();
            while (rs.next()) {
                InPharmacy++;
            }
            while (rs1.next()) {
                Delivery++;
            }
            OrderArray[0] = Delivery;
            OrderArray[1] = InPharmacy;
            Con.close();
        } catch (Exception ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return OrderArray;
    }
}
