package e1;

import java.util.Arrays;

import java.util.List;

public class ErrorValidator {

	private String tan;
	private String city;
	private String pi;
	private String ri;
	private String not1;
	private String province;
	
	private String[] valid_pcodes= {"NL","PE","NS","NB", "QC", "ON", "MB", "SK","AB","BC","YT","NT","NU"};
	private List<String> list= Arrays.asList(valid_pcodes);
	public ErrorValidator(String[] s) {
		
		this.tan=s[0];
		this.city=s[2];
		this.pi=s[4];
		this.ri=s[5];
		this.not1=s[1];
		this.province=s[3];
		
	}
	
	//is empty function
	public boolean isempty(String str) {
		
		return (str== null || str.trim().isEmpty());
	
	}
	
	//is an integer function
	public boolean isInteger(String str) {
		
		if(isempty(str)) {
			
			System.out.println("the field is either empty or null");
			
	return false;
		}
		
		try {
			
			int intvalue=Integer.parseInt(str);
			return true;
		}
		
		catch(NumberFormatException e) {
			System.out.println("Input String is not an Integer.(isInteger validation).");
			return false;
		}
		
		
	}
	
	//entered value is non negative
	public boolean isnonnegative(String str) {
		
		if (isInteger(str)) {
			int intvalue=Integer.parseInt(str);
			//System.out.println("the value is============"+intvalue);
			if (intvalue<0) {
				//System.out.println("the value entered is negative");
				return false;}
			return true;
		}
			return false;
		
	}
	
	//validate PI
	public boolean validatepi() {
		
		if(isnonnegative(pi)) {
			
			return true;
			
		}
		System.out.println("the PI value entered is negative or non integer");
		return false;
	}
	
	
	//Validate RI
public boolean validateri() {
		
		if(isnonnegative(ri)) {
			
			return true;
			
		}
		System.out.println("the RI value entered is negative or non integer");
		return false;
	}


//validate City
public boolean validatecity() {
	
	if(!isempty(city)) {
		
		return true;
	}
	
	System.out.println("the value in city text field is empty");
	return false;
}
	
//validate NOT
public boolean validatenot() {
	
	if(!isempty(not1)) {
		
		return true;
	}
	
	System.out.println("the value in Name of Trust NOT text field is empty");
	return false;
}


//validate TAN

public boolean validatetan() {
	if(isempty(tan)) {return false;}
	
	if(tan.length()==8 && isnonnegative(tan)) {
		return true;	}
	else if(tan.length()==9) {
		
		if((tan.charAt(0)=='T'||tan.charAt(0)=='t') && isnonnegative(tan.substring(1))) {
		
			return true;	}
	
		System.out.println("the tan entered is invalid. A tan number starts with T followed by 8 didgits.");
		return false;
		
}

	System.out.println("the tan entered is invalid. A tan number starts with T followed by 8 didgits. The tan number does not have any special characters.");
	return false;

}

//validate province

public boolean validateprovince() {
	
	if (list.contains(province.toUpperCase())){
		
		return true;
	}
	
	
	System.out.println("Please enter the correct provincial code");
	return false;
}


}
	
	
	
	

