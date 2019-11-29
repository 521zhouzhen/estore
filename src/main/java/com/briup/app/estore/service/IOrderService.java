package com.briup.app.estore.service;

import java.util.List;

import com.briup.app.estore.bean.Order;

public interface IOrderService {
	
	void saveOrder(Order order);
	List<Order> findAllOrderByCustomerid(Integer customerid);
	void delOrder(Integer id);
	Order findById(Integer orderid);
	
}
