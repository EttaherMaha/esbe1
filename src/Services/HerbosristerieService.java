/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Etablissement;
import Entities.Herboriseterie;
import IServices.IHerbosristerie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ellouze Skander
 */
public class HerbosristerieService implements IHerbosristerie {

  
        Connection connexion; 
   
    public HerbosristerieService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    
    @Override
    public void ajouterHerbosristerie(Herboriseterie c,Etablissement e) {
         try {
           String query1 = "INSERT INTO Etablissements (nom, adresse, date_ouverture, date_fermeture, email, numero,fax,page_facebook,site_web,heure_ouverture,heure_fermeture,image,id_user) "
                    + "values ( '"+e.getNom()+"','"+e.getAdresse()+"','"+e.getDate_ouverture()+"','"+e.getDate_fermeture()+"','"+e.getEmail()+"',"+e.getNum()+","+e.getFax()+",'"+e.getPage_fb()+"','"+e.getSite_web()+"','"+e.getHeure_ouverture()+"','"+e.getHeure_fermeture()+"','"+e.getImage()+"',1 );";
             PreparedStatement stl= connexion.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
            stl.executeUpdate();
              ResultSet  generatedKeys = stl.getGeneratedKeys();
              generatedKeys.next();
            String query = "INSERT INTO herboriseterie (livraison,id_herbo) "
                    + "values ("+c.getLivraison()+","+generatedKeys.getInt(1)+" );";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
    }

    @Override
    public void supprimerHerbosristerie(Herboriseterie c) {
    
        try {
            
            String sql = "DELETE FROM herboriseterie WHERE id_herbo=?";
            
            PreparedStatement statement = null;
            statement = connexion.prepareStatement(sql);
            statement.setInt(1, c.getId_herbo());
            
            int rowsDeleted = 0;
       
                rowsDeleted = statement.executeUpdate();
           
            if (rowsDeleted > 0) {
                System.out.println("successfully!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EtablissementService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }

    @Override
    public void modifierHerbosristerie(Herboriseterie c,Etablissement e) {
    
         String sql ="UPDATE herboriseterie SET livraison ="+c.getLivraison()+" WHERE id_herbo ="+ c.getId_herbo()+";";
        String sql2="UPDATE etablissements SET nom='"+e.getNom()+"',adresse='"+e.getAdresse()+"',date_ouverture='"+e.getDate_ouverture()+"',date_fermeture='"+e.getDate_fermeture()+"',email='"+e.getEmail()+"',numero="+e.getNum()+",fax="+e.getFax()+",page_facebook='"+e.getPage_fb()+"',site_web='"+e.getPage_fb()+"',heure_ouverture="+e.getHeure_ouverture()+",heure_fermeture="+e.getHeure_fermeture()+",image='"+e.getImage()+"' where id="+c.getId_herbo()+";";
        try {
            Statement st2=connexion.createStatement();
            Statement stl = connexion.createStatement();
            stl.executeUpdate(sql);
            st2.executeUpdate(sql2);
            System.out.println("Update done");
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }


    
}
