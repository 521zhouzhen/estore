package com.briup.app.estore.bean;

import java.util.List;

public class Customer {
    private Integer id;

    private String name;

    private String password;

    private String zip;

    private String address;

    private String telephone;

    private String email;
    private List<Order> order;

    public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, String name, String password, String zip, String address, String telephone,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
	}

	public Customer(Integer id, String name, String password, String zip, String address, String telephone,
			String email, List<Order> order) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.zip = zip;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.order = order;
	}

	public List<Order> getOrder() {
		return order;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", zip=" + zip + ", address="
				+ address + ", telephone=" + telephone + ", email=" + email + ", order=" + order + "]";
	}

	public void setOrder(List<Order> order) {
		this.order = order;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}