package com.proxibanque.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxibanque.dao.IDaoAccount;
import com.proxibanque.model.BankAccount;

@Component
public class ServiceAccount implements IServiceAccount , Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IDaoAccount daoAccount;

	@Override
	public void persist(BankAccount account) throws Exception {
		daoAccount.persist(account);
	}

	@Override
	public void merge(BankAccount account) throws Exception {
		daoAccount.merge(account);
	}

	@Override
	public void remove(long accountNumber) throws Exception {
		daoAccount.remove(accountNumber);
	}

	@Override
	public BankAccount findById(long accountNumber) throws Exception {

		return daoAccount.findById(accountNumber);
	}

	@Override
	public List<BankAccount> findAll() throws Exception {
		return daoAccount.findAll();
	}

	@Override
	public void transfer(BankAccount senderAccount, BankAccount recieverAccount, double amount) throws Exception {
		BankAccount sender = daoAccount.findById(senderAccount.getAccountNumber());
		sender.setBalance(sender.getBalance()-amount);
		
		BankAccount reciever = daoAccount.findById(recieverAccount.getAccountNumber());
		reciever.setBalance(reciever.getBalance()+amount);
		
		daoAccount.merge(sender);
		daoAccount.merge(reciever);

	}

}
