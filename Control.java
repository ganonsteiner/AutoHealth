package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class Control {
	@FXML
	PasswordField passWord;
	@FXML
	TextField userName;
	@FXML
	PasswordField nPass;
	@FXML
	TextField currPass;
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
	
	// nurse text fields for input for vitals/healthconcerns/allergens
	@FXML
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
	TextArea healthConcerns;
	@FXML 
	TextArea pPresc;
	@FXML 
	TextArea presc;
	@FXML 
	TextField allergens;

	// nurse text fields for input for messages
	@FXML
	TextField nurseMessRec;
	@FXML
	TextField nurseMessSub;
	@FXML
	TextArea nurseMessText;
	
	@FXML
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
	
	// alex update
	@FXML
	TextArea patInput;
	@FXML
	TextArea physReadDoc;
	@FXML
	TextArea prescInput;
	@FXML
	TextArea physicalInput;

	public void setPhysicalFromDoc(ActionEvent event) throws IOException {
		String nPhys = physicalInput.getText();
		String nPat = patInput.getText();
		doctor1 = system.loadFile();

		doctor1.addPatientPhysical(nPat, nPhys);
		system.saveFile(doctor1);

		updatePhysicalDescrDoc(doctor1.getPatientFromDoc(nPat).getPhysicals());

		FXMLLoader loader = new FXMLLoader(getClass().getResource("doctor_screen_jfx.fxml"));
		root = loader.load();

	}
	public void updatePhysicalDescrDoc(ArrayList<String> inPhys) {
		String prString = "";
		for(int i = 0; i < inPhys.size(); i++)
		{
			prString += inPhys.get(i) + "\n";
		}
		physReadDoc.setText(prString);
	}
	// alex update
	
	public void register(ActionEvent event) throws IOException {
		
		  String name = userName.getText();
		  String pass = nPass.getText();
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
				   system.saveFile(doctor1);
				   
				  displayInfo(nEmail, nInsurance,  nPharm);
				   
				}
			}
		}
	}
			
	public void showPassword(ActionEvent event) throws IOException	{
		String myPass = nPass.getText();
		currPass.setText(myPass);
	}
	
	public void hidePassword(ActionEvent event) throws IOException	{
		currPass.setText(" ");
	}
			
  
   public void login(ActionEvent event) throws IOException {
	   String pass = passWord.getText();
	   userN = userName.getText();
	   if(system.loadFile() == null)
       {

       }
       else
       {
           doctor1 = system.loadFile();
       }
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

           for (int i = 0; i < doctor1.getNurses().size(); i++) {

               tempNurse = doctor1.getNurses().get(i);
               if (tempNurse.getUsername().equals(userN) && tempNurse.getPassword().equals(pass)) {
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("Nurse.fxml"));
                   root = loader.load();

                   Control scene2Controller = loader.getController();
                   scene2Controller.changeChoiceBox(tempNurse);

                   stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                   scene = new Scene(root);
                   stage.setScene(scene);
                   stage.show();
               }

               for (int j = 0; j < tempNurse.getPatients().size(); j++) {

                   Patient tempPatient = tempNurse.getPatients().get(j);

                   if (tempPatient.getUsername().equals(userN) && tempPatient.getPassword().equals(pass)) {
                       currentUser = tempPatient;

                       FXMLLoader loader = new FXMLLoader(getClass().getResource("Patient.fxml"));
                       root = loader.load();

                       Control scenePatController = loader.getController();

                       int lastIndex = currentUser.getHeight().size() - 1;

                       String currentMedHistory = "";
                       String currentPhyTest = "";
                       String currentHealthConcern = "";

                       if (lastIndex >= 0) {
                           currentMedHistory = "Height: " + currentUser.getHeight().get(lastIndex) + "\n\tWeight: "
                                   + currentUser.getWeight().get(lastIndex) + "\n\tBlood Pressure: "
                                   + currentUser.getBloodPressure().get(lastIndex) + "\n\tBody Temperature: "
                                   + currentUser.getBodyTemp().get(lastIndex) + "\n\tAllergens: "
                                   + currentUser.getAllergens().get(lastIndex) + "\n";
                           currentHealthConcern = "Health Concerns: " + currentUser.getHealthConcerns().get(lastIndex)
                                   + "\n";
                           ;
                       }

                       if (currentUser.getPhysicals().size() > 0) {
                           currentPhyTest = "Physical: "
                                   + currentUser.getPhysicals().get(currentUser.getPhysicals().size() - 1) + "\n";
                       }

                       scenePatController.displayFrontpage(currentMedHistory, currentPhyTest, currentHealthConcern,
                               doctor1.getCurrUser());

                       String medHistory = "";
                       String phyTest = "";
                       String healthConcerns = "";

                       for (int k = 0; k < currentUser.getHeight().size(); k++) {
                           medHistory += "Visit " + (k + 1) + "\n\tHeight: " + currentUser.getHeight().get(k)
                                   + "\n\tWeight: " + currentUser.getWeight().get(k) + "\n\tBlood Pressure: "
                                   + currentUser.getBloodPressure().get(k) + "\n\tBody Temperature: "
                                   + currentUser.getBodyTemp().get(k) + "\n\tAllergens: "
                                   + currentUser.getAllergens().get(k) + "\n";
                           healthConcerns += "Visit " + (k + 1) + ":" + "\n\tHealth Concerns: "
                                   + currentUser.getHealthConcerns().get(k) + "\n";
                       }

                       for (int l = 0; l < currentUser.getPhysicals().size(); l++) {
                           phyTest += "Visit " + (l + 1) + ":" + "\n\tPhysical: " + currentUser.getPhysicals().get(l)
                                   + "\n";
                       }

                       scenePatController.displayDates(medHistory, phyTest, healthConcerns, doctor1.getCurrUser());

                       scenePatController.displayInfo(tempPatient.getEmail(), tempPatient.getInsurance(),
                               tempPatient.getPharmacy());

                       stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                       scene = new Scene(root);
                       stage.setScene(scene);
                       stage.show();

                   } else {
                       invalid.setText("Invalid username/password combo");
                   }

               }

           }
       }
  }
   
public void sendMessage(ActionEvent event) throws IOException {
		
		doctor1 = system.loadFile();
		Nurse tempNurse;
		
		String sender = doctor1.getCurrUser();
	
		String reciever = recipient.getText();
		String subject = nSubject.getText();
		String body = nBody.getText();
		
		Message message = new Message(body, subject, sender, reciever);
		
		if(sender.equals(doctor1.getUsername())) {
			
			doctor1.message(reciever, message);
			
		} else {
			for (int i = 0; i < doctor1.getNurses().size(); i++) {
				tempNurse = doctor1.getNurses().get(i);
				
				if(sender.equals(tempNurse.getUsername())) {
					tempNurse.message(reciever, message);
				}
				
				for (int j = 0; j < tempNurse.getPatients().size(); j++) {
					
					Patient tempPatient = tempNurse.getPatients().get(j);
					
					if (sender.equals(tempPatient.getUsername())) {
						tempPatient.message(reciever, message);
					}
				}
			}
		}
	}	
	
   public void displayFrontpage(String currMedHistory,String Physicals,String healthCon, String user) {
	   pMed.setText(currMedHistory);
	   pPhys.setText(Physicals);
	   pDia.setText(healthCon);
	   realName.setText(user);
   }   
   public void displayDates(String medHistory,String  pastPhys,String pastHealthCon, String user) {
	   date1.setText(medHistory);
	   date2.setText(pastPhys);
	   date3.setText(pastHealthCon);
	   realName.setText(user);
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


public void nurseSetInfo(ActionEvent event) throws IOException {
		
		Nurse tempNurse;
		doctor1 = system.loadFile();
		
		String newWeight = weight.getText();
		String newHeight = height.getText();
		String newBodyTemp = bodyTemp.getText(); 
		String newBloodPress = bloodPress.getText();
		String ptName = ptUserName.getText();
		String allergies = allergens.getText();
		String healthCon = healthConcerns.getText();
		
		for(int i = 0; i < doctor1.getNurses().size(); i++) {
			tempNurse = doctor1.getNurses().get(i);
			for(int j = 0; j < tempNurse.getPatients().size(); j++) {
				Patient tempPatient = tempNurse.getPatients().get(j);
				if(tempPatient.getUsername().equals(ptName)) {
				   tempPatient.setBloodPressure(newBloodPress);
				   tempPatient.setBodyTemp(newBodyTemp);
				   tempPatient.setWeight(newWeight);
				   tempPatient.setHeight(newHeight);
				   tempPatient.setAllergies(allergies);
				   tempPatient.setHealthCon(healthCon);
				   System.out.println("saved");
				   system.saveFile(doctor1);
				   FXMLLoader loader = new FXMLLoader(getClass().getResource("Nurse.fxml"));
				   root = loader.load();
				  
				   
				   stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				   scene = new Scene(root);
				   stage.setScene(scene);
				   stage.show();
				  
			}
		}
	}
  }
}
  



