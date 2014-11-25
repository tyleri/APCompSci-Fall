import java.util.*;

public class WordList {

    private ArrayList<String> MyList;

    public WordList() {
	MyList = new ArrayList<String>();
	
	//populate with random "words"
	Random r = new Random();
	for(int i=0; i < 10; i++) {
	    String s = "";
	    int numChars = r.nextInt( 5 ) + 1;
	    for(int j=0; j < numChars; j++ ) {
		s+= (char)(r.nextInt(26) + 97);		
	    }
	    MyList.add( s );
	}       
    }
    public String toString() {
	return MyList.toString();
    }

    /**
     * THESE ARE THE THREE METHODS YOU NEED TO WRITE FOR THE ASSIGNMENT!
     */
    public int numWordsOfLength( int len ) {
		int numWords = 0;

		for (int i = 0; i < MyList.size(); i++)
			if (MyList.get(i).length() == len)
				numWords++;
		return numWords;
    }
    
    public void removeWordsOfLength( int len ) {
		int index = 0;

		while (index < MyList.size()) {
			if (MyList.get(index).length() == len)
				MyList.remove(index);
			else
				index++;
		}
    }
    //END OF ASSIGNMENT
    
    public static void main(String[] args){

	WordList wl = new WordList();
	System.out.println( wl );

	System.out.println("Words of length 3: " + wl.numWordsOfLength(3));
	wl.removeWordsOfLength(3);
	System.out.println("After removing: " + wl);
    }
}
