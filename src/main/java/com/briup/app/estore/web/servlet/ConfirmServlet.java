package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.LineServiceImpl;
import com.briup.app.estore.service.OrderServiceImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;


@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ConfirmServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		保存订单到数据库
		

		ShoppingCart shopcart;
		try {
//			获取最新用户信息
			Integer userid=Integer.parseInt(""+request.getSession().getAttribute("userid"));
			
			
			CustomerMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(CustomerMapper.class);
			Customer customer = mapper.selectByPrimaryKey(userid);
			
//			保存订单
     shopcart = (ShoppingCart) request.getSession().getAttribute("shopcart");
     Order order=new Order(shopcart.getCost(),new Date(),customer);
     IOrderService is=new OrderServiceImpl();
     is.saveOrder(order);
     

     
//     保存订单项
     
		  Map<Integer, Orderline> map = shopcart. getLines(); 
		  for (Map.Entry<Integer,Orderline> me : map.entrySet()) { 
			  Orderline orderline=me.getValue();
			  orderline.setOrder(order);
			  ILineService ils=new LineServiceImpl();
			  ils.saveOrderLine(orderline);
			 
			  
			  
		  }
		 
     
     request.getRequestDispatcher("index.jsp").forward(request, response);
     
     
//     清空购物车
   
	 shopcart.clear();
     
     
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			request.getRequestDispatcher("confirmorder.jsp").forward(request, response);
		}
      
      
      
      
      
      
		/*
		 * Map<Integer, Orderline> map = shopcart. getLines(); for (Map.Entry<Integer,
		 * Orderline> me : map.entrySet()) { Orderline orderline=me.getValue();
		 */
//    	  将订单信息分别保存到line表中
    	  
    	  
    	
    	  
    	  
	}
      
      
	

	/**
	
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
