public class Window {

	private int myNumRows, myNumCols;
	private int [ ] [ ] myMat;

	public Window(int r, int c) {
		myNumRows = r;
		myNumCols = c;

		myMat = new int[r][c];
		fillWindow();
	}

	public void fillWindow() {
		for (int i=0; i < myNumRows; i++ )
			for (int j = 0; j < myNumCols; j++ )
				myMat[i][j] = (int)(Math.random() * 90) + 10;
	}

	public String toString() {
		String s = "";

		for (int i=0; i < myNumRows; i++ ) {
			for (int j = 0; j < myNumCols; j++ )
				s+= myMat[i][j] + " ";
			s+= "\n";
		}
		return s;
	}


	//SOLUTIONS GO HERE!!!

	public boolean isInBounds(int row, int col) {
		if (row < 0 || col < 0 || myNumRows < row || myNumCols < col)
			return false;
		else
			return true;
	}

	public void colorSquare( int ULrow, int ULcol, int n, int val ) {
		int row, col;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				row = ULrow + i;
				col = ULcol + j;

				if ( isInBounds(row, col) )
					myMat[row][col] = val;
			}
	}

	public void enlarge( int ULrow, int ULcol, int numRows, int numCols, int factor ) {
		int[][] area = new int[numRows][numCols];

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numCols; j++)
				area[i][j] = myMat[ULrow+i][ULcol+j];

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numCols; j++)
				colorSquare(
						ULrow + factor*i, ULcol + factor * j,
						factor, area[i][j]
						); 
	}

	public static void main(String[] args) {

		Window w = new Window(5, 4);
		System.out.println(w);
		w.enlarge(0,0,2,2,2);
		System.out.println(w);

	}
}
