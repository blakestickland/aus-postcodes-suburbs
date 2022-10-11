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
	
	public List<Postcode> findBySuburb(@PathVariable String query) {
		return postcodeRepository.findAllBySuburb(query);
	}
	
	public List<Postcode> findByPostcode(@PathVariable String query) {
		return postcodeRepository.findAllByPostcode(query);
	}
	
	
	public void create(PostcodeDTO postcode) {
		Integer maxId = postcodeRepository.getMaxId();
		String maxPostcode =  postcodeRepository.getMaxPc();
		System.out.println(maxPostcode);
		maxId++;
		Postcode p = new Postcode(maxId, postcode.getSuburb(), postcode.getPostcode(), postcode.getState());
		postcodeRepository.save(p);
	}
	
}