package pharmacy_app;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Pharmacy_App extends Application {
    
    @Override
    public void start(Stage primaryStage)  {
        try{
            Parent root= FXMLLoader.load(getClass().getResource("/Login/LoginForm.fxml"));  
            Scene scene = new Scene(root);      
            primaryStage.setScene(scene);
            primaryStage.getIcons().add(new Image("/Images/pharmacy.png"));
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
