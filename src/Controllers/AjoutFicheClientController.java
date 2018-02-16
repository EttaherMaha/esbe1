/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entities.Fiche_Client;
import Services.Fiche_ClientService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ellouze Skander
 */
public class AjoutFicheClientController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
    private Button ajouter;

    @FXML
    private TextField suivie;
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
     
        
    }
  
        
        
        
            @FXML
    void AjouterFiche(ActionEvent event) 
    {
        Fiche_ClientService fs= new Fiche_ClientService();
        Fiche_Client f= new Fiche_Client(suivie.getText(),1,35);
        fs.ajouterFicheClient(f);
    }
        
}
