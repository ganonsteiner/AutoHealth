
package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Control {
	@FXML
	TextField passWord;
	@FXML
	TextField userName;
	@FXML
	TextField newPass;
	@FXML 
	TextField birthday;
	@FXML 
	TextField newEmail;
	@FXML 
	TextField newInsurance;
	@FXML
	TextField newPharmacy;
	@FXML 
	TextArea contact;
	@FXML 
	TextArea insurance;
	@FXML 
	TextArea pharmacy;
	@FXML 
	TextArea pMed;
	@FXML 
	TextArea pPhys;
	@FXML 
	TextArea pDia;
	@FXML
	Label welcome;
	@FXML 
	TextArea date1;
	@FXML 
	TextArea date2;
	@FXML 
	TextArea date3;
	@FXML
	Label invalid;
	@FXML
	Label realName;
	@FXML
	ChoiceBox<String> cBox;
    TextField newUser;
    
    
	public Stage stage;
	private Parent root;
	private Scene scene;
	String userN = "notworking";
	private String doctorUser = "tbiggums123";
	private String doctorPass = "Tbiggums";
	private String doctorName = "Tyrone Biggums";
	private String nurseName = "Jamal Biggums";
	private String nursePass = "Jbiggums";
	private String nurseUser = "jbiggums123";
	private Doctor doctor1 = new Doctor(doctorUser, doctorPass, doctorName );
	private Nurse nurse1 = new Nurse(nurseUser, nursePass, nurseName, doctor1);
	saveSystem system = new saveSystem();
	Patient patient1;
	
	public void register(ActionEvent event) throws IOException {
		
		  String name = userName.getText();
		  String pass = newPass.getText();
		  String birth = birthday.getText();
		
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
		   root = loader.load();
		   
		 patient1 = new Patient(name, pass, birth, nurse1);
		 system.saveFile(doctor1);
		  Control scene3Controller = loader.getController();
		  scene3Controller.welcomeMessage(patient1.getUsername());
		  
		  
		   
		   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		   scene = new Scene(root);
		   stage.setScene(scene);
		   stage.show();
		}
	
	public  void changeChoiceBox(Nurse  nurse1)  
    {
    	for(int i = 0; i < nurse1.getPatients().size(); i++) {
    		cBox.setValue(nurse1.getPatients().get(i).getUsername());
    	}
    }
	
	public void displayInfo(String email, String insur, String pharm) {
		contact.setText(email);
		insurance.setText(insur);
		pharmacy.setText(pharm);
		
	}
	
	public void setinfo(ActionEvent event) throws IOException {
		String nEmail = newEmail.getText();
		String nInsurance = newInsurance.getText();
		String nPharm = newPharmacy.getText();
		Nurse tempNurse;
		doctor1 = system.loadFile();
		
		
		for(int i = 0; i < doctor1.getNurses().size(); i++) {
			tempNurse = doctor1.getNurses().get(i);
			for(int j = 0; j < tempNurse.getPatients().size(); j++) {
				Patient tempPatient = tempNurse.getPatients().get(j);
				if(tempPatient.getUsername().equals(doctor1.getCurrUser())) {
				   tempPatient.setEmail(nEmail);
				   tempPatient.setInsurance(nInsurance);
				   tempPatient.setPharmacy(nPharm);
				   
				   FXMLLoader loader = new FXMLLoader(getClass().getResource("Patient.fxml"));
				   root = loader.load();
				   
				   Control scene2Controller = loader.getController();
				   scene2Controller.displayInfo(tempPatient.getEmail(), tempPatient.getInsurance(), tempPatient.getPharmacy());
				   scene2Controller.displayFrontpage("yes", "no", "ok", doctor1.getCurrUser());
				   scene2Controller.displayDates("date1","date2","date3");
				   
				   
				   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				   scene = new Scene(root);
				   stage.setScene(scene);
				   stage.show();
				}
			}
		}
	}
			
		
			
  
   public void login(ActionEvent event) throws IOException {
	   String pass = passWord.getText();
	   userN = userName.getText();
	   doctor1 = system.loadFile();
	   doctor1.setCurrUser(userN);
	   system.saveFile(doctor1);
	   
	   
	   if(userN.equalsIgnoreCase(doctorUser) && pass.equals(doctorPass)) {
	   FXMLLoader loader = new FXMLLoader(getClass().getResource("doctor_screen_jfx.fxml"));
	   root = loader.load();
	   
//	   Control2 scene2Controller = loader.getController();
//	   scene2Controller.displayName(userN);
	   
	   
	   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   scene = new Scene(root);
	   stage.setScene(scene);
	   stage.show();
	   }else {
			Patient currentUser;
			Nurse tempNurse;
			
			
			for(int i = 0; i < doctor1.getNurses().size(); i++) {
				
				tempNurse = doctor1.getNurses().get(i);
				if(tempNurse.getUsername().equals(userN) && tempNurse.getPassword().equals(pass)) {
					  FXMLLoader loader = new FXMLLoader(getClass().getResource("Nurse.fxml"));
					   root = loader.load();
					   
					   Control scene2Controller = loader.getController();
					   scene2Controller.changeChoiceBox(tempNurse);
					   
					   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					   scene = new Scene(root);
					   stage.setScene(scene);
					   stage.show();
				}
				
				for(int j = 0; j < tempNurse.getPatients().size(); j++) {
					
					Patient tempPatient = tempNurse.getPatients().get(j);
					
					if(tempPatient.getUsername().equals(userN) && tempPatient.getPassword().equals(pass)) {
						currentUser = tempPatient;

						   FXMLLoader loader = new FXMLLoader(getClass().getResource("Patient.fxml"));
						   root = loader.load();
						   
						   Control scenePatController = loader.getController();
						   scenePatController.displayFrontpage("yes", "no", "ok", userN);
						   scenePatController.displayDates("date1","date2","date3");
						   
						   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
						   scene = new Scene(root);
						   stage.setScene(scene);
						   stage.show();
						   
					}else {
						invalid.setText("Invalid username/password combo");
					}
					
		}
			
			
				   }
		}
   }
   
   public void displayFrontpage(String one, String two, String three, String user) {
	   pMed.setText(one);
	   pDia.setText(three);
	   pPhys.setText(two);
	   realName.setText(user);
   }   
   public void displayDates(String one, String two, String three) {
	   date1.setText(one);
	   date2.setText(two);
	   date3.setText(three);
   }
   
   public void signUp(ActionEvent event) throws IOException {
	   
	   String name = userName.getText();
	
	   FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
	   root = loader.load();
	   
	   Control scene2Controller = loader.getController();
	   scene2Controller.displayName(name);
	   
	   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   scene = new Scene(root);
	   stage.setScene(scene);
	   stage.show();
	   }

	   public  void displayName(String userName)  
	    {
	    	this.userName.setText(userName);
	    }
		 public void signUpfromDocNurse(ActionEvent event) throws IOException {
			   
			   
				
			   FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
			   root = loader.load();
			  
			   
			   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			   scene = new Scene(root);
			   stage.setScene(scene);
			   stage.show();
			   }
		 public  void welcomeMessage(String username) 
		 {
		    		welcome.setText("Welcome to AutoHealth Inc: " + username);	
		 }
	 
	  public void backToLogin(ActionEvent event) throws IOException {
		  
		
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		   root = loader.load();
		   

		   
		   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		   scene = new Scene(root);
		   stage.setScene(scene);
		   stage.show();
		   }
}
  
