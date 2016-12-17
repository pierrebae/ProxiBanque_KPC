package com.proxibanque.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Counsellor extends Person {

	private String login;
	private String password;
	
	@OneToMany(mappedBy="counsellor")
	@Cascade({ CascadeType.PERSIST })
	private List<Client> listClients;

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
	
	

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
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
