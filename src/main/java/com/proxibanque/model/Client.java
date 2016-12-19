package com.proxibanque.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
public class Client extends Person {

	@ManyToOne
	@JoinColumn(name = "counsellor_id")
	private Counsellor counsellor;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CurrentAccount_id", unique = true)
	private CurrentAccount currentAccount;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "SavingsAccount_id", unique = true)
	private SavingsAccount savingsAccount;

	@Autowired
	@Embedded
	private Address address;
	
	private String telephone;
	private String email;

	public Client(Address address) {
		super();
		this.address = address;
	}

	public Client(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Client(String firstName, String lastName, String email, Address address, Counsellor counsellor) {
		super(firstName, lastName);
		this.email = email;
		this.address = address;
		this.counsellor = counsellor;
	}
	public Client(String firstName, String lastName, String email, Address address) {
		super(firstName, lastName);
		this.email = email;
		this.address = address;
	}
	
	public Client() {
		super();
	}

	public Client(String email, String telephone, Address address) {
		super();
		this.email = email;
		this.telephone = telephone;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}

	public CurrentAccount getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(CurrentAccount currentAccount) {
		this.currentAccount = currentAccount;
	}

	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}

	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}
	

}
