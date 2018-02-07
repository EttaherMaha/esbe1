/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Evenement;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Maha
 */
public interface IEvenement 
{
    public void ajouterEvenement(Evenement e);
    public void supprimerEvenement(Evenement e);
    public void modifierEvenement(Evenement e);
    public List<Evenement>afficherEvenements();
    public List<Evenement> chercherEvenementParCategorie(String nomCategorie); 
    public List<Evenement> chercherEvenementParNomUtilisateur(String nomUti);   
    public List<Evenement> chercherEvenementParDate(Date date); 
}
