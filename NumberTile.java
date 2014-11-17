/**
 * Each NumberTile objects represents a collection of 4 integers where
 * each value has an associated direction (left, up, right down).
 *
 * A NumberTile can be rotated 90 degrees clockwise to change the
 * orientation of the values.
 * 
 * You only need to use the following methods in this assignment:
 * 
 *   getLeft()
 *       returns the value at the left position
 *
 *   getRight()
 *       returns the value at the right position
 * 
 *   rotate()
 *       rotates the values clockwise by 90 dgrees
 * 
 * All other methods do not need to be called by your methods
 */

import java.util.*;

public class NumberTile {

    private ArrayList numbers;

    public NumberTile() {
	numbers = new ArrayList();
	
	Random r = new Random();	
	for (int i=0; i<4; i++)
	    numbers.add( r.nextInt(10) );
    }

    public int getLeft() {
	return (Integer)numbers.get(0);
    }
    public int getRight() {
	return (Integer)numbers.get(2);
    }
    public int getUp() {
	return (Integer)numbers.get(1);
    }
    public int getDown() {
	return (Integer)numbers.get(3);
    }

    public void rotate() {
	numbers.add( 0, numbers.get(numbers.size() - 1) );
	numbers.remove( numbers.size() - 1 );
    }

    public String toString() {
	String s = " " + numbers.get(1) + "\n";
	s+= numbers.get(0) + " " + numbers.get(2) + "\n";
	s+= " " + numbers.get(3);
	return s;
    }


    /**
     * This is just here to make sure the rotate method works correctly
     */
    public static void main(String[] args) {

	NumberTile nt = new NumberTile();

	for (int i=0; i<4; i++) {
	    System.out.println( nt + "\n" );
	    nt.rotate();
	}

    }
}
