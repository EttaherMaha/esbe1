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
import java.awt.Desktop;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author Ellouze Skander
 */
public class Etablissement3Controller implements Initializable {


    @FXML
    private CheckBox checkbox1;

    @FXML
    private CheckBox checkbox2;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtFax;

        @FXML
    private ListView<Etablissement> listeEtab;

    @FXML
    private TextField txtFb;

    @FXML
    private TextField txtImage;

    @FXML
    private Button AjouterButton;

    @FXML
    private CheckBox checkbox3;

    @FXML
    private Button SupprimerButton;

    @FXML
    private Button ChercherButton;

   

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtRecherche;

    @FXML
    private TextField txtAdresse;


    @FXML
    private TextField txtHO;

    @FXML
    private Label label1;

    @FXML
    private TextField txtSw;

    @FXML
    private Label label2;

    @FXML
    private TextField txtJO;

    @FXML
    private Label label3;

    @FXML
    private ComboBox<String> combobox2;

    @FXML
    private ComboBox<String> combobox1;

    @FXML
    private TextField txt4;

    @FXML
    private ComboBox<String> combobox4;

        @FXML
    private AnchorPane ap1;
            @FXML
    private AnchorPane ap2;
        
    @FXML
    private ComboBox<String> combobox3;
    
        @FXML
    private ComboBox<String> combo;

    @FXML
    private TextField txtHF;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txtJF;

    @FXML
    private Button ModifierButton;



    @FXML
    private TextField txtNom;
        @FXML
    private StackPane pane;
            @FXML
    private Button btnSuivant;
    
    EtablissementService cs= new EtablissementService();
        Etablissement e = new Etablissement();
    
    Connection connexion;

    public Etablissement3Controller() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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


        ObservableList<String> options2 = FXCollections.observableArrayList(
                "publique", "prive");
        combobox1.setItems(options2);

        ObservableList<String> options3 = FXCollections.observableArrayList(
                "radio", "biologie_medical", "sang");
        combobox3.setItems(options3);
        
        ObservableList<String> options4 = FXCollections.observableArrayList(
                "nuit", "jour", "garde");
        combobox4.setItems(options4);
        
        ObservableList<String> options = FXCollections.observableArrayList(
                "Cabinet Medical", "Centre de Beaute", "Herboriseterie", "Hopitale", "Laboratoire", "Parapharmacie", "Pharmacie", "Salle de sport");
        combo.setItems(options);
        
        List<Etablissement> LE = cs.afficherEtablissement();
     LE.stream().forEach((j)-> {
         listeEtab.getItems().add(j);});

    } 
    
    @FXML
    public void makeFade()
    {
        FadeTransition f = new FadeTransition();
        f.setDuration(Duration.millis(300));
        f.setNode(ap1);
        f.setFromValue(1);
        f.setToValue(0);
        f.play();
        f.setOnFinished((ActionEvent event) ->{afficherRest();});
    }
        @FXML
    public void makeFadeOff()
    {ap1.setVisible(true);
        FadeTransition f1 = new FadeTransition();
        FadeTransition f2 = new FadeTransition();
        f2.setDuration(Duration.millis(400));
        f2.setNode(ap2);
        f2.setFromValue(1);
        f2.setToValue(0);
        f2.play();
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
        f1.setDuration(Duration.millis(400));
        f1.setNode(ap1);
        f1.setFromValue(0);
        f1.setToValue(1);
        f2.stop();
        f1.play();
        
        
        

        
    }
    
    @FXML
    public void afficherRest()
    {
//            txtNom.setVisible(false);
//            txtAdresse.setVisible(false);
//            txtJO.setVisible(false);
//            txtJF.setVisible(false);
//            txtEmail.setVisible(false);
//            txtTel.setVisible(false);
//            txtFax.setVisible(false);
//            txtFb.setVisible(false);
//            txtSw.setVisible(false);
//            txtHO.setVisible(false);
//            txtHF.setVisible(false);
//            txtImage.setVisible(false);
            ap1.setVisible(false);
        btnSuivant.setVisible(false);
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
            checkbox1.setText("");
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
            checkbox1.setVisible(false);
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
    void CreerEtab(ActionEvent event) {
        if (combo.getSelectionModel().getSelectedItem() == "Cabinet Medical") {
            CabinetMedicalService cms = new CabinetMedicalService();

            CabinetMedical c = new CabinetMedical();

            c.setNom(txtNom.getText());
            c.setAdresse(txtAdresse.getText());
            c.setDate_ouverture(txtJO.getText());
            c.setDate_fermeture(txtJF.getText());
            c.setEmail(txtEmail.getText());
            c.setNum(Integer.parseInt(txtTel.getText()));
            c.setFax(Integer.parseInt(txtFax.getText()));
            c.setPage_fb(txtFb.getText());
            c.setSite_web(txtSw.getText());
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
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
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
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
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
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
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
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
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
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
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
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            e.setNb_entraineur(Integer.parseInt(txt4.getText()));
            
            hs.ajouterSalle(e);
        }
        afficher();
       makeFadeOff();
        
    }
    
    @FXML
    public void affecterChamps()
    {
        Etablissement c= listeEtab.selectionModelProperty().getValue().getSelectedItem();
        txtNom.setText(c.getNom());
            txtAdresse.setText(c.getAdresse());
            txtJO.setText(c.getDate_ouverture());
            txtJF.setText(c.getDate_fermeture());
            txtEmail.setText(c.getEmail());
            txtTel.setText(String.valueOf(c.getNum()));
            txtFax.setText(String.valueOf(c.getFax()));
            txtFb.setText(c.getPage_fb());
            txtSw.setText(c.getSite_web());
            txtHO.setText(String.valueOf(c.getHeure_ouverture()));
            txtHF.setText(String.valueOf(c.getHeure_fermeture()));
            txtImage.setText(c.getImage());
    }
    
    
    
    @FXML
    public void RemplirModifier()
    {
        Etablissement c= listeEtab.selectionModelProperty().getValue().getSelectedItem();
        if(rr()==1)
        {
            affecterChamps();
            System.out.println("1");
            combo.setValue("Cabinet Medical");

        }
        if(rr()==2)
        {
             affecterChamps();
            System.out.println("1");
            combo.setValue("Centre de Beaute");
        }
        if(rr()==3)
        {
             affecterChamps();
            System.out.println("1");
            combo.setValue("Herboriseterie");
        }
        if(rr()==4)
        {
             affecterChamps();
            System.out.println("1");
            combo.setValue("Hopitale");
        }
        if(rr()==5)
        {
             affecterChamps();
            System.out.println("1");
            combo.setValue("Laboratoire");
        }
        if(rr()==6)
        {
             affecterChamps();
            System.out.println("1");
            combo.setValue("Parapharmacie");
        }
        if(rr()==7)
        {
             affecterChamps();
            System.out.println("1");
            combo.setValue("Pharmacie");
        }
        if(rr()==8)
        {
             affecterChamps();
            System.out.println("1");
            combo.setValue("Salle de sport");
        }

    }
    
    @FXML
    public int rr()
    {
        try {
            int i = listeEtab.getSelectionModel().getSelectedItem().getId();
                
            int a=0;
            String sql1,sql2,sql3,sql4,sql5,sql6,sql7,sql8;
            sql1="select id_etab from cabinet_medical;";
            sql2="select id_etab from centre_beaute;";
            sql3="select id_etab from herboriseterie;";
            sql4="select id_etab from hopitaux;";
            sql5="select id_etab from laboratoire;";
            sql6="select id_etab from parapharmacie;";
            sql7="select id_etab from pharmacie;";
            sql8="select id_etab from salle_de_sport;";
            
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
            Statement st7 = connexion.createStatement();
            ResultSet  rs7=st7.executeQuery(sql7);
            Statement st8 = connexion.createStatement();
            ResultSet  rs8=st8.executeQuery(sql8);

            while(rs1.next())
            {a =rs1.getInt("id_etab");
                if(i==a){return 1;}}
            while(rs2.next())
            {a =rs2.getInt("id_etab");
                if(i==a){return 2;}}
            while(rs3.next())
            {a =rs3.getInt("id_etab");
                if(i==a){return 3;}}
            while(rs4.next())
            {a =rs4.getInt("id_etab");
                if(i==a){return 4;}}
            while(rs5.next())
            {a =rs5.getInt("id_etab");
                if(i==a){return 5;}}
            while(rs6.next())
            {a =rs6.getInt("id_etab");
                if(i==a){return 6;}}
            while(rs7.next())
            {a =rs7.getInt("id_etab");
                if(i==a){return 7;}}
            while(rs8.next())
            {a =rs8.getInt("id_etab");
                if(i==a){return 8;}}
        } catch (SQLException ex) {
        }
        return 0;
    }
    
     @FXML
    void ModifierEtab(ActionEvent event) {
        if (combo.getSelectionModel().getSelectedItem() == "Cabinet Medical") {
            CabinetMedicalService cms = new CabinetMedicalService();

            CabinetMedical c = new CabinetMedical();

            c.setNom(txtNom.getText());
            c.setAdresse(txtAdresse.getText());
            c.setDate_ouverture(txtJO.getText());
            c.setDate_fermeture(txtJF.getText());
            c.setEmail(txtEmail.getText());
            c.setNum(Integer.parseInt(txtTel.getText()));
            c.setFax(Integer.parseInt(txtFax.getText()));
            c.setPage_fb(txtFb.getText());
            c.setSite_web(txtSw.getText());
            c.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            c.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            c.setImage(txtImage.getText());
            c.setIdUser(1);
            
            
            
            if (checkbox1.isSelected()) {
                c.setCnam(1);
            } else {
                c.setCnam(0);
            }
            cms.modifierCabinet(c);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Centre de Beaute") {
        }
        if (combo.getSelectionModel().getSelectedItem() == "Herboriseterie") {
            HerbosristerieService hs = new HerbosristerieService();
 
            Herboriseterie e = new Herboriseterie();

            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            if (checkbox1.isSelected()) {
                e.setLivraison(1);
            } else {
                e.setLivraison(0);
            }
            hs.modifierHerbosristerie(e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Hopitale") {
            HopitauxService hs = new HopitauxService();
            
            Hopitaux e = new Hopitaux();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
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
            hs.modifierHopitaux(e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Laboratoire") {
            LaboratoireService hs = new LaboratoireService();
            Laboratoire e = new Laboratoire();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
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
            hs.modifierLaboratoire(e);
        }

        if (combo.getSelectionModel().getSelectedItem() == "Parapharmacie") {
            ParapharmacieService hs = new ParapharmacieService();
            Parapharmacie e = new Parapharmacie();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            if (checkbox1.isSelected()) {
                e.setLivraison(1);
            } else {
                e.setLivraison(0);
            }
            hs.modifierParapharmacie(e);
        } 
        if (combo.getSelectionModel().getSelectedItem() == "Pharmacie") {
            PharmacieService hs = new PharmacieService();
            Pharmacie e = new Pharmacie();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            
                e.setType(combobox4.getSelectionModel().getSelectedItem().toString());
            
            hs.modifierPharmacie(e);
        }
        if (combo.getSelectionModel().getSelectedItem() == "Salle de sport") {
            SalledeSportService hs = new SalledeSportService();
            SalledeSport e = new SalledeSport();
            e.setNom(txtNom.getText());
            e.setAdresse(txtAdresse.getText());
            e.setDate_ouverture(txtJO.getText());
            e.setDate_fermeture(txtJF.getText());
            e.setEmail(txtEmail.getText());
            e.setNum(Integer.parseInt(txtTel.getText()));
            e.setFax(Integer.parseInt(txtFax.getText()));
            e.setPage_fb(txtFb.getText());
            e.setSite_web(txtSw.getText());
            e.setHeure_ouverture(Integer.parseInt(txtHO.getText()));
            e.setHeure_fermeture(Integer.parseInt(txtHF.getText()));
            e.setImage(txtImage.getText());
            e.setIdUser(1);
            
            e.setNb_entraineur(Integer.parseInt(txt4.getText()));
            
            hs.modifierSalle(e);
        }
        
       makeFadeOff();
       afficher();
        
    }
     
     
}
