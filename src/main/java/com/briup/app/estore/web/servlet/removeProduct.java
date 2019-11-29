package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.shoppingcart.ShoppingCart;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

@WebServlet("/removeProduct")
public class removeProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public removeProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer bookid = Integer.parseInt(""+request.getParameter("productid"));
		 ShoppingCart shopcart= (ShoppingCart) request.getSession().getAttribute("shopcart");
		 shopcart.delete(bookid);
							request.getRequestDispatcher("/user/shopcart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
