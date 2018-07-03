package aca;

import junit.framework.TestCase;

public class AppTestCase extends TestCase {

	protected int value1, value2;
	protected String value3, value4;
	App ap;

	// assigning the values
	protected void setUp() {
		value1 = 3;
		value2 = 3;
		value3 = "s";
		value4 = "d";
		ap = new App();
	}

	public void testAdd() {
		double result = value1 + value2;
		assertTrue(result == 6);
	}

	public void testConcatenate( String value3, String value4){

		String resultStr = ap.concatenate(value3, value4);
		assertTrue(resultStr.equals("sd"));
	}
}
