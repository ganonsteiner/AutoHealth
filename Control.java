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
	TextField userName;
    TextField password;
	public Stage stage;
	private Parent root;
	private Scene scene;
  
   public void login(ActionEvent event) throws IOException {
	   
	   String userN = userName.getText();
	   
	   if(userN.equalsIgnoreCase("doctor")) {
	   FXMLLoader loader = new FXMLLoader(getClass().getResource("doctor_screen_jfx.fxml"));
	   root = loader.load();
	   
//	   Control2 scene2Controller = loader.getController();
//	   scene2Controller.displayName(userN);
	   
	   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   scene = new Scene(root);
	   stage.setScene(scene);
	   stage.show();
	   }
	   else if(userN.equalsIgnoreCase("nurse")) {
		   FXMLLoader loader = new FXMLLoader(getClass().getResource("Nurse.fxml"));
		   root = loader.load();
		   
//		   Control2 scene2Controller = loader.getController();
//		   scene2Controller.displayName(userN);
		   
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
	  
	
	   FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
	   root = loader.load();
	   
	  
	   
	   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	   scene = new Scene(root);
	   stage.setScene(scene);
	   stage.show();
	   }
	}

