public class A2dFun {

	public static void main(String[] args) {
		
		int[][] a2d = new int[4][3];

		// Adding values to a2d
		for (int i = 0; i < a2d.length; i++)
			for (int j = 0; j < a2d[i].length; j++)
				a2d[i][j] = j + i * a2d[i].length;

		// Printing out a2d
		String s = "";
		for (int i = 0; i < a2d.length; i++) {
			for (int j = 0; j < a2d[i].length; j++)
				s += a2d[i][j] + " ";
			s += "\n";
		}

		System.out.println(s);

	}

}
