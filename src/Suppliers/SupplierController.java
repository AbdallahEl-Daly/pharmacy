/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suppliers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class SupplierController implements Initializable {

    @FXML
    private TableView<supplier> Sup_Search_table;

    @FXML
    private TableColumn<supplier, String> Sup_Search_ID;

    @FXML
    private TableColumn<supplier, String> Sup_Search_Name;

    @FXML
    private TableColumn<supplier, String> Sup_Search_Phone1;

    @FXML
    private TableColumn<supplier, String> Sup_Search_Phone2;

    @FXML
    private TableColumn<supplier, String> Sup_Search_Phone3;

    @FXML
    private TableColumn<supplier, String> Sup_Search_Phone4;

    @FXML
    private TableColumn<supplier, String> Sup_Search_Address;

    @FXML
    private TextField Search_ID;

    @FXML
    private TextField Search_Name;

    @FXML
    private TextField Search_Phone;

    @FXML
    private TextField Display_ID;

    @FXML
    private TextField Display_Name;

    @FXML
    private TextField Display_Phone1;

    @FXML
    private TextField Display_Phone2;

    @FXML
    private TextArea Display_Address;

    @FXML
    private TextField Display_Phone3;

    @FXML
    private TextField Display_Phone4;

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
    private TableView<supplier> Sup_Add_table;

    @FXML
    private TableColumn<supplier, String> Sup_Add_ID;

    @FXML
    private TableColumn<supplier, String> Sup_Add_Name;

    @FXML
    private TableColumn<supplier, String> Sup_Add_Phone1;

    @FXML
    private TableColumn<supplier, String> Sup_Add_Phone2;

    @FXML
    private TableColumn<supplier, String> Sup_Add_Address;

    @FXML
    private TextField Add_Phone3;

    @FXML
    private TextField Add_Phone4;
    @FXML
    private Label Add_MessageLbl;
    @FXML
    private Label SUD_MessageLBL;

    @FXML
    private Button cancelBTN;

    private int index = -1;

    private int deleteChoice = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Options.Suppliers.getSuppliers(Sup_Search_ID,
                Sup_Search_Name, Sup_Search_Phone1, Sup_Search_Phone2,
                Sup_Search_Phone3, Sup_Search_Phone4, Sup_Search_Address,
                Sup_Search_table);
        Options.Suppliers.refreshAddTable(
                Sup_Add_ID, Sup_Add_Name, Sup_Add_Phone1,
                Sup_Add_Phone2, Sup_Add_Address, Sup_Add_table);
        cancelBTN.setVisible(false);
    }

    @FXML
    public void AddBtnAction(ActionEvent evt) throws IOException {
        String ID = Add_ID.getText();
        String Name = Add_Name.getText();
        String Phone1 = Add_Phone1.getText();
        String Phone2 = Add_Phone2.getText();
        String Phone3 = Add_Phone2.getText();
        String Phone4 = Add_Phone4.getText();
        String Address = Add_Address.getText();

        if (ID.equals("") || Name.equals("") || Phone1.equals("") || Address.equals("")) {
            Add_MessageLbl.setText("Incompleted Data!!!");
        } else {
            boolean SupplierExist = Database.Utils.SupplierExist_ID(ID);
            if (SupplierExist) {
                Add_MessageLbl.setText("This ID Exists!!!");
            } else {
                Database.Utils.insertSupplier(ID, Name, Phone1, Phone2, Phone3, Phone4, Address);
                Add_MessageLbl.setText("Supplier Added Successfully...");
                Options.Suppliers.refreshAddTable(
                        Sup_Add_ID, Sup_Add_Name, Sup_Add_Phone1,
                        Sup_Add_Phone2, Sup_Add_Address, Sup_Add_table);
            }
        }
    }

    @FXML
    public void SearchByName(KeyEvent Kv) {
        String Name = Search_Name.getText();
        if (Name.equals("")) {
            Options.Suppliers.refreshSearchTable(Sup_Search_ID, Sup_Search_Name,
                    Sup_Search_Phone1, Sup_Search_Phone2, Sup_Search_Phone3,
                    Sup_Search_Phone4, Sup_Search_Address, Sup_Search_table);
        } else {
            Options.Suppliers.searchSuppliersByName(Sup_Search_ID, Sup_Search_Name,
                    Sup_Search_Phone1, Sup_Search_Phone2, Sup_Search_Phone3,
                    Sup_Search_Phone4, Sup_Search_Address, Sup_Search_table, Name);
        }
    }

    @FXML
    public void SearchByID(KeyEvent Kv) {
        String ID = Search_ID.getText();
        if (ID.equals("")) {
            Options.Suppliers.refreshSearchTable(Sup_Search_ID, Sup_Search_Name,
                    Sup_Search_Phone1, Sup_Search_Phone2, Sup_Search_Phone3,
                    Sup_Search_Phone4, Sup_Search_Address, Sup_Search_table);
        } else {
            Options.Suppliers.searchSuppliersByID(Sup_Search_ID, Sup_Search_Name,
                    Sup_Search_Phone1, Sup_Search_Phone2, Sup_Search_Phone3,
                    Sup_Search_Phone4, Sup_Search_Address, Sup_Search_table, ID);
        }
    }

    @FXML
    public void SearchByPhone(KeyEvent Kv) {
        String Phone = Search_Phone.getText();
        if (Phone.equals("")) {
            Options.Suppliers.refreshSearchTable(Sup_Search_ID, Sup_Search_Name,
                    Sup_Search_Phone1, Sup_Search_Phone2, Sup_Search_Phone3,
                    Sup_Search_Phone4, Sup_Search_Address, Sup_Search_table);
        } else {
            Options.Suppliers.searchSuppliersByPhone(Sup_Search_ID, Sup_Search_Name,
                    Sup_Search_Phone1, Sup_Search_Phone2, Sup_Search_Phone3,
                    Sup_Search_Phone4, Sup_Search_Address, Sup_Search_table, Phone);
        }
    }

    @FXML
    public void TableMouseClick(MouseEvent evt) throws IOException {
        index = Sup_Search_table.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            return;
        }
        Display_ID.setText(Sup_Search_ID.getCellData(index));
        Display_Name.setText(Sup_Search_Name.getCellData(index));
        Display_Phone1.setText(Sup_Search_Phone1.getCellData(index));
        Display_Phone2.setText(Sup_Search_Phone2.getCellData(index));
        Display_Phone3.setText(Sup_Search_Phone3.getCellData(index));
        Display_Phone4.setText(Sup_Search_Phone4.getCellData(index));
        Display_Address.setText(Sup_Search_Address.getCellData(index));
    }

    @FXML
    public void editBtnAction(ActionEvent evt) throws IOException {
        String ID = Display_ID.getText();
        String Name = Display_Name.getText();
        String Phone1 = Display_Phone1.getText();
        String Phone2 = Display_Phone2.getText();
        String Phone3 = Display_Phone3.getText();
        String Phone4 = Display_Phone4.getText();
        String Address = Display_Address.getText();
        if (ID.equals("") || Name.equals("") || Phone1.equals("") || Address.equals("")) {
            SUD_MessageLBL.setText("Incompleted Data!!");
        } else {
            Database.Utils.UpdateSupplier(ID, Name, Phone1, Phone2, Phone3, Phone4, Address);
            SUD_MessageLBL.setText("Data Updated Successfully");
            Options.Suppliers.refreshSearchTable(Sup_Search_ID, Sup_Search_Name,
                    Sup_Search_Phone1, Sup_Search_Phone2, Sup_Search_Phone3,
                    Sup_Search_Phone4, Sup_Search_Address, Sup_Search_table);
        }

    }

    @FXML
    public void deleteBtnAction(ActionEvent evt) throws IOException {
        String ID = Display_ID.getText();
        String Name = Display_Name.getText();
        if (ID.equals("") || Name.equals("")) {
            SUD_MessageLBL.setText("Click On Supplier To Delete!!");
        } else {
            if (deleteChoice == 0) {
                SUD_MessageLBL.setText("Click Delete Again if You Sure Want Deleting," + Name);
                cancelBTN.setVisible(true);
                deleteChoice = 1;
            } else if (deleteChoice == 1) {
                Database.Utils.deleteSupplier(ID);
                Options.Suppliers.refreshSearchTable(Sup_Search_ID, Sup_Search_Name,
                        Sup_Search_Phone1, Sup_Search_Phone2, Sup_Search_Phone3,
                        Sup_Search_Phone4, Sup_Search_Address, Sup_Search_table);
                SUD_MessageLBL.setText(Name + ", has been Deleted");
                deleteChoice = 0;
                cancelBTN.setVisible(false);
            }

        }

    }

    @FXML
    public void cancelBTN(ActionEvent evt) throws IOException {
        deleteChoice = 0;
        SUD_MessageLBL.setText("");
        cancelBTN.setVisible(false);
    }
}
