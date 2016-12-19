package com.proxibanque.controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	@Autowired
	private ServiceClient clientService;
	@Autowired
	private Client client;
	private List<Client> clients;
	private List<Client> selectedClients;
	private long idCli;

	

	
	public void loadClients() throws Exception {

		clients = clientService.findAll();
		
	}
	

	

	public String saveClient() throws Exception {
		clientService.persist(this.client);
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
	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Client Selected", ((Client) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Client Unselected", ((Client) event.getObject()).getLastName());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
