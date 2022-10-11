package com.blakecode.postcodesau.postcode;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PostcodeRepository extends JpaRepository<Postcode, Integer> {
	@Query (value = "SELECT MAX(id) FROM Postcode")
	public Integer getMaxId();
	
	@Query (value = "SELECT MIN(postcode) FROM Postcode")
	public String getMaxPc();
	
	@Query ("SELECT p FROM Postcode p WHERE " + 
			"p.suburb LIKE CONCAT('%', :query, '%')")
	List<Postcode> findAllBySuburb(String query);
	
	@Query ("SELECT p FROM Postcode p WHERE " + 
			"p.postcode LIKE CONCAT('%', :query, '%')")
	List<Postcode> findAllByPostcode(String query);
}
