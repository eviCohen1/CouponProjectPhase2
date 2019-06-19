package com.evicohen.Services;


import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

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
	
	@Path("test2")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllCompnies () throws Exception {
		
		AdminFacade admin = getFacade();
		Collection<Company> companies = admin.getAllCompanies(); 		
		return new Gson().toJson(companies); 	
		
	}

	// Create new Company, used AdminFacade //
	
//	@Path("createCompany")
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String createComapny(@QueryParam("name") String compName, @QueryParam("pass") String password,
//			@QueryParam("email") String email) throws Exception {
//		System.out.println("Im here3");
//
//		String failMassage = "FAILED TO REMOVE A COMPANY: there is no such id! " + compName
//				+ " - please enter another company id";
//		AdminFacade admin = getFacade();
//		Company company = new Company(1111, compName, password, email);
//
//		try {
//
//			if (admin.createCompany(company) == true) {
//
//				return "SUCCEED TO ADD A NEW COMPANY: name = " + compName + ", id = " + company.getId();
//
//			}
//
//		} catch (DBException | CreateException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//		return failMassage;
//	}
	


	@Path("test")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest() {
		System.out.println("Im here2");
		return "test";
	}
	

}
