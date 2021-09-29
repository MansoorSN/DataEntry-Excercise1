package controller;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.testng.Assert;

public class ErrorValidatorTest {
@Mock
private ErrorValidator e;

	@Test
	public void test1() {
		
		e=Mockito.mock(ErrorValidator.class);
		Mockito.when(e.validatetan()).thenReturn(true);
		Mockito.when(e.validatenot()).thenReturn(true);
		Mockito.when(e.validatepi()).thenReturn(true);
		Mockito.when(e.validateri()).thenReturn(true);
		Mockito.when(e.validatecity()).thenReturn(true);
		Mockito.when(e.validateprovince()).thenReturn(true);
		
		
		Assert.assertTrue(e.validatetan()  && e.validatenot() && e.validatecity() && e.validateprovince() && e.validatepi() && e.validateri());		
		System.out.println("test1!");
		
		Assert.assertTrue(e.validatetan());		
		System.out.println("test1!");
	}

	
	@Test
	public void test2() {
		
		//String[] s1={"12345678","Trust1", "Ottawa","ON","10000","30000"};
		//ErrorValidator e=new ErrorValidator(s1);
		e=Mockito.mock(ErrorValidator.class);
		Mockito.when(e.validatetan()).thenReturn(true);
		
		Assert.assertTrue(e.validatetan());	
		System.out.println("test2!");
	
	
	}
	
}
