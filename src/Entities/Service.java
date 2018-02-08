/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author elbrh
 * 
 * each partner has many services 
 */
public class Service {
    
    private int id ; 
    private String nom,description ;
    private float tarif ;
    private int id_etab;
    
    ///////////*********** Constructor ************************//////////////////

    public Service() {
    }
    
    

    public Service( String nom, String description, float tarif) {
        this.nom = nom;
        this.description = description;
        this.tarif = tarif;
    }
    
    
    
    ///////////********** Getter & Setter *****************//////////////////////

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

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public int getId_etab() {
        return id_etab;
    }

    public void setId_etab(int id_etab) {
        this.id_etab = id_etab;
    }
    
    
    
    
    
    //////////********** toString  ***********//////////////////

    @Override
    public String toString() {
        return "Services{" + "id=" + id + ", nom=" + nom + ", description=" + description + ", tarif=" + tarif + '}';
    }
    
    
    
    
    
    
}
