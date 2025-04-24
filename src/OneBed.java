public class OneBed extends Room {
    private String bedType;

    /**
     * Default constructor for the OneBed class
     */
    OneBed () {
        super();
        setBedType("Twin");

        ImplementationClass.Rooms[Room.getNumOfRooms()] = this;
    }

    /**
     * Parameterized constructor for the OneBed class
     * @param roomNumber Int. Room Number of the OneBed object
     * @param roomType String. Room Type of the OneBed object
     * @param pricePerNight Double. Price per Night of the OneBed object
     * @param bedType String. Bed type of the OneBed object
     */
    OneBed (int roomNumber, String roomType, double pricePerNight, String bedType) {
        super(roomNumber, roomType, pricePerNight);
        setBedType(bedType);

        ImplementationClass.Rooms[Room.getNumOfRooms()] = this;
        System.out.println(ImplementationClass.Rooms[Room.getNumOfRooms()]);
    }

    /**
     * Mutator. Sets the BedType of the OneBed object
     * @param bedType New bedType
     */
    public void setBedType (String bedType) {
        if (bedType.equals("") || bedType == null) {
            throw new IllegalArgumentException("Bed type must not be empty or null");
        } else {
            this.bedType = bedType;
        }
    }

    /**
     * Accessor. Returns the BedType of the OneBed object
     * @return bedType of the OneBed object
     */
    public String getBedType () {
        return this.bedType;
    }

    /**
     * Returns the String representation of the OneBed object
     */
    public String toString () {
        return super.toString() + ", Bed Type: " + this.getBedType();
    }
}
