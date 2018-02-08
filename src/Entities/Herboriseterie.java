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


    public Herboriseterie(int id_herbo, String type) {
        this.id_herbo = id_herbo;
        this.type = type;

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



    @Override
    public String toString() {
        return "Herboriseterie{" + "id_herbo=" + id_herbo + ", type=" + type + '}';
    }
    
    
}
