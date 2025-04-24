public class Room {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private static int numOfRooms = 0;

    /**
     * This is the default constructor for the Room class.
     */
    Room () {
        this.roomNumber = 0;
        this.roomType = "One Bed";
        this.pricePerNight = 50;
        
        Room.numOfRooms++;
        // TODO: Add to rooms array in implementation class when ready
    }

    /**
     * This is the fully parameterized constructor for the Room class.
     * @param roomNumber Int. Room number
     * @param roomType String. Room type
     * @param pricePerNight Double. Price of Room per Night
     */
    Room (int roomNumber, String roomType, double pricePerNight) {
        this.setRoomNumber(roomNumber);
        this.setRoomType(roomType);
        this.setPricePerNight(pricePerNight);

        Room.numOfRooms++;
        // TODO: Add to rooms array in implementation class when ready
    }

    /**
     * Mutator. Sets the Room Number.
     * @param roomNumber Int. Room Number of the Room
     */
    public void setRoomNumber (int roomNumber) {
        if (roomNumber > 0) {
            this.roomNumber = roomNumber;
        } else {
            throw new IllegalArgumentException("Room number cannot be less than 0");
        }
    }
    /**
     * Mutator. Sets the Room Type
     * @param roomType String. Room Type of the Room
     */
    public void setRoomType (String roomType) {
        if (roomType.equals("") || roomType == null) {
            throw new IllegalArgumentException("Room type cannot be blank or null");
        } else {
            this.roomType = roomType;
        }
    }
    /**
     * Mutator. Sets the Price Per Night
     * @param pricePerNight Double. Price Per Night of the Room
     */
    public void setPricePerNight (double pricePerNight) {
        if (pricePerNight > 0) {
            this.pricePerNight = pricePerNight;
        } else {
            throw new IllegalArgumentException("Price per night cannot be negative");
        }
    }

    /**
     * Accessor. Returns the Room Number
     * @return Returns Room Number of the Room
     */
    public int getRoomNumber () {return this.roomNumber;}

    /**
     * Accessor. Returns the Room Type
     * @return Returns Room Type of the Room
     */
    public String getRoomType () {return this.roomType;}

    /**
     * Accessor. Returns the Price Per Night
     * @return Returns Price Per Night of the Room
     */
    public double getPricePerNight () {return this.pricePerNight;}

    /**
     * Accessor. Returns the Number of Rooms
     * @return Returns Number of Rooms (Static Method)
     */
    public static int getNumOfRooms () {return Room.numOfRooms;}

    /**
     * Special Purpose. Essentially a Setter for the static numOfRooms variable
     * @param numOfRooms New numOfRooms
     */
    public void updateNumOfRooms (int numOfRooms) {
        if (Room.numOfRooms > 0) {
            Room.numOfRooms = numOfRooms;
        } else {
            throw new IllegalArgumentException("Number of rooms must be more than 0");
        }
    }

    /**
     * Special Purpose. Returns the String representation of the Object
     * @return String representation of the Room object
     */
    public String toString () {
        return "Room Number: " + this.getRoomNumber() + ", Room Type: " + this.getRoomType() + ", Price Per Night: " + this.getPricePerNight();   
    }
}
