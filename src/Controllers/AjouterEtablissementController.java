/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataStorage.MyDB;
import Entities.CabinetMedical;
import Entities.Etablissement;
import Entities.Herboriseterie;
import Entities.Hopitaux;
import Entities.Laboratoire;
import Entities.Parapharmacie;
import Entities.Pharmacie;
import Entities.SalledeSport;
import Services.CabinetMedicalService;
import Services.EtablissementService;
import Services.HerbosristerieService;
import Services.HopitauxService;
import Services.LaboratoireService;
import Services.ParapharmacieService;
import Services.PharmacieService;
import Services.SalledeSportService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ellouze Skander
 */
public class AjouterEtablissementController implements Initializable {

    @FXML
    private CheckBox checkbox1;

    @FXML
    private AnchorPane ap;

    @FXML
    private CheckBox checkbox2;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private ComboBox<?> combobox2;

    @FXML
    private ComboBox<String> combobox1;

    @FXML
    private ComboBox<String> combobox3;
    
    @FXML
    private ComboBox<String> combobox4;

    @FXML
    private CheckBox checkbox3;

    @FXML
    private TextField txtDO;

    @FXML
    private TextField txt4;
    
    @FXML
    private TextField txtDF;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAdresse;

    @FXML
    private TextField txtHO;

    @FXML
    private TextField txtSW;

    @FXML
    private TextField txtFax;

    @FXML
    private Button btnValider;

    @FXML
    private TextField txtHF;

    @FXML
    private TextField txtNum;

    @FXML
    private TextField txtFB;

    @FXML
    private TextField txtImage;

    @FXML
    private TextField txtNom;

    @FXML
    private ComboBox<String> combo;

    @FXML
    private TextField txt2;

    /**
     * Initializes the controller class.
     */
    Connection connexion;

    public AjouterEtablissementController() {
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> options = FXCollections.observableArrayList(
                "Cabinet Medical", "Centre de Beaute", "Herboriseterie", "Hopitale", "Laboratoire", "Parapharmacie", "Pharmacie", "Salle de sport");
        combo.setItems(options);

        ObservableList<String> options2 = FXCollections.observableArrayList(
                "publique", "prive");
        combobox1.setItems(options2);

        ObservableList<String> options3 = FXCollections.observableArrayList(
                "radio", "biologie_medical", "sang");
        combobox3.setItems(options3);
        
        ObservableList<String> options4 = FXCollections.observableArrayList(
                "nuit", "jour", "garde");
        combobox4.setItems(options4);

        checkbox1.setVisible(false);
        checkbox2.setVisible(false);
        checkbox3.setVisible(false);
        combobox1.setVisible(false);
        combobox2.setVisible(false);
        combobox3.setVisible(false);
        combobox4.setVisible(false);
        txt2.setVisible(false);
        txt4.setVisible(false);

    }

    @FXML
    public void typeEtab(ActionEvent event) {
        label1.setText("");
        label2.setText("");
        label3.setText("");
        checkbox1.setVisible(false);
        checkbox2.setVisible(false);
        checkbox3.setVisible(false);
        txt4.setVisible(false);
        combobox1.setVisible(false);
        combobox2.setVisible(false);
        combobox3.setVisible(false);
        combobox4.setVisible(false);
        txt2.setVisible(false);
        if (combo.getSelectionModel().getSelectedItem() == "Cabinet Medical") {
            label1.setText("");
            label2.setText("");
            label3.setText("");
            combobox4.setVisible(false);
            checkbox1.setVisible(false);
            checkbox2.setVisible(false);
            checkbox3.setVisible(false);
            txt4.setVisible(false);
            combobox1.setVisible(false);
            combobox2.setVisible(false);
            combobox3.setVisible(false);
            label1.setText("CNAM");
            checkbox1.setVisible(true);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Centre de Beaute") {
        }
        if (combo.getSelectionModel().getSelectedItem() == "Herboriseterie") {
            label1.setText("");
            label2.setText("");
            label3.setText("");
            checkbox1.setVisible(false);
            checkbox2.setVisible(false);
            checkbox3.setVisible(false);
            combobox4.setVisible(false);
            combobox1.setVisible(false);
            combobox2.setVisible(false);
            combobox3.setVisible(false);
            label1.setText("livraison");
            checkbox1.setText("");
            checkbox1.setVisible(true);
            txt4.setVisible(false);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Hopitale") {
            label1.setText("");
            label2.setText("");
            label3.setText("");
            txt4.setVisible(false);
            checkbox1.setVisible(false);
            checkbox2.setVisible(false);
            checkbox3.setVisible(false);
            combobox4.setVisible(false);
            combobox1.setVisible(false);
            combobox2.setVisible(false);
            combobox3.setVisible(false);
            label1.setText("type");
            combobox1.setVisible(true);
            label2.setText("urgence");
            checkbox2.setText("");
            checkbox2.setVisible(true);
            label3.setText("CNAM");
            checkbox3.setText("");
            checkbox3.setVisible(true);

        }
        if (combo.getSelectionModel().getSelectedItem() == "Laboratoire") {
            label1.setText("");
            label2.setText("");
            label3.setText("");
            checkbox1.setVisible(false);
            checkbox2.setVisible(false);
            checkbox3.setVisible(false);
            combobox4.setVisible(false);
            txt4.setVisible(false);
            combobox1.setVisible(false);
            combobox2.setVisible(false);
            combobox3.setVisible(false);
            label1.setText("CNAM");
            checkbox1.setVisible(true);
            label2.setText("Equipe composé de");
            txt2.setVisible(true);
            label3.setText("type");
            combobox3.setVisible(true);

        }
        if (combo.getSelectionModel().getSelectedItem() == "Parapharmacie") {
            label1.setText("");
            label2.setText("");
            label3.setText("");
            checkbox1.setVisible(false);
            checkbox2.setVisible(false);
            checkbox3.setVisible(false);
            combobox4.setVisible(false);
            combobox1.setVisible(false);
            combobox2.setVisible(false);
            combobox3.setVisible(false);
            label1.setText("livraison");
            checkbox1.setText("");
            checkbox1.setVisible(true);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Pharmacie") {
            label1.setText("");
            label2.setText("");
            label3.setText("");
            txt4.setVisible(false);
            checkbox1.setVisible(false);
            checkbox2.setVisible(false);
            checkbox3.setVisible(false);
            combobox4.setVisible(true);
            combobox1.setVisible(false);
            combobox2.setVisible(false);
            combobox3.setVisible(false);
            label1.setText("Type");
            checkbox1.setText("");
            checkbox1.setVisible(true);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Salle de sport") {
        label1.setText("Nbr entraineur");
        label2.setText("");
        label3.setText("");
        checkbox1.setVisible(false);
        checkbox2.setVisible(false);
        checkbox3.setVisible(false);
        txt4.setVisible(true);
        combobox1.setVisible(false);
        combobox2.setVisible(false);
        combobox3.setVisible(false);
        combobox4.setVisible(false);
        txt2.setVisible(false);
        
        }
    }

    @FXML
    void CreerEtab(ActionEvent event) {
        if (combo.getSelectionModel().getSelectedItem() == "Cabinet Medical") {
            CabinetMedicalService cms = new CabinetMedicalService();

            CabinetMedical c = new CabinetMedical();

            c.setNom(txtNom.getText());
            c.setAdresse(txtAdresse.getText());
            c.setDate_ouverture(txtDO.getText());
            c.setDate_fermeture(txtDF.getText());
            c.setEmail(txtEmail.getText());
            c.setNum(Integer.parseInt(txtNum.getText()));
            c.setFax(Integer.parseInt(txtFax.getText()));
            c.setPage_fb(txtFB.getText());
            c.setSite_web(txtSW.getText());
            c.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            c.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            c.setImage(txtImage.getText());
            c.setIdUser(1);
            
            
            
            if (checkbox1.isSelected()) {
                c.setCnam(1);
            } else {
                c.setCnam(0);
            }
            cms.ajouterCabinet(c);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Centre de Beaute") {
        }
        if (combo.getSelectionModel().getSelectedItem() == "Herboriseterie") {
            HerbosristerieService hs = new HerbosristerieService();
 
            Herboriseterie e = new Herboriseterie();

            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtDO.getText());
            e.setDate_fermeture(txtDF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtNum.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFB.getText());
            e.setSite_web(txtSW.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            if (checkbox1.isSelected()) {
                e.setLivraison(1);
            } else {
                e.setLivraison(0);
            }
            hs.ajouterHerbosristerie(e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Hopitale") {
            HopitauxService hs = new HopitauxService();
            
            Hopitaux e = new Hopitaux();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtDO.getText());
            e.setDate_fermeture(txtDF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtNum.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFB.getText());
            e.setSite_web(txtSW.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            e.setType(combobox1.getSelectionModel().getSelectedItem().toString());
            if (checkbox2.isSelected()) {
                e.setUrgence(1);
            } else {
                e.setUrgence(0);
            }
            if (checkbox3.isSelected()) {
                e.setCnam(1);
            } else {
                e.setCnam(0);
            }
            hs.ajouterHopitaux(e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Laboratoire") {
            LaboratoireService hs = new LaboratoireService();
            Laboratoire e = new Laboratoire();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtDO.getText());
            e.setDate_fermeture(txtDF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtNum.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFB.getText());
            e.setSite_web(txtSW.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            if (checkbox1.isSelected()) {
                e.setCnam(1);
            } else {
                e.setCnam(0);
            }
            e.setNb_equipe(Integer.parseInt(txt2.getText()));
            e.setType(combobox3.getSelectionModel().getSelectedItem());
            hs.ajouterLaboratoire(e);
        }

        if (combo.getSelectionModel().getSelectedItem() == "Parapharmacie") {
            ParapharmacieService hs = new ParapharmacieService();
            Parapharmacie e = new Parapharmacie();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtDO.getText());
            e.setDate_fermeture(txtDF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtNum.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFB.getText());
            e.setSite_web(txtSW.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            if (checkbox1.isSelected()) {
                e.setLivraison(1);
            } else {
                e.setLivraison(0);
            }
            hs.ajouterParapharmacie(e);
        } 
        if (combo.getSelectionModel().getSelectedItem() == "Pharmacie") {
            PharmacieService hs = new PharmacieService();
            Pharmacie e = new Pharmacie();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtDO.getText());
            e.setDate_fermeture(txtDF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtNum.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFB.getText());
            e.setSite_web(txtSW.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            
                e.setType(combobox4.getSelectionModel().getSelectedItem().toString());
            
            hs.ajouterPharmacie(e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Salle de sport") {
            SalledeSportService hs = new SalledeSportService();
            SalledeSport e = new SalledeSport();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtDO.getText());
            e.setDate_fermeture(txtDF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtNum.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFB.getText());
            e.setSite_web(txtSW.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            e.setNb_entraineur(Integer.parseInt(txt4.getText()));
            
            hs.ajouterSalle(e);
        }

        Stage stage = (Stage) btnValider.getScene().getWindow();
        stage.close();
        
    }

    public void modifEtab(ActionEvent event)
    {
        
    }
    
    
}
