
package Options;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class getFunction {
    /**
     * This function Takes Data of User to sign it up for the first Time and returns the message in MessageLbl Parameter
     * @param username
     * @param sellerID
     * @param Pass
     * @param RePass
     * @param Phone1
     * @param Phone2
     * @param Staff
     * @param Admin
     * @param MessageLbl 
     */
    public static void SignUp(String username, String sellerID, String Pass,
            String RePass, String Phone1, String Phone2, RadioButton Staff,
            RadioButton Admin, Label MessageLbl){
        if (username.equals("") || sellerID.equals("") || Pass.equals("")
                || RePass.equals("") || Phone1.equals("") || Phone2.equals("")) {
            MessageLbl.setText("Incompleted Data!!!");
        } else if ((!Admin.isSelected() && (!Staff.isSelected()))) {
            MessageLbl.setText("Choose Departement First!!!");
        } else if (Pass.equals(RePass)) {
            if (Staff.isSelected()) {
                Database.Utils.insertUser(sellerID, Pass, username, Phone1, Phone2, "Staff");
            } else if (Admin.isSelected()) {
                Database.Utils.insertUser(sellerID, Pass, username, Phone1, Phone2, "Admin");
            }
            MessageLbl.setText("User Created Successfully");
        } else {
            MessageLbl.setText("Password Doesn't Match!!");
        }
    }
    
    public void OpenWindow(String PageLocation) throws IOException{
        ActionEvent ev = new ActionEvent();
        Stage close = new Stage();
        close = (Stage) ((Button) ev.getSource()).getScene().getWindow();
        close.close();
        Stage stage = new Stage();
        Parent part = FXMLLoader.load(getClass().getResource(PageLocation));
        Scene scene = new Scene(part);
        stage.setScene(scene);
        stage.show();  
    }
    
}
