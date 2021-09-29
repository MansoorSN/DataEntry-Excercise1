package controller;
import org.testng.annotations.Test;
import org.testng.Assert;
public class Test1 {

	String[] s0={"T12345678","Trust1", "Ottawa","ON","10000","30000"};
	ErrorValidator e=new ErrorValidator(s0);
	String[] s1={"T12345678","Trust1", "Ottawa","ON","-9999","30000"};
	ErrorValidator e1=new ErrorValidator(s1);
	MainFrame3 m=new MainFrame3();
	
	@Test
	public void test1()
	{	
		Assert.assertTrue(e.validatetan() && e.validatenot() && e.validatecity() && e.validateprovince() && e.validatepi() && e.validateri());		
		System.out.println("test1!");	
	}
	
@Test
public void test2() {	
	Assert.assertTrue(e.validatetan() && e.validatenot() && e.validatecity() && e.validateprovince() && e.validatepi() && e.validateri());
		System.out.println("test2");
	}

@Test
public void test3() {		
	Assert.assertFalse(e1.validatetan() && e1.validatenot() && e1.validatecity() && e1.validateprovince() && e1.validatepi() && e1.validateri(), "it was not false");
		System.out.println("test3");
	}

@Test
public void test4() {	
	Assert.assertTrue(e.validatepi());
		System.out.println("test4");
	}
}
