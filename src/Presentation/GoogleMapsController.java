/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ellouze Skander
 */
public class GoogleMapsController extends Application {
     
    private Scene scene;
    MyBrowser myBrowser;
     
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Google map");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(600);
        myBrowser = new MyBrowser();
        scene = new Scene(myBrowser, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }

   
     
    class MyBrowser extends Region {
        HBox toolbar;
         
        WebView webView = new WebView();
        WebEngine webEngine = webView.getEngine();
        
         
         
        public MyBrowser(){
          
            final URL urlGoogleMaps = getClass().getResource("GoogleMapsV3.html");
            webEngine.load(urlGoogleMaps.toExternalForm());
            webEngine.setJavaScriptEnabled(true);
             
            getChildren().add(webView);
          
      }
    }
}
