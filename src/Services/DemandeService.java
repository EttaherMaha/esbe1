/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Demande;
import IServices.IDemande;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maha
 */
public class DemandeService implements IDemande
{
      Connection conn;
    
    public DemandeService()
    {
        this.conn=MyDB.getinstance().getConnexion();
    }

    
    @Override
    public void ajouterDemande(Demande d)
    {
        if (CheckDemande(d.getId_user())){
            modifierDemande(d);
            System.out.println("yeaaah");
        }
        else {
        String sql ="Insert into demande(nom,prenom,CIN,date_naissance,CIN_image_recto,CIN_image_verso,diplome,photo_etab,num_identifiant,patente,id_user) values ('"+d.getNom()+"','"+d.getPrenom()+"',"
                    +d.getCIN()+",'"+d.getDate_naissance()+"','"+d.getCIN_image_recto()+"','"+d.getCIN_image_verso()+"','"+d.getDiplome()+"','"+d.getPhoto_etab()+"',"+d.getNum_identifiant()+",'"+d.getPatente()+"',"+d.getId_user()+");";
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
        
    }

    @Override
    public void supprimerDemande(Demande d)
    {
         String sql ="DELETE FROM demande WHERE id_demande= "+d.getId_demande()+";";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Delete Demande Done");
        } 
        catch (SQLException ex) 
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    @Override
    public void modifierDemande(Demande d)
    {
        String sql ="UPDATE demande SET nom = '"+d.getNom()+"',prenom = '"+d.getPrenom()+
                "',CIN= '"+d.getCIN()+"',date_naissance= '"+d.getDate_naissance()+"',CIN_image_recto= '"+
                d.getCIN_image_recto()+"',CIN_image_verso= '"+d.getCIN_image_verso()+"',diplome= '"+d.getDiplome()+
                "',photo_etab= '"+d.getPhoto_etab()+"',num_identifiant= "+d.getNum_identifiant()+",patente='"+
                d.getPatente()+"'  WHERE id_user ="+d.getId_user()+";";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Update demande done");
        } 
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public List<Demande> afficherDemandes()
    {
        List<Demande> ListDemande=new ArrayList <Demande>();
        
        ResultSet rs;
        
        String sql ="select * from demande";
        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql); 
            
            System.out.println("Affichage Done");
            while(rs.next())
            {
                Demande demande = new Demande();
                demande.setId_demande(rs.getInt("id_demande"));
                demande.setNom(rs.getString("nom"));
                demande.setPrenom(rs.getString("prenom"));
                demande.setCIN(rs.getInt("CIN"));
                demande.setDate_naissance(rs.getString("date_naissance"));
                demande.setCIN_image_recto(rs.getString("CIN_image_recto"));
                demande.setCIN_image_verso(rs.getString("CIN_image_verso"));
                demande.setDiplome(rs.getString("diplome"));
                demande.setPhoto_etab(rs.getString("photo_etab"));
                demande.setNum_identifiant(rs.getInt("num_identifiant"));
                demande.setPatente(rs.getString("patente"));
                demande.setId_user(rs.getInt("id_user"));
                ListDemande.add(demande);
                System.out.println(demande.toString());                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       return ListDemande ;
    }

    
    @Override
    public List<Demande> chercherDemandeParNom(String nomUti) 
    {
         List<Demande> ListDemande=new ArrayList <Demande>();              
        ResultSet rs;
        String sql ="select id from fos_user where username = '"+nomUti+"';";

        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);    
            rs.next();
            int iduti= rs.getInt("id");
            System.out.println(iduti);
            String sql2="select * from demande where id_user ="+iduti+";";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Demande demande = new Demande();
                demande.setId_demande(rs2.getInt("id_demande"));
                demande.setNom(rs2.getString("nom"));
                demande.setPrenom(rs2.getString("prenom"));
                demande.setCIN(rs2.getInt("CIN"));
                demande.setDate_naissance(rs2.getString("date_naissance"));
                demande.setCIN_image_recto(rs2.getString("CIN_image_recto"));
                demande.setCIN_image_verso(rs2.getString("CIN_image_verso"));
                demande.setDiplome(rs2.getString("diplome"));
                demande.setPhoto_etab(rs2.getString("photo_etab"));
                demande.setNum_identifiant(rs2.getInt("num_identifiant"));
                demande.setPatente(rs2.getString("patente"));
                demande.setId_user(rs2.getInt("id_user"));

                ListDemande.add(demande);
                System.out.println(demande.toString());               
            }
        } 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListDemande;
    }

    @Override
    public boolean CheckDemande(int id_user)
    {
        String sql = "select * from demande where id_user = "+id_user +";";
        Statement stl;
          try {
              stl = conn.createStatement();
               ResultSet rs = stl.executeQuery(sql);
               if (rs.next()){
                   return true ;
               }
          } catch (SQLException ex) {
              System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
          }
        return false ;
        
    }
}
