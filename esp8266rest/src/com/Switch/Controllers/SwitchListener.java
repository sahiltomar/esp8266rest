package com.Switch.Controllers;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.Switch.models.ListService;
import com.Switch.models.Switch;
import com.Switch.models.SwitchState;


/**
 * Application Lifecycle Listener implementation class SwitchListener
 *
 */
@WebListener
public class SwitchListener implements ServletContextListener {

	@EJB
	private ListService ls;
	
    public SwitchListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    
    public void contextDestroyed(ServletContextEvent event)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    	Switch s1 = new Switch("switch1","OFF");
    	Switch s2 = new Switch("switch2","OFF");
    	
    	//List<Switch> sList = Arrays.asList(s1,s2);	
    	
    	//ServletContext sc = event.getServletContext();
    	//sc.setAttribute("SwitchList", sList);
    	
    	ls.addSwitch(s1);
        ls.addSwitch(s2);   
        
       // List<Switch>sList = (List<Switch>)ls.getList();
    	//ServletContext sc = event.getSession().getServletContext();
    //	HttpSession session = event.getSession();
    	//sc.setAttribute("SwitchList", sList);
    	//session.set
    }
	
}
