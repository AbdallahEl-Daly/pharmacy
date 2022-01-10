package Options;

import Medicine.Medicine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MedicineAddFormTable {

    public static void getTable(
            TableColumn<Medicine, String> tableID,
            TableColumn<Medicine, String> tableName,
            TableColumn<Medicine, Double> tableQuantity,
            TableColumn<Medicine, Integer> tableRibbon,
            TableColumn<Medicine, Double> tableRibbonPrice,
            TableColumn<Medicine, Double> tablePrice,
            TableColumn<Medicine, String> tableExpiredDate,
            TableView<Medicine> MedicineTableAddForm
    ) {

        ObservableList<Medicine> MedicineList;
        tableID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        tableName.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        tableQuantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        tableRibbon.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("Ribbon"));
        tableRibbonPrice.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("RibbonPrice"));
        tablePrice.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("price"));
        tableExpiredDate.setCellValueFactory(new PropertyValueFactory<Medicine, String>("ExpiredDate"));
        MedicineList = Database.Utils.getMedicineTable();
        MedicineTableAddForm.setItems(MedicineList);
    }

    public static void refreshTable(
            TableColumn<Medicine, String> tableID,
            TableColumn<Medicine, String> tableName,
            TableColumn<Medicine, Double> tableQuantity,
            TableColumn<Medicine, Integer> tableRibbon,
            TableColumn<Medicine, Double> tableRibbonPrice,
            TableColumn<Medicine, Double> tablePrice,
            TableColumn<Medicine, String> tableExpiredDate,
            TableView<Medicine> MedicineTableAddForm) {

        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        tableID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        tableName.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        tableQuantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        tableRibbon.setCellValueFactory(new PropertyValueFactory<Medicine, Integer>("Ribbon"));
        tableRibbonPrice.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("RibbonPrice"));
        tablePrice.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("price"));//ExpiredDate
        tableExpiredDate.setCellValueFactory(new PropertyValueFactory<Medicine, String>("ExpiredDate"));
        MedicineList = Database.Utils.getMedicineTable();
        MedicineTableAddForm.setItems(MedicineList);

    }

    public static void getPillsTable(
            TableColumn<Medicine, String> Product_ID,
            TableColumn<Medicine, String> Product_Name,
            TableColumn<Medicine, Double> Quantity,
            TableView<Medicine> PillsTable
    ) {

        ObservableList<Medicine> MedicineList;
        Product_ID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Product_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        MedicineList = Database.Utils.getMedicineTable();
        PillsTable.setItems(MedicineList);
    }

    public static void refreshPillsTable(
            TableColumn<Medicine, String> Product_ID,
            TableColumn<Medicine, String> Product_Name,
            TableColumn<Medicine, Double> Quantity,
            TableView<Medicine> PillsTable
    ) {
        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        Product_ID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Product_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        MedicineList = Database.Utils.getMedicineTable();
        PillsTable.setItems(MedicineList);
    }
    
    
    public static void getPillsTableByID(
            TableColumn<Medicine, String> Product_ID,
            TableColumn<Medicine, String> Product_Name,
            TableColumn<Medicine, Double> Quantity,
            TableView<Medicine> PillsTable,int ID
    ) {
        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        Product_ID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Product_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        MedicineList =  Database.Utils.searchMedicineByID(ID);
        PillsTable.setItems(MedicineList);
    }
    
    public static void getPillsTableByName(
            TableColumn<Medicine, String> Product_ID,
            TableColumn<Medicine, String> Product_Name,
            TableColumn<Medicine, Double> Quantity,
            TableView<Medicine> PillsTable,String Name
    ) {
        ObservableList<Medicine> MedicineList = FXCollections.observableArrayList();
        MedicineList.clear();
        Product_ID.setCellValueFactory(new PropertyValueFactory<Medicine, String>("MedicineID"));
        Product_Name.setCellValueFactory(new PropertyValueFactory<Medicine, String>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Medicine, Double>("quantity"));
        MedicineList =  Database.Utils.searchMedicineByName(Name);
        PillsTable.setItems(MedicineList);
    }
}
