import java.util.*;

public class Stat {

    private SuperArray data;


    /**
     * Initialize the data array to a size of your choosing.
     */
    public Stat()  {
		data = new SuperArray();
    }
    
    /**
     * Initialize the data array to the specified size.
     */
    public Stat(int s)  {
		data = new SuperArray(s);
		for (int i = 0; i < s; i++) {
			data.add(0);
		}
    }

    /**
     * Returns a string that contains all the elements of the array.
     */
    public String toString() {
		return data.toString();
    }
    
    /*
     * Go through the array and have the user enter 
     * values for each available space.
     */
	public void setValues() {
		Scanner scan = new Scanner(System.in);
		for (int count = 0; count < data.size(); count++) {
			System.out.println("Enter an integer for grade #" + (count+1) );
			data.set(scan.nextInt(), count);
		}
	}

    /**
     * Return the sum of all the data in the array.
     */
	public int calcSum() {
		int sum = 0;
		for (int count = 0; count < data.size(); count++)
			sum += (int)data.get(count);
		return sum;
	}

    /**
     * Return the average of the data in the array.
     */
    public double calcAvg() {
		return (double)calcSum() / data.size();
    }

    /**
     * Return the smallest value in the array.
     */
	public int findMin() {
		int min = (int)data.get(0);
		for (int count = 1; count < data.size(); count++)
			if ((int)data.get(count) < min)
				min = (int)data.get(count);
		return min;
	}

    /**
     * Return the largest value in the array.
     */
	public int findMax() {
		int max = (int)data.get(0);
		for (int count = 1; count < data.size(); count++)
			if ( (int)data.get(count) > max)
				max = (int)data.get(count);
		return max;
	}

    public int freq(int n) {
	    int freq = 0;
	    for (int count = 0; count < data.size(); count++)
		    if ((int)data.get(count) == n)
			    freq++;
	    return freq;
    }

    public boolean evenBalance() {
	    int sum1 = 0, sum2 = 0;
	    for (int count = 0; count < data.size() / 2; count++) {
		    sum1 += (int)data.get(count);
		    sum2 += (int)data.get(data.size() - 1 - count);
	    }
	    return sum1 == sum2;
    }

    public int mode() {
	    int mode = (int)data.get(0);
	    int freq = freq(mode);
	    for (int count = 1; count < data.size(); count++)
		    if ( freq( (int)data.get(count) ) > freq ) {
			    mode = (int)data.get(count);
			    freq = freq(mode);
		    }
	    return mode;
    }

	public int[] mode2() {
		int[] modes = { mode() };
		int freq = freq( modes[0] );
		for (int count = 0; count < data.size(); count++)
			if (Arrays.binarySearch(modes, (int)data.get(count)) < 0)
				if (freq( (int)data.get(count) ) == freq) {
					modes = Arrays.copyOf(modes, modes.length+1);
					modes[modes.length - 1] = (int)data.get(count);
					Arrays.sort(modes);
				}
		return modes;
	}

	public boolean evenBalance2() {
		if (data.size() % 2 == 0)
			return evenBalance();
		else {
			int sum1 = 0, sum2 = 0, mid = (int)data.get(data.size() / 2);
			for (int count = 0; count < data.size() / 2; count++) {
				sum1 += (int)data.get(count);
				sum2 += (int)data.get(data.size() - 1 - count);
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
	System.out.println("Data: " + s);
	System.out.println("Sum: " +  s.calcSum() );
	System.out.println("Average: " + s.calcAvg() );
	System.out.println("Min: " + s.findMin() );
	System.out.println("Max: " + s.findMax() );
	System.out.println("evenBalance: " + s.evenBalance() );
	System.out.println("Mode: " + s.mode() );
	System.out.println("Mode2: " + Arrays.toString(s.mode2()));
	System.out.println("evenBalance2: " + s.evenBalance2() );
    }
}
