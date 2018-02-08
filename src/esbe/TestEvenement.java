/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbe;

import Entities.Evenement;
import Services.EvenementService;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;



/**
 *
 * @author Maha
 */
public class TestEvenement
{
     public static void main(String[] args) throws ParseException
     {  
      /*SimpleDateFormat ft = 
      new SimpleDateFormat ("yyyy.MM.dd");
         SimpleDateFormat date=new SimpleDateFormat("YYYY-MM-DD");
                  DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         String start = null;
        Date startDate = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(start).getTime());

      
         // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          
//        Date date = new Date();
         
         */
         


        LocalDate d = LocalDate.parse( "2015-09-02" );
        LocalDate d1 = LocalDate.parse( "2016-02-04" );

        System.out.println(d);
        System.out.println(d1);
  
       // Date dd = new Date(115, 05, 20);
        
        
        Evenement event1=new Evenement(d,d1,"9h","30min","Promo salle de sport","image",67,1);
        
         EvenementService cs= new EvenementService();
         
        //TEST AJOUT!//
         
        // cs.ajouterEvenement(event1);
        //cs.ajouterEvenement(event2);
         
         // TEST SUPRESSION!
         
         //event1.setId_event(3);
         //cs.supprimerEvenement(event1);
         
         //TEST AFFICHAGE!
         cs.afficherEvenements();
         System.out.println("******promo************");
        //cs.chercherEvenementParCategorie("Promo");
       
          //System.out.println("******************");
          //cs.chercherEvenementParNomUtilisateur("maha");
          
          //CHERCHER PAR DATE 
          //cs.chercherEvenementParDate(d);
          event1.setId_event(4);
          
          //MODIF
          cs.modifierEvenement(event1);
          System.out.println("********************");
          cs.chercherEvenementParCategorie("yeux");
          System.out.println(" //////////////// ");
          cs.chercherEvenementParNomUtilisateur("rania");
        
          
          

          
         
         
     }

    
}
