package com.proxibanque.model;

import javax.persistence.Entity;

@Entity
public class BankAccount {

	private long accountNumber;
	private double balance;
	private String creationDate;
	private AccountType accountType;

	public BankAccount() {
		super();
	}

	public BankAccount(long accountNumber, double balance, String creationDate, AccountType accountType) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.creationDate = creationDate;
		this.accountType = accountType;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

}
