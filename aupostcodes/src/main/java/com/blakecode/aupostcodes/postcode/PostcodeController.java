package com.blakecode.aupostcodes.postcode;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aupostcodes")
public class PostcodeController {
	@Autowired
	private PostcodeService postcodeService;
	
	@GetMapping
	public List<Postcode> getPostcodes() {
		return postcodeService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void savePostcode(@Valid @RequestBody PostcodeDTO postcode) {
		postcodeService.create(postcode);
	}
}
