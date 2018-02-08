/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.TypeProduitSalleDeSport;

/**
 *
 * @author elbrh
 */
public class ProduitSalleDeSport extends Produit{
    
    private TypeProduitSalleDeSport type ;
    private int id_salle ;

    ////////////************ Constructor *****************//////////////

    public ProduitSalleDeSport() {
    }
    
    
    public ProduitSalleDeSport(TypeProduitSalleDeSport type, String nom, String description, String image, float prix) {
        super( nom, description, image, prix);
        this.type = type;
      // this.id_salle = id_salle ;
    }

    
    /////////*********** Getter & Setter **********************//////////////
    public String getType() {
        return type.name();
    }

    public void setType(TypeProduitSalleDeSport type) {
        this.type = type;
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }
    
    
    
    
    
}
