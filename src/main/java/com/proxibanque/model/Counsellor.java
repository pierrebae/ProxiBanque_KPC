package com.proxibanque.model;

public class Counsellor extends Person {

	private String login;
	private String password;

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
