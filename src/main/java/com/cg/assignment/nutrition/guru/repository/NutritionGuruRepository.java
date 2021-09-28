package com.cg.assignment.nutrition.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.assignment.nutrition.guru.model.PersonData;


@Repository
public interface NutritionGuruRepository extends JpaRepository<PersonData, Integer>{

	PersonData findByPersonId(int personId);

}
