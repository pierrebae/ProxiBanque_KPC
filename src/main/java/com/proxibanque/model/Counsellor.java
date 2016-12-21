package com.proxibanque.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see cette classe étend Person et a un login et password, ainsi qu'une liste
 *      de clients
 *
 */
@Entity
public class Counsellor extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;

	@OneToMany(mappedBy = "counsellor", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.PERSIST })
	private List<Client> clients;

	public Counsellor(String firstName, String lastName, String login, String password) {
		super(firstName, lastName);
		this.login = login;
		this.password = password;
	}

	public Counsellor(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Counsellor() {
		super();
	}

	public void addClient(Client client) {
		clients.add(client);
		client.setCounsellor(this);
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
