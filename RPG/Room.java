public class Room {

	private int type; // 1 = fighting, 2 = shop, 3 = nothing
	private int location; // map class will have a list of #'d rooms
	
	public Room (int roomNum) {
		type = 1; // making all the rooms fighting for now
		location = roomNum;
	}

	// Returns the number of the room
	public int getLocation() {
		return location;
	}

}
