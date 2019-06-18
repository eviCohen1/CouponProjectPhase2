package com.evicohen.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/company")
public class CompanyService {
	
	
	  @Path("/test2")
	  @GET
	  @Produces(MediaType.TEXT_PLAIN)
	public String getTest() { 
		
		return "test"; 
	}

}
