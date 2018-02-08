/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbe;

import Entities.Demande;
import Services.DemandeService;

/**
 *
 * @author Maha
 */
public class TestDemande
{
      public static void main(String[] args)
   {
       
    Demande d1;
    d1 = new Demande("rania","Eer",12345678,"2018-02-20","image","image","image","image",123,"image",1);
    DemandeService cs= new DemandeService();
    
    //test ajout
    
    cs.ajouterDemande(d1);
    
    //TEST SUPPRESSION
    
    //d1.setId_demande(1);
   // cs.supprimerDemande(d1);
    
    
    //TEST AFFICHAGEµ
    
  //  cs.afficherDemandes();
    
    // TEST RECHERCHE
       System.out.println("******");
      // cs.chercherDemandeParNom("rania");
       
      // cs.modifierDemande(d1);
      cs.afficherDemandes();

       
       
       
       
       
    
   }
    
    
}
