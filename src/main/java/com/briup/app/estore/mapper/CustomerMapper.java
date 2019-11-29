package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Customer;
import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer customer);

    Customer selectByPrimaryKey(Integer id);

    List<Customer> selectAll();

    

	Customer selectByName(String name);

	void  updateByPrimaryKey(Customer customer);
}