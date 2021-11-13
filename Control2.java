package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Control2 {
     @FXML
	 TextField userName;
     @FXML
     TextField newPass;
     @FXML
     TextField birthday;
     @FXML
     ChoiceBox<String> cBox;
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
     
    public  void changeChoiceBox(ArrayList<Patient> arrayList)  
    {
    	cBox.getItems().add(arrayList.get(0).getUsername());
    }

    public  void displayName(String userName)  
    {
    	this.userName.setText(userName);
    }
    
	public void register(ActionEvent event) throws IOException {
		   
		  String name = userName.getText();
		  String pass = newPass.getText();
		  String birth = birthday.getText();
		
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("Welcome.fxml"));
		   root = loader.load();
		   
		  Patient patient1 = new Patient(name, pass, birth, nurse1);
		  
		  Control3 scene3Controller = loader.getController();
		  scene3Controller.welcomeMessage(patient1.getUsername());
		  
		  
		   
		   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		   scene = new Scene(root);
		   stage.setScene(scene);
		   stage.show();
		   }
	 public void signUpfromDocNurse(ActionEvent event) throws IOException {
		   
		   
			
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
		   root = loader.load();
		  
		   
		   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		   scene = new Scene(root);
		   stage.setScene(scene);
		   stage.show();
		   }
		

}
