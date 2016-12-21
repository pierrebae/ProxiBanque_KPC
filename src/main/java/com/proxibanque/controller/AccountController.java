package com.proxibanque.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxibanque.model.BankAccount;
import com.proxibanque.model.Client;
import com.proxibanque.service.ServiceAccount;

/**
 * AccountController permet la redirection des pages et l'utilisation de
 * méthodes du service pour toutes pages .xhtml portant sur les opérations
 * bancaires
 * 
 *
 */

@Component("accountController")
@ViewScoped
public class AccountController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ServiceAccount serviceAccount;

	private BankAccount bankAccount;
	private List<BankAccount> bankAccounts;
	private List<BankAccount> selectedBankAccounts;
	private String simpleDate;
	private Client selectedClient;
	private List<Client> selectedClients;

	@PostConstruct
	public void init() {
		refreshList();
	}

	public void refreshList() {
		this.bankAccount = new BankAccount();
		this.bankAccounts = new ArrayList<BankAccount>();
		this.selectedBankAccounts = new ArrayList<BankAccount>();
		try {
			this.bankAccounts.addAll(serviceAccount.findAll());
			this.selectedBankAccounts.addAll(bankAccounts);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadAccount() throws Exception {
		bankAccounts = serviceAccount.findAll();
	}

	public String saveAccount() throws Exception {

		simpleDate = date();
		bankAccount.setCreationDate(simpleDate);

		selectedClient.addAccount(bankAccount);

		serviceAccount.persist(bankAccount);
		refreshList();
		return "listAccount";
	}

	public String removeAccount(BankAccount bankAccount) throws Exception {

		serviceAccount.remove(bankAccount.getAccountNumber());
		refreshList();
		return "listAccount";

	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String date() {
		Date creationDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDate = dateFormat.format(creationDate);
		return simpleDate;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	public List<BankAccount> getSelectedBankAccounts() {
		return selectedBankAccounts;
	}

	public void setSelectedBankAccounts(List<BankAccount> selectedBankAccounts) {
		this.selectedBankAccounts = selectedBankAccounts;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public List<Client> getSelectedClients() {
		return selectedClients;
	}

	public void setSelectedClients(List<Client> selectedClients) {
		this.selectedClients = selectedClients;
	}

}
