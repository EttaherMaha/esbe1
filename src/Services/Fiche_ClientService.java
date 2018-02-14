/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Etablissement;
import Entities.Fiche_Client;
import IServices.IFiche_Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class Fiche_ClientService implements IFiche_Client{
    
    Connection conn;
private ObservableList<Fiche_Client> data;
    public Fiche_ClientService() {
        this.conn=MyDB.getinstance().getConnexion();
    }
    

    @Override
    public void ajouterFicheClient(Fiche_Client fc) {
        String sql ="Insert into fiche_client(suivie,id_user,id_etab) values ('"+fc.getSuivie()+"','"+fc.getId_user()+"',"+fc.getId_etablissement()+");";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Ajout effectué");
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }    }

    @Override
    public void supprimerFicheClient(Fiche_Client fc) {
        String sql ="DELETE FROM fiche_client WHERE id_user= "+fc.getId_user()+" AND id_etab= "+fc.getId_etablissement()+"; ";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Suppression de la fiche effectuée");
        } 
        catch (SQLException ex) 
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void modifierFicheClient(Fiche_Client fc) {
        String sql = "UPDATE fiche_client SET suivie = '"+fc.getSuivie()+"' WHERE id_user= "+fc.getId_user()+" AND id_etab= "+fc.getId_etablissement()+"; ";
        
        /*select id from user where roles='user' and id='id_partenaire';*/
          /*select * from fiche_client  where roles='user' and id='id_partenaire';*/
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Modification effectuée");
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }    }
 
    @Override
    public Fiche_Client afficherFicheClient(Fiche_Client fc) {
        Fiche_Client fiche_client = new Fiche_Client() ;
        ResultSet rs ;
        String sql ="SELECT * FROM fiche_client WHERE id_user= "+fc.getId_user()+" AND id_etablissement= "+fc.getId_etablissement()+"; ";
        try {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            rs.next();
            fiche_client = new Fiche_Client(rs.getString("suivie"), rs.getInt("Id_user"), rs.getInt("Id_etab"));
            System.out.println(fiche_client.toString());
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return fiche_client;    
    }
    
   
    @Override
    public List<Fiche_Client> afficherToutFicheClient() {
      List<Fiche_Client> ListFiche=new ArrayList <Fiche_Client>();
        
        //ResultSet rs;
        
        String sql ="select * from fiche_client";
        try 
        {
            Statement stl = conn.createStatement();
             ResultSet rs=stl.executeQuery(sql);          
            System.err.println("Display Done");
            while(rs.next())
            {
                Fiche_Client fiche = new Fiche_Client();
                fiche.setId_user(rs.getInt("id_user"));
                fiche.setId_etablissement(rs.getInt("id_etab"));
                fiche.setSuivie(rs.getString("suivie"));

                ListFiche.add(fiche);
                System.out.println(fiche.toString());                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       return ListFiche ;
    }

    @Override
    public ObservableList<Fiche_Client> rechercherFiche_Client(String nom) {
     data = FXCollections.observableArrayList();
        List<Fiche_Client> ListFicheClient=new ArrayList <Fiche_Client>();              
        ResultSet rs;
       
                String sql1="select id_user from fiche_client;";
           // String sql2="select username from user where id="+rs.getInt("id_user")+";";
                Fiche_Client fiche_client = new Fiche_Client() ;
                List <Fiche_Client> e = new ArrayList <Fiche_Client>();
  
       // String sql2="select username from user where id="+rs.getInt("id_user")+";";
        try 
        {
            Statement stl = conn.createStatement();

            ResultSet  rs1=stl.executeQuery(sql1);       
            System.out.println("Affichage Done");
            while(rs1.next())
            {
                String sql2="select username from user where id="+rs1.getInt("id_user")+";";
                Statement st2 = conn.createStatement();
                ResultSet  rs2=st2.executeQuery(sql2);
                while(rs2.next())
                    {
                      Fiche_Client  FicheClient = new Fiche_Client(rs1.getString("suivie"), rs1.getInt("id_user"), rs1.getInt("id_etab"));
                        data.add(FicheClient);
                        System.out.println(e);               
                    }
        }} 
        
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        return data;}

       
}
