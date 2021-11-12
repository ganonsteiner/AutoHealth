package application;

import java.io.Serializable;
import java.util.*;


public class Nurse extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nurseName;
	Doctor nurseDoctor;
	
	protected ArrayList<Patient> nPatients;
	
	//add nurse constructor that will add a new nurse to the arraylist in the doctor class
	public Nurse (String username, String password, String name, Doctor doc) {
		super(username, password);
		nurseName = name;
		nPatients = new ArrayList<Patient>();
		nurseDoctor = doc;	
	}
	
	public void message (String userName, Message newMessage) {
		
		Message newMessage = new Message(text, insubject, inSender, inRec);
		boolean foundUser = false; 
		
		for(int i = 0; i < nPatients.size(); i++) {
			Patient pt = nPatients.get(i);
			if(pt.getUsername().equals(recipientUserName)) {
				foundUser = true;
				message
			}
		}
		
		
		
	}
	
	// add nurse constructor for 
	
	public void createPatientAccount(String userName, String password, String inBirth, Doctor doc, Nurse ptNurse) {
		Patient newPatient = new Patient(userName, password, inBirth);
		addPatient(newPatient);
	}
	
	public void addPatient(Patient inPatient) {
		nPatients.add(inPatient);
	}
	
	public void addPatientData(String inUser, String inBloodPressure, double inBodyTemperature, String inWeight, double inHeight, String inAllergens, String inHealth) {
		
		// my nurse, my doctor 
		//patient.mynurse = patient object
		for(int i = 0; i < nPatients.size(); i++) {
			if()
			
		}
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
	
}
