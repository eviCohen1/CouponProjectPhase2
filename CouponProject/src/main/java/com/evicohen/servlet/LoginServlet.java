package com.evicohen.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.evicohen.Facade.CompanyFacade;
import com.evicohen.Facade.CouponClientFacade;
import com.evicohen.JavaBeans.Company;
import com.evicohen.Main.CouponSystem;
import com.evicohen.Main.CouponSystem.clientType;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CouponSystem system;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	// init function - start the Coupon System
	@Override
	public void init() throws ServletException {
		try {
			system = CouponSystem.getCouponSystem();
		} catch (Exception e) {
			System.out.println("Failed to connect to db, Failed to load system");
			System.exit(1);
		}
		System.out.println("Loaded...");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// check whether there is a open session
		HttpSession session = request.getSession(false);

		if (session != null) {

			session.invalidate(); // killing the session if exist
		}

		session = request.getSession(true); // create a new session for a new
											// client
		System.out.println(session.getId() + " * " + session.getMaxInactiveInterval());
		// getting the data from the Login HTML form
		String username = request.getParameter("name");
		String password = request.getParameter("pass");
		String ClientType = request.getParameter("type");
		clientType type = clientType.valueOf(ClientType); // convert String to
															// ENUM

		try {

			CouponClientFacade facade = system.login(username, password, type);
			System.out.println("loginServlet: request = " + request); // for
																		// debug
			System.out.println("loginServlet: response = " + response); // for
																		// debug

			if (facade != null) {
				// updating the session with the login facade
				session.setAttribute("facade", facade);
				// dispatcher to the right Page according to the Client Type
				switch (type) {
				case Admin:
					request.getRequestDispatcher("Admin.html").forward(request, response);
					break;

				case Company:
					// updating the session with the logged in company
					CompanyFacade companyFacade = new CompanyFacade();
					if (companyFacade.login(username, password, type)) {
						CompanyFacade companyFacade1 = (CompanyFacade) CouponSystem.getCouponSystem().login(username, password, type);
						session.setAttribute("companyFacade", companyFacade1);
						request.getRequestDispatcher("company.html").forward(request, response);
					}

					break;

				case Customer:
					// updating the session with the logged in customer
					// Customer customer =
					// ((CustomerFacade)facade).getLoginCustomer();
					// session.setAttribute("customer", customer);
					request.getRequestDispatcher("customer.html").forward(request, response);
					break;

				default:
					break;
				}
			}

			else {
				// return to the Login HTML form if the user name or password
				// are incorrect
				// response.getWriter().print("The UserName or the Password are
				// incorrect! please try again");
				response.sendRedirect("login.html");
			}

		}

		// LoginException
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
