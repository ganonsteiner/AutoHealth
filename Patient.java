package application;
import java.util.*;
import java.io.Serializable;

public class Patient extends User implements Serializable{

	private static final long serialVersionUID = 1L;

	private ArrayList<String> bloodPressure;
	private ArrayList<Double> bodyTemp;
	private ArrayList<Double> weight;
	private ArrayList<Double> height;
	private String birthday;
	private String pharmacy;
	private String insurance;
	private String phoneNumber;
	private String emailAddress;
	private ArrayList<String> allergens;
	private ArrayList<String> healthConcerns;
	private ArrayList<String> physicals;
	int age;

	private Doctor myDoctor;
	private Nurse myNurse;

	Patient(String username, String password, String inBirth, Nurse inNurse) {

		super(username, password);
		birthday = inBirth;
		myNurse = inNurse;
		myDoctor = inNurse.getDoctor();
		

		bloodPressure = new ArrayList<>();
		bodyTemp = new ArrayList<>();
		weight = new ArrayList<>();
		height = new ArrayList<>();
		allergens = new ArrayList<>();
		healthConcerns = new ArrayList<>();
		physicals = new ArrayList<>();
		inNurse.addPatient(this);
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
		allergens.add(inPatientAllergens);
	}

	public void addHealth(String inHealth) {
		healthConcerns.add(inHealth);
	}

	public void setAge(int inAge) {
		age = inAge;
	}
	public void setPharmacy(String inPharm) {
		pharmacy = inPharm;
	}
	
	public String getPharmacy() {
		return pharmacy;
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

	public ArrayList<Double> getBodyTemp() {
		return bodyTemp;
	}

	public ArrayList<Double> getWeight() {
		return weight;
	}

	public ArrayList<Double> getHeight(){
		return height;
	}

	public void message(String username, Message message)
	{

		this.messageHistory.add(message);

		if(username.equals(myDoctor.getUsername()))
		{
			myDoctor.getMessageHistory().add(message);
		}
		else if(username.equals(myNurse.getUsername()))
		{
			myNurse.getMessageHistory().add(message);
		}
		else
		{
			throw new IllegalStateException("Invalid recipent");
		}
	}
}
