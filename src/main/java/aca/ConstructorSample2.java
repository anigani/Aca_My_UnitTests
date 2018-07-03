package aca;

public class ConstructorSample2 {

	private String name = "default name";
	private int id;
	private int[] arr = { 1, 2, 3, 4, 5 };

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int[] getArr() {
		return this.arr;
	}

	public ConstructorSample2() {

	}

	public ConstructorSample2(int[] arr) {
		setArr(arr);
	}

	public ConstructorSample2(String name) {
		setName(name);
	}

	public ConstructorSample2(int id) {
		setId(id);
	}

	public ConstructorSample2(String name, int id) {
		setName(name);
		setId(id);
	}

	public ConstructorSample2(int[] arr, int id) {
		setArr(arr);
		setId(id);
	}

	public ConstructorSample2(int id, String name) {
		if (name != null) {
			setName(name);
		}
		setId(id);
	}

	public int forSample() {
		int ret = 0;
		int i = 0;
		for (i = 0; i <= getId(); i++) {
			ret = ret + i;
		}
		return ret;
	}

	public int foreachSample() {
		int ret = 0;
		for (int i : getArr()) {
			ret += i;
		}
		return ret;
	}

	public int whileSample() {
		int i = 0;
		int ret = 0;
		while (i++ < getId()) {
			ret = ret + i;
		}

		return ret;
	}

	public int doWhileSample() {
		int ret = 0;
		int i = 2;
		do {
			ret = ret + i;
		} while (i < getId());

		return ret;
	}

	public static void main(String[] args) {
		ConstructorSample2 sample2 = new ConstructorSample2();
		sample2.setId(2);
		System.out.println(sample2.forSample());
		System.out.println(sample2.foreachSample());
		
		System.out.println(sample2.whileSample());
		System.out.println(sample2.doWhileSample());

	}
}
