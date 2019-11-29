package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.OrderServiceImpl;

/**
 * Servlet implementation class DelOrderServlet
 */
@WebServlet("/DelOrderServlet")
public class DelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderid=Integer.parseInt(request.getParameter("id"));
		IOrderService is=new OrderServiceImpl();
		is.delOrder(orderid);
		response.getWriter().write("ggggg");
		request.getRequestDispatcher("user/orderlist.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
