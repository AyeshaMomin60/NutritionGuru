package com.cg.assignment.nutrition.guru.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.assignment.nutrition.guru.exception.NutritionGuruException;
import com.cg.assignment.nutrition.guru.model.PersonData;
import com.cg.assignment.nutrition.guru.repository.NutritionGuruRepository;

@SpringBootTest
class NutritionGuruServiceTest {

	@Autowired
    NutritionGuruService nutritionGuruService;
	
	@MockBean
	NutritionGuruRepository nutritionGuruRepository;
	
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
	void testRegisterPerson() {
		when(nutritionGuruRepository.save(person)).thenReturn(person);
        PersonData personDetails = nutritionGuruService.registerPerson(person);
        Assertions.assertNotNull(personDetails);
        Assertions.assertEquals(person, personDetails);
	}

	@Test
	void testFetchPersonDetails() {
		when(nutritionGuruRepository.findByPersonId(1)).thenReturn(person);
		System.out.println("The Register detail is comminig "+nutritionGuruService.fetchPersonDetails(1));
        PersonData personDetails = nutritionGuruService.fetchPersonDetails(1);
        Assertions.assertNotNull(personDetails);
        Assertions.assertEquals(person, personDetails);
	}

	@Test
	void testGetPersonBMI() throws NutritionGuruException {
		when(nutritionGuruRepository.findByPersonId(1)).thenReturn(person);
		when(nutritionGuruRepository.save(person)).thenReturn(person);
		System.out.println("The Register detail is comminig "+nutritionGuruService.fetchPersonDetails(1));
		PersonData personDetails=nutritionGuruRepository.findByPersonId(1);
		float personBMI = nutritionGuruService.getPersonBMI(1);
        float height=personDetails.getPersonHeight();
		float weight=personDetails.getPersonWeight();
	    float BMI=(weight/(height*height));
	    personDetails.setPersonBMI(BMI);
        Assertions.assertNotNull(personDetails);
        Assertions.assertEquals(person.getPersonBMI(), personBMI);
	}

	@Test
	void testGetPersonDietBaseOnBMI() {
		when(nutritionGuruRepository.findByPersonId(1)).thenReturn(person);
		PersonData personDetails=nutritionGuruRepository.findByPersonId(1);
		
		Assertions.assertNotNull(personDetails);
	}

	@Test
	void testGetbodyTypeBasedOnDietType() {
		when(nutritionGuruRepository.findByPersonId(1)).thenReturn(person);
		PersonData personDetails=nutritionGuruRepository.findByPersonId(1);
		Assertions.assertNotNull(personDetails);
	}

}
