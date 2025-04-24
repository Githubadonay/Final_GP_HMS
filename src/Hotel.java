public class Hotel {
    private String hotelName;
    private String phoneNumber;
    private String emailAddress;
    private String checkInTime;
    private String checkOutTime;
    private Reservation reservation;
    private Room room;
    private Employee employee;
    private Guest guest;

    public Hotel(String hotelName,String phoneNumber,
     String emailAddress, String checkInTime, String checkOutTime, 
     Room room, Employee employee, Guest guest, Reservation reservation){
         this.hotelName = hotelName;
         this.phoneNumber = phoneNumber;
         this.emailAddress = emailAddress;
         this.checkInTime = checkInTime;
         this.checkOutTime = checkOutTime;
        setRoom(room);
        setEmployee(employee);
        setGuest(guest);
        setReservation(reservation);

    }
    public String getHotelName(){return this.hotelName;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public String getEmailAddress(){return this.emailAddress;}
    public String getCheckInTime(){return this.checkInTime;}
    public String getCheckOutTime(){return this.checkOutTime;}
    public Room getRoom() { return this.room; }
    public Employee getEmployee() { return this.employee; }
    public Guest getGuest() { return this.guest; }
    public Reservation getReservation() { return this.reservation; }

    public void  setHotelName(String hotelName){
        if(hotelName.equals(""))
        this.hotelName = hotelName;
    }
    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber.equals(""))
        this.phoneNumber = phoneNumber;
    }
    public void setEmailAddress(String emailAddress){
        if(emailAddress.equals(""))
        this.emailAddress = emailAddress;
    }
    public void setCheckInTime(String checkInTime){
        if(checkInTime.equals(""))
        this.checkInTime = checkInTime;
    }
    public void setCheckOutTime(String checkOutTime){
        if(checkOutTime.equals(""))
        this.checkOutTime = checkOutTime;
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
        return "Hotel Name: " + this.getHotelName() + "\n"
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




