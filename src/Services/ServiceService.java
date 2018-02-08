/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.ProduitPharmaceutique;
import Entities.Service;
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
 * @author elbrh
 */
public class ServiceService implements IServices.IService{
    
    Connection conn ;

    public ServiceService() {
        this.conn = MyDB.getinstance().getConnexion();
    }
    
    
    @Override
    public void addService(Service s) {
        
        String sql ="Insert into services(nom,description,tarif) values ('"+s.getNom()+"','"
                    +s.getDescription()+"',"+s.getTarif()+");";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Add Done");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
    }

    @Override
    public void editService(Service s) {
        String sql ="UPDATE services SET nom = '"+s.getNom()+"',description = '"
                    +s.getDescription()+"',tarif ="+s.getTarif()+" WHERE id ="+ s.getId()+";";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Update done");
        } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public void deleteService(Service s) {
       String sql ="DELETE FROM services WHERE id = "+s.getId()+";";
        try {
            Statement stl = conn.createStatement();
            stl.executeUpdate(sql);
            System.out.println("Delete Done");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public Service showService(Service s) {
        Service service = new Service() ;
        ResultSet rs = null ;
        String sql ="SELECT * FROM services WHERE id = "+s.getId()+";";
        try {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            rs.next();
            service = new Service(rs.getString("nom"),rs.getString("description") , rs.getFloat("tarif"));
            System.out.println(service.toString());
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return service;
    }

    @Override
    public List<Service> searchService(String nom) {
        List<Service> ls = new ArrayList<>();
        ResultSet rs ;
        Service service ;
        String sql ="SELECT * FROM services WHERE nom = '"+nom+"';";
        try {
            Statement stl = conn.createStatement();
            rs = stl.executeQuery(sql);
            while(rs.next()){
                 service = new Service(rs.getString("nom"),rs.getString("description") , rs.getFloat("tarif"));
                 service.setId(rs.getInt("id"));
                 System.out.println(service.toString());
                 ls.add(service);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return ls;
    
    
    }
    
    
}
