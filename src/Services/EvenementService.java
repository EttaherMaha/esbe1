/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Evenement;
import IServices.IEvenement;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maha
 */
public class EvenementService implements IEvenement
{
     Connection conn;
    
    public EvenementService()
    {
        this.conn=MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterEvenement(Evenement e)           
    {         
       
        
        String sql ="Insert into evenements (date_debut,date_fin,image,id_user,id_categorie,description) values ('"+e.getDate_debut()+"',"+e.getDate_fin()+","
                    +e.getImage()+",'"+e.getId_user()+"','"+e.getId_categorie()+"','"+e.getDescription()+"');";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Add Done");
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }              
    }

    

    @Override
    public void supprimerEvenement(Evenement e)
    {
           String sql ="DELETE FROM evenements WHERE id_event= "+e.getId_event()+";";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Delete Categorie Done");
            } 
        catch (SQLException ex) 
            {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
    }

    @Override
    public void modifierEvenement(Evenement e)
    {
        String sql ="UPDATE evenements SET date_debut = '"+e.getDate_debut()+"',date_fin = '"
                    +e.getDate_fin()+"',image ='"+e.getImage()+"',description = '"
                    +e.getDescription()+"' WHERE id_event ="+ e.getId_event()+";";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Update Conseil done");
        } 
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }    }

    @Override
    public List<Evenement> afficherEvenements()
    {
         List<Evenement> ListEvents=new ArrayList <Evenement>();
        
        ResultSet rs;
        
        String sql ="select * from evenements";
        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);          
            System.out.println("Affichage Done");
            while(rs.next())
            {
                Evenement event = new Evenement();
                event.setId_event(rs.getInt("id_event"));
                event.setDate_debut(rs.getDate("date_debut"));
                event.setDate_fin(rs.getDate("date_fin"));
                event.setImage(rs.getString("image"));
                event.setId_user(rs.getInt("id_user"));
                event.setId_categorie(rs.getInt("id_categorie"));
                event.setDescription(rs.getString("description"));
                ListEvents.add(event);
                System.out.println(event.toString());                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       return ListEvents ;
        
    }

    @Override
    public List<Evenement> chercherEvenementParCategorie(String nomCategorie)
    {
        List<Evenement> ListEvent=new ArrayList <Evenement>();              
       ResultSet rs;
        
        String sql ="select id_categorie from categorie where nom='"+nomCategorie+"';";

        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);    
            rs.next();
            int idcateg= rs.getInt("id_categorie");
            System.out.println(idcateg);
            String sql2="select * from evenements where id_categorie ="+idcateg+";";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Evenement event = new Evenement();
                event.setId_event(rs2.getInt("id_event"));
                 event.setDate_debut(rs2.getDate("date_debut"));
                event.setDate_fin(rs2.getDate("date_fin"));
                event.setImage(rs2.getString("image"));
                event.setId_user(rs2.getInt("id_user"));
                event.setId_categorie(rs2.getInt("id_categorie"));
                event.setDescription(rs2.getString("description"));

                ListEvent.add(event);
                System.out.println(event.toString());               
            }
        } 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListEvent;
    }



    @Override
    public List<Evenement> chercherEvenementParNomUtilisateur(String nomUti)
    {
        List<Evenement> ListEvent=new ArrayList <Evenement>();              
        ResultSet rs;
        String sql ="select id from fos_user where username = '"+nomUti+"';";

        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);    
            rs.next();
            int idUti= rs.getInt("id");
            System.out.println(idUti);
            String sql2="select * from evenements where id_user ="+idUti+";";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Evenement evenement = new Evenement();
                evenement.setId_event(rs2.getInt("id_event"));
                evenement.setDate_debut(rs2.getDate("date_debut"));
                evenement.setDate_fin(rs2.getDate("date_fin"));
                evenement.setImage(rs2.getString("image"));
                evenement.setId_user(rs2.getInt("id_user"));
                evenement.setId_categorie(rs2.getInt("id_categorie"));
                evenement.setDescription(rs2.getString("description"));

                ListEvent.add(evenement);
                System.out.println(evenement.toString());               
            }
        } 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListEvent;
        
    }

    @Override
    public List<Evenement> chercherEvenementParDate(java.sql.Date date)
    {
        return null;
    }


}
