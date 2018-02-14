/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Etablissement;
import Entities.Pharmacie;
import IServices.IPharmacie;
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
public class PharmacieService implements IPharmacie {
    Connection connexion;

    

    public PharmacieService() {
         this.connexion = MyDB.getinstance().getConnexion();
    }
    
    
    
    @Override
    public void ajouterPharmacie(Pharmacie p, Etablissement e) {
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
            String query = "INSERT INTO pharmacie (id_pharmacie, type) "
                    + "values ("+generatedKeys.getInt(1)+",'"+p.getType()+"' );";
            Statement stm= connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerPharmacie(Pharmacie c) {
        try {
            
            String sql = "DELETE FROM pharmacie WHERE id_pharmacie=?";
            
            PreparedStatement statement = null;
            statement = connexion.prepareStatement(sql);
            statement.setInt(1, c.getId_pharmacie());
            
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
    public void modifierCabinet(Pharmacie c) {
        String sql ="UPDATE pharmacie SET type ='"+c.getType()+ "' WHERE id_pharmacie ='"+ c.getId_pharmacie()+"';";
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