package com.proxibanque.model;

import javax.persistence.Entity;

@Entity
public class SavingsAccount extends BankAccount {

	private Client client;

	
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(long accountNumber, double balance, String creationDate, AccountType accountType, Client client) {
		super(accountNumber, balance, creationDate, accountType);
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
