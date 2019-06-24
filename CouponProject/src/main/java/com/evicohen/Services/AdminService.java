package com.evicohen.Services;


import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.evicohen.Exceptions.CreateException;
import com.evicohen.Exceptions.DBException;
import com.evicohen.Facade.AdminFacade;
import com.evicohen.JavaBeans.Company;
import com.evicohen.Main.CouponSystem;
import com.evicohen.Main.CouponSystem.clientType;
import com.google.gson.Gson;


@Path("admin")
public class AdminService {

	public AdminService() {
		System.out.println("Im here 1");
	}

//	@Context
//	private HttpServletRequest request;
//	@Context
//	private HttpServletResponse response;
//
//	private AdminFacade getFacade() {
//
//		AdminFacade admin = null;
//		admin = (AdminFacade) request.getSession(false).getAttribute("facade");
//		return admin;
//
//	}
	
	
	private AdminFacade getFacade() throws Exception {

		AdminFacade admin = null;
		admin = (AdminFacade) CouponSystem.getCouponSystem().login("admin", "1234", clientType.Admin);
		System.out.println(admin);
		return admin;

	}
	
	@Path("getAllCompanies")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCompnies () throws Exception {
		
		AdminFacade admin = getFacade();
		Collection<Company> companies = admin.getAllCompanies(); 		
		return new Gson().toJson(companies); 	
		
	}
	
	@GET 
	@Path ("getCompany/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getComapny (@PathParam("companyId") long comId) throws Exception { 
		
		AdminFacade admin = getFacade() ; 
		
		try { 
			
			Company company = admin.getCompany(comId);
			if ( company != null) { 
				return new Gson().toJson(company); 
			}
			
			
		}catch ( Exception e ) { 
			
		}
		
		return null ; 
		
	}
	
//	@POST 
//	@Path("CreateCompany")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response createComapny ( String jsonComString) throws Exception { 
//		
//		AdminFacade admin = getFacade(); 
//		Gson gson = new Gson(); 
//		
//
//		
//		Company companyJason = gson.fromJson(jsonComString,Company.class);  
//		
//		if ( companyJason != null && admin.createCompany(companyJason) ) { 
//			
//			return Response.ok(200).entity("Created Company" + companyJason.getCompName()).build(); 
//		}else { 
//			return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity("Failed to Create Company" + companyJason.getCompName()).build(); 
//		}
//
//	}

	// Create new Company, used AdminFacade //
	
	@Path("createCompany")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String createComapny(@QueryParam("name") String compName, @QueryParam("pass") String password,
			@QueryParam("email") String email) throws Exception {

		String failMassage = "FAILED TO REMOVE A COMPANY: there is no such id! " + compName
				+ " - please enter another company id";
		AdminFacade admin = getFacade();
		Company company = new Company(1111, compName, password, email);

		try {

			if (admin.createCompany(company) == true) {

				return "SUCCEED TO ADD A NEW COMPANY: name = " + compName + ", id = " + company.getId();

			}

		} catch (DBException | CreateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return failMassage;
	}
	
	@DELETE
	@Path("removeCompany/{compId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String removeCompany(@PathParam("compId")long id) throws Exception { 
		System.out.println("Im here Remove Company");
		AdminFacade admin = getFacade(); 
		Company company = admin.getCompany(id);
		System.out.println(id);
		
		try {
			
            if (company != null ) { 
            	admin.removeCompany(company); 
            	return "SUCCEED TO REMOVE A COMPANY: name = " + company.getCompName() + ", id = " + id;
            	
            }
            
			return "FAILED TO REMOVE A COMPANY :  please try again " ;  
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "FAILD TO REMOVE A COMPANY, THE COMPANY :" +  company.getCompName() + "no such a company "  ; 
				
	} 
	
	@POST 
	@Path ("updateCompany") 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public String updateComapny ( String jsonComString) throws Exception  {
		
		AdminFacade admin = getFacade() ; 
		Gson gson = new Gson(); 
		
		Company compFromJson = gson.fromJson(jsonComString, Company.class); 
		Company company = admin.getCompany(compFromJson.getId()); 
		System.out.println(company);
		try {
			
			if ( company != null ) { 
				admin.updateCompany(company,compFromJson.getPassword(),compFromJson.getEmail()); 	
				
				return "SUCCEED TO UPDATE A COMPANY + " +  company.getCompName() +  "  : Password = " + compFromJson.getPassword() + " Email = " + compFromJson.getEmail() ; 
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "FAILED TO UPDATE A COMPANY:" + company.getCompName() ; 
		
		
		
	}
	

	

}
