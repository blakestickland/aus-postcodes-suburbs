package com.blakecode.postcodesau.postcode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class PostcodeDTO {
	
	@NotBlank (message = "DTO suburb field cannot be blank")
	@Length(min = 5, max = 99, message = "suburb field must be between 5-99 characters")
	// Check that the suburb begins with a capital letter and does not include special characters nor digits
	@Pattern(regexp = "^[A-Z][a-zA-Z-\s]+", 
			message = "DTO suburb must start with an uppercase letter and can only contain letters, spaces, and hyphens")
	private String suburb;
		
	@NotBlank (message = "DTO postcode field cannot be blank")
	@Length(min = 4, max = 4, message = "DTO postcode field must have four digits such as 3121 or 7241")
	@Range(min = 100, max = 9999, message = "DTO postcode field must be between 0100 and 9999")
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
