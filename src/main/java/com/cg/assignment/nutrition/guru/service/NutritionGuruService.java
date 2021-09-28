package com.cg.assignment.nutrition.guru.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.assignment.nutrition.guru.exception.NutritionGuruException;
import com.cg.assignment.nutrition.guru.model.PersonData;
import com.cg.assignment.nutrition.guru.repository.NutritionGuruRepository;

@Service
@Transactional
public class NutritionGuruService{
	
	@Autowired
	NutritionGuruRepository nutritionGuruRepository;

	Logger logger = LoggerFactory.getLogger(NutritionGuruService.class);
	
	
	public PersonData registerPerson(PersonData personDetail) {
		
		return nutritionGuruRepository.save(personDetail);
	}


	public PersonData fetchPersonDetails(int personId) {
		return nutritionGuruRepository.findByPersonId(personId);
	}


	public float getPersonBMI(int personId) throws NutritionGuruException {
		PersonData personDetails=nutritionGuruRepository.findByPersonId(personId);
		if(personDetails.equals(null)) {
			throw new NutritionGuruException("Person Details Not Found");
		}
		logger.info("peron Details is:"+personDetails);
		float height=personDetails.getPersonHeight();
		float weight=personDetails.getPersonWeight();
	    float BMI=(weight/(height*height));
	    logger.info("MBI value calculated is: "+BMI);
	    personDetails.setPersonBMI(BMI);
	    nutritionGuruRepository.save(personDetails);
		return BMI;
	}


	public String getPersonDietBaseOnBMI(int personId) throws NutritionGuruException {
		PersonData personDetails=nutritionGuruRepository.findByPersonId(personId);
		String DietType;
		if(personDetails.equals(null)) {
			throw new NutritionGuruException("Person Details Not Found");
		}
		logger.info("person Details : "+personDetails);
		
			if(personDetails.getPersonBMI()<18.5) {
				DietType="under Weight";
			}
			
			else if(personDetails.getPersonBMI()>18.5 && personDetails.getPersonBMI()<24.9) {
				DietType="Healthy Weight";
			}
			
			else {
				DietType="Over Weight";
			}
			personDetails.setPersonDietType(DietType);
			nutritionGuruRepository.save(personDetails);
		  return DietType;
	}


	public String GetbodyTypeBasedOnDietType(int personId) throws NutritionGuruException {
		PersonData personDetails=nutritionGuruRepository.findByPersonId(personId);
		String bodyType;
		if(personDetails.equals(null)) {
			throw new NutritionGuruException("Person Details Not Found");
		}
		logger.info("person Details : "+personDetails);
		
			if(personDetails.getPersonDietType().equalsIgnoreCase("under Weight")) {
				bodyType="weight gain";
			}
			else if(personDetails.getPersonDietType().equalsIgnoreCase("Over Weight")) {
				bodyType="weight loss";
			}
			else {
				bodyType="stable weight";
			}
		return bodyType;
	}
	
	

	
	
	
	
}
