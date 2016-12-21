package com.proxibanque.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTranfer;
	private String transferDate;
	private double amount;
	private long numAccountSender;
	private long numAccountReciever;
	private String clientName;
	private String clientFirstName;

	public Transfer() {
		super();
	}

	public Transfer(long numAccountSender, long numAccountReciever, double amount) {
		super();
		Date creationDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String newSimpleDate = dateFormat.format(creationDate);
		this.transferDate = newSimpleDate;
		this.numAccountSender = numAccountSender;
		this.numAccountReciever = numAccountReciever;
		this.amount = amount;
	}

	public String getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(String transferDate) {
		this.transferDate = transferDate;
	}

	public long getIdTranfer() {
		return idTranfer;
	}

	public void setIdTranfer(long idTranfer) {
		this.idTranfer = idTranfer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

}
