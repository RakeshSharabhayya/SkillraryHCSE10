package genaricLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	/**
	 * This class contains all reusabkle methods to perform operations on properties file
	 */
	
	private Properties property;
	
	
	/**
	 * This method is used to initialize proprties method
	 * 
	 * @param filePath
	 */
	
	
	
	public void propertiesInit(String filePath) {

	
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream(filePath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//This method is used to fetch data from properties file using key
	//@param key
	//@return
	
	
	public String readDataFromProperties(String key) {
		return property.getProperty(key);
	}

	/**
	 * This method is used to write data to properties file
	 * @param Key
	 * @param Value
	 * @param comments
	 * @param filepath
	 */
public void writeToPropertiesFile(Object Key, Object Value, String comments, String filepath)
{
property.put(Key, Value);
{
	
	FileOutputStream fos=null;
	try 
	{
		fos = new FileOutputStream(filepath);
	}
	catch (FileNotFoundException e)
	{
		
		e.printStackTrace();
	}
			try {
				property.store(fos,comments);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
}
}
}