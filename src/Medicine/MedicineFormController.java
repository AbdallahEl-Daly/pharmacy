/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicine;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MedicineFormController implements Initializable {

    @FXML
    Button AddMedicineBtn;
    @FXML
    private TextField MedicineID;
    @FXML
    private TextField MedicineName;
    @FXML
    private TextField Price;
    @FXML
    private TextField Quantity;
    @FXML
    private TextField RibbonPrice;
    @FXML
    private TextField RibbonSize;
    @FXML
    private TextField SearchMedicineID;
    @FXML
    private TextField SearchMedicineName;
    @FXML
    private DatePicker ExpiredDate;
    @FXML
    private Label MessageLbl;
    @FXML
    private Label MedicineNameLbl;
    @FXML
    private Label MedicineIdLbl;
    @FXML
    private Label DateOfDB;
    @FXML
    private Label Star1;
    @FXML
    private Label Star2;
    @FXML
    private Label Star3;
    @FXML
    private Button NameSearchBtn;
    @FXML
    private Button idSearchBtn;
    @FXML
    private Button EditMedicine;
    @FXML
    private TableView<Medicine> MedicineTableAddForm;
    @FXML
    private TableColumn<Medicine, String> tableID;
    @FXML
    private TableColumn<Medicine, String> tableName;
    @FXML
    private TableColumn<Medicine, Double> tableQuantity;
    @FXML
    private TableColumn<Medicine, Double> tablePrice;
    @FXML
    private TableColumn<Medicine, Integer> tableRibbon;
    @FXML
    private TableColumn<Medicine, Double> tableRibbonPrice;
    @FXML
    private TableColumn<Medicine, String> tableExpiredDate;
    @FXML
    private TableView<Medicine> Store_Table;

    @FXML
    private TableColumn<Medicine, String> Store_ID;

    @FXML
    private TableColumn<Medicine, String> Store_Name;

    @FXML
    private TableColumn<Medicine, Double> Store_Price;

    @FXML
    private TableColumn<Medicine, Double> Store_Quantity;

    @FXML
    private TableColumn<Medicine, String> Store_ExpiredDate;

    @FXML
    private TableColumn<Medicine, Integer> Store_Ribbon;

    @FXML
    private TableColumn<Medicine, Double> Store_Ribbon_Price;

    @FXML
    private TextField Search_ID;

    @FXML
    private TextField Search_Name;

    @FXML
    private Label MessageLbl1;

    @FXML
    private TextField Search_ExpiredMonth;

    @FXML
    private RadioButton AddOperation;

    @FXML
    private ToggleGroup Operation;

    @FXML
    private RadioButton SearchOperation;

    private int index = -1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MedicineNameLbl.setText("");
        MedicineIdLbl.setText("");
        SearchMedicineID.setVisible(false);
        SearchMedicineName.setVisible(false);
        NameSearchBtn.setVisible(false);
        idSearchBtn.setVisible(false);
        Quantity.setDisable(true);
        MedicineName.setDisable(true);
        MedicineID.setDisable(true);
        EditMedicine.setDisable(true);
        Star1.setText("");
        Star2.setText("");
        Star3.setText("");
        Options.MedicineAddFormTable.getTable(
                tableID,
                tableName,
                tableQuantity,
                tableRibbon,
                tableRibbonPrice,
                tablePrice,
                tableExpiredDate,
                MedicineTableAddForm);
        Options.MedicineStore.getTable(Store_ID, Store_Name, Store_Price,
                Store_Quantity, Store_ExpiredDate,
                Store_Ribbon, Store_Ribbon_Price, Store_Table);
    }

    @FXML
    public void AddMedicineBtn(ActionEvent evt) throws IOException {
        String ID = MedicineID.getText();
        String Name = MedicineName.getText();
        String priceVal = Price.getText();
        String quantityVal = Quantity.getText();
        String NoOfRibbon = RibbonSize.getText();
        String Ribbonprice = RibbonPrice.getText();
        Star1.setText("");
        Star2.setText("");
        Star3.setText("");
        boolean NameExist = Database.Utils.medicineExist_Name_ID(Name);
        boolean IDExist = Database.Utils.medicineExist_Name_ID(ID);

        if (ID.equals("") || Name.equals("") || priceVal.equals("")
                || quantityVal.equals("") || NoOfRibbon.equals("")
                || Ribbonprice.equals("")) {
            MessageLbl.setText("Incompleted Data!!");
        } else {
            if (NameExist || IDExist) {
                MessageLbl.setText("This Medicine Exists!!");
            } else {
                double price = Double.parseDouble(priceVal);
                double quantity = Double.parseDouble(quantityVal);
                double RibPrice = Double.parseDouble(Ribbonprice);
                int Ribbon = Integer.parseInt(NoOfRibbon);
                char Char = Name.toUpperCase().charAt(0);
                try {
                    LocalDate expired = ExpiredDate.getValue();
                    LocalDate NowDate = LocalDate.now();
                    if (expired.isBefore(NowDate)) {
                        MessageLbl.setText("This Date is invalid...!!");
                    } else {
                        String ExpiredDate = expired.toString();
                        Database.Utils.addMedicine(ID, Name, Char, quantity, price, Ribbon, RibPrice, ExpiredDate);
                        MessageLbl.setText("Medicine : " + Name + ", has been added Successfully");
                        MedicineID.setText("");
                        RibbonPrice.setText("");
                        RibbonSize.setText("");
                        Quantity.setText("");
                        Price.setText("");
                        MedicineName.setText("");
                        Options.MedicineAddFormTable.refreshTable(tableID,
                                tableName, tableQuantity, tableRibbon, tableRibbonPrice,
                                tablePrice, tableExpiredDate, MedicineTableAddForm);
                    }
                } catch (Exception ex) {
                    MessageLbl.setText("Choose Expired Date First!!");
                }
            }
        }

    }

    @FXML
    public void SearchMedicineName(ActionEvent evt) throws IOException {
        String Name = SearchMedicineName.getText();
        Star1.setText("");
        Star2.setText("");
        Star3.setText("");
        if (Name.equals("")) {
            MessageLbl.setText("Type Medicine Name First!!");
        } else {
            String data[] = new String[7];
            data = Database.Utils.findMedicinebyName(Name);
            if (data[0].equals("notExist")) {
                MessageLbl.setText("Medicine Not Found!!");
            } else {
                MedicineID.setText(data[0]);
                MedicineName.setText(data[1]);
                Quantity.setText(data[2]);
                Price.setText(data[3]);
                RibbonSize.setText(data[4]);
                RibbonPrice.setText(data[5]);
                DateOfDB.setText(data[6]);
                MessageLbl.setText("Medicine is here...");
            }
        }
    }

    @FXML
    public void SearchMedicineID(ActionEvent evt) throws IOException {
        String ID = SearchMedicineID.getText();
        Star1.setText("");
        Star2.setText("");
        Star3.setText("");
        if (ID.equals("")) {
            MessageLbl.setText("Type Medicine ID First!!");
        } else {
            String data[] = new String[7];
            data = Database.Utils.findMedicinebyId(ID);
            if (data[0].equals("notExist")) {
                MessageLbl.setText("Medicine Not Found!!");
            } else {
                MedicineID.setText(data[0]);
                MedicineName.setText(data[1]);
                Quantity.setText(data[2]);
                Price.setText(data[3]);
                RibbonSize.setText(data[4]);
                RibbonPrice.setText(data[5]);
                DateOfDB.setText(data[6]);
                MessageLbl.setText("Medicine is here...");
            }
        }
    }

    @FXML
    public void editMedicine(ActionEvent evt) throws IOException {
        String NoOfRibbon = RibbonSize.getText();
        String Ribbonprice = RibbonPrice.getText();
        String priceVal = Price.getText();
        String ProductId = MedicineID.getText();
        if (NoOfRibbon.equals("") || Ribbonprice.equals("") || priceVal.equals("")) {
            MessageLbl.setText("Make sure, These Fields are Full");
            Star1.setText("*");
            Star2.setText("*");
            Star3.setText("*");
        } else {
            try {
                LocalDate expired = ExpiredDate.getValue();
                String Date = expired.toString();
                Database.Utils.editMedicine(ProductId, Double.parseDouble(priceVal),
                        Integer.parseInt(NoOfRibbon), Double.parseDouble(Ribbonprice), Date);
                MessageLbl.setText("Medicine Data Updated Successfully");
                Options.MedicineAddFormTable.refreshTable(tableID,
                        tableName, tableQuantity, tableRibbon, tableRibbonPrice,
                        tablePrice, tableExpiredDate, MedicineTableAddForm);
            } catch (Exception ex) {
                String DateExpired = DateOfDB.getText();
                Database.Utils.editMedicine(ProductId, Double.parseDouble(priceVal),
                        Integer.parseInt(NoOfRibbon), Double.parseDouble(Ribbonprice), DateExpired);
                MessageLbl.setText("Medicine Data Updated Successfully");
                Options.MedicineAddFormTable.refreshTable(tableID,
                        tableName, tableQuantity, tableRibbon, tableRibbonPrice,
                        tablePrice, tableExpiredDate, MedicineTableAddForm);
            }
        }

    }

    @FXML
    public void Add_RadioButton(ActionEvent evt) throws IOException {
        idSearchBtn.setVisible(false);
        NameSearchBtn.setVisible(false);
        SearchMedicineID.setVisible(false);
        SearchMedicineName.setVisible(false);
        EditMedicine.setDisable(true);
        MedicineIdLbl.setText("");
        MedicineNameLbl.setText("");
        Quantity.setDisable(false);
        MedicineName.setDisable(false);
        MedicineID.setDisable(false);
    }

    @FXML
    public void Search_RadioButton(ActionEvent evt) throws IOException {
        MedicineNameLbl.setText("Medicine Name :");
        MedicineIdLbl.setText("Medicine Id :");
        SearchMedicineID.setVisible(true);
        SearchMedicineName.setVisible(true);
        NameSearchBtn.setVisible(true);
        idSearchBtn.setVisible(true);
        Quantity.setDisable(true);
        MedicineName.setDisable(true);
        MedicineID.setDisable(true);
        EditMedicine.setDisable(true);
        Star1.setText("");
        Star2.setText("");
        Star3.setText("");
    }

    @FXML
   public final EventHandler<Event> refreshMedicine_Table(){
        Options.MedicineAddFormTable.refreshTable(tableID,
                        tableName, tableQuantity, tableRibbon, tableRibbonPrice,
                        tablePrice, tableExpiredDate, MedicineTableAddForm);
        return null;
    }
   
    @FXML
   public final EventHandler<Event> refreshStore_Table(){
      Options.MedicineStore.refreshTable(
                    Store_ID, Store_Name, Store_Price,
                    Store_Quantity, Store_ExpiredDate,
                    Store_Ribbon, Store_Ribbon_Price,
                    Store_Table
            );
        return null;
    }
   
    @FXML
    public void Edit_RadioButton(ActionEvent evt) throws IOException {
        Quantity.setDisable(true);
        MedicineName.setDisable(true);
        MedicineID.setDisable(true);
        EditMedicine.setDisable(false);
        idSearchBtn.setVisible(false);
        NameSearchBtn.setVisible(false);
        SearchMedicineID.setVisible(false);
        SearchMedicineName.setVisible(false);
        MedicineIdLbl.setText("");
        MedicineNameLbl.setText("");
        Star1.setText("");
        Star2.setText("");
        Star3.setText("");
    }
    @FXML
    public void SearchByID(KeyEvent evt) {
        String ID = Search_ID.getText();//""
        if (ID.equals("")) {
            Options.MedicineStore.refreshTable(
                    Store_ID, Store_Name, Store_Price,
                    Store_Quantity, Store_ExpiredDate,
                    Store_Ribbon, Store_Ribbon_Price,
                    Store_Table
            );
        } else {
            Options.MedicineStore.getTableSearchedByID(
                    Store_ID, Store_Name, Store_Price,
                    Store_Quantity, Store_ExpiredDate,
                    Store_Ribbon, Store_Ribbon_Price,
                    Store_Table, Integer.parseInt(ID));
        }

    }

    @FXML
    public void SearchByName(KeyEvent evt) {
        String Name = Search_Name.getText();//""
        if (Name.equals("")) {
            Options.MedicineStore.refreshTable(
                    Store_ID, Store_Name, Store_Price,
                    Store_Quantity, Store_ExpiredDate,
                    Store_Ribbon, Store_Ribbon_Price,
                    Store_Table
            );
        } else {
            Options.MedicineStore.getTableSearchedByName(
                    Store_ID, Store_Name, Store_Price,
                    Store_Quantity, Store_ExpiredDate,
                    Store_Ribbon, Store_Ribbon_Price,
                    Store_Table, Name);
        }

    }

    @FXML
    public void SearchByExpiredMonth(KeyEvent evt) {
        String Month = Search_ExpiredMonth.getText();//""
        if (Month.equals("")) {
            Options.MedicineStore.refreshTable(
                    Store_ID, Store_Name, Store_Price,
                    Store_Quantity, Store_ExpiredDate,
                    Store_Ribbon, Store_Ribbon_Price,
                    Store_Table
            );
        } else {
            Options.MedicineStore.getTableSearchedByExpiredDate(
                    Store_ID, Store_Name, Store_Price,
                    Store_Quantity, Store_ExpiredDate,
                    Store_Ribbon, Store_Ribbon_Price,
                    Store_Table, Month);
        }

    }

    @FXML
    public void SearchByNameAction(MouseEvent evt) throws IOException {
        Search_ID.setText("");
        Search_ExpiredMonth.setText("");
        Options.MedicineStore.refreshTable(
                Store_ID, Store_Name, Store_Price,
                Store_Quantity, Store_ExpiredDate,
                Store_Ribbon, Store_Ribbon_Price,
                Store_Table
        );
    }

    @FXML
    public void SearchByIDAction(MouseEvent evt) throws IOException {
        Search_Name.setText("");
        Search_ExpiredMonth.setText("");
        Options.MedicineStore.refreshTable(
                Store_ID, Store_Name, Store_Price,
                Store_Quantity, Store_ExpiredDate,
                Store_Ribbon, Store_Ribbon_Price,
                Store_Table
        );
    }

    @FXML
    public void SearchByExcpiredMonthAction(MouseEvent evt) throws IOException {
        Search_Name.setText("");
        Search_ID.setText("");
        Options.MedicineStore.refreshTable(
                Store_ID, Store_Name, Store_Price,
                Store_Quantity, Store_ExpiredDate,
                Store_Ribbon, Store_Ribbon_Price,
                Store_Table
        );
    }

    @FXML
    public void TableMouseClick(MouseEvent evt) throws IOException {
        index = MedicineTableAddForm.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            return;
        }
        MedicineID.setText(tableID.getCellData(index));
        MedicineName.setText(tableName.getCellData(index));
        Quantity.setText(tableQuantity.getCellData(index).toString());
        RibbonSize.setText(tableRibbon.getCellData(index).toString());
        RibbonPrice.setText(tableRibbonPrice.getCellData(index).toString());
        Price.setText(tablePrice.getCellData(index).toString());
        DateOfDB.setText(tableExpiredDate.getCellData(index));
    }

    @FXML
    public void trancateFields(MouseEvent evt) throws IOException {
        MedicineID.setText("");
        MedicineName.setText("");
        Quantity.setText("");
        RibbonPrice.setText("");
        Price.setText("");
        DateOfDB.setText("");
        RibbonSize.setText("");
    }
}
