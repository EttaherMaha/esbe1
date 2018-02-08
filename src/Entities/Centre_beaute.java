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
public class Centre_beaute {
    private int id_centre;
    private String image;
    private int id_etab;

    public Centre_beaute(int id_centre, String image,int id_etab) {
        this.id_centre = id_centre;
        this.image = image;
        this.id_etab=id_etab;
    }

    public int getId_etab() {
        return id_etab;
    }

    public void setId_etab(int id_etab) {
        this.id_etab = id_etab;
    }

    public int getId_centre() {
        return id_centre;
    }

    public void setId_centre(int id_centre) {
        this.id_centre = id_centre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Centre_beaute{" + "id_centre=" + id_centre + ", image=" + image + ", id_etab=" + id_etab + '}';
    }

 
    
    
    
    
}
