/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import src.entities.Properties;

/**
 *
 * @author Darren
 */
public class PropertiesDB {
   
public static List<Properties> getAllProperties()
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        Query q = em.createNamedQuery("Properties.findAll");
        List<Properties> list;
        
        try {
             list = q.getResultList();
             return list;
         } // end try
        finally
         {
             em.close();
         } // end finally
}
public static Properties getPropertyByID(Integer id)
    {
    
        EntityManager em = DBUtil.getEmf().createEntityManager();
         try {
             Properties a = em.find(Properties.class,id);
             return a;
         } // end try
        finally
         {
             em.close();
         } // end finally
    }
public static String getPropType(Integer typeId)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        Query q = em.createNamedQuery("Propertytypes.findPropertyTypeByTypeId");
        q.setParameter("typeId",typeId);
         try {
             String PropType = (String)q.getSingleResult();
             return PropType;
         } // end try
        finally
         {
             em.close();
         } // end finally
    }  
public static String getStyleType(Integer typeId)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        Query q = em.createNamedQuery("Styles.findStyleTypeByTypeId");
        q.setParameter("styleId",typeId);
         try {
             String PropType = (String)q.getSingleResult();
             return PropType;
         } // end try
        finally
         {
             em.close();
         } // end finally
    } 
public static String getGarageType(Integer typeId)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        
        Query q = em.createNamedQuery("Garagetypes.findGarageTypeByTypeId");
        q.setParameter("garageId",typeId);
         try {
             String PropType = (String)q.getSingleResult();
             return PropType;
         } // end try
        finally
         {
             em.close();
         } // end finally
    } 
public static List<Properties> getAllPropertiesByWishList(List<Integer> ids)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
       
        Query query = em.createNamedQuery("Properties.getAllFavourites");     
        query.setParameter("ids", ids);
         try {
           List resultList = query.getResultList();
           return resultList;
          }//end try
            catch (Exception ex) {
                return null;
            }//end catch
        finally
         {
             em.close();
         } // end finally
    } 
public static List<Properties> getAllPropertiesByAgent(Integer agentId)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        Query q = em.createNamedQuery("Properties.findByAgentId");
        q.setParameter("agentId",agentId);
        
         try {
           List resultList = q.getResultList();
           return resultList;
          }//end try
            catch (Exception ex) {
                return null;
            }//end catch
        finally
         {
             em.close();
         } // end finally
    }
public static List<String> getAllLocations()
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
       
        Query query = em.createNamedQuery("Properties.getAllLocations");
      
         try {
           List List = query.getResultList();
           List<String> resultList = new ArrayList<>(new LinkedHashSet<>(List));
           return resultList;
          }//end try
            catch (Exception ex) {
                return null;
            }//end catch
        finally
         {
             em.close();
         } // end finally
    }
public static List<Properties> getAllPropertyBySearch(String Location,Double MinPrice,Double MaxPrice,Integer minSquarFeet,Integer maxSquarFeet,Integer Bedrooms)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
        Integer notSet = -1;
        Double doublenotSet = 0.1;
         try {
            
    CriteriaBuilder qb = em.getCriteriaBuilder();
    CriteriaQuery cq = qb.createQuery();
    Root<Properties> property = cq.from(Properties.class);

    //Constructing list of parameters
    List<Predicate> predicates = new ArrayList<Predicate>();
    
    //Adding predicates in case of parameter not being null
    if (!Location.equals("AllLocations")) {
        predicates.add(
                qb.equal(property.get("city"), Location));
    }
    if (MinPrice != doublenotSet  && MaxPrice != 0) {
        predicates.add(
                qb.between(property.get("price"), MinPrice, MaxPrice));
    }
    if (Bedrooms != notSet) {
        predicates.add(
                qb.equal(property.get("bedrooms"), Bedrooms));
    }
    if (minSquarFeet != notSet && maxSquarFeet != notSet) {
        predicates.add(
                qb.between(property.get("squarefeet"), minSquarFeet, maxSquarFeet));
    }
    //query itself
    cq.select(property)
            .where(predicates.toArray(new Predicate[]{}));
    //execute query and do something with result
    List<Properties> List= em.createQuery(cq).getResultList();
    
           return List;
          }//end try
            catch (Exception ex) {
                return null;
            }//end catch
        finally
         {
             em.close();
         } // end finally
    } 
public static List<Integer> getRoomCount()
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
       
        Query query = em.createNamedQuery("Properties.getRoomCount");
      
         try {
           List<Integer> List = query.getResultList();
           List<Integer> resultList = new ArrayList<>(new LinkedHashSet<>(List));
           
           return resultList;
          }//end try
            catch (Exception ex) {
                return null;
            }//end catch
        finally
         {
             em.close();
         } // end finally
    }
public static List<Properties> getRecentlyAdded(Date startDate,Date todaysDate)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
       
        Query query = em.createNamedQuery("Properties.getRecentPropertys");  
        query.setParameter("startDate", startDate);
        query.setParameter("todaysDate", todaysDate); 
      
        try {
           List List = query.getResultList();
           return List;
          }//end try
            catch (Exception ex) {
                return null;
            }//end catch
        finally
         {
             em.close();
         } // end finally
    }
public static List<Properties> getfiveRecentlyAdded(Date startDate,Date todaysDate)
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
       
        Query query = em.createNamedQuery("Properties.getRecentPropertys");  
        query.setParameter("startDate", startDate);
        query.setParameter("todaysDate", todaysDate); 
      
        try {
           List List = query.setMaxResults(5).getResultList();
           return List;
          }//end try
            catch (Exception ex) {
                return null;
            }//end catch
        finally
         {
             em.close();
         } // end finally
    }
public static List<Properties> getOldest()
    {
        EntityManager em = DBUtil.getEmf().createEntityManager();
       
        Query query = em.createNamedQuery("Properties.getOldest");  
        try {
           List List = query.setMaxResults(5).getResultList();
           return List;
          }//end try
            catch (Exception ex) {
                return null;
            }//end catch
        finally
         {
             em.close();
         } // end finally
    }
public static int insertProperty(Properties a)
  {
      EntityManager em = DBUtil.getEmf().createEntityManager();
      EntityTransaction trans = em.getTransaction();
      int id;
      try {
             trans.begin();
             em.persist(a);
             trans.commit();
             return a.getId();
         } // end try
        finally
         {
             em.close();
         } // end finally
      
  }
public static void updateProperty(Properties a)
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
public static void deleteProperty(Integer id)
  {
      EntityManager em = DBUtil.getEmf().createEntityManager();
      EntityTransaction trans = em.getTransaction();
      
      try {
             Properties a = em.find(Properties.class,id);
             trans.begin();
             em.remove(a);
             trans.commit();
         } // end try
        finally
         {
             em.close();
         } // end finally
            
  }
}
