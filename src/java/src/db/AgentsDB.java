/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import src.entities.Agents;

/**
 *
 * @author Darren
 */
public class AgentsDB {
    

    public static List<Agents> getAllAgents()
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        Query q = em.createNamedQuery("Agents.findAll");
        List<Agents> list;
        
        try {
             list = q.getResultList();
             return list;
         } // end try
        finally
         {
             em.close();
         } // end finally
}
public static Agents getByAgentId(Integer Id)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        try {
             Agents a = em.find(Agents.class,Id);
             return a;
         } // end try
        finally
         {
             em.close();
         } // end finally   
    }
public static Agents getByUsername(String username)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        try {
            Query q = em.createNamedQuery("Agents.findByUsername");
            q.setParameter("username",username);
        
            Agents a = (Agents) q.getSingleResult();
            
            return a;
            } // end try
        finally
         {
             em.close();
         } // end finally  
    }
public static void updateAgent(Agents a)
  {
      
      EntityManager em = DBUtil.getEmf().createEntityManager();
      EntityTransaction trans = em.getTransaction();
      try {
             trans.begin();
             em.persist(em.merge(a));
             trans.commit();
         } // end try
        finally
         {
             em.close();
         } // end finally
  }

}
