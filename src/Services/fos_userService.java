/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.fos_user;
import IServices.Ifos_user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author user
 */
public class fos_userService implements Ifos_user {
    
    Connection conn;

    public fos_userService() {
        this.conn=MyDB.getinstance().getConnexion();
    }
    
    @Override
    public void addUser(fos_user u) {
            String sql ="Insert into fos_user (username,username_canonical,"
                    + "email,email_canonical,enabled,salt,password,locked,expired,roles,"
                    + "credentials_expired,adresse,code_postal,sexe,num_tel,photo_profil,pays) "
                    + "values ('"+u.getUsername()+"','"+u.getUsername_canonical()+"',"
                    + "'"+u.getEmail()+"','"+u.getEmail_canonical()+"',"
                    + "'"+u.getEnabled()+"','"+u.getSalt()+"','"+u.getPassword()+"','"+u.getLocked()+"','"+u.getExpired()+
                    "','"+u.getRoles()+"','"+u.getCredentials_expired()+"','"+u.getAdresse()+"','"+
                    u.getCode_postal()+"','"+u.getSexe()+"','"+u.getNum_tel()+"','"+u.getPhoto_profil()+"','"
                    +u.getPays()+"');";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Add done");
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
            System.err.println("sql: " + sql);
        }   
    }

    @Override
    public void delete_user(fos_user u) {
        String sql ="DELETE FROM fos_user WHERE id= "+u.getId()+";";
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
    public void editPassword(String password, int id) {
        String sql = "UPDATE fos_user SET password = '"+password+"' WHERE id ="+id+";";
        
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
        }    
    }

    @Override
    public void editUser(fos_user u) {
//        String sql = "UPDATE fos_user SET "
        String sql = "UPDATE fos_user SET adresse = '"+u.getAdresse()+"',photo_profil = '"+u.getPhoto_profil()+"',code_postal = '"
                    +u.getCode_postal()+"',num_tel ="+u.getNum_tel()+" WHERE id ="+ u.getId()+";";
        
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
        }    
    }

    @Override
    public void activerCompte(int id) {

        String sql = "UPDATE fos_user SET locked = '"+1+"' WHERE id ="+id+";";

        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Modification effectuée");
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }    
    }

    @Override
    public List<fos_user> afficherUtilisateur() {
        List<fos_user> ListUsers=new ArrayList <fos_user>();
        
        ResultSet rs;
        
        String sql ="select * from fos_user";
        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);          
            System.out.println("Display Done");
            while(rs.next())
            {
                fos_user user = new fos_user();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setAdresse(rs.getString("adresse"));
                //user.setDate_de_naissance(rs.getString("date_naissance"));
                user.setSexe(rs.getString("sexe"));
                user.setNum_tel(rs.getInt("num_tel"));
                ListUsers.add(user);
                System.out.println(user.toString());                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       return ListUsers ;
    }

    @Override
    public void Authentifier(String login, String password) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(login);
           
        if ( m.matches()) { 
            
            try {
            /// login == email donc je veux selecter selon email
                System.out.println("Tentative  avec email");

                String sql = "Select * from fos_user WHERE email = '"+login +"' and password = '"+password +"';";
                Statement stl= conn.createStatement();
                ResultSet rs =stl.executeQuery(sql);
                                if(rs.next()){ 
                                    System.out.println( rs.getInt("id")+ " is connected ");}
                                else{
                                                       System.err.println("check your email or password");

                                }
           } catch (SQLException ex) {
                   System.err.println("check your email or password");
           }
            
        }
        else { /// login == username donc je veux selecter selon username 
            System.err.println("Tentative  avec username");
            try {
                

                String sql = "Select * from fos_user WHERE username = '"+login +"' and password = '"+password +"';";
                Statement stl= conn.createStatement();
                ResultSet rs  = stl.executeQuery(sql);
                if(rs.next()){ 
                                    System.out.println( rs.getInt("id")+ " is connected ");}
                                else{
                                                       System.err.println("check your username or password");

                                }
           } catch (SQLException ex) {
                   System.err.println("check your username or password");
           } 
        }
 
    }

    @Override
    public boolean verifyAccountStatus(int id) {
        String sql = "SELECT locked from fos_user where id ="+id+";"; 
        boolean test = false ;
        try {
            Statement stl = conn.createStatement();
            ResultSet rs = stl.executeQuery(sql);
            rs.next();
            
            if (rs.getInt("locked") == 0 ){
                test = false;
                System.out.println("locked");
            }
            else {
                test=  true ;
                System.out.println("mech locked ya fraise ya bnin");
            }
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }    
        return test ;
    }
    

    
    
}
