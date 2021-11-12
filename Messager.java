package application;

public class Message {
	String bodyText;
	String subject;
	String sender;
	String receiver;
	
	public Message(String text, String inSubject, String inSender, String inRec) {
		bodyText = text;
		subject = inSubject;
		sender = inSender;
		receiver = inRec;
	}
	
	public String getBodyText() {
		return bodyText;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getSender() {
		return sender;
	}
	
	public String getReceiver() {
		return receiver;
	}
}
