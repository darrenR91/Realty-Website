/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import src.entities.Favourites;
import src.entities.Styles;

/**
 *
 * @author Darren
 */
public class FavouritesDB {
    public static Favourites getFavouritesById(int favId)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
         try {
             Favourites a = em.find(Favourites.class,favId);
             return a;
         } // end try
        finally
         {
             em.close();
         } // end finally
    }
    public static Favourites insertFavouriteList(Favourites a)
  {
      EntityManager em = DBUtil.getEmf().createEntityManager();
      EntityTransaction trans = em.getTransaction();
      try {
             trans.begin();
             em.persist(a);
             trans.commit();
             return a;
         } // end try
        finally
         {
             em.close();
         } // end finally
      
  }
public static void cleanDB()
{
    EntityManager em = DBUtil.getEmf().createEntityManager();

    Query query = em.createNamedQuery("Favourites.cleanDB");  
    try {
       query.executeUpdate();
      
      }//end try
        catch (Exception ex) {
           
        }//end catch
    finally
     {
         em.close();
     } // end finally
}
}
