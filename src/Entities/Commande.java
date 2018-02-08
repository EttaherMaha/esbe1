/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author elbrh
 */
public class Commande {
    private int id_produit ;
    private int id_user ;
    private int id_commande ;
    
    
    
    /******* Constructor ****/
    public Commande(int id_produit, int id_user, int id_commande) {
        this.id_produit = id_produit;
        this.id_user = id_user;
        this.id_commande = id_commande;
    }

    public Commande() {
    }

    
    
    /****** Getter & Setter *****/ 

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande= id_commande;
    }
    
       /**
     * toString();
     */

    @Override
    public String toString() {
        return "Commande{" + "id_produit=" + id_produit + ", id_user=" + id_user + ", id_etab=" + id_commande + '}';
    }
    
    
    
 
    
    
    
    
    
    
    
}
