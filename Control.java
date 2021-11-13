package application;

import java.io.IOException;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
		   
		   Control2 scene2Controller = loader.getController();
		   scene2Controller.changeChoiceBox(nurse1.getPatients());
		   
		   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		   scene = new Scene(root);
		   stage.setScene(scene);
		   stage.show();
		}else {
				   FXMLLoader loader = new FXMLLoader(getClass().getResource("Patient.fxml"));
				   root = loader.load();
				   
//				   Control2 scene2Controller = loader.getController();
//				   scene2Controller.displayName(userN);
				   
				   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				   scene = new Scene(root);
				   stage.setScene(scene);
				   stage.show();
				   }
		}
   
   public void signUp(ActionEvent event) throws IOException {
	   
	   String name = userName.getText();
	
	   FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
	   root = loader.load();
	   
	   Control2 scene2Controller = loader.getController();
	   scene2Controller.displayName(name);
	   
	   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   scene = new Scene(root);
	   stage.setScene(scene);
	   stage.show();
	   }
}
  

