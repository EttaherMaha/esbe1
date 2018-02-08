/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Etablissement;
import Entities.Laboratoire;


/**
 *
 * @author Ellouze Skander
 */
public interface ILaboratoire {
    
        public void ajouterHopitaux(Laboratoire c,Etablissement e);
        public void supprimerHopitaux(Laboratoire c);
        public void modifierHopitaux(Laboratoire c);
}
