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

	public int size() {
		return size;
	}

	public Object get(int index) {
		if (index >= size || index < 0) {
			return null;
		} else {
			return data[index];
		}
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

	public void add(Object o, int index) {
		if (index >= size) {
			add(o);
		} else if (index >= 0) {
			if (size == data.length)
				resize(size + 10);
			for (int i = size; i > index; i--)
				data[i] = data[i-1];

			data[index] = o;
			size++;
		}
	}

	public Object remove(int index) {
		if (index >= size || index < 0) {
			return null;
		} else {
			Object o = data[index];
			for (int i = index; i < size-1; i++)
				data[i] = data[i+1];
			size--;
			return o;
		}
	}

	public Object set(Object o, int index) {
		if (index >= size || index < 0) {
			return null;
		} else {
			Object oldObject = data[index];
			data[index] = o;
			return oldObject;
		}
	}

	public static void main(String[] args) {
		
		SuperArray sa = new SuperArray();
		System.out.println(sa);

		System.out.println();
		System.out.println("Filling up the array...");
		for (int i = 0; i < 10; i++)
			sa.add(i);
		System.out.println(sa);

		System.out.println();
		System.out.println("Let's add an element to index 5");
		sa.add("Added a string here!", 5);
		System.out.println(sa);

		System.out.println();
		System.out.println("Size of the SuperArray: " + sa.size());

		System.out.println("The element at index 5 is: " + sa.get(5));
		System.out.println("The element at index 15 is: " + sa.get(15));

		System.out.println();
		System.out.println("Let's try adding to a negative index");
		sa.add("not added", -5);
		System.out.println("The SuperArray is still:");
		System.out.println(sa);

		System.out.println();
		sa.remove(8);
		System.out.println("After removing the element at index 8:");
		System.out.println(sa);

		System.out.println();
		System.out.println("Setting the element at index 0 to pi");
		sa.set(3.14159265, 0);
		System.out.println(sa);
	}

}
