/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices;

import Entities.RendezVous;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author acer
 */
public interface IRendezVous {
    
    
    public void ajouterRendezvous(RendezVous rdv);
    public void supprimerRendezvous(RendezVous rdv);
    public List<RendezVous> afficherRendezvous();
    public void modifierRendezvous(RendezVous rdv);
    public  List<RendezVous> chercherRendezvousDate(LocalDateTime dt);
    
}
