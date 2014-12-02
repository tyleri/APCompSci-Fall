import java.util.ArrayList;

public class OrderedArrayList {

	private ArrayList<Integer> data;

	public OrderedArrayList() {
		data = new ArrayList<>();
	}

	public void add(int num) {
		if (data.size() == 0)
			data.add(num);
		else {
			for (int c = 0; c < data.size(); c++)
				if (data.get(c) > num) {
					data.add(c, num);
					return;
				}

			data.add(num);
		}
	}

	public int remove(int index) {
		return data.remove(index);
	}

	public int get(int index) {
		return data.get(index);
	}

	public String toString() {
		return data.toString();
	}

	public static void main(String[] args) {
		OrderedArrayList o = new OrderedArrayList();

		o.add(5);
		o.add(6);
		o.add(2);
		o.add(-5);
		o.add(10);
		o.add(3);
		System.out.println(o);
		System.out.println();

		System.out.println("The element at index 5 is " + o.get(5));
		System.out.println("The element at index 2 is " + o.get(2));
		System.out.println("The element at index 1 is " + o.get(1));
		System.out.println(o);
		System.out.println();

		System.out.println("Removing element at index 3: " + o.remove(3));
		System.out.println("Removing element at index 0: " + o.remove(0));
		System.out.println(o);
	}

}
