/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DataStorage.MyDB;
import IServices.ICommande;
import Entities.Commande;
import Entities.Produit;
import java.sql.Connection;

/**
 *
 * @author elbrh
 */
public class CommandeService implements ICommande{
    Connection conn ;

    public CommandeService() {
        this.conn = MyDB.getinstance().getConnexion();
    }

    @Override
    public void passCommande(Commande c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addProductToCommande(Produit p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void annulerCommande(int id_commande) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showMyCommande(int id_user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showCommandebyEtab(int id_etab) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    
    
    
    
    
    
    
}
