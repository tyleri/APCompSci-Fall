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

    public int freq(int n) {
	    int freq = 0;
	    for (int count = 0; count < data.length; count++)
		    if (data[count] == n)
			    freq++;
	    return freq;
    }

    public boolean evenBalance() {
	    int sum1 = 0, sum2 = 0;
	    for (int count = 0; count < data.length / 2; count++) {
		    sum1 += data[count];
		    sum2 += data[data.length - 1 - count];
	    }
	    return sum1 == sum2;
    }

    public int mode() {
	    int mode = data[0];
	    int freq = freq(data[0]);
	    for (int count = 1; count < data.length; count++)
		    if ( freq(data[count]) > freq ) {
			    mode = data[count];
			    freq = freq(data[count]);
		    }
	    return mode;
    }

	public int[] mode2() {
		int[] modes = { mode() };
		int freq = freq( modes[0] );
		for (int count = 0; count < data.length; count++)
			if (Arrays.binarySearch(modes, data[count]) < 0)
				if (freq(data[count]) == freq) {
					modes = Arrays.copyOf(modes, modes.length+1);
					modes[modes.length - 1] = data[count];
					Arrays.sort(modes);
				}
		return modes;
	}

	public boolean evenBalance2() {
		if (data.length % 2 == 0)
			return evenBalance();
		else {
			int sum1 = 0, sum2 = 0, mid = data[data.length / 2];
			for (int count = 0; count < data.length / 2; count++) {
				sum1 += data[count];
				sum2 += data[data.length - 1 - count];
			}
			return sum1 + mid == sum2 || sum1 == (sum2 + mid);
		}
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
	System.out.println("evenBalance: " + s.evenBalance() );
	System.out.println("Mode: " + s.mode() );
	System.out.println("Mode2: " + Arrays.toString(s.mode2());
	System.out.println("evenBalance2: " + s.evenBalance2() );
    }
}
