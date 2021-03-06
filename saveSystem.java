//package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class saveSystem
{
	public saveSystem()
	{
		//initialize class for accessing methods, no parameters to initialize
	}
	public void saveFile(Object saveDoctor)
	{
		try
		{
			FileOutputStream outFile = new FileOutputStream(new File("save_file.txt"));
			ObjectOutputStream outStream = new ObjectOutputStream(outFile);
			outStream.writeObject(saveDoctor);
			outStream.close();
			System.out.println("The Object was succesfully written to a file. ");
        }
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		catch (IOException e)
		{
			System.out.println("Error initializing stream");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
        }
	}

	public Doctor loadFile()
	{
		try
		{
			FileInputStream inFile = new FileInputStream("save_file.txt");
			ObjectInputStream inStream = new ObjectInputStream(inFile);
			Object obj = inStream.readObject();
			Doctor docBoi = (Doctor) obj;
			System.out.println("The Object has been read from the file");
			inStream.close();
			return docBoi;
	    }
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
			return null;
		}
		catch (IOException | ClassNotFoundException ex) {
			System.out.println("Class not found exception maybe");
		    ex.printStackTrace();
		    return null;
		}
		//catch (IOException e)
		//{
		//	System.out.println("Error initializing stream");
		//	return null;
		//}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

}
