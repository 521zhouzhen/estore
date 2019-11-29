package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.CustomerServiceImpl;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.shoppingcart.ShoppingCart;
import com.briup.app.estore.service.*;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String path;
	private String msg;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String zip=request.getParameter("zip");
		String address=request.getParameter("address");
		String telephone=request.getParameter("telphone");	
		String email=request.getParameter("email");
		Customer customer=new Customer();
		customer.setName(name);
		customer.setPassword(password);
		customer.setZip(zip);
		customer.setAddress(address);
		customer.setTelephone(telephone);
		customer.setEmail(email);
		try {
			ICustomerService  CustomerService=new CustomerServiceImpl();
			CustomerService.login(customer);
			
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		} catch (Exception e) {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
	
		}
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
