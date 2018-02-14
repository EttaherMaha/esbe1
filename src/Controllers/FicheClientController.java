/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataStorage.MyDB;
import Entities.Etablissement;
import Entities.Fiche_Client;
import Services.EtablissementService;
import Services.Fiche_ClientService;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Ellouze Skander
 */
public class FicheClientController implements Initializable {

    
    @FXML
    private TableView<Fiche_Client> tableFiche;
    
    @FXML
    private TextField txtRecherche;

    @FXML
    private TableColumn<?, ?> suivie;

    @FXML
    private ComboBox<?> comboPatient;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private Button btnAjouter;

    @FXML
    private TableColumn<?, ?> nom;

    @FXML
    private TableColumn<?, ?> etab;

    @FXML
    private Button btnSupprimer;
    /**
     * Initializes the controller class.
     */
    Fiche_ClientService cs= new Fiche_ClientService();
    private ObservableList<Fiche_Client> data;
    
    Connection connexion;

    public FicheClientController() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
            List<Fiche_Client> LE = cs.afficherToutFicheClient();
            data = FXCollections.observableArrayList();
            Etablissement e;
            
            LE.stream().forEach((j)-> {
                data.add(j);
            });
            
            tableFiche.setItems(data);
            
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            suivie.setCellValueFactory(new PropertyValueFactory<>("suivie"));
            nom.setCellValueFactory(new PropertyValueFactory<>("id_user"));
            etab.setCellValueFactory(new PropertyValueFactory<>("id_etab"));
             
    } 
    
    
    @FXML
    public void chercher()
    {
     Fiche_ClientService es = new Fiche_ClientService();
     data=es.rechercherFiche_Client(txtRecherche.getText().toString());

            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            suivie.setCellValueFactory(new PropertyValueFactory<>("suivie"));
            nom.setCellValueFactory(new PropertyValueFactory<>("id_user"));
            etab.setCellValueFactory(new PropertyValueFactory<>("id_etab"));
      
     tableFiche.setItems(data);
   //  afficher();
    } 
    
}
