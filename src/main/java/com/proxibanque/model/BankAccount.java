package com.proxibanque.model;

public class BankAccount {

	private long accountNumber;
	private double balance;

	
	public BankAccount() {
		super();
	}

	public BankAccount(double balance) {
		super();
		this.balance = balance;
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

}
