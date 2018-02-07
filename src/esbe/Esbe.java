/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbe;

import Entities.Categorie;
import Services.CategorieService;

/**
 *
 * @author Maha
 */
public class Esbe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Categorie c1 = new Categorie("Bouche et dents",1);
        Categorie c2 = new Categorie("Coeur,circulation,veines",1);
        Categorie c3 = new Categorie("Douleurs et fièvres",1);
        Categorie c4 = new Categorie("Estomac,intestein,diabètes",1);
        Categorie c5 = new Categorie("Métabolisme et diabète",1);
        Categorie c6 = new Categorie("Nez,gorge et oreilles",1);
        Categorie c7 = new Categorie("Peaux, cheveux et ongles",1);
        Categorie c8 = new Categorie("Psychisme et dépendance",2);
        Categorie c9 = new Categorie("Reins et voie urinaires",2);
        Categorie c10 = new Categorie("Sexualité et contraception",2);
        Categorie c11 = new Categorie("Système nerveux",2);
        Categorie c12 = new Categorie("Voies respiratoires",2);
        Categorie c13 = new Categorie("Yeux",2);

        CategorieService cs = new CategorieService();
        
        // TEST AJOUT!
      /*
        cs.ajouterCategorie(c1);
        cs.ajouterCategorie(c2);
        cs.ajouterCategorie(c3);
        cs.ajouterCategorie(c4);
        cs.ajouterCategorie(c5);
        cs.ajouterCategorie(c6);
        cs.ajouterCategorie(c7);
        cs.ajouterCategorie(c8);
        cs.ajouterCategorie(c9);
        cs.ajouterCategorie(c10);
        cs.ajouterCategorie(c11);
        cs.ajouterCategorie(c12);
        cs.ajouterCategorie(c13);
        
        */
        // TEST SUPRESSION!
        /*
         c1.setId_categorie(19);
         cs.supprimerCategorie(c1);
         c1.setId_categorie(26);
         cs.supprimerCategorie(c1);
         c1.setId_categorie(18);
         cs.supprimerCategorie(c1);
         c1.setId_categorie(17);
         cs.supprimerCategorie(c1);
         c1.setId_categorie(16);
         cs.supprimerCategorie(c1);
        */
        
        
        //TEST MODIFICATITON
        
        c1.setId_categorie(65);
        c1.setNom("Estomac,intestin et fièvre");   
        cs.modifierCategorie(c1);
        
        
        
        // TEST AFFICHAGE!
        
        //cs.afficherCategorie();
        
       //TEST RECHERCHE       
       cs.chercherCommentaireParNom("maha");
       // cs.ChercherCategorieParId(4);
        
        
        
        
    }
    
}
