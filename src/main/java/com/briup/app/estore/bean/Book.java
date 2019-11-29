package com.briup.app.estore.bean;

import java.util.List;

public class Book {
    private Integer id;

    private String name;

    private Double price;
    
    private  List<Orderline> orderline;

    public Book() {
		super();
		// TODO Auto-generated constructor stub
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", orderline=" + orderline + "]";
	}
}