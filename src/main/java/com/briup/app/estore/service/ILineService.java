package com.briup.app.estore.service;



import java.util.List;

import com.briup.app.estore.bean.Orderline;

public interface ILineService  {
	
	
	

	//void DeleteOrderLine(Integer id);
	//void UpdateOrderLine(Orderline orderline);
	void saveOrderLine(Orderline orderline);
      List<Orderline>      findOrderLinesByOrderid(Integer orderid);
}
