/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Conseil;
import java.util.List;

/**
 *
 * @author Maha
 */
public interface IConseil
{
    public void ajouterConseil(Conseil c);
    public void supprimerConseil(Conseil c);
    public void modifierConseil(Conseil c);
    public List<Conseil>afficherConseils();
    public List<Conseil> chercherConseilParCategorie(String nomCategorie);
    public List<Conseil> chercherConseilParMedecin(String nomMedecin); 
}
