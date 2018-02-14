/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.CabinetMedical;
import Entities.Etablissement;
import Entities.Pharmacie;

/**
 *
 * @author anis
 */
public interface IPharmacie {
    
    public void ajouterPharmacie(Pharmacie p,Etablissement e);
    public void supprimerPharmacie(Pharmacie c);
    public void modifierCabinet(Pharmacie c,Etablissement e); 
}
