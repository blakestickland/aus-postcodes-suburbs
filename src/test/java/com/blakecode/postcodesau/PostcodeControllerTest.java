package com.blakecode.postcodesau;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blakecode.postcodesau.postcode.PostcodeController;

@SpringBootTest
public class PostcodeControllerTest {
	
	@Autowired
	private PostcodeController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
