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
                    +e.getDate_fin()+"',horaire_com = '"+e.getHoraire_com()+"',horaire_fin = '"
                    +e.getHoraire_fin()+"',description = '"+e.getDescription()+"',image ='"+e.getImage()+"' WHERE id_event ="+ e.getId_event()+";";
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
                Timestamp input = rs.getTimestamp("date_debut");
                
                Timestamp input2 = rs.getTimestamp("date_fin");
                LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
              
                
                LocalDateTime newD = rs.getTimestamp("date_debut").toLocalDateTime();
                LocalDateTime newG = rs.getTimestamp("date_fin").toLocalDateTime();
                
                java.util.Date ddd = new java.util.Date();
                java.sql.Date ddd2= new java.sql.Date(input.getTime());
                
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
                
                ListEvents.add(event2);
                System.out.println(event2.toString());                
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
            String sql2="SELECT  * from evenements INNER JOIN categorie on evenements.id_categorie ="+idcateg+";";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            
            while(rs2.next())
            {
                Timestamp input = rs2.getTimestamp("date_debut");              
                Timestamp input2 = rs2.getTimestamp("date_fin");
                LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
              
                
                LocalDateTime newD = rs2.getTimestamp("date_debut").toLocalDateTime();
                LocalDateTime newG = rs2.getTimestamp("date_fin").toLocalDateTime();
                
                java.util.Date ddd = new java.util.Date();
                java.sql.Date ddd2= new java.sql.Date(input.getTime());
                
                Evenement event = new Evenement();
                event.setId_event(rs2.getInt("id_event"));
                
                event.setDate_debut(date);
                event.setDate_fin(date2);
                event.setHoraire_com(rs2.getString("horaire_com"));
                event.setHoraire_fin(rs2.getString("horaire_fin"));
                event.setDescription(rs2.getString("description"));
                event.setImage(rs2.getString("image"));
                event.setId_categorie(rs2.getInt("id_categorie"));
                event.setId_user(rs2.getInt("id_user"));
                
               Evenement event2 = new Evenement(date,date2,rs2.getString("horaire_com"),rs2.getString("horaire_fin"),rs2.getString("description"),rs2.getString("image"),rs2.getInt("id_categorie"),rs2.getInt("id_user"));
                
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
                Timestamp input = rs2.getTimestamp("date_debut");              
                Timestamp input2 = rs2.getTimestamp("date_fin");
                LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
              
                
                LocalDateTime newD = rs2.getTimestamp("date_debut").toLocalDateTime();
                LocalDateTime newG = rs2.getTimestamp("date_fin").toLocalDateTime();
                
                java.util.Date ddd = new java.util.Date();
                java.sql.Date ddd2= new java.sql.Date(input.getTime());
                
                Evenement event = new Evenement();
                event.setId_event(rs2.getInt("id_event"));
                
                event.setDate_debut(date);
                event.setDate_fin(date2);
                event.setHoraire_com(rs2.getString("horaire_com"));
                event.setHoraire_fin(rs2.getString("horaire_fin"));
                event.setDescription(rs2.getString("description"));
                event.setImage(rs2.getString("image"));
                event.setId_categorie(rs2.getInt("id_categorie"));
                event.setId_user(rs2.getInt("id_user"));
                
               Evenement event2 = new Evenement(date,date2,rs2.getString("horaire_com"),rs2.getString("horaire_fin"),rs2.getString("description"),rs2.getString("image"),rs2.getInt("id_categorie"),rs2.getInt("id_user"));
                
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

}
