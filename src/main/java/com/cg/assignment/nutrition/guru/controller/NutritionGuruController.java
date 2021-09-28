package com.cg.assignment.nutrition.guru.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.assignment.nutrition.guru.exception.NutritionGuruException;
import com.cg.assignment.nutrition.guru.model.PersonData;
import com.cg.assignment.nutrition.guru.service.NutritionGuruService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin

public class NutritionGuruController {

	@Autowired
	NutritionGuruService nutritionGuruService;

	Logger logger = LoggerFactory.getLogger(NutritionGuruController.class);

	@PostMapping("/person")
	public ResponseEntity<PersonData> registerPerson(@RequestBody PersonData personDetail) {

		PersonData personDetails = nutritionGuruService.registerPerson(personDetail);
		logger.info("personDetail" + personDetail);
		return new ResponseEntity<>(personDetails, HttpStatus.OK);
	}

	@GetMapping("/person/BMI/{personId}")
	public ResponseEntity<String> getPersonBMI(@PathVariable("personId") int personId) throws NutritionGuruException {
		float BMIValue = nutritionGuruService.getPersonBMI(personId);
        
		return new ResponseEntity<String>("Person BMI value is : " + BMIValue, HttpStatus.ACCEPTED);

	}

	@GetMapping("/person/dietType/{personId}")
	public ResponseEntity<String> dietTypeBasedOnBMI(@PathVariable("personId") int personId) throws NutritionGuruException {
		String dietType = nutritionGuruService.getPersonDietBaseOnBMI(personId);
		return new ResponseEntity<String>(dietType, HttpStatus.ACCEPTED);

	}
	@GetMapping("/person/bodyType/{personId}")
	public ResponseEntity<String> bodyTypeBasedOnDietType(@PathVariable("personId") int personId) throws NutritionGuruException {
		String bodyType = nutritionGuruService.GetbodyTypeBasedOnDietType(personId);
		return new ResponseEntity<String>(bodyType, HttpStatus.ACCEPTED);

	}
	
	

}
