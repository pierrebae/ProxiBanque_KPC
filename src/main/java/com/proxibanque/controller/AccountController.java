package com.proxibanque.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxibanque.model.AccountType;
import com.proxibanque.model.BankAccount;
import com.proxibanque.service.ServiceAccount;


/**
 * AccountController permet la redirection des pages et l'utilisation de méthodes du service pour toutes pages .xhtml 
 * portant sur les opérations bancaires
 * 
 *
 */



@Component("accountController")
@ViewScoped
public class AccountController {

	@Autowired
	private ServiceAccount serviceAccount;
	@Autowired
	private BankAccount bankAccount;
	private List<BankAccount> banckAccounts;
	private String simpleDate;
	
	
	
	public void loadAccount() throws Exception {
		banckAccounts = serviceAccount.findAll();
	}
	
	public String saveAccount() throws Exception {
		 
		simpleDate = date();
		bankAccount.setCreationDate(simpleDate);
		
		serviceAccount.persist(bankAccount);
		return "home";
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	

	public String date(){
		Date creationDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDate = dateFormat.format(creationDate);
		return simpleDate;
	}
}
