/*========== Candidate.java ==========
  
  Each candidate object contains the following
  methods that you need to use:

       getPostion()
           returns the position the Candidate wants
       getInterviewScore()
           returns the Candidate's grade.

jdyrlandweaver
=========================*/

import java.io.*;
import java.util.*;

public class Candidate {

    int id;
    String position;
    double score;

    public Candidate(int idnum, String pos, double s) {
	id = idnum;
	position = pos;
	score = s;
    }
    public String getPosition() {
	return position;
    }
    public double getInterviewScore() {
	return score;
    }
    public String toString() {
	return id + " " + position + " " + score;
    }
}


    