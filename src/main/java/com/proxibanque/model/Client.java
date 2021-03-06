package com.proxibanque.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author Pierre Baele, Cl�ment Lacorte, Katherine Merkulova
 * @see cette classe �tend Person. il a une adresse et des informations
 *      personnelles, une liste de comptes bancaires et un conseiller
 *
 */
@Entity
public class Client extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "counsellor_id")
	private Counsellor counsellor;

	@OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.ALL })
	private List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

	@Embedded
	private Address address = new Address();

	private String telephone;
	private String email;

	public Client() {
		super();
	}

	public Client(String firstName, String lastName) {
		super(firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public Client(String firstName, String lastName, String email, Address address, Counsellor counsellor) {
		super(firstName, lastName);
		this.email = email;
		this.address = address;
		this.counsellor = counsellor;
	}

	public Client(String firstName, String lastName, String email, Address address) {
		super(firstName, lastName);
		this.email = email;
		this.address = address;
	}

	public Client(String email, String telephone, Address address) {
		super();
		this.email = email;
		this.telephone = telephone;
		this.address = address;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Counsellor getCounsellor() {
		return counsellor;
	}

	public void setCounsellor(Counsellor counsellor) {
		this.counsellor = counsellor;
	}

	public List<BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccount> bankAccount) {
		this.bankAccounts = bankAccount;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public void addAccount(BankAccount bankAccount) {
		bankAccounts.add(bankAccount);
		bankAccount.setClient(this);
	}

}
