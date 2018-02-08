/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import Entities.RendezVous;
import IServices.IRendezVous;
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
 * @author acer
 */
public class RendezVousservice implements IRendezVous {

    Connection connexion;

    public RendezVousservice() {
        connexion = MyDB.getinstance().getConnexion();
    }

    @Override
    public void ajouterRendezvous(RendezVous rdv) {
        try {
            String query = "INSERT INTO rdv ( type, date, id_user, id_service, id_partenaire, etat )"
                    + "values ( '" + rdv.getType() + "', '" + rdv.getDate() + "', " + rdv.getId_user() + ", " + rdv.getId_service() + ", " + rdv.getId_partenaire() + ", '" + rdv.getEtat() + "' )";
            Statement state = connexion.createStatement();
            state.executeUpdate(query);
            System.out.println("Ajout effectué");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }

    }

    @Override
    public void supprimerRendezvous(RendezVous rdv) {
        try {
            
            Statement state = connexion.createStatement();
            state.executeUpdate("DELETE from rdv where date='" + rdv.getDate() + "'");
            System.out.println("supression effectuée");
        } catch (SQLException ex) {
            System.out.println("supression echouee");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }
    }

    @Override
    public List<RendezVous> afficherRendezvous() {
        List<RendezVous> lsrdv = new ArrayList<RendezVous>();
        try {
            Statement state = connexion.createStatement();
            ResultSet rs = state.executeQuery("select * from rdv");

            while (rs.next()) {
                Timestamp input=rs.getTimestamp("date");
                LocalDateTime date=input.toLocalDateTime();
                RendezVous rdv = new RendezVous();
                rdv.setId_rdv(rs.getInt("id_rdv"));
                rdv.setDate(date);
                rdv.setId_user(rs.getInt("id_user"));
                rdv.setId_partenaire(rs.getInt("id_partenaire"));
                rdv.setId_service(rs.getInt("id_service"));

                rdv.setEtat(rs.getString("etat"));
                rdv.setType(rs.getString("type"));

                lsrdv.add(rdv);
                System.out.println(rdv);
            }
        } catch (SQLException ex) {
            System.out.println("Affichage echoué");
        }
        return lsrdv;
    }

    @Override
    public void modifierRendezvous(RendezVous rdv) {
        try {
            String query = "UPDATE rdv SET type='" + rdv.getType() + "', date='" + rdv.getDate() + "', id_service=" + rdv.getId_service() + ",id_partenaire=" + rdv.getId_partenaire() + ",etat='" + rdv.getEtat() + "' where id_rdv=" + rdv.getId_rdv() + ";";

            Statement stm = connexion.createStatement();
            stm.executeUpdate(query);
            System.out.println("Modification effectué");
        } catch (SQLException ex) {
            System.out.println("Echec de modification");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    @Override
    public List<RendezVous> chercherRendezvousDate(LocalDateTime dt) {
        List<RendezVous> lsrdv = new ArrayList<RendezVous>();
        try {
            String sql = "select * from rdv where date='" + dt + "';";
            
            Statement state = connexion.createStatement();
            ResultSet rs = state.executeQuery(sql);
            

            while (rs.next()) {
                Timestamp input=rs.getTimestamp("date");
                LocalDateTime date=input.toLocalDateTime();
                RendezVous rdv = new RendezVous();
                rdv.setId_rdv(rs.getInt("id_rdv"));
                rdv.setDate(date);
                rdv.setId_user(rs.getInt("id_user"));
                rdv.setId_partenaire(rs.getInt("id_partenaire"));
                rdv.setId_service(rs.getInt("id_service"));

                rdv.setEtat(rs.getString("etat"));
                rdv.setType(rs.getString("type"));

                lsrdv.add(rdv);
                
                    System.out.println(rdv);
                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return lsrdv;
    }

}
