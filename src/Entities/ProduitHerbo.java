/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.CategorieProduitHerbo;
/**
 *
 * @author elbrh
 */
public class ProduitHerbo extends Produit {
    
    private boolean bio  ; 
    private String marque ;
    private CategorieProduitHerbo categorie ;
    private int id_herbo ;

    public ProduitHerbo() {
    }

    
    /******************* Constructor *****************************************/
    
    
    
    
    
    public ProduitHerbo(Boolean bio, String marque, CategorieProduitHerbo categorie, String nom, String description, String image, float prix) {
        super( nom, description, image, prix);
        if (bio = true ){
                    this.bio = bio;

        }else {
                    this.bio = bio;

        }
        this.marque = marque;
        this.categorie = categorie;
        //this.id_herbo = id_herbo;
    }    
    
    /////*********** Getter & Setter ***********///////
    
    
    public boolean getBio() {
        return bio;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCategorie() {
        return categorie.name();
    }

    public void setCategorie(CategorieProduitHerbo categorie) {
        this.categorie = categorie;
    }

    public int getId_herbo() {
        return id_herbo;
    }

    public void setId_herbo(int id_herbo) {
        this.id_herbo = id_herbo;
    }

    /************ toString ***************///
    
    
    @Override
    public String toString() {
        return  super.toString() + "Produit_herbo{" + "bio=" + bio + ", marque=" + marque + ", categorie=" + categorie.name() + ", id_herbo=" + id_herbo + '}';
    }
    
    
    
    
    
    
    
    
}
