package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/EditOrderline")
public class EditOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EditOrderlineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 创建EditOrderlineServlet.java
	 // 2) 在该Servlet中先从Session中获得ShoppingCart对象，
		//然后获得从shopcar.jsp传递过来的lineid(bookid)和num，最后根据lineid来获得指定的Orderline对象，并且修改数量为num。
		ShoppingCart shopcart = (ShoppingCart) request.getSession().getAttribute("shopcart");
		  Integer id =Integer.parseInt( request.getParameter("productid"));
		  Integer num = Integer.parseInt(request.getParameter("num"));
		  shopcart.update(id, num);
	 // 3) 修改成功后跳转到shopcar.jsp页面
		  request.getRequestDispatcher("/shopcar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
