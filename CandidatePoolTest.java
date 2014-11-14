/*========== CandidatePoolTest.java ==========
  This file should be used to test your CandidatePool assignment.
  
  DO NOT MODIFY THIS CODE
jdyrlandweaver
=========================*/

import java.io.*;
import java.util.*;

public class CandidatePoolTest {
    public static void main(String[] args) {

	CandidatePool cp = new CandidatePool();
	String[] positions = {"bossman", "peon", "dude"};
	
	for (int i=0; i<15; i++) {
	    double score = Math.random() * 10;
	    String pos = positions[ (int)(Math.random() * 3) ];
	    cp.addCandidate( new Candidate( i, pos, score));
	}
    
	System.out.println(cp);
	System.out.println("\nAll candidates for position dude:");
	System.out.println(cp.getCandidatesForPosition("dude"));
	System.out.println("\nBest candidate for position dude:");
	System.out.println(cp.getBestCandidate("dude"));
	System.out.println("\nRemoving all candidates for position dude");
	int r = cp.removeCandidatesForPosition("dude");
	System.out.println("Removed " + r + " candidates");
	System.out.println(cp);
    }
}