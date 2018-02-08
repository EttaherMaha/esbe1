/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.CategorieProduitParapharmacie;

/**
 *
 * @author elbrh
 */
public class ProduitParapharmacie extends Produit {
    
    
    
    private String marque ; 
    private CategorieProduitParapharmacie categorie ;
    private int id_para ;
    
    
    
    
    
    ///////////////////********* Constructor *************/////////

    public ProduitParapharmacie(String marque, CategorieProduitParapharmacie categorie, String nom, 
                                String description, String image, float prix) {
        
        super( nom, description, image, prix);
        this.marque = marque;
        this.categorie = categorie;
    }

    public ProduitParapharmacie() {
    }

    
    
    
    //////////***** Getter & Setter ****///////////////////////// 
    
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCategorie() {
        return categorie.toString();
    }

    public void setCategorie(CategorieProduitParapharmacie categorie) {
        this.categorie = categorie;
    }

    public int getId_para() {
        return id_para;
    }

    public void setId_para(int id_para) {
        this.id_para = id_para;
    }
    
    
    
    ////////////************ toString ***********/////////////////////

    @Override
    public String toString() {
        return super.toString() + "ProduitParapharmacie{" + "marque=" + marque + ", categorie=" + categorie.name() + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
}
