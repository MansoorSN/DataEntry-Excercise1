package e1;

import java.util.Hashtable;

public class DataStorage 
{

	static Hashtable<String, String[]> hdata=new Hashtable<String, String[]>();
	public void storedata(String[] data)
	{
		hdata.put(data[0], data);
	}	
}





	

