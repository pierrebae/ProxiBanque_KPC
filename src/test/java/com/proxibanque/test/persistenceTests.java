package com.proxibanque.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import com.proxibanque.dao.IDaoClient;
import com.proxibanque.model.Address;
import com.proxibanque.model.Client;

@ContextConfiguration
@RunWith(MockitoJUnitRunner.class)
public class persistenceTests {

	@Mock
	private EntityManager entityManager;

	@Mock
	IDaoClient daoClient;
	@Mock
	Client client;
	@Mock
	Address address;

	@Test
	public void testSaveClientWithAddress() throws Exception {
		client = new Client();
		address = new Address("52", "streetName", "postalCode", "city");
		client.setAddress(address);
		entityManager.persist(client);
		entityManager.flush();
		assertNotNull(client.getAddress());
	}

	@Test
	public void testSaveAndFind() throws Exception {
		client = new Client();
		address = new Address("52", "streetName", "postalCode", "Londres");
		client.setAddress(address);
		Client recupClient = null;
		long id =1;
		
		entityManager.persist(client);
		entityManager.flush();
		
		doReturn(recupClient=client).when(daoClient).findById(id);
		assertNotNull(recupClient);
		
	}


}
