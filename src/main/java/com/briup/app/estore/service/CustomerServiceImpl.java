package com.briup.app.estore.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.mapper.CustomerMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class CustomerServiceImpl  implements ICustomerService {

	@Override
	public void register(Customer customer) throws Exception {
		CustomerMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(CustomerMapper.class);
		Customer customers = mapper.selectByName(customer.getName());
		if(customers==null) {   
				mapper.insert(customer);	
		} else{
			throw new Exception ("注册失败"+customer.getName()+"用户存在"); 
		}
		
	
		
	}


	public Integer login(Customer customer) throws Exception {
                               Integer id=null;
		CustomerMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(CustomerMapper.class);
		Customer customers = mapper.selectByName(customer.getName());
	
		if(customers==null) {  
			throw new Exception ("登录失败"+customer.getName()+"该用户不存在"); }
			else{
					if(!customers.getPassword().equals(customer.getPassword())) {
						  throw new Exception ("登录失败"+customer.getName()+"密码错误"); 
					}
					id=customers.getId();
					
				}
		return id;
	}




	@Override
	public void CustomerUpdate(Customer customer) throws Exception {
		CustomerMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(CustomerMapper.class);
		mapper.updateByPrimaryKey(customer);
		
	}
	
	
	
	
	public Customer CustomerDetil(Integer id) {
		CustomerMapper mapper = MyBatisSqlSessionFactory.openSession().getMapper(CustomerMapper.class);
		 Customer customer = mapper.selectByPrimaryKey(id);
		return customer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}


