package controller;

import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataStorage 
{

	private static final Logger logger = LogManager.getLogger(DataStorage.class);
	static Hashtable<String, String[]> hdata=new Hashtable<String, String[]>();
	public void storedata(String[] data)
	{
		hdata.put(data[0], data);
	}	
}





	

