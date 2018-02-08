/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Etablissement;
import IServices.IEtablissement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ellouze Skander
 */
public class EtablissementService implements IEtablissement {

    Connection connexion;
   
    public EtablissementService() {
        connexion = MyDB.getinstance().getConnexion();
    }
    
    
   
    @Override
    public List<Etablissement> chercherEtablissementParNom(String nom) {
        List<Etablissement> ListEtablissement=new ArrayList <Etablissement>();              
        ResultSet rs;
        String sql ="select * from etablissements where nom='"+nom+"';";

        try 
        {
            Statement stl = connexion.createStatement();

            ResultSet  rs2=stl.executeQuery(sql);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Etablissement e = new Etablissement();
                e.setId(rs2.getInt("id"));
                e.setNom(rs2.getString("nom"));
                e.setAdresse(rs2.getString("adresse"));
                e.setDate_ouverture(rs2.getString("date_ouverture"));
                e.setDate_fermeture(rs2.getString("date_fermeture"));
                e.setEmail(rs2.getString("email"));
                e.setNum(rs2.getInt("numero"));
                e.setFax(rs2.getInt("fax"));
                e.setPage_fb(rs2.getString("page_facebook"));
                e.setSite_web(rs2.getString("site_web"));
                e.setHeure_ouverture(rs2.getTimestamp("heure_ouverture"));
                e.setHeure_fermeture(rs2.getTimestamp("heure_fermeture"));
                e.setIdUser(rs2.getInt(1));

                ListEtablissement.add(e);
                System.out.println(e);               
            }
        } 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListEtablissement;
        
    }

    @Override
    public List<Etablissement> chercherEtablissementParAdresse(String adresse) {
     List<Etablissement> ListEtablissement=new ArrayList <Etablissement>();              
        ResultSet rs;
        String sql ="select * from etablissements where adresse='"+adresse+"';";

        try 
        {
            Statement stl = connexion.createStatement();

            ResultSet  rs2=stl.executeQuery(sql);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Etablissement e = new Etablissement();
                e.setId(rs2.getInt("id"));
                e.setNom(rs2.getString("nom"));
                e.setAdresse(rs2.getString("adresse"));
                e.setDate_ouverture(rs2.getString("date_ouverture"));
                e.setDate_fermeture(rs2.getString("date_fermeture"));
                e.setEmail(rs2.getString("email"));
                e.setNum(rs2.getInt("numero"));
                e.setFax(rs2.getInt("fax"));
                e.setPage_fb(rs2.getString("page_facebook"));
                e.setSite_web(rs2.getString("site_web"));
                e.setHeure_ouverture(rs2.getTimestamp("heure_ouverture"));
                e.setHeure_fermeture(rs2.getTimestamp("heure_fermeture"));
                e.setIdUser(rs2.getInt(1));

                ListEtablissement.add(e);
                System.out.println(e);               
            }
     }  catch (SQLException ex) {
             System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    
            return ListEtablissement;
        
    }

    @Override
    public List<Etablissement> afficherEtablissement() {
    List<Etablissement> ListEtablissement=new ArrayList <Etablissement>();              
        ResultSet rs;
        String sql ="select * from etablissements;";

        try 
        {
            Statement stl = connexion.createStatement();

            ResultSet  rs2=stl.executeQuery(sql);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Etablissement e = new Etablissement();
                e.setId(rs2.getInt("id"));
                e.setNom(rs2.getString("nom"));
                e.setAdresse(rs2.getString("adresse"));
                e.setDate_ouverture(rs2.getString("date_ouverture"));
                e.setDate_fermeture(rs2.getString("date_fermeture"));
                e.setEmail(rs2.getString("email"));
                e.setNum(rs2.getInt("numero"));
                e.setFax(rs2.getInt("fax"));
                e.setPage_fb(rs2.getString("page_facebook"));
                e.setSite_web(rs2.getString("site_web"));
                e.setHeure_ouverture(rs2.getTimestamp("heure_ouverture"));
                e.setHeure_fermeture(rs2.getTimestamp("heure_fermeture"));
                e.setIdUser(rs2.getInt(1));

                ListEtablissement.add(e);
                System.out.println(e);               
            }
     }  catch (SQLException ex) {
            Logger.getLogger(EtablissementService.class.getName()).log(Level.SEVERE, null, ex);
        }
    
            return ListEtablissement;
}
}