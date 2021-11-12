
public class test {
	String enteredUser;
	Doctor doctor1;
	Patient currentUser;
	Nurse tempNurse;
	Patient tempPatient;
	
	for(int i = 0; i < doctor1.getNurses().size(); i++) {
		
		tempNurse = doctor1.getNurses().get(i);
		
		for(int j = 0; j < tempNurse.getPatients().size(); j++) {
			
			tempPatient = tempNurse.getPatients().get(j);
			
			if(tempPatient.getUsername().equals(enteredUser)) {
				currentUser = tempPatient;
			}
		}
	}
}
