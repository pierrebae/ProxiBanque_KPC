package com.proxibanque.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.proxibanque.dao.IDaoTransfer;
import com.proxibanque.model.Transfer;

@Component
public class ServiceTransfer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private IDaoTransfer daoTransfer;
	
	public void persist(Transfer transfer) throws Exception {
		daoTransfer.persist(transfer);
	}
	
	public List<Transfer> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoTransfer.findAll();
	}
	
}
