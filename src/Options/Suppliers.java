
package Options;

import Customers.Customer;
import Suppliers.supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class Suppliers {

    
    private static supplier Supplier;
    private static ObservableList<supplier> list;


    public static void getSuppliers(
            TableColumn<supplier, String> Sup_Search_ID, 
            TableColumn<supplier, String> Sup_Search_Name, 
            TableColumn<supplier, String> Sup_Search_Phone1, 
            TableColumn<supplier, String> Sup_Search_Phone2, 
            TableColumn<supplier, String> Sup_Search_Phone3,
            TableColumn<supplier, String> Sup_Search_Phone4, 
            TableColumn<supplier, String> Sup_Search_Address, 
            TableView<supplier> Sup_Search_table) {
      
        ObservableList<supplier> SuppList;
        Sup_Search_ID.setCellValueFactory(new PropertyValueFactory<supplier, String>("ID"));
        Sup_Search_Name.setCellValueFactory(new PropertyValueFactory<supplier, String>("Name"));
        Sup_Search_Phone1.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone1"));
        Sup_Search_Phone2.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone2"));
        Sup_Search_Phone3.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone3"));
        Sup_Search_Phone4.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone4"));
        Sup_Search_Address.setCellValueFactory(new PropertyValueFactory<supplier, String>("Address"));
        SuppList = Database.Utils.getSuppliersTable();
        Sup_Search_table.setItems(SuppList);
    
    
    }

    public static void refreshSearchTable(
            TableColumn<supplier, String> Sup_Search_ID, 
            TableColumn<supplier, String> Sup_Search_Name, 
            TableColumn<supplier, String> Sup_Search_Phone1, 
            TableColumn<supplier, String> Sup_Search_Phone2, 
            TableColumn<supplier, String> Sup_Search_Phone3,
            TableColumn<supplier, String> Sup_Search_Phone4, 
            TableColumn<supplier, String> Sup_Search_Address, 
            TableView<supplier> Sup_Search_table) {
      
        ObservableList<supplier> SuppList = FXCollections.observableArrayList();
        SuppList.clear();
        Sup_Search_ID.setCellValueFactory(new PropertyValueFactory<supplier, String>("ID"));
        Sup_Search_Name.setCellValueFactory(new PropertyValueFactory<supplier, String>("Name"));
        Sup_Search_Phone1.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone1"));
        Sup_Search_Phone2.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone2"));
        Sup_Search_Phone3.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone3"));
        Sup_Search_Phone4.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone4"));
        Sup_Search_Address.setCellValueFactory(new PropertyValueFactory<supplier, String>("Address"));
        SuppList = Database.Utils.getSuppliersTable();
        Sup_Search_table.setItems(SuppList);
    
    
    }
    
    
    public static void refreshAddTable(
            TableColumn<supplier, String> Sup_Search_ID, 
            TableColumn<supplier, String> Sup_Search_Name, 
            TableColumn<supplier, String> Sup_Search_Phone1, 
            TableColumn<supplier, String> Sup_Search_Phone2, 
            TableColumn<supplier, String> Sup_Search_Address, 
            TableView<supplier> Sup_Search_table) {
      
        ObservableList<supplier> SuppList = FXCollections.observableArrayList();
        SuppList.clear();
        Sup_Search_ID.setCellValueFactory(new PropertyValueFactory<supplier, String>("ID"));
        Sup_Search_Name.setCellValueFactory(new PropertyValueFactory<supplier, String>("Name"));
        Sup_Search_Phone1.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone1"));
        Sup_Search_Phone2.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone2"));
        Sup_Search_Address.setCellValueFactory(new PropertyValueFactory<supplier, String>("Address"));
        SuppList = Database.Utils.getSuppliersTable();
        Sup_Search_table.setItems(SuppList);
    
    
    }
    

    public static void searchSuppliersByID(
            TableColumn<supplier, String> Sup_Search_ID, 
            TableColumn<supplier, String> Sup_Search_Name, 
            TableColumn<supplier, String> Sup_Search_Phone1, 
            TableColumn<supplier, String> Sup_Search_Phone2, 
            TableColumn<supplier, String> Sup_Search_Phone3,
            TableColumn<supplier, String> Sup_Search_Phone4, 
            TableColumn<supplier, String> Sup_Search_Address, 
            TableView<supplier> Sup_Search_table, String ID) {
      
        ObservableList<supplier> SuppList = FXCollections.observableArrayList();
        SuppList.clear();
        Sup_Search_ID.setCellValueFactory(new PropertyValueFactory<supplier, String>("ID"));
        Sup_Search_Name.setCellValueFactory(new PropertyValueFactory<supplier, String>("Name"));
        Sup_Search_Phone1.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone1"));
        Sup_Search_Phone2.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone2"));
        Sup_Search_Phone3.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone3"));
        Sup_Search_Phone4.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone4"));
        Sup_Search_Address.setCellValueFactory(new PropertyValueFactory<supplier, String>("Address"));
        SuppList = Database.Utils.searchSupplierByID(ID);
        Sup_Search_table.setItems(SuppList);    
    }
    

    public static void searchSuppliersByName(
            TableColumn<supplier, String> Sup_Search_ID, 
            TableColumn<supplier, String> Sup_Search_Name, 
            TableColumn<supplier, String> Sup_Search_Phone1, 
            TableColumn<supplier, String> Sup_Search_Phone2, 
            TableColumn<supplier, String> Sup_Search_Phone3,
            TableColumn<supplier, String> Sup_Search_Phone4, 
            TableColumn<supplier, String> Sup_Search_Address, 
            TableView<supplier> Sup_Search_table, String Name) {
      
        ObservableList<supplier> SuppList = FXCollections.observableArrayList();
        SuppList.clear();
        Sup_Search_ID.setCellValueFactory(new PropertyValueFactory<supplier, String>("ID"));
        Sup_Search_Name.setCellValueFactory(new PropertyValueFactory<supplier, String>("Name"));
        Sup_Search_Phone1.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone1"));
        Sup_Search_Phone2.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone2"));
        Sup_Search_Phone3.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone3"));
        Sup_Search_Phone4.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone4"));
        Sup_Search_Address.setCellValueFactory(new PropertyValueFactory<supplier, String>("Address"));
        SuppList = Database.Utils.searchSupplierByName(Name);
        Sup_Search_table.setItems(SuppList);    
    }
    
    public static void searchSuppliersByPhone(
            TableColumn<supplier, String> Sup_Search_ID, 
            TableColumn<supplier, String> Sup_Search_Name, 
            TableColumn<supplier, String> Sup_Search_Phone1, 
            TableColumn<supplier, String> Sup_Search_Phone2, 
            TableColumn<supplier, String> Sup_Search_Phone3,
            TableColumn<supplier, String> Sup_Search_Phone4, 
            TableColumn<supplier, String> Sup_Search_Address, 
            TableView<supplier> Sup_Search_table, String Phone) {
      
        ObservableList<supplier> SuppList = FXCollections.observableArrayList();
        SuppList.clear();
        Sup_Search_ID.setCellValueFactory(new PropertyValueFactory<supplier, String>("ID"));
        Sup_Search_Name.setCellValueFactory(new PropertyValueFactory<supplier, String>("Name"));
        Sup_Search_Phone1.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone1"));
        Sup_Search_Phone2.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone2"));
        Sup_Search_Phone3.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone3"));
        Sup_Search_Phone4.setCellValueFactory(new PropertyValueFactory<supplier, String>("Phone4"));
        Sup_Search_Address.setCellValueFactory(new PropertyValueFactory<supplier, String>("Address"));
        SuppList = Database.Utils.searchSupplierByPhone(Phone);
        Sup_Search_table.setItems(SuppList);    
    }
}
