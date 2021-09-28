package com.cg.assignment.nutrition.guru.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonData {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "personId")
	private int personId;
	
	@NotNull
	@Column(name = "height")
	private float personHeight;
	
	@NotNull
	@Column(name = "weight")
	private float personWeight;
	
	@Column(name = "age")
	private int personAge;
	
	@Column(name = "gender")
	private String personGender;
	
	@Column(name = "dietType")
	private String personDietType;
	
	@Column(name="BMI")
	private float personBMI;
	
	@Column(name="bodyType")
	private String bodyType;

	public PersonData() {
		super();
	}

	public PersonData(int personId, @NotNull float personHeight, @NotNull float personWeight, int personAge,
			String personGender, String personDietType, float personBMI, String bodyType) {
		super();
		this.personId = personId;
		this.personHeight = personHeight;
		this.personWeight = personWeight;
		this.personAge = personAge;
		this.personGender = personGender;
		this.personDietType = personDietType;
		this.personBMI = personBMI;
		this.bodyType = bodyType;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public float getPersonHeight() {
		return personHeight;
	}

	public void setPersonHeight(float personHeight) {
		this.personHeight = personHeight;
	}

	public float getPersonWeight() {
		return personWeight;
	}

	public void setPersonWeight(float personWeight) {
		this.personWeight = personWeight;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public String getPersonGender() {
		return personGender;
	}

	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}

	public String getPersonDietType() {
		return personDietType;
	}

	public void setPersonDietType(String personDietType) {
		this.personDietType = personDietType;
	}

	public float getPersonBMI() {
		return personBMI;
	}

	public void setPersonBMI(float personBMI) {
		this.personBMI = personBMI;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	@Override
	public String toString() {
		return "PersonData [personId=" + personId + ", personHeight=" + personHeight + ", personWeight=" + personWeight
				+ ", personAge=" + personAge + ", personGender=" + personGender + ", personDietType=" + personDietType
				+ ", personBMI=" + personBMI + ", bodyType=" + bodyType + "]";
	}
	

	
	
	
	
}
