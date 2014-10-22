public class Map {

	//return a picture of the map, X marks your location
	public void display(int location) {
		String map = "";
		for (int i = 10; i > 0; i--) {

			// numbered rooms
			map += " (";
			if (i == location)
				map += "X";
			else
				map += i + "";
			map += ")\n";

			//connecting roads
			map += "  |\n";
		}
		map += "START\n";

		System.out.println( map );
	}
}
