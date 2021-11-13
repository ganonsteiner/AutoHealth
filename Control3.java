package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Control3 {
	@FXML
	Label welcome;
	 public Stage stage;
 	 private Parent root;
 	 private Scene scene;
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
