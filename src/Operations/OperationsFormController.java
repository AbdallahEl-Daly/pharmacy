/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class OperationsFormController implements Initializable {
    
    @FXML
    private TableView<SellingProcess> Sell_Table;

    @FXML
    private TableColumn<SellingProcess, String> Sell_Prod_ID;

    @FXML
    private TableColumn<SellingProcess, String> Sell_Prod_Name;

    @FXML
    private TableColumn<SellingProcess, Double> Sell_Prod_Quantity;

    @FXML
    private TableColumn<SellingProcess, Double> Sell_Prod_Price;

    @FXML
    private TableColumn<SellingProcess, String> Sell_Prod_CustomerID;


    @FXML
    private TableColumn<SellingProcess, String> Sell_SellerID;

    @FXML
    private TableColumn<SellingProcess, String> Sell_SellerName;

    @FXML
    private TableColumn<SellingProcess, String> Sell_Date;

    @FXML
    private DatePicker Sell_FromDatePicker;

    @FXML
    private DatePicker Sell_ToDatePicker;

    @FXML
    private DatePicker Imp_FromDatePicker;

    @FXML
    private DatePicker Imp_ToDatePicker;

    @FXML
    private TableView<ImportingProcess> ImportingTable;

    @FXML
    private TableColumn<ImportingProcess, String> Imp_ProductID;

    @FXML
    private TableColumn<ImportingProcess, String> Imp_ProductName;

    @FXML
    private TableColumn<ImportingProcess, Double> Imp_Quantity;

    @FXML
    private TableColumn<ImportingProcess, Double> Imp_Price;

    @FXML
    private TableColumn<ImportingProcess, String> Imp_ExpiredDate;

    @FXML
    private TableColumn<ImportingProcess, String> Imp_SupplierID;

    @FXML
    private TableColumn<ImportingProcess, String> Imp_SupplierName;

    @FXML
    private TableColumn<ImportingProcess, String> Imp_SellerID;

    @FXML
    private TableColumn<ImportingProcess, String> Imp_SellerName;

    @FXML
    private TableColumn<ImportingProcess, String> Imp_DateOfOperation;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Options.Importings.getTable(Imp_ProductID, Imp_ProductName, Imp_Quantity,
                Imp_Price, Imp_ExpiredDate, Imp_SupplierID, Imp_SupplierName,
                Imp_SellerID, Imp_SellerName, Imp_DateOfOperation, ImportingTable);
        Options.Sellings.getTable(Sell_SellerID,Sell_SellerName,Sell_Prod_CustomerID,
                Sell_Prod_ID,Sell_Prod_Name,Sell_Prod_Quantity,Sell_Prod_Price,Sell_Date,Sell_Table);
    }

    @FXML
    public void sortImportingTable(ActionEvent evt) throws IOException {
        String fromDate = Imp_FromDatePicker.getValue().toString();
        String toDate = Imp_ToDatePicker.getValue().toString();
        Options.Importings.sortTable(Imp_ProductID, Imp_ProductName, Imp_Quantity,
                Imp_Price, Imp_ExpiredDate, Imp_SupplierID, Imp_SupplierName,
                Imp_SellerID, Imp_SellerName, Imp_DateOfOperation, ImportingTable,
                fromDate, toDate);

    }
  @FXML
    public void sortSellingTable(ActionEvent evt) throws IOException {
        String fromDate = Sell_FromDatePicker.getValue().toString();
        String toDate = Sell_ToDatePicker.getValue().toString();
        Options.Sellings.sortTable(Sell_SellerID,Sell_SellerName,Sell_Prod_CustomerID,
                Sell_Prod_ID,Sell_Prod_Name,Sell_Prod_Quantity,Sell_Prod_Price,Sell_Date,Sell_Table,
                fromDate, toDate);

    }
    @FXML
    public void refreshTable(ActionEvent evt) throws IOException {
        Options.Importings.refreshTable(Imp_ProductID, Imp_ProductName, Imp_Quantity,
                Imp_Price, Imp_ExpiredDate, Imp_SupplierID, Imp_SupplierName,
                Imp_SellerID, Imp_SellerName, Imp_DateOfOperation, ImportingTable);

    }
    
    @FXML
    public void refreshSortingTable(ActionEvent evt) throws IOException {
        Options.Sellings.refreshTable(Sell_SellerID,Sell_SellerName,Sell_Prod_CustomerID,
                Sell_Prod_ID,Sell_Prod_Name,Sell_Prod_Quantity,Sell_Prod_Price,Sell_Date,Sell_Table);

    }
}
