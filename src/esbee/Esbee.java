/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esbee;

import Entities.Fiche_Client;
import Entities.Partenaire;
import Entities.fos_user;
import Services.Fiche_ClientService;
import Services.PartenaireService;
import Services.fos_userService;
import Utils.SpecialitePartenaire;
import Utils.TypePartenaire;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author user
 */
public class Esbee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
// TODO code application logic here
       
//test Fos_user
       //fos_user u;
      String string = "January 2, 2010";
DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.US);
Date date = format.parse(string);
        fos_user user;
        
        //fos_user user1 = new fos_user(3, "mahagfhgg", "maha.fdgdfettaher@esprit.tn", 1, "pas", "123", date, 1, 1, date, "azer", date, "", 1, date, "", "16-12-1996"  , 4011, "Homme", 92332029, "", "Tunisie");
        //user = new fos_user(1, "raniaa", "rania.miaadani@esprit.tn", 1, "pas", "motdepasse16", date, 1, 1, date, "azer", date, "", 1, date, "", "16-12-1996"  , 4011, "Homme", 92332029, "", "Tunisie");
       
        user= new fos_user("bouuda","sikaa@esprit.tn","motdepasse", "fadit bellehi", "16/12/1996", 2034,
            "Femme", 21639339, "vjdnvdf", "Allemagne");

        // user.setId(2); //suppression selon id on doit extraire id
        fos_userService users = new fos_userService();
        users.Authentifier("raniaa", "motdepasse16");
        //users.Authentifier("rania.midani@esprit.tn", "16");
        //users.addUser(user);
        //users.addUser(user1);
        //users.delete_user(user);
        //users.addUser(user);
        //user1.setId(4);
        //users.delete_user(user1);
        
        //users.editPassword("ok ok 7 motherfuckingday", 1);

        //user.setAdresse("ena rania nheb nrawah");
        //users.editUser(user);


        //users.afficherUtilisateur();

        //users.verifyAccountStatus(1);
        
        
//test Partenaire
      // PartenaireService parts = new PartenaireService();
       //Partenaire part;
      // part=new Partenaire("salah", "salah@esprit.tn","salah fesed", "salah manouba", "16/05/2020", 5555, "Homme", 55046283, "gfdfvd", "Amsterdam",TypePartenaire.Gérant,SpecialitePartenaire.Acupuncteur);
      //part.set
     //  part.setType(TypePartenaire.Médecin);
       //part.setId(11);
       // System.out.println(part.getRoles());
       //parts.addPartenaire(part);
       
       
      // parts.afficherPartenaire();
     //  parts.searchPartenaire(SpecialitePartenaire.Acupuncteur);
        
        
        
        
//testFicheClient
     //   Fiche_Client fc1;
     //  fc1 = new Fiche_Client(85558,"midani","rania","rania.midani@esprit.tn",1,1);
    //   Fiche_Client fc2;
    //   fc2 = new Fiche_Client(5486532,"ettaher","maha","maha.ettaher@esprit.tn",2,1);
    //   Fiche_ClientService fcs = new Fiche_ClientService();
        //TEST AJOUT!
        //fcs.ajouterFicheClient(fc2);
        //fcs.ajouterFicheClient(fc1);
       
        // TEST SUPRESSION!
        //fc1.setId_user(1);
       // fc1.setId_etablissement(1);
        
        //fcs.supprimerFicheClient(fc1);
        
        // TEST AFFICHAGE!
        
       // fc2.setId_user(2);
        //fc1.setNom("Oueslati");
       //fc2.setId_user(2);
       //fc2.setNom("Oueslati");
       //fc2.setPrenom("Fatma");
        //fcs.modifierFicheClient(fc2);
        //fcs.afficherFicheClient(fc2);
        //fcs.afficherFicheClient(fc1);
        
         //fcs.afficherToutFicheClient();
        
       // fcs.rechercherFiche_Client("Oueslati");
    }    }
    
