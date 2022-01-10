/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SignUp;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;


/**
 * FXML Controller class
 *
 * @author hp
 */
public class SignUpController implements Initializable {

    @FXML
    Label Phone2Lbl;
    @FXML
    Label Phone1Lbl;
    @FXML
    Label rePassLbl;
    @FXML
    Label PassLbl;
    @FXML
    Label UsernameLBl;
    @FXML
    Label SignUpLbl;
    @FXML
    Label SellerIDLbl;
    @FXML
    Label MessageLbl;
    @FXML
    Label DepartmentLbl;
    @FXML
    TextField Username;
    @FXML
    TextField Phone2Field;
    @FXML
    TextField Phone1Field;
    @FXML
    TextField rePassField;
    @FXML
    TextField PassField;
    @FXML
    TextField SellerIDField;
    @FXML
    TextField LgnPasswordField;
    @FXML
    TextField LgnUseridField;
    @FXML
    Button SignUpbtn;
    @FXML
    RadioButton Staff;
    @FXML
    RadioButton Admin;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SignUpLbl.setText(null);
        SellerIDLbl.setText(null);
        UsernameLBl.setText(null);
        PassLbl.setText(null);
        rePassLbl.setText(null);
        Phone1Lbl.setText(null);
        Phone2Lbl.setText(null);
        DepartmentLbl.setText(null);
        Username.setVisible(false);
        SellerIDField.setVisible(false);
        PassField.setVisible(false);
        rePassField.setVisible(false);
        Phone1Field.setVisible(false);
        Phone2Field.setVisible(false);
        SignUpbtn.setVisible(false);
        Admin.setVisible(false);
        Staff.setVisible(false);
    }

    public void LoginbtnAction(ActionEvent ev) throws IOException {
        String userid = LgnUseridField.getText();
        String Pass = LgnPasswordField.getText();
        if (userid.equals("") || Pass.equals("")) {
            MessageLbl.setText("Incompleted Data!!!");
        } else {
            boolean Loged = Database.Utils.loginVerfication(userid, Pass);
            if (Loged) {
                SignUpLbl.setText("SignUp Your Data");
                SellerIDLbl.setText("Seller ID :");
                UsernameLBl.setText("Name :");
                PassLbl.setText("Password :");
                rePassLbl.setText("Re-Password :");
                Phone1Lbl.setText("Phone 1 :");
                Phone2Lbl.setText("Phone 2 :");
                DepartmentLbl.setText("Department :");
                Username.setVisible(true);
                SellerIDField.setVisible(true);
                PassField.setVisible(true);
                rePassField.setVisible(true);
                Phone1Field.setVisible(true);
                Phone2Field.setVisible(true);
                SignUpbtn.setVisible(true);
                Admin.setVisible(true);
                Staff.setVisible(true);
                MessageLbl.setText("Message !!");
            } else {
                MessageLbl.setText("Your Are Not Allowed!!!");
            }

        }
    }

    public void SignUp(ActionEvent ev) throws IOException {
        String username = Username.getText();
        String sellerID = SellerIDField.getText();
        String Pass = PassField.getText();
        String RePass = rePassField.getText();
        String Phone1 = Phone1Field.getText();
        String Phone2 = Phone2Field.getText();
        Options.getFunction.SignUp(username, sellerID, Pass, RePass, Phone1,
                Phone2, Staff, Admin, MessageLbl);
    }

}
