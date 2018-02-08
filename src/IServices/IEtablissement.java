/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Etablissement;
import java.util.List;

/**
 *
 * @author Ellouze Skander
 */
public interface IEtablissement {
    

public List<Etablissement> chercherEtablissementParNom(String nom);
public List<Etablissement> chercherEtablissementParAdresse(String adresse);
public List<Etablissement> afficherEtablissement();
 
}
