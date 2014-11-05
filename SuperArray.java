public class SuperArray {

	private Object[] data;
	private int size;

	public SuperArray() {
		size = 0;
		data = new Object[10];
	}

	public SuperArray(int s) {
		size = 0;
		data = new Object[s];
	}

	public String toString() {
		String output = "[ ";
		for (int i = 0; i < size; i++)
			output += data[i] + " ";
		output += "]";

		return output;
	}

	public void resize(int newSize) {
		Object[] newData = new Object[newSize];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;

		if (newSize < size) {
			size = newSize;
		}
	}

	public void add(Object o) {
		if (size == data.length)
			resize(size + 10);

		data[size] = o;
		size++;
	}

	public static void main(String[] args) {
		
		SuperArray sa = new SuperArray();
		System.out.println(sa);

		sa = new SuperArray(5);
		System.out.println(sa);

		for (int i = 0; i < 10; i++)
			sa.add(i);
		System.out.println(sa);

		for (int i = 10; i < 200; i++)
			sa.add(i);
		System.out.println(sa);

	}
}
