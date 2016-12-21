package com.proxibanque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxibanque.dao.IDaoCounsellor;
import com.proxibanque.model.Client;
import com.proxibanque.model.Counsellor;

@Component
public class ServiceCounsellor implements IServiceCounsellor {

	@Autowired
	private IDaoCounsellor daoCounsellor;

	@Override
	public void persist(Counsellor counsellor) throws Exception {
		daoCounsellor.persist(counsellor);
	}

	@Override
	public void merge(Counsellor counsellor) throws Exception {
		daoCounsellor.merge(counsellor);
	}

	@Override
	public void remove(long idCounsellor) throws Exception {
		daoCounsellor.remove(idCounsellor);
	}

	@Override
	public Counsellor findById(long idCounsellor) throws Exception {
		return daoCounsellor.findById(idCounsellor);
	}

	@Override
	public List<Counsellor> findAll() throws Exception {
		return daoCounsellor.findAll();
	}

	@Override
	public void persist(Counsellor counsellor, Client client) throws Exception {

		List<Client> clients = counsellor.getClients();
		clients.add(client);
		client.setCounsellor(counsellor);
		daoCounsellor.persist(counsellor);

	}
}
