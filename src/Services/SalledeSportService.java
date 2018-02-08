/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.CabinetMedical;
import Entities.Etablissement;
import Entities.SalledeSport;
import IServices.ISalledeSport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anis
 */
public class SalledeSportService implements ISalledeSport {

    Connection connexion;



    public SalledeSportService() {
        this.connexion = MyDB.getinstance().getConnexion();
    }
   
    
    @Override
    public void ajouterSalle(SalledeSport s, Etablissement e) {
     try {
        
               String query1 = "INSERT INTO etablissements (nom, adresse, date_ouverture,"
                       + " date_fermeture, email, numero,fax,page_facebook,site_web,heure_ouverture,"
                       + "heure_fermeture,id_user) "
                    + "values ( '"+e.getNom()+"','"+e.getAdresse()+"','"+e.getDate_ouverture()+
                       "','"+e.getDate_fermeture()+"','"+e.getEmail()+"',"+e.getNum()+","+e.getFax()+
                       ",'"+e.getPage_fb()+"','"+e.getSite_web()+"','"+e.getHeure_ouverture()+"','"
                       +e.getHeure_fermeture()+"',1 );";
           
               PreparedStatement stl= connexion.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS);
            stl.executeUpdate();
              ResultSet  generatedKeys = stl.getGeneratedKeys();
              generatedKeys.next();
            String query = "INSERT INTO salle_de_sport (id_salle, nb_entraineur) "
                    + "values ("+generatedKeys.getInt(1)+","+s.getNb_entraineur()+" );";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    
    }

    @Override
    public void supprimerSalle(SalledeSport s) {
try {
            
            String sql = "DELETE FROM salle_de_sport WHERE id_salle=?";
            
            PreparedStatement statement = null;
            statement = connexion.prepareStatement(sql);
            statement.setInt(1, s.getId_salle());
            
            int rowsDeleted = 0;
            try {
                rowsDeleted = statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(EtablissementService.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (rowsDeleted > 0) {
                System.out.println("successfully!");
            }
            else {
                System.out.println("echec");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EtablissementService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void modifierSalle(SalledeSport s) {
        String sql ="UPDATE salle_de_sport SET nb_entraineur ="+s.getNb_entraineur()+" WHERE id_salle ='"+ s.getId_salle()+"';";
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
