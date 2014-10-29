import java.util.*;

public class Stat {

    private int[] data;


    /**
     * Initialize the data array to a size of your choosing.
     */
    public Stat()  {
    }
    
    /**
     * Initialize the data array to the specified size.
     */
    public Stat(int s)  {
		data = new int[s];
    }

    /**
     * Returns a string that contains all the elements of the array.
     */
    public String toString() {
		String output = "{ ";
		for (int count = 0; count < data.length; count++) {
			output += data[count] + " ";
		}
		output += "}";
	return output;
    }
    
    /*
     * Go through the array and have the user enter 
     * values for each available space.
     */
    public void setValues() {
	Scanner scan = new Scanner(System.in);
	for (int count = 0; count < data.length; count++) {
		System.out.println("Enter an integer for grade #" + (count+1) );
		data[count] = scan.nextInt();
	}
    }

    /**
     * Return the sum of all the data in the array.
     */
    public int calcSum() {
	int sum = 0;
	for (int count = 0; count < data.length; count++)
		sum += data[count];
	return sum;
    }

    /**
     * Return the average of the data in the array.
     */
    public double calcAvg() {
	return calcSum() / data.length;
    }

    /**
     * Return the smallest value in the array.
     */
    public int findMin() {
	int min = data[0];
	for (int count = 1; count < data.length; count++)
		if (data[count] < min)
			min = data[count];
	return min;
    }

    /**
     * Return the largest value in the array.
     */
    public int findMax() {
	int max = data[0];
	for (int count = 1; count < data.length; count++)
		if (data[count] > max)
			max = data[count];
	return max;
    }

    public static void main( String[] args ) {

	int n;
	Stat s;
	Scanner scan = new Scanner( System.in );
	
	System.out.print("Number of entries: ");
	n = scan.nextInt();

	s = new Stat(n);

	s.setValues();
	System.out.println( "Data: " + s );
	System.out.println("Sum: " +  s.calcSum() );
	System.out.println("Average: " + s.calcAvg() );
	System.out.println("Min: " + s.findMin() );
	System.out.println("Max: " + s.findMax() );

    }
}
