/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginFormController implements Initializable {

    @FXML
    TextField LgnUseridField;
    @FXML
    PasswordField LgnPasswordField;
    @FXML
    Label MessageLbl;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void btnFunctionOnClick(ActionEvent ev) throws IOException {
        Stage close = new Stage();
        close = (Stage) ((Button) ev.getSource()).getScene().getWindow();
        close.close();
        Stage stage = new Stage();
        Parent part = FXMLLoader.load(getClass().getResource("/SignUp/SignUp.fxml"));
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void LoginBtn(ActionEvent evt) throws IOException {
        String username = LgnUseridField.getText();
        String Password = LgnPasswordField.getText();
        boolean Loged = Database.Utils.loginVerfication(username, Password);
        if (Loged) {
            Stage close = new Stage();
            close = (Stage) ((Button) evt.getSource()).getScene().getWindow();
            close.close();
            Stage stage = new Stage();
            Parent part = FXMLLoader.load(getClass().getResource("/HomePage/HomePage.fxml"));
            Scene scene = new Scene(part);
            stage.setScene(scene);
            stage.setTitle("Home Page");
            stage.setMaximized(true);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();            
        } else {
            MessageLbl.setText("");
            MessageLbl.setText("Login Failed");
        }
    }
    
    
    @FXML
    public void ExitBTN(ActionEvent ev) throws IOException {        
        System.exit(0);
    }


}
