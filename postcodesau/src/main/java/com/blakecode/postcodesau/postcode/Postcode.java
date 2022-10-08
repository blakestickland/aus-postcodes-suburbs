package com.blakecode.postcodesau.postcode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "postcodes_geo")
public class Postcode {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String suburb;
	private String state;
	private String postcode;
	private float latitude;
	private float longitude;
	
	public Postcode(String suburb, String state, String postcode, float latitude, float longitude) {
		this.suburb = suburb;
		this.state = state;
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Postcode(Integer id, String suburb, String postcode) {
		this.id = id;
		this.suburb = suburb;
		this.postcode = postcode;
	}
	
	public Postcode() {}
	
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