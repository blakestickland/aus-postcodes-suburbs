package com.blakecode.postcodesau.postcode;

import javax.validation.constraints.NotNull;

public class PostcodeDTO {
	
	@NotNull
	private String suburb;
		
	@NotNull
	private String postcode;
	
	
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
}
