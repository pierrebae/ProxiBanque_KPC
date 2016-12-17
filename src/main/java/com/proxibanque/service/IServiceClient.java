package com.proxibanque.service;

import java.util.List;

import com.proxibanque.model.Client;

public interface IServiceClient {

	void persist(Client client) throws Exception;
	
	void merge(Client client) throws Exception;

	void remove(long idClient) throws Exception;
	
	Client findById(long idClient) throws Exception;
	
	List<Client> findAll() throws Exception;
	
}
