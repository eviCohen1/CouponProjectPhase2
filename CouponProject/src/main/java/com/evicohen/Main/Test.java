package com.evicohen.Main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.evicohen.Facade.AdminFacade;
import com.evicohen.JavaBeans.Company;
import com.evicohen.Main.CouponSystem.clientType;





public class Test {

	public static void main(String[] args) throws Exception {

   	
		/************************************Test-threads*************************/
		
//		   Timer time = new Timer();    // Instantiate Timer Object
//	       DailyCouponExpirationTask dailyCouponExpirationTask = new DailyCouponExpirationTask();  // Instantiate SheduledTask class
//	       time.schedule(dailyCouponExpirationTask, Utils.timeScheduler(), Utils.minToMilliSec(1440));// Create task repeating every selected time, in millisecond 

//		Company company = new Company(2, "ADL", "12345", "oriel@test.com");
//		Coupon coupon = new Coupon(4, "PhoneNote8", Utils.getDate(), Utils.endDate(10),2, CouponType.CAMPING,"wtf", 1251, "image",true);
//		Customer customer = new Customer(3, "Evi", "1234");
//		Customer customer2 = new Customer(4,"Lior", "1234");
//		Coupon coupon1 = new Coupon(3, "Kobi", Utils.getDate(), Utils.endDate(60),3, CouponType.HEALTH,"wtf", 3333, "image",true);
//		Customer customer3 = new Customer(4, "Haim", "1234");
//		Customer customer4 = new Customer(5, "Shani", "1234");
//		Customer customer5 = new Customer(5, "Noam", "1234");
//		Customer customer6 = new Customer(5, "Uri", "1234");
//		Company company2 = new Company(3, "Phoebus", "12345", "oriel@test.com"); 
//		System.out.println(company2);
//		System.out.println(company2);
//		System.out.println("Evi123");
		

/*********************************************Test-Main****************************/ 
		/*********Admin**************/
//		AdminFacade adminFacade2 = new AdminFacade();
//		adminFacade2 = (AdminFacade) CouponSystem.getCouponSystem().login("admin", "1234", clientType.Admin);		
//        if ( adminFacade2 != null ) {    
//        	adminFacade2.createCompany(company);
//        	adminFacade2.removeCompany(company);
//        	adminFacade2.updateCompany(company, "777777", "Evi.Cohen1@gmail.com");    
//        	System.out.println(adminFacade2.getAllCompanies());        	
//        	adminFacade2.removeCustomer(customer5);
//        	adminFacade2.createCustomer(customer);
//        	adminFacade2.updateCustomer(customer2,"777777");   
//        	System.out.println(adminFacade2.getAllCustomers());
//        }

        /*********Company************/
//		CompanyFacade companyFacade = new CompanyFacade(); 
//        companyFacade = (CompanyFacade) CouponSystem.getCouponSystem().login("mPrest", "221284",clientType.Company);
//        if(companyFacade!=null) { 
//        	companyFacade.removeCoupon(coupon1);
//        	companyFacade.createCoupon(coupon1);
//        	companyFacade.updateCoupon(coupon1);
//        	System.out.println(companyFacade.getAllCoupons());
//        	System.out.println(companyFacade.getCouponByType(CouponType.CAMPING));
//        	System.out.println(companyFacade.getCouponsByPrice(1000.0));       	
//        	}
//    		

		//		/*********Customer************/
//        CustomerFacade customerFacade = new CustomerFacade(); 
//        customerFacade = (CustomerFacade) CouponSystem.getCouponSystem().login("Haim", "1234", clientType.Customer); 
//        if(customerFacade!=null) {
//        	customerFacade.purchaseCoupon(coupon1); 
//        	System.out.println(customerFacade.getAllPurchasedCoupons());
//        	System.out.println(customerFacade.getAllPurchasedCouponsByType(CouponType.CAMPING));
//        	System.out.println(customerFacade.getAllPurchasedCouponsByPrice(2000.0));
//        }
        
        
        

    /****************************Test-PurchasedCoupon*****************************/


	

		}

		

	}

