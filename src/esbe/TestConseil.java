/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbe;

import Entities.Conseil;
import Services.ConseilService;

/**
 *
 * @author Maha
 */
public class TestConseil
{
   public static void main(String[] args)
   {
        
        Conseil conseil1= new Conseil(" Consommez des légumes verts foncés, comme des épinards, du chou frisé et du brocoli",66,1);
        Conseil conseil2= new Conseil("Aj",60,1);
        Conseil conseil3= new Conseil("La peau est le reflet de notre état de santé général. Or, la peau est soumise chaque jour à de multiples agressions. De plus, le temps qui passe modifie ses besoins. La peau doit donc être nourrie et protégée en permanence, pour se régénérer et rester en bonne santé.",59,2);
        Conseil conseil4= new Conseil("Nos cheveux et nos ongles sont le reflet de la santé générale de notre corps. Pourtant, ils sont agressés en permanence par le soleil, le vent, les brushings ou lissages, les colorations... De plus, certains événements sont propices à la chute de cheveux, comme le changement de saison, après une grossesse...",59,1);

        
        
        ConseilService cs = new ConseilService();
        
        //TEST AJOUUT
        
       //cs.ajouterConseil(conseil1);
       //cs.ajouterConseil(conseil2);
       //cs.ajouterConseil(conseil3);
       //cs.ajouterConseil(conseil4);
       
        // TEST SUPRESSION!
        conseil1.setId_conseil(2);
        cs.supprimerConseil(conseil1);
       
        // TEST RECHERCHE AVANCEE
        //cs.chercherConseilParCategorie("yeux");
           System.out.println("*******");
        cs.chercherConseilParMedecin("maha");
        System.out.println("*******");
        
        // TEST AFFICHAGE
                        System.out.println("***AFFICHAGE ***");

        
        cs.afficherConseils();
        
        // TEST MODIFICATION 
        conseil2.setId_conseil(3);
        conseil2.setDescription("Notre poids dépend de ce que nous mangeons, mais également de nos dépenses énergétiques. La sédentarité, un déséquilibre alimentaire sur le long terme, le stress peuvent avoir également des répercussions sur notre poids.");
        cs.modifierConseil(conseil2);
        
                System.out.println("***AFFICHAGE APRES MODIFICATION****");
              
        cs.afficherConseils(); 
   }  
    
}


