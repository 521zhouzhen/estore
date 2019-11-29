package com.briup.app.estore.service;

import com.briup.app.estore.bean.Customer;

public interface ICustomerService {
	//注册功能
	void register(Customer customer) throws Exception;

	Integer login(Customer customer)throws Exception;

	void CustomerUpdate(Customer customer)throws Exception;
	
	
  Customer CustomerDetil(Integer id);
}
