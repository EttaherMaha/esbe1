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
import Services.CabinetMedicalService;
import Services.EtablissementService;
import Services.HerbosristerieService;
import Services.HopitauxService;
import Services.LaboratoireService;
import Services.ParapharmacieService;
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
    private CheckBox checkbox3;

    @FXML
    private TextField txtDO;

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

        checkbox1.setVisible(false);
        checkbox2.setVisible(false);
        checkbox3.setVisible(false);

        combobox1.setVisible(false);
        combobox2.setVisible(false);
        combobox3.setVisible(false);

        txt2.setVisible(false);

    }

    @FXML
    public void typeEtab(ActionEvent event) {
        checkbox1.setVisible(false);
        checkbox2.setVisible(false);
        checkbox3.setVisible(false);

        combobox1.setVisible(false);
        combobox2.setVisible(false);
        combobox3.setVisible(false);

        txt2.setVisible(false);
        if (combo.getSelectionModel().getSelectedItem() == "Cabinet Medical") {
            label1.setText("");
            label2.setText("");
            label3.setText("");
            checkbox1.setVisible(false);
            checkbox2.setVisible(false);
            checkbox3.setVisible(false);

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

            combobox1.setVisible(false);
            combobox2.setVisible(false);
            combobox3.setVisible(false);
            label1.setText("livraison");
            checkbox1.setText("");
            checkbox1.setVisible(true);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Hopitale") {
            label1.setText("");
            label2.setText("");
            label3.setText("");
            checkbox1.setVisible(false);
            checkbox2.setVisible(false);
            checkbox3.setVisible(false);

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

            combobox1.setVisible(false);
            combobox2.setVisible(false);
            combobox3.setVisible(false);
            label1.setText("livraison");
            checkbox1.setText("");
            checkbox1.setVisible(true);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Pharmacie") {
        }
        if (combo.getSelectionModel().getSelectedItem() == "Salle de sport") {
        }
    }

    @FXML
    void CreerEtab(ActionEvent event) {
        if (combo.getSelectionModel().getSelectedItem() == "Cabinet Medical") {
            CabinetMedicalService cms = new CabinetMedicalService();

            Etablissement e = new Etablissement();

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
            CabinetMedical cm = new CabinetMedical();
            if (checkbox1.isSelected()) {
                cm.setCnam(1);
            } else {
                cm.setCnam(0);
            }
            cms.ajouterCabinet(cm, e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Centre de Beaute") {
        }
        if (combo.getSelectionModel().getSelectedItem() == "Herboriseterie") {
            HerbosristerieService hs = new HerbosristerieService();

            Etablissement e = new Etablissement();

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
            Herboriseterie h = new Herboriseterie();
            if (checkbox1.isSelected()) {
                h.setLivraison(1);
            } else {
                h.setLivraison(0);
            }
            hs.ajouterHerbosristerie(h, e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Hopitale") {
            HopitauxService hs = new HopitauxService();
            Etablissement e = new Etablissement();
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
            Hopitaux h = new Hopitaux();
            h.setType(combobox1.getSelectionModel().getSelectedItem().toString());
            if (checkbox2.isSelected()) {
                h.setUrgence(1);
            } else {
                h.setUrgence(0);
            }
            if (checkbox3.isSelected()) {
                h.setCnam(1);
            } else {
                h.setCnam(0);
            }
            hs.ajouterHopitaux(h, e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Laboratoire") {
            LaboratoireService hs = new LaboratoireService();
            Etablissement e = new Etablissement();
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
            Laboratoire h = new Laboratoire();
            if (checkbox1.isSelected()) {
                h.setCnam(1);
            } else {
                h.setCnam(0);
            }
            h.setNb_equipe(Integer.parseInt(txt2.getText()));
            h.setType(combobox3.getSelectionModel().getSelectedItem());
            hs.ajouterHopitaux(h, e);
        }

        if (combo.getSelectionModel().getSelectedItem() == "Parapharmacie") {
            ParapharmacieService hs = new ParapharmacieService();
            Etablissement e = new Etablissement();
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
            Parapharmacie h = new Parapharmacie();
            if (checkbox1.isSelected()) {
                h.setLivraison(1);
            } else {
                h.setLivraison(0);
            }
            hs.ajouterParapharmacie(h, e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Pharmacie") {
        }
        if (combo.getSelectionModel().getSelectedItem() == "Salle de sport") {
        }

        Stage stage = (Stage) btnValider.getScene().getWindow();
        stage.close();
    }

    public void modifEtab(ActionEvent event)
    {
        
    }
    
    
}