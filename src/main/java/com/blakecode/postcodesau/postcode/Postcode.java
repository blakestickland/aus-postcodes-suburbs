package com.blakecode.postcodesau.postcode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "postcodes_geo")
public class Postcode {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO) 
//	Not using @GeneratedValue due to database seed data being INSERTED with a single INSERT request.
//	Caused a conflict with the IDs created at that time. 
//	The Hibernate Sequence had next ID as 2 due to the single INSERT request.
	private Integer id;
	
	@NotBlank(message = "Postcode suburb cannot be blank")
	@Length(min = 5, max = 99, message = "Postcode suburb must be between 5-99 characters")
	private String suburb;
	
	@NotBlank(message = "Postcode postcode cannot be blank")
	@Length(min = 4, max = 4, message = "Postcode postcode must have four digits such as 3121 or 7241")
	@Range(min = 1001, max = 9999, message = "Postcode postcode must be between 1001 and 9999")
	private String postcode;
	
	private String state;
	
	private float latitude;
	
	private float longitude;
	
	public Postcode() {}
	
	public Postcode(String suburb, String state, String postcode, float latitude, float longitude) {
		this.suburb = suburb;
		this.state = state;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Postcode(String suburb, String postcode) {
		this.suburb = suburb;
		this.postcode = postcode;
	}
	
	public Postcode(Integer id, String suburb, String postcode) {
		this.id = id;
		this.suburb = suburb;
		this.postcode = postcode;
	}
	
	public Postcode(Integer id, String suburb, String postcode, String state) {
		this.id = id;
		this.suburb = suburb;
		this.postcode = postcode;
		this.state = state;
	}
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}


	public String getSuburb() {
		return suburb;
	}


	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}