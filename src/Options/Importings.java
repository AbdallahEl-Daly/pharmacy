/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import Customers.Customer;
import Operations.ImportingProcess;
import java.sql.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author hp
 */
public class Importings {

    

    public static void getTable(
            TableColumn<ImportingProcess, String> Imp_ProductID,
            TableColumn<ImportingProcess, String> Imp_ProductName,
            TableColumn<ImportingProcess, Double> Imp_Quantity,
            TableColumn<ImportingProcess, Double> Imp_Price,
            TableColumn<ImportingProcess, String> Imp_ExpiredDate,
            TableColumn<ImportingProcess, String> Imp_SupplierID,
            TableColumn<ImportingProcess, String> Imp_SupplierName,
            TableColumn<ImportingProcess, String> Imp_SellerID,
            TableColumn<ImportingProcess, String> Imp_SellerName,
            TableColumn<ImportingProcess, String> Imp_DateOfOperation,
            TableView<ImportingProcess> ImportingTable) {

        ObservableList<ImportingProcess> list;
        Imp_ProductID.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("ProductID"));
        Imp_ProductName.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("ProductName"));
        Imp_ExpiredDate.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("ExpiredDate"));
        Imp_SupplierID.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("SupplierID"));
        Imp_SupplierName.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("SupplierName"));
        Imp_SellerID.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("sellerID"));
        Imp_SellerName.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("SupplierName"));
        Imp_DateOfOperation.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("OperationDate"));
        Imp_Quantity.setCellValueFactory(new PropertyValueFactory<ImportingProcess, Double>("Quantity"));
        Imp_Price.setCellValueFactory(new PropertyValueFactory<ImportingProcess, Double>("Price"));
        list = Database.Utils.getImportingsTable();
        ImportingTable.setItems(list);
    }

    
    public static void refreshTable(
            TableColumn<ImportingProcess, String> Imp_ProductID,
            TableColumn<ImportingProcess, String> Imp_ProductName,
            TableColumn<ImportingProcess, Double> Imp_Quantity,
            TableColumn<ImportingProcess, Double> Imp_Price,
            TableColumn<ImportingProcess, String> Imp_ExpiredDate,
            TableColumn<ImportingProcess, String> Imp_SupplierID,
            TableColumn<ImportingProcess, String> Imp_SupplierName,
            TableColumn<ImportingProcess, String> Imp_SellerID,
            TableColumn<ImportingProcess, String> Imp_SellerName,
            TableColumn<ImportingProcess, String> Imp_DateOfOperation,
            TableView<ImportingProcess> ImportingTable) {

        ObservableList<ImportingProcess> list = FXCollections.observableArrayList();
        list.clear();
        Imp_ProductID.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("ProductID"));
        Imp_ProductName.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("ProductName"));
        Imp_ExpiredDate.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("ExpiredDate"));
        Imp_SupplierID.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("SupplierID"));
        Imp_SupplierName.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("SupplierName"));
        Imp_SellerID.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("sellerID"));
        Imp_SellerName.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("SupplierName"));
        Imp_DateOfOperation.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("OperationDate"));
        Imp_Quantity.setCellValueFactory(new PropertyValueFactory<ImportingProcess, Double>("Quantity"));
        Imp_Price.setCellValueFactory(new PropertyValueFactory<ImportingProcess, Double>("Price"));
        list = Database.Utils.getImportingsTable();
        ImportingTable.setItems(list);
    }

    public static void sortTable(
            TableColumn<ImportingProcess, String> Imp_ProductID,
            TableColumn<ImportingProcess, String> Imp_ProductName,
            TableColumn<ImportingProcess, Double> Imp_Quantity,
            TableColumn<ImportingProcess, Double> Imp_Price,
            TableColumn<ImportingProcess, String> Imp_ExpiredDate,
            TableColumn<ImportingProcess, String> Imp_SupplierID,
            TableColumn<ImportingProcess, String> Imp_SupplierName,
            TableColumn<ImportingProcess, String> Imp_SellerID,
            TableColumn<ImportingProcess, String> Imp_SellerName,
            TableColumn<ImportingProcess, String> Imp_DateOfOperation,
            TableView<ImportingProcess> ImportingTable, String From, String To) {

        ObservableList<ImportingProcess> list = FXCollections.observableArrayList();
        list.clear();
        Imp_ProductID.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("ProductID"));
        Imp_ProductName.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("ProductName"));
        Imp_ExpiredDate.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("ExpiredDate"));
        Imp_SupplierID.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("SupplierID"));
        Imp_SupplierName.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("SupplierName"));
        Imp_SellerID.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("sellerID"));
        Imp_SellerName.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("SupplierName"));
        Imp_DateOfOperation.setCellValueFactory(new PropertyValueFactory<ImportingProcess, String>("OperationDate"));
        Imp_Quantity.setCellValueFactory(new PropertyValueFactory<ImportingProcess, Double>("Quantity"));
        Imp_Price.setCellValueFactory(new PropertyValueFactory<ImportingProcess, Double>("Price"));
        list = Database.Utils.sortImportingsTable(From, To);
        ImportingTable.setItems(list);
    }

    
}
