package com.proxibanque.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transfer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTransfer;
	private String transferDate;
	private double amount;
	private long numAccountSender;
	private long numAccountReciever;


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
		return idTransfer;
	}

	public void setIdTranfer(long idTranfer) {
		this.idTransfer = idTranfer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}



	public long getNumAccountSender() {
		return numAccountSender;
	}

	public void setNumAccountSender(long numAccountSender) {
		this.numAccountSender = numAccountSender;
	}

	public long getNumAccountReciever() {
		return numAccountReciever;
	}

	public void setNumAccountReciever(long numAccountReciever) {
		this.numAccountReciever = numAccountReciever;
	}

	
}
