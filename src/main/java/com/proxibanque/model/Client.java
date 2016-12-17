package com.proxibanque.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
public class Client extends Person {

	private CurrentAccount currentAccount;
	private SavingsAccount savingsAccount;
	
	private String email;

	// @Autowired
	@Embedded
	private Address address = new Address();

	public Client(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Client(String firstName, String lastName, String email, Address address) {
		super(firstName, lastName);
		this.email = email;
		this.address = address;
	}

	public Client() {
		super();
	}

	public Client(String email, Address address) {
		super();
		this.email = email;
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Client [email=" + email + ", address=" + address + "]";
	}

}
