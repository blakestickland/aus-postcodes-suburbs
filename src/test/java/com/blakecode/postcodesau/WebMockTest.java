package com.blakecode.postcodesau;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.blakecode.postcodesau.postcode.Postcode;
import com.blakecode.postcodesau.postcode.PostcodeController;
import com.blakecode.postcodesau.postcode.PostcodeRepository;
import com.blakecode.postcodesau.postcode.PostcodeService;

@WebMvcTest(PostcodeController.class)
public class WebMockTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private PostcodeService service;
	
	@MockBean 
	private PostcodeRepository repository;
	
//	@Test
//	public void greetingShouldReturnMessageFromService() throws Exception {
//		when(service.findBySuburb("Thornbury")).thenReturn(repository.findAllBySuburb("Thornbury"));
////		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
////				.andExpect(content().string(containsString("Hello, Mock")));
//	}
	
//	@Test
//	public void givenPostcodes_whenGetSuburb_thenReturnJsonArray()
//		throws Exception {
//		
//		Postcode pc = new Postcode("Thornbury", "3072");
//		
//		List<Object> suburb = Arrays.asList(pc);
//		
//		given(service.findBySuburb("Thornbury")).willReturn(suburb);
//		
//		mockMvc.perform(get("/aupostcodes/search?suburb=Thornbury")
//			.contentType(MediaType.APPLICATION_JSON))
//	      	.andExpect(status().isOk())
//	      	.andExpect((ResultMatcher) jsonPath("$", hasSize(2)))
//	      	.andExpect(jsonPath("$[0].suburb", is(pc.getSuburb())));
//	}
//
//	private Object hasSize(int i) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
