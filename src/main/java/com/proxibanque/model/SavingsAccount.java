package com.proxibanque.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

//@Entity
public class SavingsAccount extends BankAccount {

//	@OneToOne(mappedBy="savingsAccount")

//	private Client client;

	
	
	public SavingsAccount() {
		super();
	}

//	public SavingsAccount(double balance, String creationDate, AccountType accountType, Client client) {
//		super(balance, creationDate, accountType);
//		this.client = client;
//	}
//
//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}
	
	
}
