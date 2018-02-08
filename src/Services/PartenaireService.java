/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.Partenaire;
import Entities.fos_user;
import IServices.IPartenaire;
import Utils.SpecialitePartenaire;
import Utils.TypePartenaire;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class PartenaireService implements IPartenaire{

    Connection conn;

    public PartenaireService() {
        this.conn=MyDB.getinstance().getConnexion();
    }
    
    @Override
    public void addPartenaire(Partenaire p) {
//        String sql =" Insert into fos_user (username, username_canonical, email, email_canonical, password, adresse, date_naissance, code_postal, sexe, num_tel, photo_profil, pays, type, specialite) values ('"+p.getUsername()+"','"+p.getUsername_canonical()+"','"+p.getEmail()+"','"+p.getEmail_canonical()+"','"+p.getPassword()+"','"+p.getAdresse()+"','"+p.getDate_naissance()+"','"+p.getCode_postal()+"','"+p.getSexe()+"','"+p.getNum_tel()+"','"+p.getPhoto_profil()+"','"+p.getPays()+"','"+p.getType()+"','"
//                    +p.getSpecialite()+"');";
        
        String sql = "UPDATE fos_user SET roles ='"+p.getRoles()+"' ,specialite='"+p.getSpecialite()+"' ,  type='"+p.getType()+"'  WHERE id ="+p.getId()+";";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("zedneh");
        }
        catch (SQLException ex)
        {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println("SQLState: " + ex.getSQLState());
            System.err.println("VendorError: " + ex.getErrorCode());
        }   
    }

    @Override
    public void deletePartenaire(Partenaire p) {
        String sql ="DELETE FROM fos_user WHERE id= "+p.getId()+";";
        try 
        {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("fassakhneh");
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
        
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Baddalneh");
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }  
    }

    @Override
    public void activerCompte(int id) {
         String sql = "UPDATE fos_user SET locked = "+1+" WHERE id ="+id+";";

        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Activineh");
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }    
    }
    
    @Override
    public void Authentifier(String login, String password) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(login);
           
        if ( m.matches()) { 
            
            try {
            /// login == email donc je veux selecter selon email
                System.out.println("yeahaaa");

                String sql = "Select * from fos_user WHERE email = '"+login +"' and password = '"+password +"';";
                Statement stl= conn.createStatement();
                ResultSet rs =stl.executeQuery(sql);
                                if(rs.next()) System.out.println( rs.getInt("id")+ " is connected ");
           } catch (SQLException ex) {
                   System.err.println("check your email or password");
           }
            
        }
        else { /// login == username donc je veux selecter selon username 
            System.err.println("ihhhhhh");
            try {
                

                String sql = "Select * from fos_user WHERE username = '"+login +"' and password = '"+password +"';";
                Statement stl= conn.createStatement();
                ResultSet rs  = stl.executeQuery(sql);
                if(rs.next()) System.out.println( rs.getInt("id")+ " connected ");
           } catch (SQLException ex) {
                   System.err.println("check your username or password");
           } 
        }
 
    }

    
     @Override
    public List<Partenaire> afficherPartenaire() {
        List<Partenaire> ListPart=new ArrayList <Partenaire>();
        
        ResultSet rs;
        
        String sql ="select * from fos_user where roles = 'Partenaire' ";
        try 
        {
            Statement stl = conn.createStatement();
            rs=stl.executeQuery(sql);          
            System.out.println("Display Done");
            while(rs.next())
            {
                Partenaire part = new Partenaire();
                part.setId(rs.getInt("id"));
                part.setUsername(rs.getString("username"));
                part.setAdresse(rs.getString("adresse"));
                part.setNum_tel(rs.getInt("num_tel"));
                part.setSexe(rs.getString("sexe"));
                part.setEmail(rs.getString("email"));
                part.setRoles(rs.getString("roles"));
                part.setType(TypePartenaire.valueOf(rs.getString("type")));
                part.setSpecialite(SpecialitePartenaire.valueOf(rs.getString("specialite")));
                ListPart.add(part);
                System.out.println(part.toString());                
            }
        } 
        catch (SQLException ex) 
            
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
       return ListPart ;
    
    }
    

    @Override
    public List<Partenaire> searchPartenaire(SpecialitePartenaire specialite) {
        List<Partenaire> ListPart = new ArrayList<Partenaire>() ;
        
        ResultSet rs ;
        String sql = "select * from  fos_user  where specialite = '"+specialite.name()+ "';";
        try{
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            while (rs.next()) {
                Partenaire part = new Partenaire();
                part.setId(rs.getInt("id"));
                part.setUsername(rs.getString("username"));
                part.setAdresse(rs.getString("adresse"));
                part.setSpecialite(SpecialitePartenaire.valueOf(rs.getString("specialite")));
                System.out.println(part.toString());
                ListPart.add(part);
                
            }
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        if(ListPart.isEmpty()){
                    System.out.println("8alit ya 7bibi");
                }
        return ListPart;
    }



    
    
}
