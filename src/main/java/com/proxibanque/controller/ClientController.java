package com.proxibanque.controller;

<<<<<<< HEAD

=======
>>>>>>> origin/master
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proxibanque.model.Client;
import com.proxibanque.service.ServiceClient;

/**
 * ClientController permet la redirection des pages et l'utilisation de méthodes
 * du service pour toutes les pages .xhtml portant sur les opérations sur les
 * clients
 * 
 *
 */

@Component("clientController")
@ViewScoped
public class ClientController implements Serializable {
<<<<<<< HEAD
	
=======

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
>>>>>>> origin/master
	@Autowired
	private ServiceClient clientService;
	
	private Client client;
	private List<Client> clients;
	private List<Client> selectedClients;
	private long idCli;

	
	
	@PostConstruct
    public void init() {
		refreshList();
    }
	
	
	public void refreshList() {
		this.client = new Client();
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
	
	
	
	
	public void loadClients() throws Exception {

		clients = clientService.findAll();

	}
	

	

	public String saveClient() throws Exception {
		clientService.persist(this.client);
<<<<<<< HEAD
		return "listClients";
	}

	public String removeClient(Client client) throws Exception {
	
		clientService.remove(client.getId());
	
		return "listClients";
	}

	public String removeClients() throws Exception {
	
		selectedClients = getSelectedClients();
	
		if (getSelectedClients() != null) {
			for (Client client : selectedClients) {
				clientService.remove(client.getId());
			}
			return "listClients";
		} else
			return "";
	
=======
		refreshList();
		return "listClients";
>>>>>>> origin/master
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

<<<<<<< HEAD
	//
//	public String saveCompte(CompteBancaire account) {
//
//		Client client = clientService.getClientById(idCli);
//
//		if ((TypeCompte.COMPTECOURANT.equals(account.getType())) && (client.getCc() == null)) {
//			CompteCourant compteCourant = new CompteCourant(account.getSolde(), account.getType());
//			client.setCc(compteCourant);
//			clientService.updateClient(client);
//			return "addAccount";
//
//		} else if ((TypeCompte.COMPTEEPARGNE.equals(account.getType())) && (client.getCe() == null)) {
//			CompteEpargne compteEpargne = new CompteEpargne(account.getSolde(), account.getType());
//			client.setCe(compteEpargne);
//			clientService.updateClient(client);
//			return "addAccount";
//		} else {
//			return "";
//		}
//	}
//
=======
	public String removeClient(Client client) throws Exception {

		clientService.remove(client.getId());

		return "listClients";
	}

	//
	// public String saveCompte(CompteBancaire account) {
	//
	// Client client = clientService.getClientById(idCli);
	//
	// if ((TypeCompte.COMPTECOURANT.equals(account.getType())) &&
	// (client.getCc() == null)) {
	// CompteCourant compteCourant = new CompteCourant(account.getSolde(),
	// account.getType());
	// client.setCc(compteCourant);
	// clientService.updateClient(client);
	// return "addAccount";
	//
	// } else if ((TypeCompte.COMPTEEPARGNE.equals(account.getType())) &&
	// (client.getCe() == null)) {
	// CompteEpargne compteEpargne = new CompteEpargne(account.getSolde(),
	// account.getType());
	// client.setCe(compteEpargne);
	// clientService.updateClient(client);
	// return "addAccount";
	// } else {
	// return "";
	// }
	// }
	//
>>>>>>> origin/master
	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Client Selected", ((Client) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Client Unselected", ((Client) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
