package com.briup.app.estore.bean;

import java.util.Date;
import java.util.List;

public class Order {
    private Integer id;
    private Double cost;
    private Date orderdate;
    private Customer customer;
    
    public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private List<Orderline> orderline;
public Order() {
		super();
		
	}







public Order(Double cost, Date orderdate) {
	super();
	this.cost = cost;
	this.orderdate = orderdate;

}




public Order(Double cost, Date orderdate, Customer customer) {
	super();
	this.cost = cost;
	this.orderdate = orderdate;
	this.customer = customer;
}







@Override
public String toString() {
	return "Order [id=" + id + ", cost=" + cost + ", orderdate=" + orderdate + ",  orderline="
			+ orderline + "]";
}







public List<Orderline> getOrderline() {
	return orderline;
}

public void setOrderline(List<Orderline> orderline) {
	this.orderline = orderline;
}



   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }







	
  
}