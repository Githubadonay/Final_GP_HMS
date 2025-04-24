public class TwoBed extends Room {
    private String[] bedTypes = new String[2];

    /**
     * Default constructor for the TwoBed object
     */
    TwoBed () {
        super();
        String[] a = new String[] {"Twin", "Twin"};
        setBedTypes(a);

        ImplementationClass.Rooms[Room.getNumOfRooms()] = this;
    }

    /**
     * Parameterized constructor of the TwoBed object
     * @param roomNumber Int. Room Number of the TwoBed object
     * @param roomType String. Room Type of the TwoBed object
     * @param pricePerNight Double. Price per Night of the TwoBed object
     * @param bedTypes String[]. Types of the two beds of the TwoBed object
     */
    TwoBed (int roomNumber, String roomType, double pricePerNight, String[] bedTypes) {
        super(roomNumber, roomType, pricePerNight);
        setBedTypes(bedTypes);

        ImplementationClass.Rooms[Room.getNumOfRooms()] = this;
    }

    /**
     * Mutator. Sets the bedType variable
     * @param bedTypes String[]. The types of the two beds
     */
    public void setBedTypes(String[] bedTypes) {
        if (bedTypes.length == 2) {
            if (bedTypes[0].equals("") || bedTypes[0] == null) {
                throw new IllegalArgumentException("Bed type 1 cannot be blank or null");
            }
            if (bedTypes[1].equals("") || bedTypes[1] == null) {
                throw new IllegalArgumentException("Bed type 2 cannot be blank or null");
            }
            this.bedTypes = bedTypes;
        } else {
            throw new IllegalArgumentException("Bed types must be of length 2");
        }
    }

    /**
     * Accessor. Returns the bedTypes array
     * @return bedTypes array
     */
    public String[] getBedType () {
        String[] out = this.bedTypes;
        return out;
    }

    /**
     * Returns the String representation of the TwoBed object
     */
    public String toString () {
        return super.toString() + ", Bed Types: " + this.getBedType()[0] + " and " + this.getBedType()[1];
    }
}
