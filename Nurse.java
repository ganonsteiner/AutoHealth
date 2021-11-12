package application;

import java.util.*;


public class Nurse extends User {
	
	// create arrayList of Patients
	protected ArrayList<Patient> inPatients;
	
	// create a new patient account by calling the super constructor within the method
	createPatientAccount(String userName, String password, String inBirth) {
		super.createPatientAccount(userName, password, inBirth);
	}
	
	
	void addPatient(Patient inPatient) {
		// add Patient object to the arraylist inPatients
		inPatients.add(inPatient);
	}
	
	
	// add the Patient's data to the Patient object that is passed in to the method
	void addPatientData(Patient inPatient, String inBloodPressure, double inBodyTemperature, String inWeight, double inHeight, String inAllergens, String inHealth) {
		inPatient.Vitals.bloodPressure = inBloodPressure;
		inPatient.Vitals.bodyTemp = inBodyTemperature;
		inPatient.Vitals.weight = inWeight;
		inPatient.Vitals.height = inHeight;
		inPatient.allergens.add(inAllergens);
		inPatient.healthConcerns.add(inHealth);
	}
	
	// return the inPatients arrayList
	ArrayList<Patient> getPatients() {
		return inPatients;
	}
	
	
}
