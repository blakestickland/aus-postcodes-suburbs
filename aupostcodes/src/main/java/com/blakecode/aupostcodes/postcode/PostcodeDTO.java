package com.blakecode.aupostcodes.postcode;

import javax.validation.constraints.NotNull;

public class PostcodeDTO {
	@NotNull
	private String suburb;
	
	@NotNull
	private int postcode;
	
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
}
