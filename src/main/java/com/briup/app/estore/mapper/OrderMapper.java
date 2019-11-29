package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Order;
import java.util.List;

public interface OrderMapper {
//    int deleteByPrimaryKey(Integer id);

    int   insertOrder(Order order);

	
    List<Order>  selectAllOrderByCustomerid(Integer id);


	Integer  deleteOrder(Integer id);
	// Order  selectByPrimaryKey(Integer id);
	 Order  selectOrderWithOrderline(Integer id);
	/*
	 * List<Order> selectAll();
	 * 
	 * Integer updateByPrimaryKey(Order record);
	 * 
	 * Integer selectPrimaryKeyByCustomer(Integer userid);
	 */
}