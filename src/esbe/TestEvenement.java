/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbe;

import Entities.Evenement;
import Services.EvenementService;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

      */
         
         Evenement event1,event2;
         Date d= new Date(2018-02-16);
         Date d1= new Date(2019-03-12);
         Date d2= new Date(2019-04-17);
         Date d3= new Date(2019-05-12);
         //event1 = new Evenement(d,d1, "image", 2,67 , "ALOOOOOOO ");
         event2 = new Evenement(d2,d3, "image", 1,67 , "jjdidddda");


         EvenementService cs= new EvenementService();
         
        //TEST AJOUT!
         
        cs.ajouterEvenement(event2);
        //cs.ajouterEvenement(event2);
         
         // TEST SUPRESSION!
         
         //event1.setId_event(3);
         //cs.supprimerEvenement(event1);
         
         //TEST AFFICHAGE!
          
          cs.afficherEvenements();
          System.out.println("******************");
          cs.chercherEvenementParCategorie("Promo");
          
          
          System.out.println("******************");
          cs.chercherEvenementParNomUtilisateur("maha");

        
          
          
          
          //ajouter+modifier maiekhdmoush
       
          
         
         
     }

    
}
