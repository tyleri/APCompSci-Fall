public class Map {

	private Room currRoom;
	
	public Map() {
		currRoom = new Room(1);
	}

	// moves the character into the next room
	public void nextRoom () {
		int nextLoc = currRoom.getLocation() + 1;
		currRoom = new Room(nextLoc);
	}

	// return a picture of the map, X marks your location
	public String toString() {
		String map = "";
		for (int i = 10; i > 0; i--) {
			map += " (";
			if (i == currRoom.getLocation())
				map += "X";
			else
				map += i + "";
			map += ")\n";
			map += "  |\n";
		}
		map += "START\n";
		return map;
	}
}
