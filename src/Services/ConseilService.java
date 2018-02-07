/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Conseil;
import IServices.IConseil;
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
public class ConseilService implements IConseil 
{
        Connection conn;
    
    public ConseilService()
    {
        this.conn=MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterConseil(Conseil c) 
    {
        String sql ="Insert into conseil(description,id_categorie,id_user) values ('"+c.getDescription()+"',"+c.getId_categorie()+","
                    +c.getId_user()+");";
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
    public void supprimerConseil(Conseil c) 
    {
        String sql ="DELETE FROM conseil WHERE id_conseil= "+c.getId_conseil()+";";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Delete Conseil Done");
        } 
        catch (SQLException ex) 
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }

    @Override
    public void modifierConseil(Conseil c) 
    {
        String sql ="UPDATE conseil SET description = '"+c.getDescription()+"'WHERE id_conseil ="+ c.getId_conseil()+";";
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
        }
    }

    @Override
    public List<Conseil> afficherConseils()
    {
        List<Conseil> ListConseils=new ArrayList <Conseil>();
        
        ResultSet rs;
        
        String sql ="select * from conseil";
        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);          
            System.out.println("Affichage Done");
            while(rs.next())
            {
                Conseil cons = new Conseil();
                cons.setId_conseil(rs.getInt("id_conseil"));
                cons.setDescription(rs.getString("description"));
                cons.setId_categorie(rs.getInt("id_categorie"));
                cons.setId_user(rs.getInt("id_user"));
                ListConseils.add(cons);
                System.out.println(cons.toString());                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       return ListConseils ;
               
    }

    @Override
    public List<Conseil> chercherConseilParCategorie(String nomCategorie) 
            
    {
       List<Conseil> ListConseil=new ArrayList <Conseil>();              
       ResultSet rs;
        
        String sql ="select id_categorie from categorie where nom='"+nomCategorie+"';";

        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);    
            rs.next();
            int idcateg= rs.getInt("id_categorie");
            System.out.println(idcateg);
            String sql2="select * from conseil where id_categorie ="+idcateg+";";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Conseil conseil = new Conseil();
                conseil.setId_conseil(rs2.getInt("id_conseil"));
                conseil.setDescription(rs2.getString("description"));
                conseil.setId_categorie(rs2.getInt("id_categorie"));
                conseil.setId_user(rs2.getInt("id_user"));

                ListConseil.add(conseil);
                System.out.println(conseil.toString());               
            }
        } 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListConseil;
    }

    
    
    @Override
    public List<Conseil> chercherConseilParMedecin(String nomMedecin)
    {
        List<Conseil> ListConseil=new ArrayList <Conseil>();              
        ResultSet rs;
        String sql ="select id from fos_user where (roles = 'medecin') AND (username = '"+nomMedecin+"');";

        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);    
            rs.next();
            int idmedecin= rs.getInt("id");
            System.out.println(idmedecin);
            String sql2="select * from conseil where id_user ="+idmedecin+";";
            Statement st2 = conn.createStatement();
            ResultSet  rs2=st2.executeQuery(sql2);       
            System.out.println("Affichage Done");
            while(rs2.next())
            {
                Conseil conseil = new Conseil();
                conseil.setId_conseil(rs2.getInt("id_conseil"));
                conseil.setDescription(rs2.getString("description"));
                conseil.setId_categorie(rs2.getInt("id_categorie"));
                conseil.setId_user(rs2.getInt("id_user"));

                ListConseil.add(conseil);
                System.out.println(conseil.toString());               
            }
        } 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return ListConseil;
        
        
        
    }
    
}