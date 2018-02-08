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
public class Parapharmacie {
    
    private int id_para;
    private int livraison;
    private int id_etab;

    public Parapharmacie(int livraison, int id_etab) {
        this.livraison = livraison;
        this.id_etab = id_etab;
    }

    public int getId_para() {
        return id_para;
    }

    public void setId_para(int id_para) {
        this.id_para = id_para;
    }

    public int getLivraison() {
        return livraison;
    }

    public void setLivraison(int livraison) {
        this.livraison = livraison;
    }

    public int getId_etab() {
        return id_etab;
    }

    public void setId_etab(int id_etab) {
        this.id_etab = id_etab;
    }

    @Override
    public String toString() {
        return "Parapharmacie{" + "id_para=" + id_para + ", livraison=" + livraison + ", id_etab=" + id_etab + '}';
    }

 
    
    
    
}
