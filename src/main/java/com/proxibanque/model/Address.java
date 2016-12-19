package com.proxibanque.model;

import javax.persistence.Embeddable;


import org.springframework.stereotype.Component;


@Embeddable
public class Address {

	private String streetNumber;
	private String streetName;
	private String postalCode;
	private String city;

	public Address() {
		super();
	}

	public Address(String streetNumber, String streetName, String postalCode, String city) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.postalCode = postalCode;
		this.city = city;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
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

	@Override
	public String toString() {
		return "Address [streetNumber=" + streetNumber + ", streetName=" + streetName + ", postalCode=" + postalCode
				+ ", city=" + city + "]";
	}

	
}
