//ZACH
public class Room {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private static int numOfRooms = 0;

    Room () {
        this.roomNumber = 0;
        this.roomType = "One Bed";
        this.pricePerNight = 50;
        Room.numOfRooms++;
    }

    Room (int roomNumber, String roomType, double pricePerNight) {
        this.setRoomNumber(roomNumber);
        this.setRoomType(roomType);
        this.setPricePerNight(pricePerNight);
        
        Room.numOfRooms++;
    }

    public Room(Room room) {
        this.roomNumber = getRoomNumber();
        this.roomType = getRoomType();
        this.pricePerNight = getPricePerNight();
    }

    public void setRoomNumber (int roomNumber) {
        if (roomNumber > 0) {
            this.roomNumber = roomNumber;
        } else {
            throw new IllegalArgumentException("Room number cannot be less than 0");
        }
    }
    
    public void setRoomType (String roomType) {
        if (roomType.equals("") || roomType == null) {
            throw new IllegalArgumentException("Room type cannot be blank or null");
        } else {
            this.roomType = roomType;
        }
    }
    
    public void setPricePerNight (double pricePerNight) {
        if (pricePerNight > 0) {
            this.pricePerNight = pricePerNight;
        } else {
            throw new IllegalArgumentException("Price per night cannot be negative");
        }
    }

   
    public int getRoomNumber () {return this.roomNumber;}

    
    public String getRoomType () {return this.roomType;}

    
    public double getPricePerNight () {return this.pricePerNight;}

    
    public static int getNumOfRooms () {return Room.numOfRooms;}


    public void updateNumOfRooms (int numOfRooms) {
        if (Room.numOfRooms > 0) {
            Room.numOfRooms = numOfRooms;
        } else {
            throw new IllegalArgumentException("Number of rooms must be more than 0");
        }
    }

    public String toString () {
        return "Room Number: " + this.getRoomNumber() 
        + ", Room Type: " + this.getRoomType() 
        + ", Price Per Night: " + this.getPricePerNight();   
    }
}
