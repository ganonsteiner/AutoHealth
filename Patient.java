package application;
import java.util.*;

public class Patient extends User {
	ArrayList<String> bloodPressure;
	ArrayList<double> bodyTemp;
	ArrayList<double> weight;
	ArrayList<double> height;
	String birthday;
	String insurance;
	String phoneNumber;
	String emailAddress;
	ArrayList<String> allergens;
	ArrayList<String> healthConcerns;
	ArrayList<String> physicals;
	int age;
	
	Doctor myDoctor;
	Nurse myNurse;
	
	public Patient(String inUser, String inPass, String inBirth ) {
		if(inUser !=null && inPass != null && inBirth != null)	{
			userName = inUser;
			password = inPass;
			birthday = inBirth;
		
	}else {
		throw new IllegalStateException("You need a user name, password, and birthday");}
	}
	
	public void setInsurance(String inInsurance) {
		insurance = inInsurance;
	}
	
	public void setPhoneNumber(String inPhone) {
		phoneNumber = inPhone;
	}
	
	public void setEmail(String inEmail) {
		emailAddress = inEmail;
	}
	
	public void addAllergens(String inPatientAllergens) {
		allergens=inPatientAllergens;
	}
	
	public void addHealth(String inHealth) {
		healthConcerns = inHealth;
	}
	
	public void setAge(int inAge) {
		age = inAge;
	}
	
	public void addPhysicals(String inPhys) {
		physicals.add(inPhys);
	}
	
	public void setVitals(String inBloodPressure, double inBodyTemp, double inWeight, double inHeight) {
		bloodPressure.add(inBloodPressure);
		bodyTemp.add(inBodyTemp);
		weight.add(inWeight);
		height.add(inHeight);
	}
	
	public String getInsurance() {
		return insurance;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return emailAddress;
	}
	
	public ArrayList<String> getAllergens() {
		return allergens;
	}
	
	public ArrayList<String> getHealthConcerns() {
		return healthConcerns;
	}
	
	public ArrayList<String> getPhysicals() {
		return physicals;
	}
	
	public int getAge() {
		return age;
	}
	
	public ArrayList<String> getBloodPressure() {
		return bloodPressure;
	}
	
	public ArrayList<double> getBodyTemp() {
		return bodyTemp;
	}
	
	public ArrayList<double> getWeight() {
		return weight;
	}
	
	public ArrayList<double> getHeight(){
		return height;
	}
	
	public void message(String username, Message message) {
		if(username.equals(myDoctor.username)) {
			
		} else if(username.equals(myNurse.username)) {
			
		} else {
			
		}
	}
}
