public class Reservation {
    private String reservationID;
    private String arrivalDate;
    private String departureDate;
    private double totalPrice;
    private Guest guest;
    //private Room room;
    //static variable 
    private static int numOfReservation;

    Reservation(){
        this.reservationID = "";
        this.arrivalDate = "";
        this.departureDate = "";
        this.totalPrice = 0;
        numOfReservation++;
    }

    public Reservation(String reservationID, String arrivalDate, String departureDate, double totalPrice, String guestID, String guestName, String guestPhone, String guestAddress, String guestEmail ){
        this.reservationID = "";
        this.arrivalDate = "";
        this.departureDate = "";
        this.totalPrice = 0;
        this.guest = new Guest(guestID, guestName, guestPhone, guestAddress, guestEmail); 
        numOfReservation++;
    }

    //Accessors (getter methods)
    public String getreservationID (){
        return this.reservationID;
    }
    public String getarrivalDate (){
        return this.arrivalDate;
    }
    public String getdepartureDate (){
        return this.departureDate;
    }
    public double gettotalPrice(){
        return this.totalPrice;
    }
    public Guest getGuest(){return new Guest(this.guest);}
    public static int getnumOfReservation(){
        return numOfReservation;
    }

    //mutators (setter methods)
    public void setreservationID (String reservationID){
    if(reservationID.equals("") && reservationID.length() != 5)
        throw new IllegalArgumentException(" Error! The reservation ID cannot be blank and must have a length of 5");
    else 
        this.reservationID = reservationID;
    }
    //validation using is digit 
    public void setarrivalDate (String arrivalDate){
        boolean validArrivalDate = true;
        if(arrivalDate.length() != 8) {
            validArrivalDate = false; 
        }
        int x=0 ;
        while (validArrivalDate && x < arrivalDate.length()){
            if (!Character.isDigit(arrivalDate.charAt(x))){
                validArrivalDate = false; 
                break;
                 }
            else {
                x++;
                 }
        }
        if (validArrivalDate){
            this.arrivalDate = arrivalDate;
        }
        else {
            throw new IllegalArgumentException("Error! Enter a vlid arrival date");
        }
    }
    //validation using is digit 
    public void setdepartureDate (String departureDate){
        boolean validDepartDate = true;
        if(departureDate.length() != 8) {
            validDepartDate = false; 
        }
        int x=0 ;
        while (validDepartDate && x < departureDate.length()){
            if (!Character.isDigit(departureDate.charAt(x))){
                validDepartDate = false; 
                break;
                 }
            else {
                x++;
                 }
        }
        if (validDepartDate){
            this.departureDate = departureDate;
        }
        else {
            throw new IllegalArgumentException("Error! Enter a vlid departure date");
        }
    }
    public void settotalPrice (double totalPrice){
        if (totalPrice>0)
        this.totalPrice = totalPrice;
    else 
        throw new IllegalArgumentException("Error! Please enter a valid number");
    }
    public void setguest(Guest guest){
        this.guest = new Guest(guest); 
    }

     //toString method 
     public String toString (){
        return this.getreservationID() + " | "  + 
        this.getarrivalDate() + " | "  + 
        this.getdepartureDate() + " | "  + 
        this.gettotalPrice(); 
    }

}
