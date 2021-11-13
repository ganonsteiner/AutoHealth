package application;

import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    TextField newUser;
    
    
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
	
	
	public void register(ActionEvent event) throws IOException {
		   
		  String name = userName.getText();
		  String pass = newPass.getText();
		  String birth = birthday.getText();
		
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
		   root = loader.load();
		   
		  Patient patient1 = new Patient(name, pass, birth, nurse1);
		  System.out.print(nurse1.getPatients().get(0).getPassword());
		  Control scene3Controller = loader.getController();
		  scene3Controller.welcomeMessage(patient1.getUsername());
		  
		  
		   
		   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		   scene = new Scene(root);
		   stage.setScene(scene);
		   stage.show();
		}
  
   public void login(ActionEvent event) throws IOException {
	   String pass = passWord.getText();
	   String userN = userName.getText();
	   
	   
	   if(userN.equalsIgnoreCase(doctorUser) && pass.equals(doctorPass)) {
	   FXMLLoader loader = new FXMLLoader(getClass().getResource("doctor_screen_jfx.fxml"));
	   root = loader.load();
	   
//	   Control2 scene2Controller = loader.getController();
//	   scene2Controller.displayName(userN);
	   
	   
	   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   scene = new Scene(root);
	   stage.setScene(scene);
	   stage.show();
	   }
	   else if(userN.equalsIgnoreCase(nurseUser) && pass.equals(nursePass)) {
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("Nurse.fxml"));
		   root = loader.load();
		   
		   //Control2 scene2Controller = loader.getController();
		   //scene2Controller.changeChoiceBox(nurse1.getPatients());
		   
		   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		   scene = new Scene(root);
		   stage.setScene(scene);
		   stage.show();
		}else {
			Patient currentUser;
			Nurse tempNurse;
			
			for(int i = 0; i < doctor1.getNurses().size(); i++) {
				
				tempNurse = doctor1.getNurses().get(i);
				
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
  
