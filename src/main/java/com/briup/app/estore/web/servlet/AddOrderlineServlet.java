package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.mapper.OrderlineMapper;
import com.briup.app.estore.service.BookServiceImpl;
import com.briup.app.estore.service.IBookService;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.service.LineServiceImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

@WebServlet("/AddOrderlineServlet")
public class AddOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddOrderlineServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		接受请求数据，调用service方法 
                                   
		Integer bookid = Integer.parseInt(""+request.getParameter("bookid"));
		
                                 // 调用service方法  
		//ILineService lineService=new LineServiceImpl();
	//	Orderline orderLine = lineService.InsertOrderLine(bookid, num);
		BookMapper  mapper=MyBatisSqlSessionFactory.openSession().getMapper(BookMapper.class);
	    Book book = mapper.selectByPrimaryKey(bookid);
		Orderline orderLine=new Orderline(book);
		 ShoppingCart shopcart= (ShoppingCart) request.getSession().getAttribute("shopcart");
		 shopcart.add(orderLine);
		  PrintWriter writer = response.getWriter();
		    writer.print(orderLine);
							request.getRequestDispatcher("/index.jsp").forward(request, response);
							
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		
	
	
	 doGet(req, resp);};
	}
	