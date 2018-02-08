/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Partenaire;
import Utils.SpecialitePartenaire;
import java.util.List;

/**
 *
 * @author user
 */
public interface IPartenaire {
   public void addPartenaire(Partenaire p);
   public void deletePartenaire (Partenaire p);
   public void editPassword(String password, int id);
   public void activerCompte (int id);
   public List <Partenaire> searchPartenaire(SpecialitePartenaire specialite);
   public List <Partenaire> afficherPartenaire();
   public void Authentifier (String login,String password);
}
