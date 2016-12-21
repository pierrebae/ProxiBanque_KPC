package com.proxibanque.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.proxibanque.dao.IDaoClient;
import com.proxibanque.model.BankAccount;
import com.proxibanque.model.Client;

@Component
public class ServiceClient implements IServiceClient,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IDaoClient daoClient;

	@Override
	public void persist(Client client) throws Exception {
System.out.println("save client");
		daoClient.persist(client);
	}

	@Override
	public void merge(Client client) throws Exception {
		// TODO Auto-generated method stub
		daoClient.merge(client);
	}

	@Override
	public void remove(long idClient) throws Exception {
		Client client = daoClient.findById(idClient);
		client.setCounsellor(null);
		daoClient.merge(client);
		daoClient.remove(idClient);
	}

	@Override
	public Client findById(long idClient) throws Exception {
		// TODO Auto-generated method stub
		return daoClient.findById(idClient);
	}

	@Override
	public List<Client> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoClient.findAll();
	}

	@Override
	public void persist(Client client, BankAccount bankAccount) throws Exception {

		List <BankAccount> bankAccounts=client.getBankAccounts();
		bankAccounts.add(bankAccount);
		bankAccount.setClient(client);
//		client.setBankAccounts(bankAccounts);
		daoClient.persist(client);
		
		
	}

}
