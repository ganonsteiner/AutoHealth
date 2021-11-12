//package application;

import java.io.Serializable;
import java.util.*;

public class Nurse extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nurseName;
	private Doctor nurseDoctor;

	protected ArrayList<Patient> patients;

	// add nurse constructor that will add a new nurse to the arraylist in the
	// doctor class
	public Nurse(String username, String password, String name, Doctor doctor) {
		super(username, password);
		patients = new ArrayList<Patient>();
		
		nurseName = name;
		nurseDoctor = doctor;
	}

	public void message(String username, Message message) {

		this.messageHistory.add(message);

		if (username.equals(nurseDoctor.getUsername())) {
			nurseDoctor.getMessageHistory().add(message);
		}

		for (int i = 0; i < patients.size(); i++) {
			if (username.equals(patients.get(i).getUsername())) {
				patients.get(i).getMessageHistory().add(message);
			}
		}
	}

	public void createPatientAccount(String userName, String password, String inBirth, Doctor doc, Nurse ptNurse) {
		Patient newPatient = new Patient(userName, password, inBirth);
		addPatient(newPatient);
	}

	public void addPatient(Patient inPatient) {
		patients.add(inPatient);
	}

	public void addPatientData(String inUser, String inBloodPressure, double inBodyTemp, double inWeight, double inHeight, String inAllergens, String inHealth) {
		
		Patient patient;
		
		for(int i = 0; i < patients.size(); i++) {
			if(inUser.equals(patients.get(i).getUsername())) {
				patient = patients.get(i);
				
				patient.getBloodPressure().add(inBloodPressure);
				patient.getBodyTemp().add(inBodyTemp);
				patient.getWeight().add(inWeight);
				patient.getHeight().add(inHeight);
				patient.getAllergens().add(inAllergens);
				patient.getHealthConcerns().add(inHealth);
				
				break;
			}
		}
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}
}
