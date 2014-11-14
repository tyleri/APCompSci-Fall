/*========== CandidatePool.java ==========

  Each CandidatePool object contains the following
  instance variables that you may need to use:
       
  pool
      An ArrayList of only Candidate objects

  You will need to write the following methods:
   
  getCandidatesForPosition(String pos)
      returns a candidate-only ArrayList containing all
      the Candidates in pool that have positions pos

  getBestCandidate(String pos)
      returns the Candidte in pool that matches position
      pos with the highest score
      If there are no candidates for the given position, 
      returns null

  removeCandidatesForPosition(String pos)
      Removes all the Candidates in the pool that match
      position pos.
      Returns the number of candidates removed

jdyrlandweaver
=========================*/
import java.io.*;
import java.util.*;

public class CandidatePool {
    
    //=================================
    //DO NOT MODIFY ANY OF THIS CODE
    ArrayList pool;
    
    public CandidatePool() {
	pool = new ArrayList();
    }
    public void addCandidate(Candidate c) {
	pool.add(c);
    }
    public String toString() {
	return pool.toString();
    }
    
    //=================================
    //START YOUR WORK HERE
    public ArrayList getCandidatesForPosition(String pos) {
		ArrayList<Candidate> ac = new ArrayList<Candidate>();
		Candidate curr;

		for (int i = 0; i < pool.size(); i++) {
			curr = (Candidate)pool.get(i);
			if (curr.getPosition().equals(pos))
				ac.add(curr);
		}
		return ac;
    }

    public Candidate getBestCandidate(String pos) {
		ArrayList<Candidate> ac = getCandidatesForPosition(pos);

		if (ac.size() == 0)
			return null;
		else {
			Candidate best = ac.get(0), curr;
			for (int i = 1; i < ac.size(); i++) {
				curr = ac.get(i);
				if (curr.getInterviewScore() > best.getInterviewScore())
					best = curr;
			}
			return best;
		}
    }

    public int removeCandidatesForPosition(String pos){
		int count = 0;
		Candidate curr;

		for (int i = 0; i < pool.size(); i++) {
			curr = (Candidate)pool.get(i);
			if (curr.getPosition().equals(pos)) {
				pool.remove(i);
				count++;
				i--;
			}
		}
		return count;
    }
}

    
