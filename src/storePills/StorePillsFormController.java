/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storePills;

import Medicine.Medicine;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class StorePillsFormController implements Initializable {

    @FXML
    private TableView<Medicine> PillsTable;

    @FXML
    private TableColumn<Medicine, String> Product_ID;

    @FXML
    private TableColumn<Medicine, String> Product_Name;

    @FXML
    private TableColumn<Medicine, Double> Quantity;

    @FXML
    private TextField MedicineNameField;

    @FXML
    private TextField PriceFromSupplierField;

    @FXML
    private TextField SearchByIDField;

    @FXML
    private TextField SearchByName;

    @FXML
    private TextField QuantityField;

    @FXML
    private TextField TotalField;

    @FXML
    private ComboBox<String> SupllierComboBiox;

    @FXML
    private DatePicker ExpiredDatePicker;

    @FXML
    private Label MessageLBl;

    @FXML
    private Button StoreBtn;

    private int rowCount;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Options.MedicineAddFormTable.getPillsTable(Product_ID, Product_Name,
                Quantity, PillsTable);
        ObservableList<String> suppliers = FXCollections.observableArrayList(Database.Utils.getSupplierComboBox());
        SupllierComboBiox.setItems(suppliers);
        SupllierComboBiox.getStyleClass().add("center-aligned");
        StoreBtn.setDisable(true);
        StoreBtn.setStyle("-fx-text-inner-color: White;");
    }

    @FXML
    public void SearchByID(KeyEvent evt) {
        String ID = SearchByIDField.getText();
        int IdVal = 0;
        if (ID.equals("")) {
            Options.MedicineAddFormTable.refreshPillsTable(Product_ID,
                    Product_Name, Quantity, PillsTable);
            MedicineNameField.setText("");
            StoreBtn.setDisable(true);
        } else {
            try {
                IdVal = Integer.parseInt(ID);
                Options.MedicineAddFormTable.getPillsTableByID(Product_ID,
                        Product_Name, Quantity, PillsTable, IdVal);
                MessageLBl.setText("");
                if (PillsTable.getItems().size() == 1) {
                    MedicineNameField.setText(Product_Name.getCellData(0));
                    StoreBtn.setDisable(false);
                } else {
                    MedicineNameField.setText("");
                }
            } catch (Exception ex) {
                MessageLBl.setText("Numbers Only!!");
                SearchByIDField.setText("");
                MedicineNameField.setText("");
                StoreBtn.setDisable(true);
            }
        }

    }

    @FXML
    public void SearchByName(KeyEvent evt) {
        String Name = SearchByName.getText();
        if (Name.equals("")) {
            Options.MedicineAddFormTable.refreshPillsTable(Product_ID,
                    Product_Name, Quantity, PillsTable);
            MedicineNameField.setText("");
            StoreBtn.setDisable(true);
        } else {
            Options.MedicineAddFormTable.getPillsTableByName(Product_ID,
                    Product_Name, Quantity, PillsTable, Name);
            if (PillsTable.getItems().size() == 1) {
                MedicineNameField.setText(Product_Name.getCellData(0));
                StoreBtn.setDisable(false);
            } else {
                MedicineNameField.setText("");
                StoreBtn.setDisable(true);
            }

        }

    }

    @FXML
    public void calculateTotalPrice(KeyEvent evt) {
        double Quantity, TotalPrice, PriceOfBox;
        String val = QuantityField.getText();
        if (val.equals("")) {
            MessageLBl.setText("Set Quantity");
        } else {
            try {
                Quantity = Double.parseDouble(QuantityField.getText());
                PriceOfBox = Double.parseDouble(PriceFromSupplierField.getText());
                TotalPrice = Quantity * PriceOfBox;
                TotalField.setText(String.valueOf(TotalPrice));
                MessageLBl.setText("");
            } catch (Exception ex) {
                MessageLBl.setText("Numbers Only!!");
                QuantityField.setText("");
            }
        }
    }

    @FXML
    public void calculateTotalPriceFromQuantity(KeyEvent evt) {
        double Quantity, TotalPrice, PriceOfBox;
        String val = PriceFromSupplierField.getText();
        if (val.equals("")) {
            MessageLBl.setText("Set Price");
        } else {
            try {
                Quantity = Double.parseDouble(QuantityField.getText());
                PriceOfBox = Double.parseDouble(PriceFromSupplierField.getText());
                TotalPrice = Quantity * PriceOfBox;
                TotalField.setText(String.valueOf(TotalPrice));
                MessageLBl.setText("");
            } catch (Exception ex) {
                MessageLBl.setText("Numbers Only!!");
                QuantityField.setText("");
            }
        }
    }

    @FXML
    public void searchByIdClicked(MouseEvent evt) throws IOException {
        SearchByName.setText("");
    }

    @FXML
    public void searchByNameClicked(MouseEvent evt) throws IOException {
        SearchByIDField.setText("");
    }

    @FXML
    public void StorePills(ActionEvent evt) throws IOException {
        String SupplierName = SupllierComboBiox.getSelectionModel().getSelectedItem();
        String ProductName = Product_Name.getCellData(0);
        String total = TotalField.getText();
        LocalDate expired;
        LocalDate Null = null;
        String ExpiredDate = null;
        String ProductId = Product_ID.getCellData(0);
        double Price, quantity;
        try {
            expired = ExpiredDatePicker.getValue();
            ExpiredDate = expired.toString();
            try {
                quantity = Double.parseDouble(QuantityField.getText());
                Price = Double.parseDouble(PriceFromSupplierField.getText());
                if (SupplierName.equals("") || ProductName.equals("") || total.equals("")) {
                    MessageLBl.setText("Incompleted Data");
                } else {
                    //String SupplierName, String ProductId,
                    //String ProductName,String ExpiredDate,double Quantity,double Price
                    Database.Utils.ImportingProcess(SupplierName, ProductId, ProductName, ExpiredDate, quantity, Price);
                    MessageLBl.setText("Medicine Stored");
                    Options.MedicineAddFormTable.refreshPillsTable(Product_ID,
                            Product_Name, Quantity, PillsTable);
                }
            } catch (Exception ex) {
                MessageLBl.setText("Incompleted Data");
            }
        } catch (Exception ex) {
            MessageLBl.setText("Choose Expired Date");
        }
        StoreBtn.setDisable(true);
        TotalField.setText("");
        MedicineNameField.setText("");
        PriceFromSupplierField.setText("");
        QuantityField.setText("");
        Product_Name.setText("");
        ExpiredDatePicker.setValue(Null);
        SearchByName.setText("");
        SearchByIDField.setText("");
        
    }

}
