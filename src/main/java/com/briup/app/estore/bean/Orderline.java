package com.briup.app.estore.bean;

import java.util.List;

public class Orderline {
	public Orderline(Book book) {
		super();
		this.book = book;
	}

	private Integer id;

	private Integer num;
	private Order order;
	private Book book;

	

	public Orderline() {
		// TODO Auto-generated constructor stub
	}

	
	


	public Orderline(Integer id, Integer num, Order order, Book book) {
		super();
		this.id = id;
		this.num = num;
		this.order = order;
		this.book = book;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Orderline [id=" + id + ", num=" + num + ", order=" + order + ", book=" + book + "]";
	}

}