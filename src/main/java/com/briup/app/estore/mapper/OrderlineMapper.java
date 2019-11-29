package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Orderline;
import java.util.List;

public interface OrderlineMapper {
  //  int deleteByPrimaryKey(Integer id);

    int insertOrderLine(Orderline orderline);
   List< Orderline>   selectOrderWithOrderlineAndBook(Integer id);
	/*
	 * Orderline selectByPrimaryKey(Integer id);
	 * 
	 * List<Orderline> selectAll();
	 * 
	 * int updateByPrimaryKey(Orderline orderline); Orderline selectByBookId(Integer
	 * boookid);
	 */
}