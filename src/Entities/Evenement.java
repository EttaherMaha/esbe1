/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Maha
 */
public class Evenement 
{
    private int id_event;
    private Date date_debut;
    private Date date_fin;
    private String image;
    private int id_user;
    private int id_categorie;
   private String description;

    public Evenement()
    {
    }

    public Evenement(Date date_debut, Date date_fin, String image, int id_user, int id_categorie,String description)
    {
        this.date_debut =date_debut;
        this.date_fin =date_fin;
        this.image = image;
        this.id_user = id_user;
        this.id_categorie=id_categorie;
        this.description=description;
        
    }

 

    public int getId_event()
    {
        return id_event;
    }

    public Date getDate_debut()
    {
        return date_debut;
    }

    public Date getDate_fin()
    {
        return date_fin;
    }

    public String getImage()
    {
        return image;
    }

    public int getId_user()
    {
        return id_user;
    }

    public int getId_categorie()
    {
        return id_categorie;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }  
    
    public void setId_categorie(int id_categorie)
    {
        this.id_categorie = id_categorie;
    }
    
    public void setId_event(int id_event)
    {
        this.id_event = id_event;
    }

    public void setDate_debut(Date date_debut)
     {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin)
    {
        this.date_fin = date_fin;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public void setId_user(int id_user) 
    {
        this.id_user = id_user;
    }

    @Override
    public String toString() 
    {
        return "Evenement{" + "id_event=" + id_event + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", image=" + image + ", id_user=" + id_user + ", id_categorie=" + id_categorie + ", description=" + description + '}';
    }



    
   
    
    
    
    
   
    
    
}
