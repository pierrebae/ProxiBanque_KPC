package com.proxibanque.model;

import java.util.Date;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountNumber;
	private double balance;
	private String creationDate;
	private Date dateLastModification = new Date();
	private AccountType accountType;
	
	@ManyToOne
	@JoinColumn(name="client_id")
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

}
