import java.util.ArrayList;

public class User {

	protected String username;
	protected String password;
	protected ArrayList<Message> messageHistory;
	
	// Generic constructor to be inherited by Doctor, Nurse, and Patient
	User(String username, String password) {
		this.username = username;
		this.password = password;
		this.messageHistory = new ArrayList<>();
	}
	
	// Login method to be used by Doctor, Nurse, and Patinet
	public boolean login(String inputUser, String inputPass) {
		if(this.username.equals(inputUser) && this.password.equals(inputPass)) {
			return true;
		} else {
			return false;
		}
	}
	
	// Getters for generic user attributes
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public ArrayList<Message> getMessageHistory() {
		return this.messageHistory;
	}
}