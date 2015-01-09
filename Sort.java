/*========== Sort.java ==========

  Class used to test various sorting algorithms.
  The constructor will create an array of ints and then
  populate them with random values.
  
  The class also contains variables to keep track
  of the number of swaps and comparisons performed
  for a given sort.

  Complete bubble(), selection() and insertion()
jdyrlandweaver
=========================*/

import java.io.*;
import java.util.*;

public class Sort {

    public static int DEFAULT_SIZE = 1000;

    private int[] list;
    private int swaps;
    private int comps;
  
	public Sort() {
		list = new int[ DEFAULT_SIZE ];
		swaps = comps = 0;
		populate();
	}

	public Sort(int size) {
		list = new int[size];
		swaps = comps = 0;
		populate();
	}


    /*======== public void populate()) ==========
      Inputs:   
      Returns: 
      
      populates the list with random ints in the 
      range [0, list.length)
      
      12/13/11 09:15:54
      jdyrlandweaver
      ====================*/
	public void populate() {

		Random r = new Random();
		for (int i=0; i<list.length; i++)
			list[i] = r.nextInt() % list.length;
	}

    /*======== public void duplicate () ==========
      Inputs:  Sort s
               int size 
      Returns: 

      Copies size elements from the list of Sort s
      to the calling Sort object
      
      12/13/11 09:16:50
      jdyrlandweaver
      ====================*/
	public void duplicate (Sort s, int size) {

		for (int i=0; i<size; i++)
			list[i] = s.list[i];
	}

	public int size() {
		return list.length;
	}

	public String toString() {
		String s = "";
		for (int i=0; i<list.length - 1; i++)
			s = s + list[i] + ", ";
		return s + list[list.length-1];
	}

	public void printStats() {

		System.out.println("\tSwaps: " + swaps + 
				"\n\tComps: " + comps);
	}

    /*======== public boolean isSorted()) ==========
      Inputs:   
      Returns: true if the list is sorted
               false if the list is unsorted

      12/13/11 09:17:36
      jdyrlandweaver
      ====================*/
	public boolean isSorted() {
		for (int i=0; i<list.length - 1; i++)
			if (list[i] > list[i+1])
				return false;
		return true;
	}
   
    /*======== public void swap() ==========
      Inputs:  int a
               int b  
      Returns: 
      
      Swaps the values at postitons a and b int list

      12/13/11 09:18:09
      jdyrlandweaver
      ====================*/
	public void swap(int a, int b) {
		int c = list[a];
		list[a] = list[b];
		list[b] = c;
		swaps++;
	}

    /*======== public long bubble()) ==========
      Inputs:   
      Returns: The amount of time, in miliseconds
               the sort took to complete

      Performs a bubble sort on list.
      Keeps track of swaps and comps
      
      Use System.currentTimeMillis() to get the 
      current time in milliseconds

      12/13/11 09:19:22
      jdyrlandweaver
      ====================*/
	public long bubble() {
		long startTime = System.currentTimeMillis();
		int end = size();

		while (end > 0) {
			int newEnd = 0;
			for (int j = 1; j < end; j++) {
				comps++;
				if (list[j-1] > list[j]) {
					swap(j-1, j);
					newEnd = j;
				}
			}
			end = newEnd;
		}

		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

    /*======== public long selection()) ==========
      Inputs:   
      Returns: The amount of time, in miliseconds
               the sort took to complete

      Performs a selection sort on list.
      Keeps track of swaps and comps
      
      Use System.currentTimeMillis() to get the 
      current time in milliseconds

      12/13/11 09:22:07
      jdyrlandweaver
      ====================*/
	public long selection() {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < size()-1; i++) {
			int min = i;

			for (int j = i; j < size(); j++) {
				comps++;
				if (list[j] < list[min])
					min = j;
			}
			swap(i, min);
		}

		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}

    /*======== public long insertion()) ==========
      Inputs:   
      Returns: The amount of time, in miliseconds
               the sort took to complete

      Performs an insertion sort on list.
      Keeps track of swaps and comps
      There are no true swaps only shifts, but 
      a swap is 3 assignments, and a shift is 1.
      Use math to figure out how they can be equated.

      Use System.currentTimeMillis() to get the 
      current time in milliseconds

      12/13/11 09:23:06
      jdyrlandweaver
      ====================*/
	public long insertion() {
		long startTime = System.currentTimeMillis();
		int shifts = 0;

		for (int i = 1; i < size(); i++) {
			int num = list[i], currIndex = i-1;
			while (currIndex >= 0 && list[currIndex] > num & ++comps>0) {
				list[currIndex+1] = list[currIndex];
				shifts++;
				currIndex--;
			}
			list[currIndex+1] = num;
		}
		swaps = shifts / 3;

		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}


	public static void main(String[] args) {

		//change this value to get more significant time results
		int x = 10000;

		Sort b = new Sort(x);
		Sort s = new Sort(x);
		Sort i = new Sort(x);

		b.duplicate(b, b.size());
		s.duplicate(b, s.size());
		i.duplicate(b, i.size());

		System.out.println("Bubble Sort:");
		System.out.println("\tTime:" + b.bubble());
		if ( b.isSorted() ) 
			System.out.println("Bubble Sort: SUCCESS");
		else
			System.out.println("Bubble Sort: FAIL");
		b.printStats();

		System.out.println("Selection Sort:");
		System.out.println("\tTime:" + s.selection());
		if ( s.isSorted() ) 
			System.out.println("Selection Sort: SUCCESS");
		else
			System.out.println("Selction Sort: FAIL");

		s.printStats();

		System.out.println("Insertion Sort:");
		System.out.println("\tTime:" + i.insertion());
		if ( i.isSorted() ) 
			System.out.println("Insertion Sort: SUCCESS");
		else
			System.out.println("Insertion Sort: FAIL");
		i.printStats();

	}
}
