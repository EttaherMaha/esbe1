/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author anis
 */
public class SalledeSport {
    private int id_salle;
    private int nb_entraineur;

    public SalledeSport(int nb_entraineur) {
        this.nb_entraineur = nb_entraineur;
    }

    public SalledeSport() {
    }

    public int getId_salle() {
        return id_salle;
    }

    public void setId_salle(int id_salle) {
        this.id_salle = id_salle;
    }

    public int getNb_entraineur() {
        return nb_entraineur;
    }

    public void setNb_entraineur(int nb_entraineur) {
        this.nb_entraineur = nb_entraineur;
    }

    @Override
    public String toString() {
        return "SalledeSport{" + "id_salle=" + id_salle + ", nb_entraineur=" + nb_entraineur + '}';
    }
    
    
    
}
