/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Etablissement;
import Entities.Parapharmacie;
import IServices.IParapharmacie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ellouze Skander
 */
public class ParapharmacieService implements IParapharmacie {

    
        
       Connection connexion;
   
    public ParapharmacieService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    @Override
    public void ajouterParapharmacie(Parapharmacie c, Etablissement e) {
    
          try {

               String query1 = "INSERT INTO Etablissements (nom, adresse, date_ouverture, date_fermeture, email, numero,fax,page_facebook,site_web,heure_ouverture,heure_fermeture,id_user) "
                    + "values ( '"+e.getNom()+"','"+e.getAdresse()+"','"+e.getDate_ouverture()+"','"+e.getDate_fermeture()+"','"+e.getEmail()+"',"+e.getNum()+","+e.getFax()+",'"+e.getPage_fb()+"','"+e.getSite_web()+"','"+e.getHeure_ouverture()+"','"+e.getHeure_fermeture()+"',1 );";
            PreparedStatement stl= connexion.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
            stl.executeUpdate();
              ResultSet  generatedKeys = stl.getGeneratedKeys();
              generatedKeys.next();
            String query = "INSERT INTO parapharmacie (livraison,id_para) "
                    + "values ("+c.getLivraison()+","+generatedKeys.getInt(1)+" );";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void supprimerParapharmacie(Parapharmacie c) {
   
    
         try {
            
            String sql = "DELETE FROM parapharmacie WHERE id_para=?";
            
            PreparedStatement statement = null;
            statement = connexion.prepareStatement(sql);
            statement.setInt(1, c.getId_para());
            
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
    public void modifierParapharmacie(Parapharmacie c) {
    
          String sql ="UPDATE parapharmacie SET livraison ="+c.getLivraison()+" WHERE id_para ='"+ c.getId_para()+"';";
        try {
            Statement stl = connexion.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Update done");
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    
}
