package com.briup.app.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.mapper.OrderMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class OrderServiceImpl implements IOrderService {

	@Override
	public void saveOrder(Order order) {

		try {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

			OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
			mapper.insertOrder(order);
                 sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Order> findAllOrderByCustomerid(Integer customerid) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> orders = mapper.selectAllOrderByCustomerid(customerid);
		return orders;
		
		
	}

	@Override
	public void delOrder(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		mapper.deleteOrder(id);
		sqlSession.commit();
	}

	@Override
	public Order findById(Integer orderid) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();

		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		return mapper.selectOrderWithOrderline(orderid);
		
		
		
	}

}
