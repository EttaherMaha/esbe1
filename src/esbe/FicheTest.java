/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbe;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ellouze Skander
 */
public class FicheTest extends Application {

    @Override
    public void start(Stage Stage) throws IOException {
         Parent root=FXMLLoader.load(getClass().getResource("/Presentation/FicheClient.fxml"));
        Scene scene = new Scene(root);
        Stage.setScene(scene);
        Stage.show();
        //Alert a = new Alert(Alert.AlertType.ERROR);
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
