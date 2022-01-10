/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import Operations.ImportingProcess;
import Operations.SellingProcess;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author hp
 */
public class Sellings {

    public static void getTable(
            TableColumn<SellingProcess, String> Sell_SellerID,
            TableColumn<SellingProcess, String> Sell_SellerName,
            TableColumn<SellingProcess, String> Sell_Prod_CustomerID,
            TableColumn<SellingProcess, String> Sell_Prod_ID,
            TableColumn<SellingProcess, String> Sell_Prod_Name,
            TableColumn<SellingProcess, Double> Sell_Prod_Quantity,
            TableColumn<SellingProcess, Double> Sell_Prod_Price,
            TableColumn<SellingProcess, String> Sell_Date,
            TableView<SellingProcess> Sell_Table) {

        ObservableList<SellingProcess> list;
        Sell_SellerID.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("SellerID"));
        Sell_SellerName.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("SellerName"));
        Sell_Prod_CustomerID.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("CustomerID"));
        Sell_Prod_ID.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("ProductID"));
        Sell_Prod_Name.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("ProductName"));
        Sell_Date.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("Date"));
        Sell_Prod_Quantity.setCellValueFactory(new PropertyValueFactory<SellingProcess, Double>("Quantity"));
        Sell_Prod_Price.setCellValueFactory(new PropertyValueFactory<SellingProcess, Double>("Price"));
        list = Database.Utils.getSellingTable();
        Sell_Table.setItems(list);

    }

    public static void refreshTable(
            TableColumn<SellingProcess, String> Sell_SellerID,
            TableColumn<SellingProcess, String> Sell_SellerName,
            TableColumn<SellingProcess, String> Sell_Prod_CustomerID,
            TableColumn<SellingProcess, String> Sell_Prod_ID,
            TableColumn<SellingProcess, String> Sell_Prod_Name,
            TableColumn<SellingProcess, Double> Sell_Prod_Quantity,
            TableColumn<SellingProcess, Double> Sell_Prod_Price,
            TableColumn<SellingProcess, String> Sell_Date,
            TableView<SellingProcess> Sell_Table) {

        ObservableList<SellingProcess> list = FXCollections.observableArrayList();
        list.clear();
        Sell_SellerID.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("SellerID"));
        Sell_SellerName.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("SellerName"));
        Sell_Prod_CustomerID.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("CustomerID"));
        Sell_Prod_ID.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("ProductID"));
        Sell_Prod_Name.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("ProductName"));
        Sell_Date.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("Date"));
        Sell_Prod_Quantity.setCellValueFactory(new PropertyValueFactory<SellingProcess, Double>("Quantity"));
        Sell_Prod_Price.setCellValueFactory(new PropertyValueFactory<SellingProcess, Double>("Price"));
        list = Database.Utils.getSellingTable();
        Sell_Table.setItems(list);

    }
public static void sortTable(
            TableColumn<SellingProcess, String> Sell_SellerID,
            TableColumn<SellingProcess, String> Sell_SellerName,
            TableColumn<SellingProcess, String> Sell_Prod_CustomerID,
            TableColumn<SellingProcess, String> Sell_Prod_ID,
            TableColumn<SellingProcess, String> Sell_Prod_Name,
            TableColumn<SellingProcess, Double> Sell_Prod_Quantity,
            TableColumn<SellingProcess, Double> Sell_Prod_Price,
            TableColumn<SellingProcess, String> Sell_Date,
            TableView<SellingProcess> Sell_Table, String From, String To) {

        ObservableList<SellingProcess> list = FXCollections.observableArrayList();
        list.clear();
        Sell_SellerID.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("SellerID"));
        Sell_SellerName.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("SellerName"));
        Sell_Prod_CustomerID.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("CustomerID"));
        Sell_Prod_ID.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("ProductID"));
        Sell_Prod_Name.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("ProductName"));
        Sell_Date.setCellValueFactory(new PropertyValueFactory<SellingProcess, String>("Date"));
        Sell_Prod_Quantity.setCellValueFactory(new PropertyValueFactory<SellingProcess, Double>("Quantity"));
        Sell_Prod_Price.setCellValueFactory(new PropertyValueFactory<SellingProcess, Double>("Price"));
        list = Database.Utils.sortsellingTable(From,To);
        Sell_Table.setItems(list);

    }
}
