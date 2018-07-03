

package aca;

import org.junit.Test;

import junit.framework.Assert;

import static org.junit.Assert.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
    {
	
	App app = new App();
	
	
	
	@Test
	public void testDivZer() {
		Assert.assertEquals(app.div(2, 0), 0);
	}
	
	@Test
	public void testDiv() {
		Assert.assertEquals(app.div(2, 1), 2);
	}
	
	  @Test
	    public void testConcatenate() {
	        String result = app.concatenate("one", "two");
	        assertEquals("onetwo", result);

	    }
	  
	  @Test
	    public void testConcatenateWithNull() {
	        String result = app.concatenate(null, "two");
	        assertEquals("two", result);
	    }
	  
	  @Test
	  public void testAMethod(){
		 String result = app.amethod("10", 20);
		 assertEquals(result, "30");
	  }
	  
	  @Test
	  public void testAMethodWithNumberFormatException(){
		  boolean thrown = false;
		  try {
			   app.amethod(null, 20);
		  } catch (NumberFormatException e) {
		    thrown = true;
		  }
		  assertTrue(thrown);
	  }
	  @Test
	  public void testAMethodWithNullPointerException(){
		  boolean thrown = false;
		  try {
			   app.amethod("3", null);
		  } catch (NullPointerException e) {
		    thrown = true;
		  }
		  assertTrue(thrown);
	  }
}
