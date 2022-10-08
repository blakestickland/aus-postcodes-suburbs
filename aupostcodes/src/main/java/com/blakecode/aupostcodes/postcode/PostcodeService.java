package com.blakecode.aupostcodes.postcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostcodeService {
	@Autowired
	private PostcodeRepository postcodeRepository;
	
	public List<Postcode> getAll() {
		return postcodeRepository.findAll();
	}
	
	public void create(PostcodeDTO postcode) {
		Postcode p = new Postcode(postcode.getName(), postcode.getPostcode());
		postcodeRepository.save(p);
	}
	
}
