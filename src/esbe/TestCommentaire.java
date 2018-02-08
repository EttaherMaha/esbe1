/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbe;

import Entities.Commentaire;
import Services.CommentaireService;

/**
 *
 * @author Maha
 */
public class TestCommentaire 
{
     public static void main(String[] args) 
    {
        // TODO code application logic here
        Commentaire c2 = new Commentaire(1,"Merci beaucoup pour votre excellent travail ");
        Commentaire c3 = new Commentaire(2,"Franchement Professionnel bravo");
        Commentaire c4= new Commentaire(2,"Le top du top . Bon courage doc .");
        CommentaireService cs = new CommentaireService();
        
        //TEST AJOUT
        
        /*
        cs.ajouterCommentaire(c2);
        cs.ajouterCommentaire(c3);
        cs.ajouterCommentaire(c4);
        */
        // TEST SUPRESSION!
        
        c2.setId_commentaire(9);
        cs.supprimerCommentaire(c2);
        
        
        //TEST MODIFICATITON
        
        c2.setId_commentaire(8);
        c2.setContenu("BOOOOOON");
        cs.modifierCommentaire(c2);
        
        // TEST AFFICHAGE
        
        cs.afficherCommentaires();
        
        // Test Recherche
        
       cs.chercherCommentaireParNom("maha");
        
       
    }
    
}
