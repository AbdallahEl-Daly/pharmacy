/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Options;

import Medicine.Medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author hp
 */
public class MedicineStore {

    public static void getTable(TableColumn<Medicine, String> Store_ID,
            TableColumn<Medicine, String> Store_Name,
            TableColumn<Medicine, Double> Store_Price,
            TableColumn<Medicine, Double> Store_Quantity,
            TableColumn<Medicine, String> Store_ExpiredDate,
            TableColumn<Medicine, Integer> Store_Ribbon,
            TableColumn<Medicine, Double> Store_Ribbon_Price,
            TableView<Medicine> Store_Table
    ) {

        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        Store_ID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Store_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Store_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("price"));
        Store_Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        Store_ExpiredDate.setCellValueFactory(new PropertyValueFactory<Medicine, String>("ExpiredDate"));
        Store_Ribbon.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("Ribbon"));
        Store_Ribbon_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("RibbonPrice"));
        MedicineList = Database.Utils.getMedicineTable();
        Store_Table.setItems(MedicineList);
    }

    public static void getTableSearchedByID(TableColumn<Medicine, String> Store_ID,
            TableColumn<Medicine, String> Store_Name,
            TableColumn<Medicine, Double> Store_Price,
            TableColumn<Medicine, Double> Store_Quantity,
            TableColumn<Medicine, String> Store_ExpiredDate,
            TableColumn<Medicine, Integer> Store_Ribbon,
            TableColumn<Medicine, Double> Store_Ribbon_Price,
            TableView<Medicine> Store_Table, int ID
    ) {

        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        Store_ID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Store_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Store_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("price"));
        Store_Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        Store_ExpiredDate.setCellValueFactory(new PropertyValueFactory<Medicine, String>("ExpiredDate"));
        Store_Ribbon.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("Ribbon"));
        Store_Ribbon_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("RibbonPrice"));
        MedicineList = Database.Utils.searchMedicineByID(ID);
        Store_Table.setItems(MedicineList);
    }

    public static void getTableSearchedByName(
            TableColumn<Medicine, String> Store_ID,
            TableColumn<Medicine, String> Store_Name,
            TableColumn<Medicine, Double> Store_Price,
            TableColumn<Medicine, Double> Store_Quantity,
            TableColumn<Medicine, String> Store_ExpiredDate,
            TableColumn<Medicine, Integer> Store_Ribbon,
            TableColumn<Medicine, Double> Store_Ribbon_Price,
            TableView<Medicine> Store_Table,
            String Name) {

        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        Store_ID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Store_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Store_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("price"));
        Store_Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        Store_ExpiredDate.setCellValueFactory(new PropertyValueFactory<Medicine, String>("ExpiredDate"));
        Store_Ribbon.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("Ribbon"));
        Store_Ribbon_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("RibbonPrice"));
        MedicineList = Database.Utils.searchMedicineByName(Name);
        Store_Table.setItems(MedicineList);
    }

    public static void getTableSearchedByExpiredDate(
            TableColumn<Medicine, String> Store_ID,
            TableColumn<Medicine, String> Store_Name,
            TableColumn<Medicine, Double> Store_Price,
            TableColumn<Medicine, Double> Store_Quantity,
            TableColumn<Medicine, String> Store_ExpiredDate,
            TableColumn<Medicine, Integer> Store_Ribbon,
            TableColumn<Medicine, Double> Store_Ribbon_Price,
            TableView<Medicine> Store_Table,
            String Month) {

        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        Store_ID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Store_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Store_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("price"));
        Store_Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        Store_ExpiredDate.setCellValueFactory(new PropertyValueFactory<Medicine, String>("ExpiredDate"));
        Store_Ribbon.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("Ribbon"));
        Store_Ribbon_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("RibbonPrice"));
        MedicineList = Database.Utils.searchMedicineByExpiredDate(Month);
        Store_Table.setItems(MedicineList);
    }

    public static void refreshTable(
            TableColumn<Medicine, String> Store_ID,
            TableColumn<Medicine, String> Store_Name,
            TableColumn<Medicine, Double> Store_Price,
            TableColumn<Medicine, Double> Store_Quantity,
            TableColumn<Medicine, String> Store_ExpiredDate,
            TableColumn<Medicine, Integer> Store_Ribbon,
            TableColumn<Medicine, Double> Store_Ribbon_Price,
            TableView<Medicine> Store_Table) {

        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        Store_ID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Store_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Store_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("price"));
        Store_Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        Store_ExpiredDate.setCellValueFactory(new PropertyValueFactory<Medicine, String>("ExpiredDate"));
        Store_Ribbon.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("Ribbon"));
        Store_Ribbon_Price.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("RibbonPrice"));
        MedicineList = Database.Utils.getMedicineTable();
        Store_Table.setItems(MedicineList);
    }

    
    public static void StartMedTable(
            TableColumn<Medicine, String> Med_ProdID,
            TableColumn<Medicine, String> Med_ProdName,
            TableColumn<Medicine, Double> Med_Quantity,
            TableColumn<Medicine, Double> Med_RibPrice,
            TableColumn<Medicine, Double> Med_BoxPrice,
            TableView<Medicine> MedicineTable) {
        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        Med_ProdID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Med_ProdName.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Med_Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        Med_BoxPrice.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("price"));
        Med_RibPrice.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("RibbonPrice"));
        MedicineList = Database.Utils.getMedicineTable();
        MedicineTable.setItems(MedicineList);
    }
  public static void StartMedTable_Search(
            TableColumn<Medicine, String> Med_ProdID,
            TableColumn<Medicine, String> Med_ProdName,
            TableColumn<Medicine, Double> Med_Quantity,
            TableView<Medicine> MedicineTable, String Val) {
        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        Med_ProdID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Med_ProdName.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Med_Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        MedicineList = Database.Utils.searchMedicineByValue(Val);
        MedicineTable.setItems(MedicineList);
    }
  
    public static void getShortCommingsTable( TableColumn<Medicine, String> Prod_Name,
            TableColumn<Medicine, Double> Prod_Quantity,
            TableView<Medicine> shortComingsTable
            
    ) {

        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        Prod_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Prod_Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        MedicineList = Database.Utils.getShortcomingsTable();
        shortComingsTable.setItems(MedicineList);
    }
}
