package com.blakecode.postcodesau.postcode;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostcodeRepository extends JpaRepository<Postcode, Integer> {
	@Query (value = "SELECT MAX(id) FROM Postcode")
	public Integer getMaxId();
}
