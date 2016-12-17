package com.proxibanque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.proxibanque.dao.DaoAccount;
import com.proxibanque.dao.DaoClient;
import com.proxibanque.model.Address;
import com.proxibanque.model.BankAccount;
import com.proxibanque.model.Client;




@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class persistenceTests {

	@PersistenceContext
	private EntityManager entityManager;

	
	@Autowired
	DaoClient daoClient;
//    OrdersDao orderDao;
	
//	@Autowired
//	DaoAccount daoAccount;
//	ItemsDao itemDao;
	
	
	
	
//	@Test
//	@Transactional
//	public void testDaoImpl() throws Exception {
//		Address address = new Address(52, "streetName", "postalCode", "city");
//		Client client = new Client("email", address);
//		daoClient.persist(client);
//		assertNotNull(client);
		
	
	@Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {
		//Address address = new Address(52, "streetName", "postalCode", "city");
		Client client = new Client();
		client.getAddress().setCity("Paris");
		entityManager.persist(client);
		entityManager.flush();
		assertNotNull(client.getId());
	}

		

	
	
		
//	}
//	
//	@Test
//	@Transactional
//	public void testDaoServices() throws Exception{
//		Order order = new Order();
//		order.getItems().add(new Item());
//		orderDao.persist(order);
//		assertEquals(1, orderDao.count());
//	}
//	
//	@Test
//	@Transactional
//	public void testSaveOrderWithItems() throws Exception {
//		Order order = new Order();
//		order.getItems().add(new Item());
//		entityManager.persist(order);
//		entityManager.flush();
//		assertNotNull(order.getId());
//	}
//
//	@Test
//	@Transactional
//	public void testSaveAndGet() throws Exception {
//		Order order = new Order();
//		order.getItems().add(new Item());
//		entityManager.persist(order);
//		entityManager.flush();
//		// Otherwise the query returns the existing order (and we didn't set the
//		// parent in the item)...
//		entityManager.clear();
//		Order other = (Order) entityManager.find(Order.class, order.getId());
//		assertEquals(1, other.getItems().size());
//		assertEquals(other, other.getItems().iterator().next().getOrder());
//	}
//
//	@Test
//	@Transactional
//	public void testSaveAndFind() throws Exception {
//		Order order = new Order();
//		Item item = new Item();
//		item.setProduct("foo");
//		order.getItems().add(item);
//		entityManager.persist(order);
//		entityManager.flush();
//		// Otherwise the query returns the existing order (and we didn't set the
//		// parent in the item)...
//		entityManager.clear();
//		Order other = (Order) entityManager
//				.createQuery(
//						"select o from Order o join o.items i where i.product=:product")
//				.setParameter("product", "foo").getSingleResult();
//		assertEquals(1, other.getItems().size());
//		assertEquals(other, other.getItems().iterator().next().getOrder());
//	}
//	
//	
	
}
