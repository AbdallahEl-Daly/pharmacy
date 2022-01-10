/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartPage;

import Medicine.Medicine;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class StartFormController implements Initializable {

    @FXML
    private TableView<Medicine> MedicineTable;

    @FXML
    private TableColumn<Medicine, String> Med_ProdID;

    @FXML
    private TableColumn<Medicine, String> Med_ProdName;

    @FXML
    private TableColumn<Medicine, Double> Med_Quantity;

    @FXML
    private TableColumn<Medicine, Double> Med_RibPrice;

    @FXML
    private TableColumn<Medicine, Double> Med_BoxPrice;

    @FXML
    private TextField SearchField;

    @FXML
    private TableView<Orders> OrdersTable;

    @FXML
    private TableColumn<Orders, String> Orders_ProdID;

    @FXML
    private TableColumn<Orders, String> Orders_ProdName;

    @FXML
    private TableColumn<Orders, Double> Orders_Quantity;

    @FXML
    private TableColumn<Orders, Double> Orders_Price;

    @FXML
    private Label MessageLbl;

    @FXML
    private RadioButton BoxesRB;

    @FXML
    private ToggleGroup QuantityGroup;

    @FXML
    private RadioButton RibbonsRB;

    @FXML
    private TextField Med_NameField;

    @FXML
    private TextField Med_QuantityField;

    @FXML
    private TextField CustomerCodeField;

    @FXML
    private TextField CustomerNameField;

    @FXML
    private CheckBox UnkownCustomerCheckBox;

    @FXML
    private TextField TotalCostField;

    @FXML
    private TextField PaymentField;

    @FXML
    private TextField RemainingField;

    @FXML
    private Label CustomerNameLbl;

    @FXML
    private Label SellerNameLbl;

    @FXML
    private Label CustomerCodeLbl;

    @FXML
    private RadioButton InPharmacy;

    @FXML
    private RadioButton Delivery;

    private double OrderTotalPrice;
    private double OrderQuantity;
    private int index = -1;

    ObservableList<Orders> OrdersList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Options.MedicineStore.StartMedTable(Med_ProdID, Med_ProdName, Med_Quantity, Med_RibPrice, Med_BoxPrice, MedicineTable);
        SellerNameLbl.setText(Database.Utils.getSignedInSellerData("Name"));
    }

    @FXML
    public void SearchByValue(KeyEvent evt) {
        String val = SearchField.getText();//""
        if (val.equals("")) {
            Options.MedicineStore.StartMedTable(Med_ProdID, Med_ProdName, Med_Quantity, Med_RibPrice, Med_BoxPrice, MedicineTable);
            Med_NameField.setText("");
        } else {
            Options.MedicineStore.StartMedTable_Search(Med_ProdID, Med_ProdName, Med_Quantity, MedicineTable, val);
            if (MedicineTable.getItems().size() == 1) {
                Med_NameField.setText(Med_ProdName.getCellData(0));
            } else {
                Med_NameField.setText("");
            }
        }

    }

    @FXML
    public void QuantityFieldKeyReleased(KeyEvent evt) {
        double quantityFromTextField = 0, Price = 0;
        if (Med_QuantityField.getText().equals("")) {
            MessageLbl.setText("Message!!!");
        } else {
            try {
                quantityFromTextField = Double.parseDouble(Med_QuantityField.getText());
                MessageLbl.setText("Message!!!");
                if (BoxesRB.isSelected()) {
                    OrderQuantity = quantityFromTextField;
                    Price = Med_BoxPrice.getCellData(0);
                } else if (RibbonsRB.isSelected()) {
                    OrderQuantity = quantityFromTextField / 10;
                    Price = Med_RibPrice.getCellData(0);
                }
                OrderTotalPrice = quantityFromTextField * Price;
            } catch (Exception ex) {
                MessageLbl.setText("Numbers Only!!!");
                Med_QuantityField.setText("");
            }
        }

    }

    @FXML
    public void CheckCustmerBox(ActionEvent avt) throws IOException {
        if (UnkownCustomerCheckBox.isSelected()) {
            CustomerCodeField.setDisable(true);
            CustomerNameField.setDisable(true);
            CustomerNameLbl.setText("");
            CustomerCodeLbl.setText("");

        } else {
            CustomerCodeField.setDisable(false);
            CustomerNameField.setDisable(false);
            CustomerNameLbl.setText("Customer Name :");
            CustomerCodeLbl.setText("Customer Code :");
        }
    }

    @FXML
    public void AddOrderButton(ActionEvent avt) throws IOException {
        String Pod_ID = Med_ProdID.getCellData(0);
        String Pod_Name = Med_ProdName.getCellData(0);
        if (MedicineTable.getItems().size() > 1) {
            MessageLbl.setText("Search For Medicine First!!!");
        } else {
            double quantityFromTextField = 0, Price = 0, TotalPrice = 0;
            if (Med_QuantityField.getText().equals("") || Med_QuantityField.getText().equals(" ")) {
                MessageLbl.setText("Add quantity");
            } else {
                if (!UnkownCustomerCheckBox.isSelected()) {
                    String Code = CustomerCodeField.getText();
                    if (Code.equals("")) {
                        MessageLbl.setText("Put Customer Code Or Choose Unkown Customer!!!");
                    } else {
                        String CustName = Database.Utils.getCustomerNamebyID(Code);
                        if (CustName.equals("")) {
                            MessageLbl.setText("Customer Not Exist!!!");
                        } else {
                            try {
                                quantityFromTextField = Double.parseDouble(Med_QuantityField.getText());
                                MessageLbl.setText("Message!!!");
                                if (BoxesRB.isSelected()) {
                                    OrderQuantity = quantityFromTextField;
                                    Price = Med_BoxPrice.getCellData(0);
                                } else if (RibbonsRB.isSelected()) {
                                    OrderQuantity = quantityFromTextField / 10;
                                    Price = Med_RibPrice.getCellData(0);
                                }
                                OrderTotalPrice = quantityFromTextField * Price;
                                Orders_ProdID.setCellValueFactory(new PropertyValueFactory<Orders, String>("ProductID"));
                                Orders_ProdName.setCellValueFactory(new PropertyValueFactory<Orders, String>("ProductName"));
                                Orders_Quantity.setCellValueFactory(new PropertyValueFactory<Orders, Double>("Quantity"));
                                Orders_Price.setCellValueFactory(new PropertyValueFactory<Orders, Double>("Price"));
                                OrdersList.add(new Orders(Pod_ID, Pod_Name, OrderQuantity, OrderTotalPrice));
                                OrdersTable.setItems(OrdersList);
                                for (int i = 0; i <= OrdersTable.getItems().size(); i++) {
                                    TotalPrice = TotalPrice + Double.parseDouble(Orders_Price.getCellData(i).toString());
                                    TotalCostField.setText(String.valueOf(TotalPrice));
                                }
                                MessageLbl.setText("Message!!!");
                            } catch (Exception ex) {
                                MessageLbl.setText("Numbers Only!!!");
                                Med_QuantityField.setText("");
                            }
                        }
                    }
                } else {
                    try {
                        quantityFromTextField = Double.parseDouble(Med_QuantityField.getText());
                        MessageLbl.setText("Message!!!");
                        if (BoxesRB.isSelected()) {
                            OrderQuantity = quantityFromTextField;
                            Price = Med_BoxPrice.getCellData(0);
                        } else if (RibbonsRB.isSelected()) {
                            OrderQuantity = quantityFromTextField / 10;
                            Price = Med_RibPrice.getCellData(0);
                        }
                        OrderTotalPrice = quantityFromTextField * Price;
                        Orders_ProdID.setCellValueFactory(new PropertyValueFactory<Orders, String>("ProductID"));
                        Orders_ProdName.setCellValueFactory(new PropertyValueFactory<Orders, String>("ProductName"));
                        Orders_Quantity.setCellValueFactory(new PropertyValueFactory<Orders, Double>("Quantity"));
                        Orders_Price.setCellValueFactory(new PropertyValueFactory<Orders, Double>("Price"));
                        OrdersList.add(new Orders(Pod_ID, Pod_Name, OrderQuantity, OrderTotalPrice));
                        OrdersTable.setItems(OrdersList);
                        for (int i = 0; i < OrdersTable.getItems().size(); i++) {
                            TotalPrice = TotalPrice + Double.parseDouble(Orders_Price.getCellData(i).toString());
                            TotalCostField.setText(String.valueOf(TotalPrice));
                        }
                    } catch (Exception ex) {
                        MessageLbl.setText("Numbers Only!!!");
                        Med_QuantityField.setText("");
                    }
                }

            }
        }

    }

    @FXML
    public void PaymentKeyReleased(KeyEvent evt) {
        double totalCost = 0, Payment = 0, Remaining = 0;
        totalCost = Double.parseDouble(TotalCostField.getText());
        if (PaymentField.getText().equals("")) {
            MessageLbl.setText("Message!!!");
        } else {
            try {
                Payment = Double.parseDouble(PaymentField.getText());
                Remaining = Payment - totalCost;
                RemainingField.setText(String.valueOf(Remaining));
            } catch (Exception ex) {
                MessageLbl.setText("Numbers Only!!!");
                PaymentField.setText("");
            }
        }

    }

    @FXML
    public void CustomerCodeKeyReleased(KeyEvent evt) {
        String Code = CustomerCodeField.getText();
        if (Code.equals("")) {
            CustomerNameField.setText("");
        } else {
            CustomerNameField.setText(Database.Utils.getCustomerNamebyID(Code));
        }

    }

    @FXML
    public void TableMouseClick(MouseEvent evt) throws IOException {
        index = OrdersTable.getSelectionModel().getSelectedIndex();
        if (index == -1) {
        }
    }

    @FXML
    public void DeleteOrderFromTable(ActionEvent avt) throws IOException {
        int choice = JOptionPane.showConfirmDialog(null,
                "Are You Sure Deleting Order Of Medicine,"
                + Orders_ProdName.getCellData(index) + "  ?");
        if (choice == 0) {
            OrdersTable.getItems().remove(index);
        }
    }

    @FXML
    public void sellOrder(ActionEvent avt) throws IOException {
        String SellerId = Database.Utils.getSignedInSellerData("ID");
        String SellerName = Database.Utils.getSignedInSellerData("Name");
        String CustomerId, ProductId, ProductName, Statues = null;
        double Quantity, Price;
        if (InPharmacy.isSelected()) {
            Statues = "In Pharmacy";
        } else if (Delivery.isSelected()) {
            Statues = "Delivery";
        }
        if (UnkownCustomerCheckBox.isSelected()) {
            CustomerId = "Unkown";
        } else {
            CustomerId = CustomerCodeField.getText();
        }
        for (int i = 0; i < OrdersTable.getItems().size(); i++) {
            ProductId = Orders_ProdID.getCellData(i);
            ProductName = Orders_ProdName.getCellData(i);
            Quantity = Orders_Quantity.getCellData(i);
            Price = Orders_Price.getCellData(i);
            Database.Utils.InsertsellingProcess(SellerId, SellerName, CustomerId,
                    ProductId, ProductName, Quantity, Price, Statues);
        }
        MessageLbl.setText("Order Soled");
        OrdersTable.getItems().remove(0, OrdersTable.getItems().size());
        RemainingField.setText("");
        PaymentField.setText("");
        SearchField.setText("");
        Med_NameField.setText("");
        Med_QuantityField.setText("");
        TotalCostField.setText("");
        PaymentField.setText("");
        RemainingField.setText("");
        CustomerCodeField.setText("");
        CustomerNameField.setText("");
        Options.MedicineStore.StartMedTable(Med_ProdID, Med_ProdName, 
                Med_Quantity, Med_RibPrice, Med_BoxPrice, MedicineTable);

    }

}
