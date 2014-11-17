/**
 * Each TileGame object contains the following instance variables
 * that you may need to use:
 *   
 *   gameBoard
 *      An ArrayList of NumberTiles
 * 
 * You will need to write the following methods:
 * 
 *     int getIndexForFit( NumberTile nt )
 *         Returns the index of gameboard where nt will "fit"
 *         See below for an explanation on what "fitting" means
 *         If the game board is empty, return 0
 *
 *     boolean insertTile( NumberTile nt )
 *          Attempts to place nt in the gameBoard. 
 *          All possible orientations of nt can be tried.
 *          If nt can fit, then place it in the board and return true
 *          If nt cannot fit, return false and leave gameBoard unchanged
 */
import java.util.*;

public class TileGame{

    //LEAVE THIS CODE ALONE
    
    private ArrayList gameBoard;

    public TileGame() {
	gameBoard = new ArrayList();
    }
    public String toString() {

	NumberTile nt;
	String s = "";
	
	for (int i=0; i < gameBoard.size(); i++) {

	    nt = (NumberTile)gameBoard.get(i);
	    s+= " " + nt.getUp() + "   ";
	}
	s+= "\n";		

	for (int i=0; i < gameBoard.size(); i++) {

	    nt = (NumberTile)gameBoard.get(i);
	    s+= nt.getLeft() + " " + nt.getRight() + "  ";
	}
	s+= "\n";
	
	for (int i=0; i < gameBoard.size(); i++) {

	    nt = (NumberTile)gameBoard.get(i);
	    s+= " " + nt.getDown() + "   ";
	}
	
	return s;
    }

    //YOUR SOLUTIONS START HERE

    /**
     * A tile "Fits" in the game board if its left value matches the right
     * value of the tile before it, and its right value matches the left
     * value of the tile after it.
     * For example, this tile:
     *                          6
     *                         5 2
     *                          1
     * Can fit between these two:
     *        1     7
     *       3 5   2 9
     *        6     4
     * To give us: 
     *        1     6    7
     *       3 5   5 2  2 9
     *        6     1    4
     *
     * This method returns the index of the GameBoard that the parameter tile
     * will "fit" into
     * 
     * If the new tile can fit in multiple spaces, can return any one of them
     *
     * 0 and size() are valid positions for the new tile
     * 
     * If the tile cannot fit, returns -1
     */ 
    public int getIndexForFit( NumberTile nt ) {	
		if (gameBoard.size() == 0)
			return 0;
		else if (nt.getRight() == ((NumberTile)gameBoard.get(0)).getLeft())
			return 0;
		else if ( nt.getLeft() == ((NumberTile)gameBoard.get(gameBoard.size()-1)).getRight() )
			return gameBoard.size();
		else if (gameBoard.size() == 1) {
			return -1;
		}
		else
			for (int i = 1; i < gameBoard.size(); i++) {
				if ( ((NumberTile)gameBoard.get(i-1)).getRight() == nt.getLeft() )
					if ( ((NumberTile)gameBoard.get(i)).getLeft() == nt.getRight() )
						return i;
			}
		
		return -1;
    }


    /**
     * Attempts to place a new NumberTile into the existing game board checking
     * all possible orientations of the new tile
     * 
     * Inserts the tile into the board if it can fit and returns true.
     *
     * If the tile cannot fit, returns false
     */
    public boolean insertTile( NumberTile nt ) {	
		TileGame tg = new TileGame();
		for (int i = 0; i < 4; i++, nt.rotate())
			if (getIndexForFit(nt) != -1) {
				gameBoard.add(getIndexForFit(nt), nt);
				return true;
			}

		return false;
    }
    
}
