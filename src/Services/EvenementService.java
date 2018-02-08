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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
       
        String sql ="Insert into evenements (date_debut,date_fin,horaire_com,horaire_fin,description,image,id_categorie,id_user) values ('"+e.getDate_debut()+"','"+e.getDate_fin()+"','"
                    +e.getHoraire_com()+"','"+e.getHoraire_fin()+"','"+e.getDescription()+"','"+e.getImage()+"',"+e.getId_categorie()+","+e.getId_user()+");";
        try 
        {
            System.out.println(sql);
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
            System.out.println("Delete EvenementDone");
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
                    +e.getDate_fin()+"',horaire_com = '"+e.getHoraire_com()+"',horaire_fin = '"
                    +e.getHoraire_fin()+"',description = '"+e.getDescription()+"',image ='"+e.getImage()+"' WHERE id_event ="+ e.getId_event()+";";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Update Evenement done");
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
List<Evenement> ListEvent=new ArrayList <Evenement>();              
       ResultSet rs;
        try 
        {
            String sql2="SELECT  * from evenements";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            
            while(rs2.next())
            {                
                Evenement event = new Evenement();
                Timestamp input = rs2.getTimestamp("date_debut");              
                Timestamp input2 = rs2.getTimestamp("date_fin");
                LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDateTime newD = rs2.getTimestamp("date_debut").toLocalDateTime();
                LocalDateTime newG = rs2.getTimestamp("date_fin").toLocalDateTime();
                java.util.Date ddd = new java.util.Date();
                java.sql.Date ddd2= new java.sql.Date(input.getTime());
                event.setId_event(rs2.getInt("id_event"));
                event.setDate_debut(date);
                event.setDate_fin(date2);
                event.setHoraire_com(rs2.getString("horaire_com"));
                event.setHoraire_fin(rs2.getString("horaire_fin"));
                event.setDescription(rs2.getString("description"));
                event.setImage(rs2.getString("image"));
                event.setId_categorie(rs2.getInt("id_categorie"));
                event.setId_user(rs2.getInt("id_user"));

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
    public List<Evenement> chercherEvenementParCategorie(String nomCategorie)
    {
       List<Evenement> ListEvent=new ArrayList <Evenement>();              
       ResultSet rs;
        try 
        {
            String sql2="SELECT  * from evenements INNER JOIN categorie c on evenements.id_categorie = c.id_categorie where c.nom = '"+nomCategorie+"';";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            
            while(rs2.next())
            {                
                Evenement event = new Evenement();
                Timestamp input = rs2.getTimestamp("date_debut");              
                Timestamp input2 = rs2.getTimestamp("date_fin");
                LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDateTime newD = rs2.getTimestamp("date_debut").toLocalDateTime();
                LocalDateTime newG = rs2.getTimestamp("date_fin").toLocalDateTime();
                java.util.Date ddd = new java.util.Date();
                java.sql.Date ddd2= new java.sql.Date(input.getTime());
                event.setId_event(rs2.getInt("id_event"));
                event.setDate_debut(date);
                event.setDate_fin(date2);
                event.setHoraire_com(rs2.getString("horaire_com"));
                event.setHoraire_fin(rs2.getString("horaire_fin"));
                event.setDescription(rs2.getString("description"));
                event.setImage(rs2.getString("image"));
                event.setId_categorie(rs2.getInt("id_categorie"));
                event.setId_user(rs2.getInt("id_user"));

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
        try 
        {
            String sql2="SELECT  * from evenements INNER JOIN fos_user u on evenements.id_user = u.id where u.username = '"+nomUti+"';";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            
            while(rs2.next())
            {                
                Evenement event = new Evenement();
                Timestamp input = rs2.getTimestamp("date_debut");              
                Timestamp input2 = rs2.getTimestamp("date_fin");
                LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDateTime newD = rs2.getTimestamp("date_debut").toLocalDateTime();
                LocalDateTime newG = rs2.getTimestamp("date_fin").toLocalDateTime();
                java.util.Date ddd = new java.util.Date();
                java.sql.Date ddd2= new java.sql.Date(input.getTime());
                event.setId_event(rs2.getInt("id_event"));
                event.setDate_debut(date);
                event.setDate_fin(date2);
                event.setHoraire_com(rs2.getString("horaire_com"));
                event.setHoraire_fin(rs2.getString("horaire_fin"));
                event.setDescription(rs2.getString("description"));
                event.setImage(rs2.getString("image"));
                event.setId_categorie(rs2.getInt("id_categorie"));
                event.setId_user(rs2.getInt("id_user"));

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
    public List<Evenement> chercherEvenementParDate(LocalDate datee)
    {
        List<Evenement> ListEvent=new ArrayList <Evenement>();              
        ResultSet rs;
        String sql ="select * from evenements where date_debut = '"+datee+"';";

        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);    
            rs.next();
            
            while(rs.next())
            {
                  
                 Timestamp input2 = rs.getTimestamp("date_fin");
                Timestamp input  = rs.getTimestamp("date_debut");
               
                LocalDate date  =  input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
              
                Evenement event = new Evenement();
                event.setId_event(rs.getInt("id_event"));
                
                event.setDate_debut(date);
                event.setDate_fin(date2);
                event.setHoraire_com(rs.getString("horaire_com"));
                event.setHoraire_fin(rs.getString("horaire_fin"));
                event.setDescription(rs.getString("description"));
                event.setImage(rs.getString("image"));
                event.setId_categorie(rs.getInt("id_categorie"));
                event.setId_user(rs.getInt("id_user"));

                 Evenement event2 = new Evenement(date,date2,rs.getString("horaire_com"),rs.getString("horaire_fin"),rs.getString("description"),rs.getString("image"),rs.getInt("id_categorie"),rs.getInt("id_user"));
                
                ListEvent.add(event2);
                System.out.println(event2.toString());                    
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
    public void supprimmerEvenement(LocalDate date) 
    {
                   String sql ="DELETE FROM evenements WHERE date_debut = '"+date+"';";
                   System.out.println(sql);
        try {
            Statement stl = conn.createStatement();
            int k = stl.executeUpdate(sql);
            if (k > 0) {
                System.out.println("Delete evenement Done");
            }
            
            
            } 
        catch (SQLException ex) 
            {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
        
    }

}
