package com.proxibanque.model;

import javax.persistence.Embeddable;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class Address {

	private int streetNumber;
	private String streetName;
	private String postalCode;
	private String city;

	public Address() {
		super();
	}

	public Address(int streetNumber, String streetName, String postalCode, String city) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.city = city;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
