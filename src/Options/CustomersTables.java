/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import Customers.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author hp
 */
public class CustomersTables {

    private static Customer customer;
    private static ObservableList<Customer> list;

    public static void getCustomers(
            TableColumn<Customer, String> Cust_Search_ID,
            TableColumn<Customer, String> Cust_Search_Name,
            TableColumn<Customer, String> Cust_Search_Phone1,
            TableColumn<Customer, String> Cust_Search_Phone2,
            TableColumn<Customer, String> Cust_Search_Address,
            TableView<Customer> Cust_Search_table) {
        
    
        ObservableList<Customer> CustomerList;
        Cust_Search_ID.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
        Cust_Search_Name.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name"));
        Cust_Search_Phone1.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone1"));
        Cust_Search_Phone2.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone2"));
        Cust_Search_Address.setCellValueFactory(new PropertyValueFactory<Customer, String>("Address"));
        CustomerList = Database.Utils.getCustomersTable();
        Cust_Search_table.setItems(CustomerList);
    
    }
    
    public static void getCustomerByID(
            TableColumn<Customer, String> Cust_Search_ID,
            TableColumn<Customer, String> Cust_Search_Name,
            TableColumn<Customer, String> Cust_Search_Phone1,
            TableColumn<Customer, String> Cust_Search_Phone2,
            TableColumn<Customer, String> Cust_Search_Address,
            TableView<Customer> Cust_Search_table, String ID) {
        
    
        ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
        CustomerList.clear();
        Cust_Search_ID.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
        Cust_Search_Name.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name"));
        Cust_Search_Phone1.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone1"));
        Cust_Search_Phone2.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone2"));
        Cust_Search_Address.setCellValueFactory(new PropertyValueFactory<Customer, String>("Address"));
        CustomerList = Database.Utils.getCustomerByID(ID);
        Cust_Search_table.setItems(CustomerList);
    
    }
    
    public static void getCustomerByName(
            TableColumn<Customer, String> Cust_Search_ID,
            TableColumn<Customer, String> Cust_Search_Name,
            TableColumn<Customer, String> Cust_Search_Phone1,
            TableColumn<Customer, String> Cust_Search_Phone2,
            TableColumn<Customer, String> Cust_Search_Address,
            TableView<Customer> Cust_Search_table, String Name) {
        
    
        ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
        CustomerList.clear();
        Cust_Search_ID.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
        Cust_Search_Name.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name"));
        Cust_Search_Phone1.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone1"));
        Cust_Search_Phone2.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone2"));
        Cust_Search_Address.setCellValueFactory(new PropertyValueFactory<Customer, String>("Address"));
        CustomerList = Database.Utils.getCustomerByName(Name);
        Cust_Search_table.setItems(CustomerList);
    
    }
    
    public static void getCustomerByPhone(
            TableColumn<Customer, String> Cust_Search_ID,
            TableColumn<Customer, String> Cust_Search_Name,
            TableColumn<Customer, String> Cust_Search_Phone1,
            TableColumn<Customer, String> Cust_Search_Phone2,
            TableColumn<Customer, String> Cust_Search_Address,
            TableView<Customer> Cust_Search_table, String Phone) {
        
    
        ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
        CustomerList.clear();
        Cust_Search_ID.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
        Cust_Search_Name.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name"));
        Cust_Search_Phone1.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone1"));
        Cust_Search_Phone2.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone2"));
        Cust_Search_Address.setCellValueFactory(new PropertyValueFactory<Customer, String>("Address"));
        CustomerList = Database.Utils.getCustomerByPhone(Phone);
        Cust_Search_table.setItems(CustomerList);
    
    }
    public static void refreshTable(
            TableColumn<Customer, String> Cust_Search_ID,
            TableColumn<Customer, String> Cust_Search_Name,
            TableColumn<Customer, String> Cust_Search_Phone1,
            TableColumn<Customer, String> Cust_Search_Phone2,
            TableColumn<Customer, String> Cust_Search_Address,
            TableView<Customer> Cust_Search_table) {
        
    
        ObservableList<Customer> CustomerList = FXCollections.observableArrayList();
        CustomerList.clear();
        Cust_Search_ID.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
        Cust_Search_Name.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name"));
        Cust_Search_Phone1.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone1"));
        Cust_Search_Phone2.setCellValueFactory(new PropertyValueFactory<Customer, String>("Phone2"));
        Cust_Search_Address.setCellValueFactory(new PropertyValueFactory<Customer, String>("Address"));
        CustomerList = Database.Utils.getCustomersTable();
        Cust_Search_table.setItems(CustomerList);
    
    }

}
