package aca;

public class ConstructorSample {
	private int intParam = 0;
	private String stringParam;
	private int[] intArr = { 1, 2, 3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 ,11 ,12};

	public int[] getIntArr() {
		return intArr;
	}

	public void setIntArr(int[] intArr) {
		this.intArr = intArr;
	}

	public int getIntParam() {
		return intParam;
	}

	public void setIntParam(int intParam) {
		this.intParam = intParam;
	}

	public String getStringParam() {
		return stringParam;
	}

	public void setStringParam(String stringParam) {
		this.stringParam = stringParam;
	}

	public ConstructorSample() {
		System.out.println("This is equivalent to default constructor");
	}

	public ConstructorSample(int i) {
		setIntParam(i);
	}

	public ConstructorSample(String str) {
		setStringParam(str);
	}

	public ConstructorSample(int[] arr) {
		setIntArr(arr);
	}

	public ConstructorSample(String str, int i) {
		setStringParam(str);
		setIntParam(i);
	}

	public ConstructorSample(String str, int[] arr) {
		setStringParam(str);
		setIntArr(arr);

	}

	public ConstructorSample(String str, int[] arr, int i) {
		setStringParam(str);
		setIntArr(arr);
		setIntParam(i);
	}

	public int forLoopSample() {
		int ret = 0;
		for (int i = 0; i < getIntParam(); i++) {
			ret = ret + i;
		}
		return ret;
	}

	public int foreachSample() {
		int ret = 0;
		for (int i : getIntArr()) {
			ret = ret + i;
		}
		return ret;
	}

	public int whileDoSample() {

		int ret = 0;
		int i = getIntParam();
		while (i-- > 0) {
			ret = ret  +i;
		}

		return ret;
	}

	public int doWhileSample() {

		int ret=0;
		int i = getIntParam();
		do {
			ret = ret +i;
		} while (i-- > 0);

		return ret;
	}
	
	public static void main(String[] args) {
		int i = 10;
		String str = "barev";
		
		ConstructorSample sample1 = new ConstructorSample();
		sample1.setIntParam(i);
		sample1.setStringParam(str);
		
		System.out.println("doWhile result is " + sample1.doWhileSample());
		System.out.println("whileDo result is " + sample1.whileDoSample());
		System.out.println("forEach result is " + sample1.foreachSample());
		System.out.println("for result is " + sample1.forLoopSample());
		
	}
}
