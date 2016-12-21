package com.proxibanque.service;

import java.util.List;

import com.proxibanque.model.BankAccount;

/**
 * 
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see cette interface définit les signatures de méthode de la couche service
 *      relative aux comptes bancaires
 *
 */
public interface IServiceAccount {

	void persist(BankAccount account) throws Exception;

	void merge(BankAccount account) throws Exception;

	void remove(long accountNumber) throws Exception;

	BankAccount findById(long accountNumber) throws Exception;

	List<BankAccount> findAll() throws Exception;

	void transfer(long senderAccount, long recieverAccount, double amount) throws Exception;

}
