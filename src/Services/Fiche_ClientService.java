/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Etablissement;
import Entities.Fiche_Client;
import Entities.fos_user;
import IServices.IFiche_Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author user
 */
public class Fiche_ClientService implements IFiche_Client{
    
    Connection conn;
private ObservableList<Fiche_Client> data;
    public Fiche_ClientService() {
        this.conn=MyDB.getinstance().getConnexion();
    }
    

    @Override
    public void ajouterFicheClient(Fiche_Client fc) {
        try 
        {
          String sql ="Insert into fiche_client(suivie,id_user,id_etab) values ('"+fc.getSuivie()+"','"+fc.getId_user()+"',"+fc.getId_etablissement()+");";
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Ajout effectué");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Ajout fiche confirmation");
            alert.setHeaderText(null);
            alert.setContentText("fiche ajoutée!");

            alert.showAndWait();
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }    }

    @Override
    public void supprimerFicheClient(Fiche_Client fc) {
        
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Alerte suppression");
        alert.setHeaderText("Suppression d'un conseil");
        alert.setContentText("Êtes-vous sûr(e) de vouloir supprimer?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
        try 
        {
            String sql ="DELETE FROM fiche_client WHERE id= "+fc.getId()+";";
            System.out.println(sql);
           Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Suppression de la fiche effectuée");
        } 
        catch (SQLException ex) 
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        }
    }

    @Override
    public void modifierFicheClient(Fiche_Client fc) {
        String sql = "UPDATE fiche_client SET suivie = '"+fc.getSuivie()+"' WHERE id_user= "+fc.getId_user()+" AND id_etab= "+fc.getId_etablissement()+"; ";
        
        /*select id from user where roles='user' and id='id_partenaire';*/
          /*select * from fiche_client  where roles='user' and id='id_partenaire';*/
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Modification effectuée");
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }    }
 
    @Override
    public Fiche_Client afficherFicheClient(Fiche_Client fc) {
        Fiche_Client fiche_client = new Fiche_Client() ;
        ResultSet rs ;
        String sql ="SELECT * FROM fiche_client WHERE id_user= "+fc.getId_user()+" AND id_etablissement= "+fc.getId_etablissement()+"; ";
        try {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            rs.next();
            fiche_client = new Fiche_Client(rs.getString("suivie"), rs.getInt("Id_user"), rs.getInt("Id_etab"));
            System.out.println(fiche_client.toString());
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return fiche_client;    
    }
    
   
    @Override
    public List<Fiche_Client> afficherToutFicheClient() {
      List<Fiche_Client> ListFiche=new ArrayList <Fiche_Client>();
        
        //ResultSet rs;
        
         String sql ="select f.*,etab.nom ,user.username FROM fiche_client f, etablissements etab ,user user  WHERE (f.id_etab = etab.id) and (f.id_user = user.id);";
        try 
        {
            Statement stl = conn.createStatement();
             ResultSet rs=stl.executeQuery(sql);          
            System.err.println("Display Done");
            while(rs.next())
            {   
                Fiche_Client fiche = new Fiche_Client();
                fiche.setId(rs.getInt("id"));
                fiche.setId_user(rs.getInt("id_user"));
                fiche.setId_etablissement(rs.getInt("id_etab"));
                fiche.setSuivie(rs.getString("suivie"));
                fiche.setNomEtab(rs.getString("nom"));
                fiche.setNomUser(rs.getString("username"));
                ListFiche.add(fiche);
                System.out.println(fiche.toString());                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       return ListFiche ;
    }

    @Override
    public ObservableList<Fiche_Client> rechercherFiche_Client(String nom) {
     data = FXCollections.observableArrayList();
        List<Fiche_Client> ListFicheClient=new ArrayList <Fiche_Client>();              
        ResultSet rs;
       
                String sql1="select f.*,etab.nom ,user.username FROM fiche_client f, etablissements etab ,user user  WHERE (f.id_etab = etab.id) and ('"+nom+"' = user.username);";
           // String sql2="select username from user where id="+rs.getInt("id_user")+";";
                Fiche_Client fiche_client = new Fiche_Client() ;
                List <Fiche_Client> e = new ArrayList <Fiche_Client>();
  
       // String sql2="select username from user where id="+rs.getInt("id_user")+";";
        try 
        {
            Statement stl = conn.createStatement();

            ResultSet  rs1=stl.executeQuery(sql1);       
            System.out.println("Affichage Done");
            while(rs1.next()) 
            {
                String sql2="select username from user where id="+rs1.getInt("id_user")+";";
                Statement st2 = conn.createStatement();
                ResultSet  rs2=st2.executeQuery(sql2);
                while(rs2.next())
                    {
                      Fiche_Client  FicheClient = new Fiche_Client(rs1.getString("suivie"), rs1.getInt("id_user"), rs1.getInt("id_etab"));
                        data.add(FicheClient);
                        System.out.println(e);               
                    }
        }} 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return data;
    
    }
    
    
       @Override
    public  List<String> listerNomsPartanaire() 
    {
       // data= FXCollections.observableArrayList();
        List<String> ListPart=new ArrayList <String>();              
        ResultSet rs;
        String sql ="select username from user where roles = 'partenaire';";

          try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);          
            System.out.println("Affichage Done");
            while(rs.next())
            {
             ListPart.add(rs.getString("username"));                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListPart;
    }
    
    
    
        
        @Override
    public List<String> listerNomsEtab() 
    {
        List<String> ListCat=new ArrayList <String>();              
        ResultSet rs;
        String sql ="select nom from etablissements;";

          try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);          
            System.out.println("Affichage Done");
            while(rs.next())
            {
                //Categorie c = new Categorie();
                //c.setNom(rs.getString("nom"));

                ListCat.add(rs.getString("nom"));
                //System.out.println(c.toString1());                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListCat;
    }
    
    
     @Override
    public fos_user getUser(int idUser ) 
    {
       fos_user user =new fos_user();
        
                      
        ResultSet rs;
        String sql ="select * from user where id='"+idUser+"';";

          try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);          
            System.out.println("Affichage Done");
            while(rs.next())
            {
              user.setId(idUser);
              user.setUsername(rs.getString("username"));
               
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return user;
    }
    
    
    
    
   
       
}
