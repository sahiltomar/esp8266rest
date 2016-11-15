package com.Switch.models;

import java.lang.annotation.Repeatable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
//import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.core.Context;

/**
 * Session Bean implementation class ListService
 */
//@Singleton(name="ListService")
@Stateful
@LocalBean
public class ListService {

    /**
     * Default constructor. 
     */
    public ListService() {
        // TODO Auto-generated constructor stub
    }
    
    
    @PersistenceContext(unitName = "ESP8266DBMS",type=PersistenceContextType.EXTENDED)
    private EntityManager em;
    
   
    public List<Switch> getList(){
    	
    	TypedQuery<Switch> query = em.createQuery("SELECT s from Switch s",Switch.class);
    	
    	List<Switch> sList = query.getResultList();
    	
    	return sList;
    }

    
    public void addSwitch(Switch s){
    	
    	//TypedQuery<Switch> query = em.createQuery("SELECT s from Switch s",Switch.class);
    	
    //	List<Switch> sList = query.getResultList();
    	
    	//int id=s.getId();
    	
    	//if(sList.contains(s) && sList != null){
    		
    		//em.createQuery("UPDATE Switch set switchState =\'ON\' where Id ="+id+"",Switch.class).executeUpdate();
    	//}
    	//else{
    		
    		em.persist(s);
    //	}
    	
    	
    }
    
    public void updateSwitch(String sw,Switch s){
    	
    	
    	Integer id = s.getId();
    	
    	//
    	if(sw == "ON"){
    		
    		
    		Query query = em.createQuery("update Switch set switchState = 'OFF'"+" where Id = "+id+"",Switch.class);
    		//query.setParameter("id", id);
    		query.executeUpdate();
    		s.setSwitchState("OFF");
    		em.merge(s);
    		em.flush();
    	    
    		
    	}else{
    		
    		
    		Query query = em.createQuery("update Switch set switchState = 'ON'"+" where Id = "+id+"",Switch.class);
    		//query.setParameter("id", id);
    		query.executeUpdate();
    		s.setSwitchState("ON");
    		em.merge(s);
    		em.flush();
    		
    	}
    	
    	
    	
    }
}
