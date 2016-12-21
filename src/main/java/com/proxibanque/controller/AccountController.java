package com.proxibanque.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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

	private double amount =0L;
	private BankAccount bankAccount;
	private BankAccount bankAccountSender;
	private List<BankAccount> bankAccounts;
	private List<BankAccount> selectedBankAccounts;
	private List<BankAccount> bankAccountsSender;
	private List<BankAccount> bankAccountsReciever;
	private long numAccountSender =0L;
	private long numAccountReciever  =0L;
	private String simpleDate;
	private Client selectedClient;
	private List<Client> selectedClients;

	@PostConstruct
	public void init() {
		refreshList();
	}

	public void refreshList() {

		this.bankAccount = new BankAccount();
		this.bankAccountSender = new BankAccount();
		this.bankAccountsSender = new ArrayList<BankAccount>();
		this.bankAccountsReciever = new ArrayList<BankAccount>();
		this.bankAccounts = new ArrayList<BankAccount>();
		this.selectedBankAccounts = new ArrayList<BankAccount>();
		try {
			this.bankAccounts.addAll(serviceAccount.findAll());
			this.bankAccountsSender.addAll(serviceAccount.findAll());
			this.bankAccountsReciever.addAll(serviceAccount.findAll());
			this.selectedBankAccounts.addAll(bankAccounts);
		} catch (Exception e) {
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

	public String transfer() throws Exception {
		serviceAccount.transfer(numAccountSender, numAccountReciever, amount);
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

	public List<BankAccount> getBankAccountsSender() {
		return bankAccountsSender;
	}

	public void setBankAccountsSender(List<BankAccount> bankAccountsSender) {
		this.bankAccountsSender = bankAccountsSender;
	}

	public List<BankAccount> getBankAccountsReciever() {
		return bankAccountsReciever;
	}

	public void setBankAccountsReciever(List<BankAccount> bankAccountsReciever) {
		this.bankAccountsReciever = bankAccountsReciever;
	}

	public BankAccount getBankAccountSender() {
		return bankAccountSender;
	}

	public void setBankAccountSender(BankAccount bankAccountSender) {
		this.bankAccountSender = bankAccountSender;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
