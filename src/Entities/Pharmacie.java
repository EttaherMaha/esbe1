/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Utils.type;

/**
 *
 * @author anis
 */
public class Pharmacie {
    
   private int id_pharmacie;
   private type type;

    public Pharmacie(type type) {
        this.type = type;
    }

    public Pharmacie() {
    }

    
   
   
    public int getId_pharmacie() {
        return id_pharmacie;
    }

    public void setId_pharmacie(int id_pharmacie) {
        this.id_pharmacie = id_pharmacie;
    }

    public String getType() {
        return type.name();
    }

    public void setType(type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pharmacie{" + "id_pharmacie=" + id_pharmacie + ", type=" + type + '}';
    }
   
   
    
}
