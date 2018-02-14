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
public class Laboratoire extends Etablissement {
    private int id_laboratoire;
    private int cnam;
    private int nb_equipe;
    private String type;


    public Laboratoire(int cnam, int nb_equipe, String type) {
        this.cnam = cnam;
        this.nb_equipe = nb_equipe;
        this.type = type;
    }

    public Laboratoire() {
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



    @Override
    public String toString() {
        return "Laboratoire{" + "id_laboratoire=" + id_laboratoire + ", cnam=" + cnam + ", nb_equipe=" + nb_equipe + ", type=" + type +  '}';
    }
    
    
}
