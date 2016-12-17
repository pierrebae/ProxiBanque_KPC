package com.proxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.proxibanque.dao.DaoClient;
import com.proxibanque.dao.IDaoClient;
import com.proxibanque.model.Client;

@Component
public class ServiceClient implements IServiceClient  {

	@Autowired
	private IDaoClient daoClient;
	
	@Override
	public void persist(Client client) throws Exception {
		
		daoClient.persist(client);
	}

	@Override
	public void merge(Client client) throws Exception {
		// TODO Auto-generated method stub
		daoClient.merge(client);
	}

	@Override
	public void remove(long idClient) throws Exception {
		// TODO Auto-generated method stub
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

	
	
	
	
}
