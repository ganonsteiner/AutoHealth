package application;
import java.util.*;

public class Patient extends User {
	String bloodPressure;
	double bodyTemp;
	double weight;
	double height;
	String birthday;
	String insurance;
	String phoneNumber;
	String emailAddress;
	String allergens;
	String healthConcerns;
	String physicals;
	int age;
	
	public Patient(String inUser, String inPass, String inBirth ) {
		if(inUser !=null || inPass != null || inBirth != null)	{
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
		physicals = inPhys;
	}
	
	public void setVitals(String inBloodPressure, double inBodyTemp, double inWeight, double inHeight) {
		bloodPressure = inBloodPressure;
		bodyTemp = inBodyTemp;
		weight = inWeight;
		height = inHeight;
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
	
	public String getAllergens() {
		return allergens;
	}
	
	public String getHealthConcerns() {
		return healthConcerns;
	}
	
	public String getPhysicals() {
		return physicals;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getBloodPressure() {
		return bloodPressure;
	}
	
	public double getBodyTemp() {
		return bodyTemp;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public double getHeight(){
		return height;
	}
	
	
	
}
