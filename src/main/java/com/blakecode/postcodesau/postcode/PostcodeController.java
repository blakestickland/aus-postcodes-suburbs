package com.blakecode.postcodesau.postcode;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blakecode.postcodesau.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/aupostcodes")
public class PostcodeController {
	@Autowired
	private PostcodeService postcodeService;
	
	@GetMapping("/admin")
	public List<Postcode> getPostcodes() {
		return postcodeService.getAll();
	}
	
	// ENDPOINT: GET /aupostcodes/{id}
	@GetMapping("/admin/{id}")
	public ResponseEntity<Postcode> getPostcodeById(@PathVariable(value = "id") int id) {
		Postcode postcode = postcodeService.getPostcode(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found with id " + id));
		
		return new ResponseEntity<>(postcode, HttpStatus.OK);
	}
	
	// SEARCHES
	
	// Return search based on suburb entered
	//  ENDPOINT: GET /aupostcodes/search?suburb={query}
	// NOTE: query should not have white space. Whitespace can be replaced by an underscore(_) 
	// or a plus-sign(+) or percentage-sign and the digits 2 and 0 (%20)
	
	@GetMapping("/search")
	public ResponseEntity<List<Postcode>> findBySuburbOrPostcode(
			@RequestParam(name="suburb", required=false) String suburb, 
			@RequestParam(name="postcode", required=false) String postcode) {
		
		if (StringUtils.hasLength(suburb)) {
			List<Postcode> suburbs = postcodeService.findBySuburb(suburb);
			if (suburbs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(suburbs, HttpStatus.OK);	
		} 
		
		if (StringUtils.hasLength(postcode)) {
			List<Postcode> postcodes = postcodeService.findByPostcode(postcode);
			if (postcodes == null) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(postcodes, HttpStatus.OK);	
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	
	// CREATE
	
	@PostMapping("/admin/create")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void savePostcode(@Valid @RequestBody PostcodeDTO postcode) {
		postcodeService.create(postcode);
	}
}