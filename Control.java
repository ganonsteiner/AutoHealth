package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
	Label welcome;
	@FXML
	Label invalid;
	@FXML
	ChoiceBox<String> cBox;
    TextField newUser;
	
	 // nurse text fields for input for vitals/healthconcerns/allergens
    	/*@FXML
    	TextField weight;
    	@FXML
    	TextField height;
    	@FXML
    	TextField bodyTemp;
    	@FXML
   	TextField bloodPress;
   	@FXML 
    	TextField ptUserName;
    	@FXML 
    	TextField healthConcerns;
    	@FXML 
    	TextField allergens;
    
    	// nurse text fields for input for messages
    	@FXML
    	TextField nurseMessRec;
    	@FXML
    	TextField nurseMessSub;
    	@FXML
    	TextField nurseMessText; */
    
	public Stage stage;
	private Parent root;
	private Scene scene;
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
  
   public void login(ActionEvent event) throws IOException {
	   String pass = passWord.getText();
	   String userN = userName.getText();
	   doctor1 = system.loadFile();
	   
	   
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
					
					   /*double newWeight = Double.parseDouble(weight.getText());
					   double newHeight = Double.parseDouble(height.getText());
					   double newBodyTemp = Double.parseDouble(bodyTemp.getText()); 
					   String newBloodPress = bloodPress.getText();
					   String ptName = ptUserName.getText();
					   String allergies = allergens.getText();
					   String healthCon = healthConcerns.getText();
					   
					   tempNurse.addPatientData(ptName, newBloodPress, newBodyTemp, newWeight, newHeight, allergies, healthCon);*/
				}
				
				for(int j = 0; j < tempNurse.getPatients().size(); j++) {
					
					Patient tempPatient = tempNurse.getPatients().get(j);
					
					if(tempPatient.getUsername().equals(userN) && tempPatient.getPassword().equals(pass)) {
						currentUser = tempPatient;

						   FXMLLoader loader = new FXMLLoader(getClass().getResource("Patient.fxml"));
						   root = loader.load();
						   
//						   Control2 scene2Controller = loader.getController();
//						   scene2Controller.displayName(userN);
						   
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
  
