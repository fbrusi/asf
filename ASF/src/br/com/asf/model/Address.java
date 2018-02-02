package br.com.asf.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Address {

	@NotEmpty
	@Column(nullable = false, name = "postal_code")
	private String postalCode;
	
	@NotEmpty
	@Column(nullable = false)
	private String neighborhood;
	
	@NotEmpty
	@Column(nullable = false)
	private String city;
	
	@NotEmpty
	@Column(nullable = false)
	private String state;
	
	@NotEmpty
	@Column(nullable = false)
	private String street;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
