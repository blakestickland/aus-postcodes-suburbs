package com.blakecode.postcodesau.postcode;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blakecode.postcodesau.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping(value = "/aupostcodes")
public class PostcodeController {
	@Autowired
	private PostcodeService postcodeService;
	
	@GetMapping
	public List<Postcode> getPostcodes() {
		return postcodeService.getAll();
	}
	
// GET /aupostcodes/{id}
	@GetMapping("/{id}")
	public ResponseEntity<Postcode> getPostcodeById(@PathVariable(value = "id") int id) {
		Postcode postcode = postcodeService.getPostcode(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not found with id " + id));
		
		return new ResponseEntity<>(postcode, HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void savePostcode(@Valid @RequestBody PostcodeDTO postcode) {
		postcodeService.create(postcode);
	}
}