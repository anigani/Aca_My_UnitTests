package aca;

public class App {
	public String concatenate(String one, String two) {
		if(one == null) return two;
		if(two == null) return one;
		
		return one + two;
	}

	public String amethod(String a, Integer b) throws NullPointerException, NumberFormatException {
		int i = Integer.parseInt(a);
		Integer c = b + (Integer)i;
		String d = c.toString();;
		return d;
	}
	
	public int div(int a, int b) {
		if(b==0) {
			return 0;
		}
		return a/b;
	}
}
