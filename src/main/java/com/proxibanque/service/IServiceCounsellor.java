package com.proxibanque.service;

import java.util.List;

import com.proxibanque.model.Client;
import com.proxibanque.model.Counsellor;

public interface IServiceCounsellor {

	void persist(Counsellor counsellor) throws Exception;

	void merge(Counsellor counsellor) throws Exception;

	void remove(long idCounsellor) throws Exception;

	Counsellor findById(long idCounsellor) throws Exception;

	List<Counsellor> findAll() throws Exception;

	void persist(Counsellor counsellor, Client client) throws Exception;
	
}
