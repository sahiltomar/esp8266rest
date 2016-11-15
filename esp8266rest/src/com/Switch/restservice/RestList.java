package com.Switch.restservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.Switch.models.ListService;
import com.Switch.models.Switch;

@Path("/getSwitchState")
public class RestList {

	@Context
	UriInfo uriInfo;

	@EJB
	ListService ls;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Switch> getSwitchState() {
		// List<Switch> sList;
		// @Context HttpServletRequest request
		// HttpSession session = request.getSession(true);
		// sList= (List<Switch>) session.getAttribute("SwitchList");

		// UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
		// URI uri = uriBuilder.build(sList);

		// if(sList == null){

		// Response.serverError();
		// }
		// return Response.status(500).build();

		// return Response.created(uri).build();
		
		if(ls != null){
			List<Switch> sList = ls.getList();
	    	if(sList == null){
	    		
	    		System.out.println("Switch List is null");
	    	}
			return sList;
		}

		return null;
	}

}
