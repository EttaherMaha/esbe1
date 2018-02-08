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
public class Laboratoire {
    private int id_laboratoire;
    private int cnam;
    private int nb_equipe;
    private String type;
    private int id_etab;

    public Laboratoire(int cnam, int nb_equipe, String type, int id_etab) {
        this.cnam = cnam;
        this.nb_equipe = nb_equipe;
        this.type = type;
        this.id_etab = id_etab;
    }

    public int getId_laboratoire() {
        return id_laboratoire;
    }

    public void setId_laboratoire(int id_laboratoire) {
        this.id_laboratoire = id_laboratoire;
    }

    public int getCnam() {
        return cnam;
    }

    public void setCnam(int cnam) {
        this.cnam = cnam;
    }

    public int getNb_equipe() {
        return nb_equipe;
    }

    public void setNb_equipe(int nb_equipe) {
        this.nb_equipe = nb_equipe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId_etab() {
        return id_etab;
    }

    public void setId_etab(int id_etab) {
        this.id_etab = id_etab;
    }

    @Override
    public String toString() {
        return "Laboratoire{" + "id_laboratoire=" + id_laboratoire + ", cnam=" + cnam + ", nb_equipe=" + nb_equipe + ", type=" + type + ", id_etab=" + id_etab + '}';
    }
    
    
}
