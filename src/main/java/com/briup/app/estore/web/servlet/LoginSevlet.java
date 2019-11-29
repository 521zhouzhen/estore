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


@WebServlet("/login")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path;
	private String msg;
    public LoginSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		Customer customer=new Customer();
		customer.setName(name);
		customer.setPassword(password);
		path="/index.jsp";
		//request.getRequestDispatcher(path).forward(request, response);
		try {
			ICustomerService  CustomerService=new CustomerServiceImpl();
			Integer id = CustomerService.login(customer);
			request.getRequestDispatcher(path).forward(request, response);
			
		} catch (Exception e) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
	
		}
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
