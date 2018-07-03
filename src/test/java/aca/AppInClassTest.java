package aca;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppInClassTest 
    extends TestCase
{
	String arg0, arg1, arg2, arg3;
	int result;
	AppInClass app = new AppInClass();

	public void setUp(){
		arg0 = "20";
		arg1 = "30";
		arg2 = "25a";
		result = 50;
		arg3 = "2147483649";
	}
	
	public void testMethodToTest() {
		
		int res = app.methodToTest(arg0, arg1);
		assertTrue("Method did not calculate correctly", res==result);
	}
	
	public void testMethodToTestWithExceptions(){
		boolean  bool = false;
		
		try{
			app.methodToTest(arg0, arg2);
		}
		catch(NumberFormatException ex){
			bool = true;
		}
		assertTrue(bool);
	}
	
	public void testMethodToTestWithNullParams(){
		boolean bool = false;
		try {
		app.methodToTest(arg0,  null);
		} 
		catch(NumberFormatException ex) {
			bool = true;
		}
		assertTrue(bool);
	}
	
	public void testMethodToTestWithMaxIntParams(){
		boolean bool = false;
		try {
		app.methodToTest(arg3,  "1");
		}
		catch (NumberFormatException ex)
		{
			bool = true;
		}
		assertTrue(bool);
	}
	
}
