/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.Commande;
import Entities.Produit;
import java.util.List;

/**
 *
 * @author elbrh
 */
public interface ICommande {
    public void passCommande(Commande c); // product contains in one etab 
    public void addProductToCommande(Produit p);
    public void annulerCommande(int id_commande);
    public List<Commande> showMyCommande(int id_user);
    public List<Commande> showCommandebyid(int id_commande);

}
