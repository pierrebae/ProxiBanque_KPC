package com.proxibanque.model;

import java.util.List;

import javax.persistence.Entity;

/**
 * 
 * @author Pierre Baele, Cl�ment Lacorte, Katherine Merkulova
 * @see cette classe �tend Person, le g�rant a une liste de conseillers. Le
 *      g�rant repr�sente l'agence bancaire, vu qu'il est unique par agence
 *
 */
public class Manager extends Person {

	private List<Counsellor> counsellors;

	public Manager() {
		super();
	}

	public Manager(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public List<Counsellor> getCounsellors() {
		return counsellors;
	}

	public void setCounsellors(List<Counsellor> listCounsellors) {
		this.counsellors = counsellors;
	}

	@Override
	public String toString() {
		return "Manager [counsellors=" + counsellors + "]";
	}

}
