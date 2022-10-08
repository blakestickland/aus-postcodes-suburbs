package com.blakecode.postcodesau.postcode;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@Transactional
public class PostcodeService {
	@Autowired
	private PostcodeRepository postcodeRepository;
	
	public List<Postcode> getAll() {
		return postcodeRepository.findAll();
	}
	
	public Optional<Postcode> getPostcode(@PathVariable int id) {
		return postcodeRepository.findById(id);
	}
	
	public void create(PostcodeDTO postcode) {
		Integer maxId = postcodeRepository.getMaxId();
		maxId++;
		System.out.println(maxId);
		Postcode p = new Postcode(maxId, postcode.getSuburb(), postcode.getPostcode());
		postcodeRepository.save(p);
	}
	
}