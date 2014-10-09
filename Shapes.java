public class Shapes {
    
    /*======== public static String line() ==========
      Inputs:  String c (single character String)
               int n 
      Returns: A String that contains n copies of c
      ex: Shapes.line( "^", 4 ); ==> "^^^^"
      ====================*/
	public static String line(String c, int n) {
		String s = "";
		while (n > 0) {
			s += c;
			n--;
		}
		return s;
	}
    
    /*======== public static String box() ==========
      Inputs:  String c (single character)
               int rs
               int cs 
      Returns: A String made up of a rs x cs grid of c
      ex: Shapes.box("*", 2, 3) ==> "***
                                     ***"
     ====================*/
	public static String box(String c, int rs, int cs) {
		String s = "";
		while (rs > 0) {
			s += line(c, cs);
			s += "\n";
			rs--;
		}
		return s;
	}


    /*======== public String tri1() ==========
      Inputs:  String c 
               int h 
      Returns: A "triangle" of c, h lines high
      ex: Shapes.tri1("|", 3); ==> "|
                                    ||
				    |||"
      ====================*/
    public static String tri1(String c, int h) {
	String s = "";
	for (int count = 1; count <= h; count++) {
		s += line(c, count);
		s += "\n";
	}
	return s;
    }

    /*======== public String tri2() ==========
      Inputs:  String c 
               int h 
      Returns: A differnt "triangle" of c, h lines high
      ex: Shapes.tri2("|", 3); ==> "  |
                                     ||
				    |||"
      ====================*/
    public static String tri2(String c, int h){
        String s="";
		for (int count = 1; count <= h; count++) {
			s += line(" ", h - count);
			s += line(c, count);
			s += "\n";
		}
		return s;
	}

    /*======== public String tri3() ==========
      Inputs:  String c 
               int h 
      Returns: A differnt "triangle" of c, h lines high
      ex: Shapes.tri2("|", 3); ==> " |
                                    |||
				   |||||"
      ====================*/
    public static String tri3(String c, int h) {
        String s="";
		final int baseLength = 2 * h - 1;
		for (int count = 0, col = 1; count < h; count++, col += 2) {
			s += line(" ", (baseLength - col) / 2);
			s += line(c, col);
			s += "\n";
		}
		return s;
    }


    /*======== public diamond() ==========
      Inputs:  String c 
               int h 
      Returns: A "diamond" of c, h lines high
      ex: Shapes.tri2("|", 5); ==> " |
                                    |||
				   |||||"
				    |||
				     |"
      ====================*/
    public static String diamond(String c, int h){
		String s = "";
		final int baseLength = 2 * h - 1;
		s += tri3(c, h);
		for (int col = baseLength - 2; col > 0; col -= 2) {
			s += line(" ", (baseLength - col) / 2);
			s += line(c, col);
			s += "\n";
		}
		return s;
	}
    
    public static void main(String[] args) {
	System.out.println("Line Test:");
	System.out.println(Shapes.line("%",10));
	
	System.out.println("Box Test:");
	System.out.println(Shapes.box("#", 5,4));
	System.out.println(Shapes.box("#", 4,5));
	System.out.println();
	
	System.out.println("Tri1 Test:");
	System.out.println(Shapes.tri1("@", 5));
	System.out.println();

	System.out.println("Tri2 Test:");
	System.out.println(Shapes.tri2("+", 5));
	System.out.println();

	System.out.println("Tri3 Test:");
	System.out.println(Shapes.tri3("|", 4));
	System.out.println();

	System.out.println("Diamond Test:");
	System.out.println(Shapes.diamond("*", 5));
    }
}
