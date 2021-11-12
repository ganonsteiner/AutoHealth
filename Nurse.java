package application;

import java.util.*;


public class Nurse extends User {
	
	Doctor nurseDoc = new Doctor();
	
	protected ArrayList<Patient> nPatients;
	
	public void createPatientAccount(String userName, String password, String inBirth) {
		Patient newPatient = new Patient(userName, password, inBirth);
		addPatient(newPatient);
	}
	
	public void addPatient(Patient inPatient) {
		nPatients.add(inPatient);
	}
	
	public void addPatientData(Patient inPatient, String inBloodPressure, double inBodyTemperature, String inWeight, double inHeight, String inAllergens, String inHealth) {
		inPatient.Vitals.bloodPressure = inBloodPressure;
		inPatient.Vitals.bodyTemp = inBodyTemperature;
		inPatient.Vitals.weight = inWeight;
		inPatient.Vitals.height = inHeight;
		inPatient.allergens.add(inAllergens);
		inPatient.healthConcerns.add(inHealth);
	}
	
	public ArrayList<Patient> getPatients() {
		return nPatients;
	}