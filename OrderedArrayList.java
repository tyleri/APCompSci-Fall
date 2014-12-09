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

	public int linearSearch(Comparable element) {
		for (int i = 0; i < data.size(); i++)
			if (data.get(i).compareTo(element) == 0)
				return i;
		return -1;
	}

	public int binarySearch(Comparable element) {
		int start = 0, middle = data.size() / 2, end = data.size();
		int comp = data.get(middle).compareTo(element);

		while (comp != 0) {
			if (start == end)
				return -1;
			else if (comp > 0)
				end = middle - 1;
			else if (comp < 0)
				start = middle + 1;
			middle = (end + start) / 2;

			comp = data.get(middle).compareTo(element);
		}

		return middle;
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

		System.out.println("\"apple\" is at index " + o.binarySearch("apple"));
		System.out.println("\"quarter\" is at index " + o.binarySearch("quarter"));
		System.out.println("\"cat\" is at index " + o.binarySearch("cat"));
		System.out.println("\"broccoli\" is at index " + o.binarySearch("broccoli"));
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
	}

}
