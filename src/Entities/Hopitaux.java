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
    private int id_etab;

    public Hopitaux(String type, int urgence, int cnam, int id_etab) {
        this.type = type;
        this.urgence = urgence;
        this.cnam = cnam;
        this.id_etab = id_etab;
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

    public int getId_etab() {
        return id_etab;
    }

    public void setId_etab(int id_etab) {
        this.id_etab = id_etab;
    }

    @Override
    public String toString() {
        return "Hopitaux{" + "id_hopital=" + id_hopital + ", type=" + type + ", urgence=" + urgence + ", cnam=" + cnam + ", id_etab=" + id_etab + '}';
    }
    
    
}
