package com.proxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proxibanque.dao.IDaoClient;
import com.proxibanque.model.Client;

public class ServiceClient implements IServiceClient  {

	@Autowired
	private IDaoClient daoClient;
	
	@Override
	public void persist(Client client) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void merge(Client client) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(long idClient) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client findById(long idClient) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
