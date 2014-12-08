import java.util.ArrayList;

public class OrderedArrayList {

	private ArrayList<Comparable> data;

	public OrderedArrayList() {
		data = new ArrayList<>();
	}

	public void add(Comparable element) {
		for (int c = 0; c < data.size(); c++)
			if (element.compareTo(data.get(c)) < 0) {
				data.add(c, element);
				return;
			}

		data.add(element);

		/* Mr. DW's solution
		 * int i = 0;
		 * while (i < data.size() && value > data.get() )
		 *     i++;
		 * data.add( i, value );
		 */
	}

	public Object remove(int index) {
		return data.remove(index);
	}

	public Object get(int index) {
		return data.get(index);
	}

	public String toString() {
		return data.toString();
	}

	private int search(Comparable element) {
		for (int i = 0; i < data.size(); i++)
			if (data.get(i).compareTo(element) == 0)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		//Testing with integers
		OrderedArrayList o = new OrderedArrayList();

		o.add(5);
		o.add(8);
		o.add(9);
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

		System.out.println();
		System.out.println();

		//Testing with strings
		o = new OrderedArrayList();
		o.add("zebra");
		o.add("banana");
		o.add("quarter");
		o.add("apple");
		o.add("numbers");
		o.add("cat");
		o.add("frogs");
		System.out.println(o);
		System.out.println();

		System.out.println("\"apple\" is at index " + o.search("apple"));
		System.out.println("\"quarter\" is at index " + o.search("quarter"));
		System.out.println("\"cat\" is at index " + o.search("cat"));
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
