public class Hotel {
    private int hotelID;
    private String hotelName;
    private String phoneNumber;
    private String emailAddress;
    private String checkInTime;
    private String checkOutTime;
    //private static int numOfHotel;
    private Reservation reservation;
    private Room room;
    private Employee employee;
    private Guest guest;

     public Hotel(int hotelID,String hotelName,String phoneNumber,
    String emailAddress, String checkInTime, String checkOutTime){
         this.hotelID = hotelID;
         this.hotelName = hotelName;
         this.phoneNumber = phoneNumber;
         this.emailAddress = emailAddress;
         this.checkInTime = checkInTime;
         this.checkOutTime = checkOutTime;
        // numOfHotel++;
    } 

    public Hotel(int hotelID,String hotelName,String phoneNumber,
     String emailAddress, String checkInTime, String checkOutTime, 
     Room room, Employee employee, Guest guest, Reservation reservation){
         this.hotelID = hotelID;
         this.hotelName = hotelName;
         this.phoneNumber = phoneNumber;
         this.emailAddress = emailAddress;
         this.checkInTime = checkInTime;
         this.checkOutTime = checkOutTime;
        setRoom(room);
        setEmployee(employee);
        setGuest(guest);
        setReservation(reservation);
        //numOfHotel++;

    }
    public int getHotelID(){return this.hotelID;}
    public String getHotelName(){return this.hotelName;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public String getEmailAddress(){return this.emailAddress;}
    public String getCheckInTime(){return this.checkInTime;}
    public String getCheckOutTime(){return this.checkOutTime;}
    public Room getRoom() { return this.room; }
    public Employee getEmployee() { return this.employee; }
    public Guest getGuest() { return this.guest; }
    public Reservation getReservation() { return this.reservation; }
    /* public static int getNumOfHotel() {
        return numOfHotel;
    } */
    /* public static void updateNumOfEmployee() {
        numOfHotel--;
    } */

    public void setHotelID(int hotelID){
        if(hotelID > 0)
        this.hotelID = hotelID;
        else 
            throw new IllegalArgumentException("Hotel ID cannot stay empty!!");
    }
    public void setHotelName(String hotelName){
        if(hotelName.equals(""))
        this.hotelName = hotelName;
        else 
            throw new IllegalArgumentException("Hotel name cannot stay empty!!");
    }
    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber.equals(""))
        this.phoneNumber = phoneNumber;
        else 
            throw new IllegalArgumentException("Hotel Phone number cannot stay empty!!");
    }
    public void setEmailAddress(String emailAddress){
        if(emailAddress.equals(""))
        this.emailAddress = emailAddress;
        else 
            throw new IllegalArgumentException("Hotel email address cannot stay empty!!");
    }
    public void setCheckInTime(String checkInTime){
        if(checkInTime.equals(""))
        this.checkInTime = checkInTime;
        else 
            throw new IllegalArgumentException("Hotel check in Time cannot stay empty!!");
    }
    public void setCheckOutTime(String checkOutTime){
        if(checkOutTime.equals(""))
        this.checkOutTime = checkOutTime;
        else 
            throw new IllegalArgumentException("Hotel check out Time cannot stay empty!!");
    }
    public void setRoom(Room room) {
      this.room = room;
   }   
    public void setEmployee(Employee employee) {
      this.employee = employee;
   }   
    public void setGuest(Guest guest) {
      this.guest = guest;
   }   
    public void setReservation(Reservation reservation) {
      this.reservation = reservation;
   }   
     

    public String toString(){
        return "Hotel ID: " + this.getHotelID() + "\n"
        + "Hotel Name: " + this.getHotelName() + "\n"
        + "Hotel Phone number: " + this.getPhoneNumber() + "\n"
        + "Address: " + this.getEmailAddress() + "\n"
        + "Check In: "+ this.getCheckInTime() + "\n"
        + "Check Out: " + this.getCheckOutTime() + "\n"
            + "Room: "+ this.getRoom().toString() +  "\n"
            + "Reservation: " + this.getReservation().toString() + "\n"
            + "Guest: " + this.getGuest().toString() + "\n"
            + "Employee: " + this.getEmployee().toString() + "\n";
    }
}




