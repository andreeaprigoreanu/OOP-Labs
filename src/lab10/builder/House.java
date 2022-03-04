package lab10.builder;

public class House {

	// TODO: write optional and mandatory facilities to have in a house
	private String address;
	private int numFloors;
	private int numRooms;
	private int numBalconies;
	private int numPools;
	private boolean hasPrivateParking;


	// TODO: complete the private constructor
	private House(HouseBuilder builder) {
		this.address = builder.address;
		this.numFloors = builder.numFloors;
		this.numRooms = builder.numRooms;
		this.numBalconies = builder.numBalconies;
		this.numPools = builder.numPools;
		this.hasPrivateParking = builder.hasPrivateParking;
	}

	// TODO: generate getters

	public String getAddress() {
		return address;
	}

	public int getNumFloors() {
		return numFloors;
	}

	public int getNumRooms() {
		return numRooms;
	}

	public int getNumBalconies() {
		return numBalconies;
	}

	public int getNumPools() {
		return numPools;
	}

	public boolean isHasPrivateParking() {
		return hasPrivateParking;
	}


	// TODO: override toString method
	@Override
	public String toString() {
		return "House{" +
				"address='" + address + '\'' +
				", numFloors=" + numFloors +
				", numRooms=" + numRooms +
				", numBalconies=" + numBalconies +
				", numPools=" + numPools +
				", hasPrivateParking=" + hasPrivateParking +
				'}';
	}

	public static class HouseBuilder {

		// TODO: write some facilities
		private String address; // mandatory
		private int numFloors; // mandatory
		private int numRooms; // mandatory
		private int numBalconies = 0; // optional
		private int numPools = 0; // optional
		private boolean hasPrivateParking = false; // optional

		// TODO: complete the house builder constructor only with the mandatory facilities
		public HouseBuilder(String address, int noFloors, int noRooms) {
			this.address = address;
			this.numFloors = noFloors;
			this.numRooms = noRooms;
		}

		// TODO: add the optional facilities in a builder design
		public HouseBuilder numBalconies(int numBalconies) {
			this.numBalconies = numBalconies;
			return this;
		}

		public HouseBuilder numPools(int numPools) {
			this.numPools = numPools;
			return this;
		}

		public HouseBuilder hasPrivateParking(boolean hasPrivateParking) {
			this.hasPrivateParking = hasPrivateParking;
			return this;
		}

		// TODO: complete the final build method
		public House build() {
			return new House(this);
		}

		// TODO: test functionality in a Main class
		public static void main(String[] args) {
			House basicHouse = new House.HouseBuilder("123 Andronache Street, Bucharest", 2, 6).build();
			System.out.println(basicHouse);

			House vacationHouse = new HouseBuilder("34 Furnica Street, Sinaia", 2, 5)
					.numBalconies(2)
					.build();
			System.out.println(vacationHouse);

			House mansion = new HouseBuilder("22 Victoriei Street, Bucharest", 5, 16)
					.numBalconies(7)
					.numPools(2)
					.hasPrivateParking(true)
					.build();
			System.out.println(mansion);
		}
	}
}
