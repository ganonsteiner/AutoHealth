package application;

public class Messager {
	String bodyText;
	String subject;
	String sender;
	String receiver;
	
	public Messager(String text, String inSubject, String inSender, String inRec) {
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
