/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Commentaire;
import IServices.ICommentaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maha
 */
public class CommentaireService implements ICommentaire
{
     Connection conn;
    
    public CommentaireService()
    {
        this.conn=MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterCommentaire(Commentaire c)
    {
         String sql= "Insert into commentaire(id_user,contenu) values ('"+c.getId_user()+"','"+c.getContenu()+"');";
         try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Add Commentaire Done");
             }
         catch (SQLException ex) 
            {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
             }
        
    }

    @Override
    public void supprimerCommentaire(Commentaire c)
    {
          String sql ="DELETE FROM commentaire WHERE id_commentaire= "+c.getId_commentaire()+";";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Delete Commentaire Done");
            } 
        catch (SQLException ex) 
            {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            }
    }

    @Override
    public void modifierCommentaire(Commentaire c)
    {
        String sql ="UPDATE commentaire SET contenu = '"+c.getContenu()+"'WHERE id_commentaire ="+ c.getId_commentaire()+";";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Update commentaire done");
        } 
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public List<Commentaire> afficherCommentaires()
    {
         List<Commentaire> ListCommentaire=new ArrayList <Commentaire>();
        
        ResultSet rs;
        
        String sql ="select * from commentaire";
        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);          
            System.out.println("Affichage Done");
            while(rs.next())
            {
                Commentaire c = new Commentaire();
                c.setId_commentaire(rs.getInt("id_commentaire"));
                c.setId_user(rs.getInt("id_user"));
                c.setContenu(rs.getString("contenu"));
                ListCommentaire.add(c);
                System.out.println(c.toString());
                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       return ListCommentaire;
    }

    @Override
    public List<Commentaire> chercherCommentaireParNom(String nomUti)
    {
        List<Commentaire>ListCommentaire =new ArrayList <Commentaire>();              
       ResultSet rs;
        
        String sql ="select id from fos_user where username='"+nomUti+"';";

        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);    
            rs.next();
            int idUser= rs.getInt("id");
            System.out.println(idUser);
            String sql2="select * from commentaire where id_user ="+idUser+";";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Commentaire commentaire = new Commentaire();
                commentaire.setId_commentaire(rs2.getInt("id_commentaire"));
                commentaire.setContenu(rs2.getString("contenu"));
                commentaire.setId_user(rs2.getInt("id_user"));

                ListCommentaire.add(commentaire);
                System.out.println(commentaire.toString());               
            }
        } 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListCommentaire;
    }
    

    }

