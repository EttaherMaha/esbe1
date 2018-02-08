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
public class CabinetMedical {
    private int id_cabinet;
    private int cnam;

    
     public CabinetMedical( int cnam) {

        this.cnam = cnam;

    }

    public CabinetMedical() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_cabinet() {
        return id_cabinet;
    }

    public void setId_cabinet(int id_cabinet) {
        this.id_cabinet = id_cabinet;
    }

    public int getCnam() {
        return cnam;
    }

    public void setCnam(int cnam) {
        this.cnam = cnam;
    }

    @Override
    public String toString() {
        return "CabinetMedical{" + "id_cabinet=" + id_cabinet + ", cnam=" + cnam + '}';
    }



   

    
    
    
}
