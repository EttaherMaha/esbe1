/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataStorage.MyDB;
import Entities.Etablissement;
import Services.EtablissementService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ellouze Skander
 */
public class EtablissementController  implements Initializable {

    @FXML
    private TableColumn<Etablissement, Timestamp> Heure_ouverture;

    @FXML
    private TextField txtRecherche;

    @FXML
    private TableColumn<Etablissement, String> Nom;

    @FXML
    private Button btnAfficher;

    @FXML
    private TableColumn<Etablissement, String> Date_ouverture;

    @FXML
    private Button AjouterButton;

    @FXML
    private Button SupprimerButton;

    @FXML
    private Button ModifierButton;

    @FXML
    private Button ChercherButton;

    @FXML
    private TableView<Etablissement> TableEtab;

    @FXML
    private TableColumn<Etablissement, Integer> Id;

    @FXML
    private TableColumn<Etablissement, Integer> Fax;

    @FXML
    private TableColumn<Etablissement , Timestamp> Heure_fermeture;

    @FXML
    private TableColumn<Etablissement, String> Date_fermeture;

    @FXML
    private TableColumn<Etablissement, String> Page_fb;
    
    @FXML
    private TableColumn<Etablissement, String> Site_web;

    @FXML
    private TableColumn<Etablissement, String> Email;

    @FXML
    private TableColumn<Etablissement, Integer> Num;
    
    @FXML
    private TableColumn<Etablissement, String> Adresse;
    

    
    EtablissementService cs= new EtablissementService();
    private ObservableList<Etablissement> data;
    
    Connection connexion;

    public EtablissementController() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
//    void Ajouter(ActionEvent event) throws IOException
//    {
//        Stage Stage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("../Presentation/AjouterEtablissement.fxml"));
//        Scene scene = new Scene(root);
//        Stage.setScene(scene);
//        Stage.show();
//    }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
     List<Etablissement> LE = cs.afficherEtablissement();
     data = FXCollections.observableArrayList();
     Etablissement e;
     
     LE.stream().forEach((j)-> {
         data.add(j);
     });
     
     TableEtab.setItems(data);
     
     Id.setCellValueFactory(new PropertyValueFactory<>("id"));
     Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
     Date_ouverture.setCellValueFactory(new PropertyValueFactory<>("date_ouverture"));
     Date_fermeture.setCellValueFactory(new PropertyValueFactory<>("date_fermeture"));
     Email.setCellValueFactory(new PropertyValueFactory<>("email"));
     Num.setCellValueFactory(new PropertyValueFactory<>("num"));
     Fax.setCellValueFactory(new PropertyValueFactory<>("fax"));
     Page_fb.setCellValueFactory(new PropertyValueFactory<>("page_fb"));
     Site_web.setCellValueFactory(new PropertyValueFactory<>("site_web"));
     Heure_ouverture.setCellValueFactory(new PropertyValueFactory<>("heure_ouverture"));
     Heure_fermeture.setCellValueFactory(new PropertyValueFactory<>("heure_fermeture"));
     Id.setCellValueFactory(new PropertyValueFactory<>("id_user"));
     Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
     
         

    }
    
    
    public void afficher()
    {
         List<Etablissement> LE = cs.afficherEtablissement();
     data = FXCollections.observableArrayList();
     Etablissement e;
     
     LE.stream().forEach((j)-> {
         data.add(j);
     });
     
     TableEtab.setItems(data);
     
     Id.setCellValueFactory(new PropertyValueFactory<>("id"));
     Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
     Date_ouverture.setCellValueFactory(new PropertyValueFactory<>("date_ouverture"));
     Date_fermeture.setCellValueFactory(new PropertyValueFactory<>("date_fermeture"));
     Email.setCellValueFactory(new PropertyValueFactory<>("email"));
     Num.setCellValueFactory(new PropertyValueFactory<>("numero"));
     Fax.setCellValueFactory(new PropertyValueFactory<>("fax"));
     Page_fb.setCellValueFactory(new PropertyValueFactory<>("page_facebook"));
     Site_web.setCellValueFactory(new PropertyValueFactory<>("site_web"));
     Heure_ouverture.setCellValueFactory(new PropertyValueFactory<>("heure_ouverture"));
     Heure_fermeture.setCellValueFactory(new PropertyValueFactory<>("heure_fermeture"));
     Id.setCellValueFactory(new PropertyValueFactory<>("id_user"));
     Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
     
    }
    
    
   public void supprimer()
   {
    Etablissement e= TableEtab.getSelectionModel().getSelectedItem();
    EtablissementService cs= new EtablissementService();
    cs.supprimerEtablissement(e);
    afficher(); 
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
    
    @FXML
    public void chercher()
    {
     EtablissementService es = new EtablissementService();
     data=es.chercherEtablissementParNom(txtRecherche.getText().toString());

     Id.setCellValueFactory(new PropertyValueFactory<>("id"));
     Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
     Date_ouverture.setCellValueFactory(new PropertyValueFactory<>("date_ouverture"));
     Date_fermeture.setCellValueFactory(new PropertyValueFactory<>("date_fermeture"));
     Email.setCellValueFactory(new PropertyValueFactory<>("email"));
     Num.setCellValueFactory(new PropertyValueFactory<>("numero"));
     Fax.setCellValueFactory(new PropertyValueFactory<>("fax"));
     Page_fb.setCellValueFactory(new PropertyValueFactory<>("page_facebook"));
     Site_web.setCellValueFactory(new PropertyValueFactory<>("site_web"));
     Heure_ouverture.setCellValueFactory(new PropertyValueFactory<>("heure_ouverture"));
     Heure_fermeture.setCellValueFactory(new PropertyValueFactory<>("heure_fermeture"));
     Id.setCellValueFactory(new PropertyValueFactory<>("id_user"));
     Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
      
     TableEtab.setItems(data);
   //  afficher();
    } 
          
    @FXML
    public void Modifier (CellEditEvent edditedCell)
    {
        Etablissement e = TableEtab.getSelectionModel().getSelectedItem();
        e.setNom(edditedCell.getNewValue().toString());
    }
    
    @FXML
    public void Smodif(ActionEvent event) throws IOException
    {
      //   Alert a = new Alert(Alert.AlertType.ERROR);
      //   System.out.println("vegerge");
       //  a.show();
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../Presentation/Modifier2Etablissement.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public int rr()
    {
        try {
            int i = TableEtab.getSelectionModel().getSelectedItem().getId();
                
            int a=0;
            String sql1,sql2,sql3,sql4,sql5,sql6;
            sql1="select * from cabinet_medical;";
            sql2="select * from centre_beaute;";
            sql3="select * from herboriseterie;";
            sql4="select * from hopitaux;";
            sql5="select * from laboratoire;";
            sql6="select * from parapharmacie;";
            
            Statement stl = connexion.createStatement();
            ResultSet  rs1=stl.executeQuery(sql1);
            Statement st2 = connexion.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);
            Statement st3 = connexion.createStatement();
            ResultSet  rs3=st3.executeQuery(sql3);
            Statement st4 = connexion.createStatement();
            ResultSet  rs4=st4.executeQuery(sql4);
            Statement st5 = connexion.createStatement();
            ResultSet  rs5=st5.executeQuery(sql5);
            Statement st6 = connexion.createStatement();
            ResultSet  rs6=st6.executeQuery(sql6);

            while(rs1.next())
            {a =rs1.getInt("id");
                if(i==a){return 1;}}
            while(rs2.next())
            {a =rs2.getInt("id");
                if(i==a){return 2;}}
            while(rs3.next())
            {a =rs3.getInt("id");
                if(i==a){return 3;}}
            while(rs4.next())
            {a =rs4.getInt("id");
                if(i==a){return 4;}}
            while(rs5.next())
            {a =rs5.getInt("id");
                if(i==a){return 5;}}
            while(rs6.next())
            {a =rs6.getInt("id");
                if(i==a){return 6;}}
        } catch (SQLException ex) {
        }
        return 0;
    }
    
}
