/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.fos_user;
import java.util.List;

/**
 *
 * @author user
 */
public interface Ifos_user {
    public void addUser(fos_user u);
    public void delete_user(fos_user u);
   public void editPassword(String password, int id);
   public void editUser(fos_user u);
   public void activerCompte (int id);
   //public void rechercherUtilisateur (String nom);
   public List <fos_user> afficherUtilisateur();
   public boolean verifyAccountStatus(int id); //vérifier si le compte est activé ou désactivé
   public void Authentifier (String login,String password);
}
