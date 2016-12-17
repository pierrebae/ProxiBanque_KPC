package com.proxibanque.service;

import java.util.List;

import com.proxibanque.model.BankAccount;
import com.proxibanque.model.Client;

public interface IServiceAccount {

	
	void persist(BankAccount account) throws Exception;

	void merge(BankAccount account) throws Exception;

	void remove(long accountNumber) throws Exception;

	BankAccount findById(long accountNumber) throws Exception;

	List<BankAccount> findAll() throws Exception;
	
	void transfer(BankAccount senderAccount, BankAccount recieverAccount, double amount) throws Exception;
	
	
}
