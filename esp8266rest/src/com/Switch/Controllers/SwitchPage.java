package com.Switch.Controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Switch.models.ListService;
import com.Switch.models.Switch;
import com.Switch.models.SwitchState;

/**
 * Servlet implementation class SwitchPage
 */
@WebServlet("/SwitchPage")
public class SwitchPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	ListService ls;
	
	/*Switch s1 = new Switch("Switch1",SwitchState.valueOf("OFF"));
	Switch s2 = new Switch("Switch1",SwitchState.valueOf("OFF"));
	
	List<Switch> sList = Arrays.asList(s1,s2);	*/
	
    public SwitchPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/switch_page.jsp").forward(request, response);;
		
	}

	List<Switch> sList = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		if(request.getParameter("switch1") != null && request.getParameter("switch1").equals("switch1")){
			
			sList = (List<Switch>)ls.getList();
     		String sw1	= sList.get(0).getSwitchState();

			ls.updateSwitch(sw1,sList.get(0));
			
				
		}	
		else{// if(request.getParameter("switch2").equals("switch2")){
			sList = (List<Switch>)ls.getList();
			String sw2	= sList.get(1).getSwitchState();
			
			ls.updateSwitch(sw2, sList.get(1));
		
		}
		
	//	sc.setAttribute("SwitchList", sList);
		 //System.out.println(sList.size());
	    response.sendRedirect("SwitchPage");
	    
	   
	}
	
}
