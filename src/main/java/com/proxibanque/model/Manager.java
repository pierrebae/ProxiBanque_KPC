package com.proxibanque.model;

import java.util.List;

import javax.persistence.Entity;

/**
 * 
 * @author Pierre Baele, Clément Lacorte, Katherine Merkulova
 * @see cette classe étend Person, le gérant a une liste de conseillers. Le
 *      gérant représente l'agence bancaire, vu qu'il est unique par agence
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
