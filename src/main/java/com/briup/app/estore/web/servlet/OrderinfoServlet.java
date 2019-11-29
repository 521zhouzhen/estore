package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Order;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.OrderServiceImpl;

@WebServlet("/OrderinfoServlet")
public class OrderinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OrderinfoServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderid=Integer.parseInt(request.getParameter("id"));
		IOrderService is=new OrderServiceImpl();
		Order order=is.findById(orderid);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
