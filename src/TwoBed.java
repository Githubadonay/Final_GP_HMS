//ZACH
public class TwoBed extends Room {
    private String[] bedTypes = new String[2];

    
    TwoBed () {
        super();
        String[] a = new String[] {"Twin", "Twin"};
        setBedTypes(a);

        ImplementationClass.Rooms[Room.getNumOfRooms()] = this;
    }

    
    TwoBed (int roomNumber, String roomType, double pricePerNight, String[] bedTypes) {
        super(roomNumber, roomType, pricePerNight);
        setBedTypes(bedTypes);

        ImplementationClass.Rooms[Room.getNumOfRooms()] = this;
    }

    
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

    public String[] getBedType () {
        String[] out = this.bedTypes;
        return out;
    }


    public String toString () {
        return super.toString() + ", Bed Types: " + this.getBedType()[0] + " and " + this.getBedType()[1];
    }
}
