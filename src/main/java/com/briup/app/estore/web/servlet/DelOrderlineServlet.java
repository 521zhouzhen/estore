package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.shoppingcart.ShoppingCart;


@WebServlet("/DelOrderline")
public class DelOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DelOrderlineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1) 创建DelOrderlineServlet.java
	  //2) 在Servlet中获得shopcar.jsp页面中传递过来的lineid(bookid)。
		
		     Integer id =Integer.parseInt( request.getParameter("productid"));
	 // 3) 从Session中获得ShoppingCart对象，并且调用它的dropLine(Long lineid)方法来删除一个指定的Orderline对象
		     
		     ShoppingCart shopcart = (ShoppingCart) request.getSession().getAttribute("shopcart");
		     shopcart.delete(id);
	  //4) 删除成功后跳转到shopcar.jsp页面
		     request.getRequestDispatcher("/shopcar.jsp").forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
