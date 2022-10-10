package com.blakecode.postcodesau.postcode;

import javax.validation.constraints.NotNull;

public class PostcodeDTO {
	
	@NotNull
	private String suburb;
		
	@NotNull
	private String postcode;
	
	private String state;
	
	
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
