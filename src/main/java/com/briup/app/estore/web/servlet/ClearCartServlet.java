package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.shoppingcart.ShoppingCart;

@WebServlet("/shopcartClear")
public class ClearCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ClearCartServlet() {
        super();
    }
    
	/*
	 * 1) 创建ClearCartServlet.java 2)
	 * 在该Servlet中获得ShoppingCart对象，然后调用其中的clear()方法来清空购物车。
	 * 
	 *  3) 清空购物车成功后跳转到index.jsp页面
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCart shopcart= (ShoppingCart) request.getSession().getAttribute("shopcart");
		 shopcart.clear();
		 request.getRequestDispatcher("/user/shopcart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
