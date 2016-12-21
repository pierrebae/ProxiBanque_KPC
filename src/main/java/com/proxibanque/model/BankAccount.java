package com.proxibanque.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BankAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountNumber;
	private double balance;
	private String creationDate;
	private Date dateLastModification = new Date();
	private AccountType accountType;
	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name="client_id")
	private Client client;

	public BankAccount() {
		super();
	}

	public BankAccount(double balance, String creationDate, AccountType accountType) {
		super();
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

	public Date getDateLastModification() {
		return dateLastModification;
	}

	public void setDateLastModification(Date dateLastModification) {
		this.dateLastModification = dateLastModification;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "BankAccount accountNumber=" + accountNumber + ", balance=" + balance + client;
	}

	
	
	
}
