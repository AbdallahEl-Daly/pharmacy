/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CustomersFormController implements Initializable {

    @FXML
    private TableView<Customer> Cust_Search_table;

    @FXML
    private TableColumn<Customer, String> Cust_Search_ID;

    @FXML
    private TableColumn<Customer, String> Cust_Search_Name;

    @FXML
    private TableColumn<Customer, String> Cust_Search_Phone1;

    @FXML
    private TableColumn<Customer, String> Cust_Search_Phone2;

    @FXML
    private TableColumn<Customer, String> Cust_Search_Address;

    @FXML
    private TableView<Customer> Cust_Add_table;
    @FXML
    private TableColumn<Customer, String> Cust_Add_ID;
    @FXML
    private TableColumn<Customer, String> Cust_Add_Name;
    @FXML
    private TableColumn<Customer, String> Cust_Add_Phone1;
    @FXML
    private TableColumn<Customer, String> Cust_Add_Phone2;
    @FXML
    private TableColumn<Customer, String> Cust_Add_Address;
    @FXML
    private TextField Search_ID;

    @FXML
    private TextField Search_Name;

    @FXML
    private TextField Search_Phone;

    @FXML
    private TextField Display_Name;

    @FXML
    private TextField Display_ID;

    @FXML
    private TextField Display_Phone1;

    @FXML
    private TextField Display_Phone2;

    @FXML
    private TextArea Display_Address;

    @FXML
    private TextField Add_Name;

    @FXML
    private TextField Add_ID;

    @FXML
    private TextField Add_Phone1;

    @FXML
    private TextField Add_Phone2;

    @FXML
    private TextArea Add_Address;

    @FXML
    private Label SUD_MessageLbl;

    @FXML
    private Label Add_MessageLbl;

    private int index = -1;
    private Customer customer;
    //ObservableList<Student>  StudentList = FXCollections.observableArrayList();
    ObservableList<Customer> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Options.CustomersTables.getCustomers(Cust_Add_ID, Cust_Add_Name,
                Cust_Add_Phone1, Cust_Add_Phone2, Cust_Add_Address,
                Cust_Add_table);
        Options.CustomersTables.getCustomers(Cust_Search_ID, Cust_Search_Name,
                Cust_Search_Phone1, Cust_Search_Phone2, Cust_Search_Address,
                Cust_Search_table);

    }

    @FXML
    public void AddBtn(ActionEvent evt) throws IOException {
        String Name = Add_Name.getText();
        String ID = Add_ID.getText();
        String Phone1 = Add_Phone1.getText();
        String Phone2 = Add_Phone2.getText();
        String address = Add_Address.getText();
        if (Name.equals("") || ID.equals("") || Phone1.equals("")
                || Phone2.equals("") || address.equals("")) {
            Add_MessageLbl.setText("Incompleted Data!!!");
        } else {
            boolean CustomerExist = Database.Utils.CustomerExist(ID);
            if (CustomerExist) {
                Add_MessageLbl.setText("Customer Exists !!!");
            } else {
                Database.Utils.insertCustomer(ID, Name, Phone1, Phone2, address);
                Add_MessageLbl.setText("Customer Added Successfully");
                Options.CustomersTables.refreshTable(Cust_Add_ID, Cust_Add_Name,
                        Cust_Add_Phone1, Cust_Add_Phone2, Cust_Add_Address,
                        Cust_Add_table);
                Add_Address.setText("");
                Add_Phone2.setText("");
                Add_Phone1.setText("");
                Add_ID.setText("");
                Add_Name.setText("");
            }
        }
    }

    @FXML
    public void editBtn(ActionEvent evt) throws IOException {
        String Name = Display_Name.getText();
        String ID = Display_ID.getText();
        String Phone1 = Display_Phone1.getText();
        String Phone2 = Display_Phone2.getText();
        String address = Display_Address.getText();
        if (Name.equals("") || ID.equals("") || Phone1.equals("")
                || Phone2.equals("") || address.equals("")) {
            SUD_MessageLbl.setText("Incompleted Data!!!");
        } else {
            Database.Utils.UpdateCustomer(ID, Name, Phone1, Phone2, address);
            SUD_MessageLbl.setText("Customer Updated Successfully");
            Options.CustomersTables.refreshTable(Cust_Search_ID, Cust_Search_Name,
                    Cust_Search_Phone1, Cust_Search_Phone2, Cust_Search_Address,
                    Cust_Search_table);
            Display_Name.setText("");
            Display_ID.setText("");
            Display_Phone1.setText("");
            Display_Phone2.setText("");
            Display_Address.setText("");

        }
    }

    @FXML
    public void deleteBtn(ActionEvent evt) throws IOException {
        String ID = Display_ID.getText();
        if (ID.equals("")) {
            SUD_MessageLbl.setText("Select Customer Data!!!");
        } else {
            Database.Utils.deleteCustomer(ID);
            SUD_MessageLbl.setText("Customer Deleted Successfully");
            Options.CustomersTables.refreshTable(Cust_Search_ID, Cust_Search_Name,
                    Cust_Search_Phone1, Cust_Search_Phone2, Cust_Search_Address,
                    Cust_Search_table);
            Display_Name.setText("");
            Display_ID.setText("");
            Display_Phone1.setText("");
            Display_Phone2.setText("");
            Display_Address.setText("");

        }
    }

    @FXML
    public void TableMouseClick(MouseEvent evt) throws IOException {
        index = Cust_Search_table.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            return;
        }
        Display_ID.setText(Cust_Search_ID.getCellData(index));
        Display_Name.setText(Cust_Search_Name.getCellData(index));
        Display_Phone1.setText(Cust_Search_Phone1.getCellData(index).toString());
        Display_Phone2.setText(Cust_Search_Phone2.getCellData(index).toString());
        Display_Address.setText(Cust_Search_Address.getCellData(index).toString());
    }

    @FXML
    public void SearchByID(KeyEvent Kv) {
        String ID = Search_ID.getText();
        if (ID.equals("")) {
            Options.CustomersTables.refreshTable(
                    Cust_Search_ID, Cust_Search_Name, Cust_Search_Phone1,
                    Cust_Search_Phone2, Cust_Search_Address, Cust_Search_table);
        } else {
            Options.CustomersTables.getCustomerByID(
                    Cust_Search_ID, Cust_Search_Name, Cust_Search_Phone1,
                    Cust_Search_Phone2, Cust_Search_Address, Cust_Search_table, ID);
        }
    }

    @FXML
    public void SearchByName(KeyEvent Kv) {
        String Name = Search_Name.getText();
        if (Name.equals("")) {
            Options.CustomersTables.refreshTable(
                    Cust_Search_ID, Cust_Search_Name, Cust_Search_Phone1,
                    Cust_Search_Phone2, Cust_Search_Address, Cust_Search_table);
        } else {
            Options.CustomersTables.getCustomerByName(
                    Cust_Search_ID, Cust_Search_Name, Cust_Search_Phone1,
                    Cust_Search_Phone2, Cust_Search_Address, Cust_Search_table, Name);
        }
    }

    @FXML
    public void SearchByPhone(KeyEvent Kv) {
        String Phone = Search_Phone.getText();
        if (Phone.equals("")) {
            Options.CustomersTables.refreshTable(
                    Cust_Search_ID, Cust_Search_Name, Cust_Search_Phone1,
                    Cust_Search_Phone2, Cust_Search_Address, Cust_Search_table);
        } else {
            Options.CustomersTables.getCustomerByPhone(
                    Cust_Search_ID, Cust_Search_Name, Cust_Search_Phone1,
                    Cust_Search_Phone2, Cust_Search_Address, Cust_Search_table, Phone);
        }
    }

    @FXML
    public final EventHandler<Event> refreshSearchTable() {
        Options.CustomersTables.refreshTable(
                Cust_Search_ID, Cust_Search_Name, Cust_Search_Phone1,
                Cust_Search_Phone2, Cust_Search_Address, Cust_Search_table);
        return null;

    }
    
    @FXML
    public final EventHandler<Event> refreshAddTable() {
        Options.CustomersTables.getCustomers(Cust_Add_ID, Cust_Add_Name,
                Cust_Add_Phone1, Cust_Add_Phone2, Cust_Add_Address,
                Cust_Add_table);
        return null;

    }
}
