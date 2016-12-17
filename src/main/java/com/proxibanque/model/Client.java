package com.proxibanque.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Client extends Person {

	private String email;
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "counsellor_id")
	private Counsellor counsellor;

	public Client(String firstName, String lastName, String email, Address address) {
		super(firstName, lastName);
		this.email = email;
		this.address = address;
	}

	public Client() {
		super();
	}

	public Client(String email, Address address, Counsellor counsellor) {
		super();
		this.email = email;
		this.address = address;
		this.counsellor = counsellor;
	}

	
	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
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

}
