/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomePage;

import Medicine.Medicine;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomePageController implements Initializable {

    @FXML
    Label MedicineLbl;

    @FXML
    private Label DateLBL;

    @FXML
    private Label DayOfWeekLbl;

    @FXML
    private Label HoursLabl;

    @FXML
    private Label DeliveryNumbersLbl;

    @FXML
    private Label InPharmacyNumbersLbl;

    @FXML
    private Label DocNameLbl;

    @FXML
    private TableView<Medicine> shortComingsTable;

    @FXML
    private TableColumn<Medicine, String> Prod_Name;

    @FXML
    private TableColumn<Medicine, Double> Prod_Quantity;

    private Date nowDate,date;

    private final SimpleDateFormat formated = new SimpleDateFormat("hh:mm:ss aa");
    private final SimpleDateFormat dateformated = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat weekFormated = new SimpleDateFormat("EEEE");
    private String nowTime;

    private Thread clock, Orders;

    private int DeliveryNum, InPharmacyNum;
    int[] OrdersFromDB = new int[2];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DocNameLbl.setText("Dr. " + Database.Utils.getSignedInSellerData("Name"));
        Options.MedicineStore.getShortCommingsTable(Prod_Name, Prod_Quantity, shortComingsTable);
        date = new Date();
        DateLBL.setText(dateformated.format(date));
        DayOfWeekLbl.setText(weekFormated.format(date));
        ThreadFunc();
        RefreshOrders();
    }

    private void ThreadFunc() {
        clock = new Thread() {
            public void run() {
                while (true) {
                    nowDate = new Date();
                    nowTime = formated.format(nowDate);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            HoursLabl.setText(nowTime);
                        }
                    });
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        clock.start();
    }

    private void RefreshOrders() {
        Orders = new Thread() {
            public void run() {
                while (true) {
                    Platform.runLater(new Runnable() {
                        public void run() {
                            OrdersFromDB = Database.Utils.ordersNum();
                            DeliveryNumbersLbl.setText(String.valueOf(OrdersFromDB[0]));
                            InPharmacyNumbersLbl.setText(String.valueOf(OrdersFromDB[1]));
                            Options.MedicineStore.getShortCommingsTable(Prod_Name, Prod_Quantity, shortComingsTable);
                        }
                    });

                    try {
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        };
        Orders.start();

    }
//    TimerTask task = new TimerTask(1000,new ActionListener(){
//        @Override 
//        public void actionPerformed(ActionEvent e){
//            System.out.println("Hello");
//        }
//    });

    @FXML
    public void StartBtn(MouseEvent evt) throws IOException {
        Stage stage = new Stage();
        Parent part = FXMLLoader.load(getClass().getResource("/StartPage/startForm.fxml"));
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setTitle("Pharmacy");
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void MedicineAction(MouseEvent evt) throws IOException {
        /*Stage close = new Stage();
        close = (Stage) ((Button) evt.getSource()).getScene().getWindow();
        close.close();*/
        Stage stage = new Stage();
        Parent part = FXMLLoader.load(getClass().getResource("/Medicine/MedicineForm.fxml"));
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setTitle("Medicine Section");
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void CustomersBtn(MouseEvent evt) throws IOException {
        Stage stage = new Stage();
        Parent part = FXMLLoader.load(getClass().getResource("/Customers/CustomersForm.fxml"));
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setTitle("Customer Section");
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void SuppliersBtn(MouseEvent evt) throws IOException {
        Stage stage = new Stage();
        Parent part = FXMLLoader.load(getClass().getResource("/Suppliers/Supplier.fxml"));
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setTitle("Supplier Section");
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void OperationsBtn(MouseEvent evt) throws IOException {
        Stage stage = new Stage();
        Parent part = FXMLLoader.load(getClass().getResource("/Operations/operationsForm.fxml"));
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setTitle("Operations Section");
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void StorePillsBtn(MouseEvent evt) throws IOException {
        Stage stage = new Stage();
        Parent part = FXMLLoader.load(getClass().getResource("/storePills/storePillsForm.fxml"));
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setTitle("Store Pills Section");
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void OurTeamBtn(MouseEvent evt) throws IOException {
        Stage stage = new Stage();
        Parent part = FXMLLoader.load(getClass().getResource("/pharmacy_app/Team.fxml"));
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.setTitle("Our Team Section");
        stage.setMaximized(true);
        stage.show();
    }

    @FXML
    public void LogOutBtn(MouseEvent evt) throws IOException {
        Database.Utils.loginedOut();
        clock.stop();
        Orders.stop();
        System.exit(0);
    }

}
