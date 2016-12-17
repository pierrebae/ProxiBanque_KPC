package com.proxibanque.model;

import java.util.List;

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

	
	
}
