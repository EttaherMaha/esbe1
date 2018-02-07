/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Categorie;
import java.util.List;

/**
 *
 * @author Maha
 */
public interface ICategorie 
{
    public void ajouterCategorie(Categorie cat);
    public void supprimerCategorie(Categorie cat);
    public void modifierCategorie(Categorie cat);
    public List<Categorie>afficherCategorie();
    public List<Categorie> chercherCommentaireParNom(String nomUti);

}
