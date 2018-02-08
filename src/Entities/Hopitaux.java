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
public class Hopitaux {
    
    private int id_hopital;
    private String type;
    private int urgence;
    private int cnam;


    public Hopitaux(String type, int urgence, int cnam) {
        this.type = type;
        this.urgence = urgence;
        this.cnam = cnam;
 
    }

    public int getId_hopital() {
        return id_hopital;
    }

    public void setId_hopital(int id_hopital) {
        this.id_hopital = id_hopital;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUrgence() {
        return urgence;
    }

    public void setUrgence(int urgence) {
        this.urgence = urgence;
    }

    public int getCnam() {
        return cnam;
    }

    public void setCnam(int cnam) {
        this.cnam = cnam;
    }



    @Override
    public String toString() {
        return "Hopitaux{" + "id_hopital=" + id_hopital + ", type=" + type + ", urgence=" + urgence + ", cnam=" + cnam + '}';
    }
    
    
}
