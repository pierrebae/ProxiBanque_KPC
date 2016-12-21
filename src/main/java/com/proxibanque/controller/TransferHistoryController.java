package com.proxibanque.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxibanque.model.Transfer;

import com.proxibanque.service.ServiceTransfer;

@Component("TransferHistoryController")
@ViewScoped
public class TransferHistoryController {

	@Autowired
	private ServiceTransfer serviceTransfer;

	private List<Transfer> transfers;

	@PostConstruct
	public void init() {
		refreshList();
	}

	public void refreshList() {

		this.transfers = new ArrayList<Transfer>();

		try {
			this.transfers.addAll(serviceTransfer.findAll());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Transfer> getTransfers() {
		return transfers;
	}

	public void setTransfers(List<Transfer> transfers) {
		this.transfers = transfers;
	}
	
	

}
