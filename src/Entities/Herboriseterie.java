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
public class Herboriseterie {
 
    private int id_herbo;
    private String type;
    private int id_etab;

    public Herboriseterie(int id_herbo, String type, int id_etab) {
        this.id_herbo = id_herbo;
        this.type = type;
        this.id_etab = id_etab;
    }

    public int getId_herbo() {
        return id_herbo;
    }

    public void setId_herbo(int id_herbo) {
        this.id_herbo = id_herbo;
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
        return "Herboriseterie{" + "id_herbo=" + id_herbo + ", type=" + type + ", id_etab=" + id_etab + '}';
    }
    
    
}
