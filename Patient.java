package application;
import java.util.*;
import java.io.Serializable;

public class Patient extends User implements Serializable{

	private static final long serialVersionUID = 1L;

	private ArrayList<String> bloodPressure;
	private ArrayList<String> bodyTemp;
	private ArrayList<String> weight;
	private ArrayList<String> height;
	private String birthday;
	private String pharmacy;
	private String insurance;
	private String phoneNumber;
	private String emailAddress;
	private ArrayList<String> allergens;
	private ArrayList<String> healthConcerns;
	private ArrayList<String> physicals;
	private ArrayList<String> prescriptions;
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

	public void setBloodPressure(String inBloodPressure) {
		bloodPressure.add(inBloodPressure);
	}
	
	public void setBodyTemp(String inBodyTemp) {
		bodyTemp.add(inBodyTemp);
	}
	
	public void setWeight(String inWeight) {
		weight.add(inWeight);
	}
	public void setHeight(String inHeight) {
		height.add(inHeight);
	}
	
	public void setHealthCon(String healthCon) {
		healthConcerns.add(healthCon);
	}
	
	public void setAllergies(String allergy) {
		allergens.add(allergy);
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

	public ArrayList<String> getBodyTemp() {
		return bodyTemp;
	}

	public ArrayList<String> getWeight() {
		return weight;
	}

	public ArrayList<String> getHeight(){
		return height;
	}
	
	public void addPrescription(String inPresc)
	{
		prescriptions.add(inPresc);
	}

	public ArrayList<String> getPrescriptions()
	{
		return prescriptions;
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
