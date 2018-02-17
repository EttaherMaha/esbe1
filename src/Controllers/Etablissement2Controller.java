/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Etablissement;
import Services.EtablissementService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ellouze Skander
 */
public class Etablissement2Controller implements Initializable {

        @FXML
    private ListView<Etablissement> listeEtab;
    /**
     * Initializes the controller class.
     */
        
        EtablissementService cs= new EtablissementService();
        Etablissement e = new Etablissement();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<Etablissement> LE = cs.afficherEtablissement();
     LE.stream().forEach((j)-> {
         listeEtab.getItems().add(j);
         
     });
     
    }  
    
    @FXML
    public void afficher()
    {
        listeEtab.getItems().clear();
          List<Etablissement> LE = cs.afficherEtablissement();
     
     LE.stream().forEach((j)-> {
         listeEtab.getItems().add(j);

 });
     
    }
    
    
      @FXML
     public void supprimer()
   {
    Etablissement e= listeEtab.getSelectionModel().getSelectedItem();
    EtablissementService cs= new EtablissementService();
    cs.supprimerEtablissement(e);
    
    
afficher();
     listeEtab.refresh();
}
     
     @FXML
    public void Ajouter (ActionEvent event) throws IOException
    {
      //   Alert a = new Alert(Alert.AlertType.ERROR);
      //   System.out.println("vegerge");
       //  a.show();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/Presentation/AjouterEtablissement.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
