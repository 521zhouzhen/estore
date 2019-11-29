package com.briup.app.estore.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.OrderlineMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class LineServiceImpl  implements ILineService{




	/*
	 * public void DeleteOrderLine(Integer id) { OrderlineMapper mapper =
	 * (OrderlineMapper)
	 * MyBatisSqlSessionFactory.openSession().getMapper(Orderline.class);
	 * mapper.deleteByPrimaryKey(id);
	 * 
	 * }
	 * 
	 * 
	 * public void UpdateOrderLine(Orderline orderline) { OrderlineMapper mapper =
	 * (OrderlineMapper)
	 * MyBatisSqlSessionFactory.openSession().getMapper(Orderline.class);
	 * mapper.updateByPrimaryKey(orderline);
	 * 
	 * }
	 */

	public void saveOrderLine(Orderline orderline) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderlineMapper mapper =sqlSession.getMapper(OrderlineMapper.class);
		//OrderlineMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(OrderlineMapper.class);
		mapper.insertOrderLine(orderline);
		sqlSession.commit();
	}

	@Override
	public List<Orderline> findOrderLinesByOrderid(Integer orderid) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		OrderlineMapper mapper =sqlSession.getMapper(OrderlineMapper.class);
		List<Orderline> list = mapper.selectOrderWithOrderlineAndBook(orderid);
		return list;
	}

	


}
