package com.proxibanque.model;

import javax.persistence.Entity;

@Entity
public class CurrentAccount extends BankAccount {

	private Client client;

	
	
	public CurrentAccount(long accountNumber, double balance, String creationDate, AccountType accountType, Client client) {
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
