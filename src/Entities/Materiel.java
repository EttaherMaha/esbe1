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
public class Materiel {
    
    
    
    private int id ;
    private String nom , description ;
    private int id_Salle ;
    private TypeProduitSalleDeSport type ;

   

    
    
    
    /////////////******************  Constractor ***************////
    
    
    public Materiel() {
    }

    public Materiel( String nom, String description) {
       // this.id = id;
        this.nom = nom;
        this.description = description;
    }

    
    //////////////////********** Getter & Setter *****///////////////
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
     public int getId_Salle() {
        return id_Salle;
    }

    public void setId_Salle(int id_Salle) {
        this.id_Salle = id_Salle;
    }

    public String getType() {
        return type.name();
    }

    public void setType(TypeProduitSalleDeSport type) {
        this.type = type;
    }
    
    
    
    ///////***************** toString ************************/////////////
    
    @Override
    public String toString() {
        return "Materiel{" + "id=" + id + ", nom=" + nom + ", description=" + description + '}';
    }
    
    
    
    
    
    
    
}
