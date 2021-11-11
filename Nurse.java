package application;

import java.util.*;


public class Nurse extends User {
	
	protected ArrayList<Patient> inPatients;
	
	//super(string userName, String password, String inBirth);
	
	void addPatient(Patient inPatient) {
		
		inPatients.add(inPatient);
	}
	
	void addPatientData(Patient inPatient, String inBloodPressure, String inBodyTemperature, String inWeight, double inHeight, String inAllergens, String inHealth) {
		inPatient.Vitals.bloodPressure = inBloodPressure;
		inPatient.Vitals.bodyTemp = inBodyTemperature;
		inPatient.Vitals.weight = inWeight;
		inPatient.Vitals.height = inHeight;
		inPatient.allergens.add(inAllergens);
		inPatient.healthConcerns.add(inHealth);
	}
	
	ArrayList<Patient> getPatients() {
		return inPatients;
	}
	
	
}
