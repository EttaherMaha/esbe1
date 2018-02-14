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

         String query1 = "INSERT INTO Etablissements (nom, adresse, date_ouverture, date_fermeture, email, numero,fax,page_facebook,site_web,heure_ouverture,heure_fermeture,image,id_user) "
                    + "values ( '"+e.getNom()+"','"+e.getAdresse()+"','"+e.getDate_ouverture()+"','"+e.getDate_fermeture()+"','"+e.getEmail()+"',"+e.getNum()+","+e.getFax()+",'"+e.getPage_fb()+"','"+e.getSite_web()+"','"+e.getHeure_ouverture()+"','"+e.getHeure_fermeture()+"','"+e.getImage()+"',1 );";
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
    public void modifierParapharmacie(Parapharmacie c,Etablissement e) {
    
          String sql ="UPDATE parapharmacie SET livraison ="+c.getLivraison()+" WHERE id_para ="+ c.getId_para()+";";
       String sql2="UPDATE etablissements SET nom='"+e.getNom()+"',adresse='"+e.getAdresse()+"',date_ouverture='"+e.getDate_ouverture()+"',date_fermeture='"+e.getDate_fermeture()+"',email='"+e.getEmail()+"',numero="+e.getNum()+",fax="+e.getFax()+",page_facebook='"+e.getPage_fb()+"',site_web='"+e.getPage_fb()+"',heure_ouverture="+e.getHeure_ouverture()+",heure_fermeture="+e.getHeure_fermeture()+",image='"+e.getImage()+"' where id="+c.getId_para()+";";
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
