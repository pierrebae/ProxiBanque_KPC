package com.proxibanque.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proxibanque.model.Address;
import com.proxibanque.model.Client;
import com.proxibanque.service.IServiceClient;
import com.proxibanque.service.ServiceClient;

public class MainTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		IServiceClient serviceClient=new ServiceClient();
		
		Address ad1=new Address(5,"Rue de la soif","3304","Ville");
		Client c1=new Client("John","Doe","john.doe@aol.fr",ad1);
		
		serviceClient.persist(c1);
		List<Client> clients= serviceClient.findAll();
		
		for (Client client : clients) {
			System.out.println(client);
		}
	}

}
