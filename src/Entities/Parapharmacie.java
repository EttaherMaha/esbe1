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
public class Parapharmacie extends Etablissement {
    
    private int id_para;
    private int livraison;


    public Parapharmacie(int livraison) {
        this.livraison = livraison;

    }

    public Parapharmacie() {
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


    @Override
    public String toString() {
        return "Parapharmacie{" + "id_para=" + id_para + ", livraison=" + livraison + '}';
    }

 
    
    
    
}
