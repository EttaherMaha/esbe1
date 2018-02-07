/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Categorie;
import IServices.ICategorie;
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
public class CategorieService implements ICategorie
{
    Connection conn;
    
    public CategorieService()
    {
        this.conn=MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterCategorie(Categorie cat) 
    {
        String sql= "Insert into categorie(nom,id_user) values ('"+cat.getNom()+"','"+cat.getId_user()+"');";
         try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Add categorie Done");
             }
         catch (SQLException ex) 
            {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
             }
        
    }

    @Override
    public void supprimerCategorie(Categorie cat)
            
    {
            String sql ="DELETE FROM categorie WHERE id_categorie= "+cat.getId_categorie()+";";
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
    public void modifierCategorie(Categorie cat)
    {
         String sql ="UPDATE categorie SET nom = '"+cat.getNom()+"'WHERE id_categorie ="+ cat.getId_categorie()+";";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Update categorie done");
        } 
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
        
    }

    @Override
    public List<Categorie> afficherCategorie()
    {
        List<Categorie> ListCategorie=new ArrayList <Categorie>();
        
        ResultSet rs;
        
        String sql ="select * from categorie";
        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);          
            System.out.println("Affichage Done");
            while(rs.next())
            {
                Categorie cat = new Categorie();
                cat.setId_categorie(rs.getInt("id_categorie"));
                cat.setNom(rs.getString("nom"));
                cat.setId_user(rs.getInt("id_user"));
                ListCategorie.add(cat);
                System.out.println(cat.toString());

                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       return ListCategorie;
    }

    @Override
    public List<Categorie> chercherCommentaireParNom(String nomUti) 
    {
       List<Categorie>ListCategorie =new ArrayList <Categorie>();              
       ResultSet rs;       
       String sql ="select id from fos_user where username='"+nomUti+"';";

        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);    
            rs.next();
            int idUser= rs.getInt("id");
            System.out.println(idUser);
            String sql2="select * from Categorie where id_user ="+idUser+";";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Categorie categorie = new Categorie();
                categorie.setId_categorie(rs2.getInt("id_categorie"));
                categorie.setNom(rs2.getString("nom"));
                categorie.setId_user(rs2.getInt("id_user"));

                ListCategorie.add(categorie);
                System.out.println(categorie.toString());               
            }
        } 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListCategorie;
    }

   
/***
    @Override
    public Categorie ChercherCategorieParId(int id_categorie)
    {
        Categorie categorie=null;
        ResultSet rs ;
        String sql="select * from categorie where id_categorie ="+id_categorie+";";
         try 
         {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            categorie= new Categorie(rs.getString("nom"));
            
         }
         catch (SQLException ex)
         {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
          return categorie;
    }
   
    **/
}
