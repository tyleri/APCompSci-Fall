import java.util.*;

public class TileGameTest {
    public static void main( String[] args ) {

	TileGame t = new TileGame();

	for(int i = 0; i < 6; i++) {

	    System.out.println( "Current Board:\n" + t );
	    NumberTile nt = new NumberTile();
	    System.out.println( "attempting to add:\n" + nt);
	    t.insertTile( nt );
	    System.out.println( "New Board:\n" + t );	    
	}
    }
    
}
