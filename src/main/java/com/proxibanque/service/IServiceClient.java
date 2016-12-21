package com.proxibanque.service;

import java.util.List;

import com.proxibanque.model.BankAccount;
import com.proxibanque.model.Client;

/**
 * 
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see cette interface définit les signatures de méthode de la couche service
 *      relative aux clientsS
 *
 */
public interface IServiceClient {

	void persist(Client client) throws Exception;

	void merge(Client client) throws Exception;

	void remove(long idClient) throws Exception;

	void persist(Client client, BankAccount bankAccount) throws Exception;

	Client findById(long idClient) throws Exception;

	List<Client> findAll() throws Exception;

}
