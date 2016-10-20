/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import src.entities.Propertytypes;

/**
 *
 * @author Darren
 */
public class PropertytypeDB {
    public static List<Propertytypes> getAllPropertytypes()
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        Query q = em.createNamedQuery("Propertytypes.findAll");
        List<Propertytypes> list;
        
        try {
             list = q.getResultList();
             return list;
         } // end try
        finally
         {
             em.close();
         } // end finally
    }
}
