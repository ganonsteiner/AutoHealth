package application;
import java.io.Serializable;
import java.util.ArrayList;

public class Doctor extends User implements Serializable
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Nurse> nNurses;
	private String docName;
	private String currUser;

	public Doctor(String username, String password, String inName)
	{
		super(username, password);
		docName = inName;
		nNurses = new ArrayList<Nurse>();
	}

	public void createPatientAccount(String inUser, String inPassword, String inBirthday, String inNurse)
	{
		for(int i = 0; i < nNurses.size(); i++)
		{
			if(nNurses.get(i).getUsername().equals(inNurse))
			{
				nNurses.get(i).addPatient(new Patient(inUser, inPassword, inBirthday, nNurses.get(i)));
			}
		}
	}

	public void addNurse(Nurse in_nurse)
	{
		nNurses.add(in_nurse);
	}

	public void addPatientPhysical(String inUser, String inPhysical)
	{
		for(int i = 0; i < nNurses.size(); i++)
		{
			for(int j = 0; j < nNurses.get(i).patients.size(); j++)
			{
				Patient pat = nNurses.get(i).patients.get(j);
				if(pat.getUsername().equals(inUser))
				{
					pat.addPhysicals(inPhysical);
				}
			}
		}
	}

	public void setPrescription(String inUser, String inPrescription)
	{
		for(int i = 0; i < nNurses.size(); i++)
		{
			for(int j = 0; j < nNurses.get(i).patients.size(); j++)
			{
				Patient pat = nNurses.get(i).patients.get(j);
				if(pat.getUsername().equals(inUser))
				{
					//pat.setPrescription(inPrescription);
				}
			}
		}
	}

	public void setCurrUser(String inCurrUser)
	{
		currUser = inCurrUser;
	}

	public void sendPrescription(String inUser)
	{
		System.out.println("Prescirption has been sent!");
	}

	public String getName()
	{
		return docName;
	}

	public String getCurrUser()
	{
		return currUser;
	}

	public ArrayList<Nurse> getNurses()
	{
		return nNurses;
	}

	public ArrayList<Message> getMessageHistory()
	{
		return super.getMessageHistory();
	}

	public Patient getPatientFromDoc(String inName)
	{
		Patient foundPatient = null;
		for(int i = 0; i < nNurses.size(); i ++)
		{
			for(int j = 0; j < nNurses.get(i).patients.size(); j++)
			{
				if(nNurses.get(i).patients.get(j).getUsername().equals(inName))
				{
					foundPatient = nNurses.get(i).patients.get(j);
					break;
				}
			}
			if(foundPatient != null)
			{
				break;
			}
		}
		return foundPatient;
	}
}
