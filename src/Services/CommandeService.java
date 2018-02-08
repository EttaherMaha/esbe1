/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.ICommande;
import Entities.Commande;
import Entities.Produit;
import Entities.RendezVous;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author elbrh
 */
public class CommandeService implements ICommande{
    Connection connexion ;

    public CommandeService() {
        this.connexion = MyDB.getinstance().getConnexion();


    }

    @Override
    public void passCommande(Commande c) {
        try {   
            String query = "INSERT INTO commande ( id_produit, id_user )"
                    + "values ( '" + c.getId_produit() + "', '" + c.getId_user() + "' );";
            Statement state = connexion.createStatement();
            state.executeUpdate(query);
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }

    @Override
    public void addProductToCommande(Produit p) {
            List<Produit> lsp=new ArrayList<Produit>();
            
            
    }

    @Override
    public void annulerCommande(int id_commande) {
        try {
            
            Statement state = connexion.createStatement();
            state.executeUpdate("DELETE from commande where id_commande='" + id_commande + "'");
            System.out.println("supression effectuée");
        } catch (SQLException ex) {
            System.out.println("supression echouee");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }

    @Override
    public List<Commande> showMyCommande(int id_user) {
        List<Commande> lscom = new ArrayList<>();
        try {
            Statement state = connexion.createStatement();
            ResultSet rs = state.executeQuery("select * from commande");

            while (rs.next()) {
                
                Commande com = new Commande();
                com.setId_produit(rs.getInt("id_produit"));
                com.setId_user(rs.getInt("id_user"));
                com.setId_commande(rs.getInt("id_commande"));

                lscom.add(com);
                System.out.println(com);
            }
        } catch (SQLException ex) {
            System.out.println("Affichage echoué");
        }
        return lscom;
    }

    @Override
    public List<Commande> showCommandebyid(int id_commande) {
            List<Commande> lscom = new ArrayList<>();
        try {
            String sql = "select * from commande where id_commande='" + id_commande + "';";
            
            Statement state = connexion.createStatement();
            ResultSet rs = state.executeQuery(sql);
            

            while (rs.next()) {
               
                Commande com = new Commande();
                com.setId_commande(rs.getInt("id_rdv"));
                
                com.setId_user(rs.getInt("id_user"));
                com.setId_produit(rs.getInt("id_produit"));
                com.setId_commande(rs.getInt("id_commande"));

               

                lscom.add(com);
                
                    System.out.println(com);
                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return lscom;
    }
    }

 
    
    
    
    
    
    
    

