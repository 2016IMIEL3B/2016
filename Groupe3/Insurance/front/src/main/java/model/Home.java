package model;

public class Home {
	int id;
	String type;
	int surface;
	int roomNumber;
	int floor;
	int bathroomNumber;
	int withGarage;
	int groundSurface;
	int terraceSurface;
	String heatingType;
	Address address;
	User user;
	
	public Home(String type, int surface, int roomNumber, int floor, int bathroomNumber, int withGarage,
			int groundSurface, int terraceSurface, String heatingType, Address address, User user) {
		super();
		this.type = type;
		this.surface = surface;
		this.roomNumber = roomNumber;
		this.floor = floor;
		this.bathroomNumber = bathroomNumber;
		this.withGarage = withGarage;
		this.groundSurface = groundSurface;
		this.terraceSurface = terraceSurface;
		this.heatingType = heatingType;
		this.address = address;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSurface() {
		return surface;
	}
	public void setSurface(int surface) {
		this.surface = surface;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getBathroomNumber() {
		return bathroomNumber;
	}
	public void setBathroomNumber(int bathroomNumber) {
		this.bathroomNumber = bathroomNumber;
	}
	public int getWithGarage() {
		return withGarage;
	}
	public void setWithGarage(int withGarage) {
		this.withGarage = withGarage;
	}
	public int getGroundSurface() {
		return groundSurface;
	}
	public void setGroundSurface(int groundSurface) {
		this.groundSurface = groundSurface;
	}
	public int getTerraceSurface() {
		return terraceSurface;
	}
	public void setTerraceSurface(int terraceSurface) {
		this.terraceSurface = terraceSurface;
	}
	public String getHeatingType() {
		return heatingType;
	}
	public void setHeatingType(String heatingType) {
		this.heatingType = heatingType;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser_id(User user) {
		this.user = user;
	}
}
