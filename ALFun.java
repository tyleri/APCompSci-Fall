import java.util.*;

public class ALFun {

    /**
     * Populate the parameter al with n random
     * ints, with each int being in the range 0 <= i <= 10
     */
    static void populateAL( ArrayList<Integer> al, int n ) {	
		Random rand = new Random();
		
		for (int i = 0; i < n; i++) {
			al.add(rand.nextInt(11));
		}
    }



    /**
     * Removes all CONSECUTIVE duplicate values in al
     * Example:
     *   If al: [1, 4, 5, 5, 5, 4, 4, 1, 3 ]
     *   after collapseDuplicates: [1, 4, 5, 4, 1, 3]
     */
    static void collapseDuplicates( ArrayList<Integer> al ) {
		int index = 1;
		while (index < al.size()) {
			if (al.get(index) == al.get(index-1))
				al.remove(index);
			else
				index++;
		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		System.out.println( "Before populate: " + a);
		populateAL( a, 40 );
		System.out.println( "After populate: " + a );
		collapseDuplicates( a );
		System.out.println( "After collapse: " + a );
	}

}
