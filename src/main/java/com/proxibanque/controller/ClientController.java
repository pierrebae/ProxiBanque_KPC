package com.proxibanque.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.ws.Service;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxibanque.model.BankAccount;
import com.proxibanque.model.Client;
import com.proxibanque.model.Counsellor;
import com.proxibanque.service.ServiceClient;

/**
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see ClientController permet la redirection des pages et l'utilisation de
 *      méthodes du service client pour toutes les pages .xhtml portant sur les
 *      opérations sur les clients.
 * 
 *
 */

@Component("clientController")
@ViewScoped
public class ClientController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ServiceClient clientService;

	private Client client;
	private Client clientSender;
	private Client clientReciever;
	private BankAccount bankAccount;
	private BankAccount accountSender;
	private BankAccount accountReciever;
	private List<BankAccount> accountsSender;
	private List<BankAccount> accountsReciever;

	private List<Client> clients;
	private List<Client> selectedClients;
	private Client selectedClient;
	private long idCli;

	private DualListModel<Client> clientsForDualReciever;
	private DualListModel<Client> clientsForDualSender;
	private String simpleDate;
	private Counsellor counsellor;
	private Counsellor selectedCounsellor;
	private List<Counsellor> selectedCounsellors;

	
	private PieChartModel pieModel;
	


	@PostConstruct
	public void init() throws Exception {
		refreshList();
		createPieModels();
		

	}

	/**
	 * cette methode effectue un rechargement de contexte
	 */
	public void refreshList() {
		this.accountSender = new BankAccount();
		this.accountReciever = new BankAccount();
		this.clientSender = new Client();
		this.clientReciever = new Client();
		this.client = new Client();
		this.selectedClient = new Client();
		this.bankAccount = new BankAccount();
		this.counsellor = new Counsellor();
		this.selectedCounsellor = new Counsellor();

		this.accountsReciever = new ArrayList<BankAccount>();
		this.accountsReciever = new ArrayList<BankAccount>();
		this.clients = new ArrayList<Client>();
		this.selectedClients = new ArrayList<Client>();
		try {
			this.clients.addAll(clientService.findAll());
			this.selectedClients.addAll(clients);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onClientChange() {
		if (clientSender != null && !client.equals("")) {
			accountsSender = clientSender.getBankAccounts();
		} else {
			accountsSender = new ArrayList<BankAccount>();
		}
	}

	public void loadClients() throws Exception {

		clients = clientService.findAll();

	}

	public void loadClient(Client client) throws Exception {

		// Client clientMemory = clientService.findById(client.getId());
		// ExternalContext externalContext =
		// FacesContext.getCurrentInstance().getExternalContext();
		//
		// Map<String, Object> requestMap = externalContext.getRequestMap();
		// requestMap.put("client", clientMemory);
		//
		// return "listClient";
	}

	public String saveClient() throws Exception {
		clientService.persist(this.client);

		refreshList();
		return "listClients";
	}

	public String saveClient(BankAccount account) throws Exception {
		clientService.persist(this.client, account);

		refreshList();
		return "listClients";
	}

	public String saveClientAndAccount() throws Exception {

		selectedCounsellor.addClient(client);

		simpleDate = date();
		bankAccount.setCreationDate(simpleDate);
		clientService.persist(this.client, this.bankAccount);
		refreshList();
		return "listClients";
	}

	public String removeClient(Client client) throws Exception {

		clientService.remove(client.getId());
		refreshList();
		return "listClients";
	}

	public void updateClient() {
		try {
			clientService.merge(this.selectedClient);
			refreshList();
			notificationSuccess("mise à jour client");
		} catch (Exception e) {
			notificationError(e, "mise à jour client");
		}

	}

	public void notificationSuccess(String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Operation " + operation + " success");
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Opération réussie");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void notificationError(Exception e, String operation) {
		Logger.getLogger(this.getClass().getName()).log(Level.ERROR, "Operation " + operation + " Error ", e);
		FacesMessage msg = null;
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification", "Une erreur est survenue");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		refreshList();
	}

	public void reset() {
		refreshList();
		RequestContext.getCurrentInstance().reset("formClients:panel");
	}

	public String removeClients() throws Exception {

		selectedClients = getSelectedClients();

		if (getSelectedClients() != null) {
			for (Client client : selectedClients) {
				clientService.remove(client.getId());
				refreshList();
			}

			return "listClients";
		} else {
			return "";
		}
	}

	
	
	private void createPieModels() {
		createPieModel();
	}
	
	private void createPieModel() {
        pieModel = new PieChartModel();
        
        double sommeCompte = 0;
    	List<Client> nombreClient0 = new ArrayList<>();
    	List<Client> nombreClient500= new ArrayList<>();
    	List<Client> nombreClient5000= new ArrayList<>();
    	List<Client> nombreClientSup= new ArrayList<>();

        for (Client client : clients) {
        	List<BankAccount> listAccounts = client.getBankAccounts();
			for (BankAccount bankAccount : listAccounts) {
				sommeCompte	+= bankAccount.getBalance();
			}
			if (sommeCompte < 0) {
				nombreClient0.add(client);
			} else if (sommeCompte < 500 && sommeCompte >= 0) {
				nombreClient500.add(client);
			} else if (sommeCompte < 5000 && sommeCompte >=500){
				nombreClient5000.add(client);
			} else {
				nombreClientSup.add(client);
			}
		}
        
        pieModel.set("Solde des Comptes < 0", nombreClient0.size());
        pieModel.set("Solde des Comptes entre 0 et 500", nombreClient500.size());
        pieModel.set("Solde des Comptes entre 500 et 5000", nombreClient5000.size());
        pieModel.set("Solde des Comptes > 5000", nombreClientSup.size());
         
        pieModel.setTitle("Nombre de Clients par Richesse");
        pieModel.setLegendPosition("w");
    }
	
	
	
	
	
	public String date(){

		Date creationDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDate = dateFormat.format(creationDate);
		return simpleDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public long getIdCli() {
		return idCli;
	}

	public void setIdCli(long idCli) {
		this.idCli = idCli;
	}

	public List<Client> getSelectedClients() {
		return selectedClients;
	}

	public void setSelectedClients(List<Client> selectedClients) {
		this.selectedClients = selectedClients;
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Client Selected", ((Client) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Client Unselected", ((Client) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public DualListModel<Client> getClientsForDualReciever() {
		return clientsForDualReciever;
	}

	public void setClientsForDualReciever(DualListModel<Client> clientsForDualReciever) {
		this.clientsForDualReciever = clientsForDualReciever;
	}

	public DualListModel<Client> getClientsForDualSender() {
		return clientsForDualSender;
	}

	public void setClientsForDualSender(DualListModel<Client> clientsForDualSender) {
		this.clientsForDualSender = clientsForDualSender;
	}

	public Client getClientSender() {
		return clientSender;
	}

	public void setClientSender(Client clientSender) {
		this.clientSender = clientSender;
	}

	public Client getClientReciever() {
		return clientReciever;
	}

	public void setClientReciever(Client clientReciever) {
		this.clientReciever = clientReciever;
	}

	public List<BankAccount> getAccountsSender() {
		return accountsSender;
	}

	public void setAccountsSender(List<BankAccount> accountsSender) {
		this.accountsSender = accountsSender;
	}

	public List<BankAccount> getAccountsReciever() {
		return accountsReciever;
	}

	public void setAccountsReciever(List<BankAccount> accountsReciever) {
		this.accountsReciever = accountsReciever;
	}

	public BankAccount getAccountSender() {
		return accountSender;
	}

	public void setAccountSender(BankAccount accountSender) {
		this.accountSender = accountSender;
	}

	public BankAccount getAccountReciever() {
		return accountReciever;
	}

	public void setAccountReciever(BankAccount accountReciever) {
		this.accountReciever = accountReciever;
	}

	public String getSimpleDate() {
		return simpleDate;
	}

	public void setSimpleDate(String simpleDate) {
		this.simpleDate = simpleDate;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;

	}

	public Counsellor getSelectedCounsellor() {
		return selectedCounsellor;
	}

	public void setSelectedCounsellor(Counsellor selectedCounsellor) {
		this.selectedCounsellor = selectedCounsellor;
	}

	public List<Counsellor> getSelectedCounsellors() {
		return selectedCounsellors;
	}

	public void setSelectedCounsellors(List<Counsellor> selectedCounsellors) {
		this.selectedCounsellors = selectedCounsellors;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

}
