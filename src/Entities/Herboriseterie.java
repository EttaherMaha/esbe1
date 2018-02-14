/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Ellouze Skander
 */
public class Herboriseterie extends Etablissement {
 
    private int id_herbo;
    private int livraison;


    public Herboriseterie(int id_herbo, int livraison) {
        this.id_herbo = id_herbo;
        this.livraison = livraison;

    }

    public Herboriseterie() {
    }

    public int getId_herbo() {
        return id_herbo;
    }

    public void setId_herbo(int id_herbo) {
        this.id_herbo = id_herbo;
    }

    public int getLivraison() {
        return livraison;
    }

    public void setLivraison(int livraison) {
        this.livraison = livraison;
    }



    @Override
    public String toString() {
        return "Herboriseterie{" + "id_herbo=" + id_herbo + ", livraison=" + livraison + '}';
    }
    
    
}
