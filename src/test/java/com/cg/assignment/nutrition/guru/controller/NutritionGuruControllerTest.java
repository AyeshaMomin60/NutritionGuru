package com.cg.assignment.nutrition.guru.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.assignment.nutrition.guru.model.PersonData;
import com.cg.assignment.nutrition.guru.service.NutritionGuruService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class NutritionGuruControllerTest {

	@Autowired
	NutritionGuruController nutritionGuruController;
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	NutritionGuruService nutritionGuruService;

	private PersonData person;

	@BeforeEach
	void initUserObject() {
		person = new PersonData();
		person.setPersonId(1);
		person.setPersonAge(12);
		person.setPersonHeight(160);
		person.setPersonGender("Male");
		person.setPersonWeight(49);
		person.setPersonBMI(16);
		person.setPersonDietType("under Weight");
		person.setBodyType("under Weight");

	}

	@Test
	@DisplayName("GET /api/person")
	void testRegisterPerson() throws Exception {

		PersonData personDetails = nutritionGuruService.registerPerson(person);

		when((nutritionGuruService).registerPerson(person)).thenReturn(person);
		String url = "/api/person";
		
		mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(person)))
				.andExpect(status().isOk())
				// Validate fields
				.andExpect(jsonPath("personId", is(1))).andExpect(jsonPath("name", is("Life Insurance")))
				.andExpect(jsonPath("cost", is(3400.89))).andExpect(jsonPath("detuctableAmount", is(340.9)))
				.andExpect(jsonPath("details", is("New Policy"))).andExpect(jsonPath("deleted", is(true)));
	}

	@Test
	void testGetPersonBMI() {
		fail("Not yet implemented");
	}

	@Test
	void testDietTypeBasedOnBMI() {
		fail("Not yet implemented");
	}

	@Test
	void testBodyTypeBasedOnDietType() {
		fail("Not yet implemented");
	}
	
	
	static String asJsonString(Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
