package com.blakecode.postcodesau.postcode;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class PostcodeDTO {
	
	@NotBlank (message = "suburb field cannot be null")
	@Length(min = 5, max = 99, message = "suburb field must be between 5-99 characters")
//	@Pattern(regexp = "[a-z]+(\\-)?/gi")
	private String suburb;
		
	@NotBlank (message = "postcode field cannot be blank")
	@Length(min = 4, max = 4, message = "postcode field must have four digits such as 3121 or 7241")
	// @Range is important to use as @Digits will pass any integer between 1 and 9999.
	@Range(min = 1001, max = 9999, message = "postcode field must be between 1001 and 9999")
	// @Digits helps with edge case of 1000 which would throw a 500 error without using it.
	@Digits(integer = 4, fraction = 0,  message = "postcode field must be digits between 1001 and 9999")
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
