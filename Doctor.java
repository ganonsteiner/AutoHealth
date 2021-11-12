package application;
import java.io.Serializable;
import java.util.ArrayList;

public class Doctor implements Serializable
{
	private static final long serialVersionUID = 1L;

	private ArrayList<Nurse> nNurses;
	private String docName;

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
				nNurses.get(i).addPatient(new Patient(inUser, inPassword, inBirthday));
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
			for(int j = 0; j < nNurses.get(i).nPatients.size(); j++)
			{
				Patient pat = nNurses.get(i).nPatients.get(j);
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
			for(int j = 0; j < nNurses.get(i).nPatients.size(); j++)
			{
				Patient pat = nNurses.get(i).nPatients.get(j);
				if(pat.getUsername().equals(inUser))
				{
					pat.setPrescription(inPrescription);
				}
			}
		}
	}

	public void sendPrescription(String inUser)
	{
		System.out.println("Prescirption has been sent!");
	}

	public String getName()
	{
		return docName;
	}

	public ArrayList<Nurse> getNurses()
	{
		return nNurses;
	}
}
