

import javax.swing.JOptionPane;

public class ImplementationClass {

    // Main Arrays
    public static Room[] Rooms = new Room[100];
    public static Employee[] allEmployees = new Employee[100];
    public static Reservation[] allReservations = new Reservation[10];
    public static Guest[] allGuests = new Guest[10];

public static void main(String[] args) {
    Hotel aHotel = new Hotel(1001, "JAVA INN", "1(800)-111-1111", 
    "JavaHouse@java.net", "03:00PM", "11:00AM");

        //Boolean flag = true; // Set to false to break the loop.
    String welcomeText = 
          "Welcome to " + aHotel.getHotelName() + "! Enjoy our Services!!!\n\n"
        + "Hotel ID: "   + aHotel.getHotelID()     + "\n"
        + "Phone: "      + aHotel.getPhoneNumber() + "\n"
        + "Email: "      + aHotel.getEmailAddress()+ "\n"
        + "Check-In: "   + aHotel.getCheckInTime() + "\n"
        + "Check-Out: "  + aHotel.getCheckOutTime();
            
        JOptionPane.showMessageDialog( null, welcomeText);
        
        String menu = ("**MAIN MENU**\nWhat would you like to do?\n\n1. Room Menu\n2. Employee Menu\n3. Reservation Menu\n4. Guest Menu\n5. Exit");
            
        do {
            int option=0;
            try{
            option = Integer.parseInt(JOptionPane.showInputDialog(menu));
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Please enter right menu option");
            }

            switch (option) {
                case 1:
                    showRoomOptions();
                    break;
                case 2:
                    showEmployeeOptions();
                    break;
                case 3:
                showReservationMenu();
                case 4:
                showGuestMenu();
                break;
                case 5:
                System.exit(0);
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-5. Try Again.");
            }
        } while (true);
    }


    //Hotel info Adonays
    
    // Adonays Employee Section
    public static void showEmployeeOptions() {
        String menu = "**EMPLOYEE MENU**\nWhat would you like to do?\n\n1. Add employee\n2. Display Employees\n3. Search For Employee\n4. Remove Employee\n5. Back to main\n6. Exit Program";
        int input = -1;
        do {
            input = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (input) {
                case 1:
                    allEmployees[Employee.getNumOfEmployee()] = addEmployee();
                    break;
                case 2:
                    displayEmployee(allEmployees);
                    break;
                case 3:
                    String employeeID = JOptionPane.showInputDialog("Enter Employee ID to search? ");
                       JOptionPane.showMessageDialog(null, "**Found Employee**\n" 
                       + allEmployees[findEmployee(allEmployees, Integer.parseInt(employeeID))].toString());
                    break;
                case 4:
                FireEmployee(allEmployees);
                    break;
                case 5:
                    main(new String[0]);
                    break;
                case 6: 
                System.exit(0);
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-6. Try Again.");
                    break;
            }
        } while (input > 0 && input < 6);
        displayEmployee(allEmployees);
    };


    public static Employee addEmployee( ) {
        Employee aEmployee = new Employee(0, null, null, 
        null, null, 0, null);

        try{
        int employeeID = Integer.parseInt(JOptionPane.showInputDialog("What is that Employee ID?"));
        aEmployee.setEmployeeID(employeeID);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error! Employee ID must be a number");
        }catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
        String name = JOptionPane.showInputDialog("What is the Employee Name?");
        aEmployee.setName(name);
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
        String email = JOptionPane.showInputDialog("What is Employee Email?");
        aEmployee.setEmail(email);
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
        String hireDate = JOptionPane.showInputDialog("What is Employee Hired date?");
        aEmployee.setHireDate(hireDate);
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        String title = "";
        double salary = 0;
        String jobDuty = "";
        try{
        title = JOptionPane.showInputDialog("What is jobs title?");
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
         salary = Double.parseDouble(JOptionPane.showInputDialog("What is the Job Salary?"));
        }catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error! Job Salary must be a number");
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try{
        jobDuty = JOptionPane.showInputDialog("What is jobs duty?");
        }catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        Job aJob = new Job(title, salary, jobDuty);
        aEmployee.setJob(aJob);
        
        
        return aEmployee;

    }

    public static int findEmployee(Employee[] allEmployees, int employeeID) {
        int searchIndex = -1;
        for (int i = 0; i < Employee.getNumOfEmployee(); i++) {
            if (allEmployees[i].getEmployeeID() == employeeID) {
                searchIndex = i;
                break;
            }
        }
        return searchIndex;
    }

    public static void displayEmployee(Employee[] allEmployees) {
        String output = "";
        for (int i = 0; i < Employee.getNumOfEmployee(); i++) {
            output += allEmployees[i].toString() + "\n";

        }
        JOptionPane.showMessageDialog(null, output);
    }

    public static void FireEmployee(Employee[] allEmployees) {
        displayEmployee(allEmployees);
        int employeeToRemove = Integer.parseInt(JOptionPane.showInputDialog("Enter the Employee ID to delate"));
        int index = findEmployee(allEmployees,employeeToRemove);
        for (int i = index; i < Employee.getNumOfEmployee(); i++) {
            allEmployees[i] = allEmployees[i + 1];
        }
        allEmployees[Employee.getNumOfEmployee()] = null;
        Employee.updateNumOfEmployee();
    }//end of Adonays Employee part


    //Tasneems work 

    public static void showReservationMenu (){
        String menu = "1. Add Reservation\n2. Remove Reservation\n3. Search Reservation\n4. Display Reservation\n5. Return to Main Menu\n6.Exit";
        int choice = 0;
        do{
            try{
                choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Please enter right menu option");
                }
            choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch(choice){
                case 1:
                    allGuests[Guest.getOccupancy()] = createGuest();
                    allReservations[Reservation.getnumOfReservation()] = createReservation();
                    break;
                case 2:
                    removeReservation(allReservations);
                    break; 
                case 3:
                    String searchKey = JOptionPane.showInputDialog("Enter the Reservation ID you are searching for");
                    int found = searchReservation(allReservations, searchKey);
                    if(found >-1)
                        JOptionPane.showMessageDialog(null, "The reservation was found:" + allReservations[found].toString()); 
                    else 
                        JOptionPane.showMessageDialog(null, "Reservation not found");
                break;    
                case 4:
                   printReservation(allReservations);
                    break;
                case 5:
                    main(new String[0]);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Choice! Must be between 1-6");
            }//end of switch 
    
        }while(choice != 6);
    }// end of method 

public static Reservation createReservation(){
//Reservation reservation = new Reservation();
Reservation reservation = new Reservation();
int roomNum=Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter the room number"));
Room room=searchRoom(roomNum);
reservation.setroom(room);


try{
    String reservationID = JOptionPane.showInputDialog("Please enter the reservation ID");
    reservation.setreservationID(reservationID);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String arrivalDate = JOptionPane.showInputDialog("Please enter the date of arrival");
    reservation.setarrivalDate(arrivalDate);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String departDate = JOptionPane.showInputDialog("Please enter the date of departure");
    reservation.setdepartureDate(departDate);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}
try{
    int numOfNights = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of nights you will stay"));
    reservation.setnumOfNights(numOfNights);
}catch(NumberFormatException ex){
    JOptionPane.showMessageDialog(null, "Error! Please enter a valid number of nights");
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

return reservation; 
}// end of create a reservation 

//search reservation 
public static int searchReservation(Reservation[] allReservations, String reservationID){
int searchIndex = -1;
for(int i=0; i<Reservation.getnumOfReservation();i++){
    if((allReservations[i].getreservationID()).equalsIgnoreCase(reservationID)){
        searchIndex = i;
        break;
    }
}
return searchIndex;
}

//remove reservation 
public static void removeReservation(Reservation[] allReservations) {
printReservation(allReservations);
String removeReservation = JOptionPane.showInputDialog("Enter the reservation you would like to remove");
int index = searchReservation(allReservations, removeReservation);
if (index > -1) {
    for (int i = index; i < Reservation.getnumOfReservation(); i++) {
        allReservations[i] = allReservations[i + 1];
    }
    allReservations[Reservation.getnumOfReservation()] = null;
    Reservation.updatenumOfReservation();
    } else {
 JOptionPane.showMessageDialog(null, "Error! Reservation was not found");
}
}

//display reservation 
public static void printReservation(Reservation[] allReservations){
String output = "" ;
for(int i=0; i<Reservation.getnumOfReservation(); i++){
    output += allReservations[i].toString() + "\n";
}
JOptionPane.showMessageDialog(null, output);
}


// Method for Guests 
public static void showGuestMenu (){
String menu = "1. Add Guest\n2. Remove Guest\n3. Display Guest\n4. Return to Main Menu\n5. Exit";
int choice = 0;

do{
    try{
        choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Please enter right menu option");
        }
    choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
    switch(choice){
        case 1:
            allGuests[Guest.getOccupancy()] = createGuest();
            break;
        case 2:
            removeGuest(allGuests);
            break; 
        case 3:
            printGuest(allGuests);
        case 4:
            main(new String[0]);
            break;
        case 5:
            System.exit(0);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Invalid Choice! Must be between 1-5");
    }//end of switch 

}while(choice>=1 && choice<=5);
}// end of method 

public static Guest createGuest(){
Guest guest = new Guest();

try{
    String GuestID = JOptionPane.showInputDialog("Please enter the Guest ID");
    guest.setguestID(GuestID);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String gName = JOptionPane.showInputDialog("Please enter the Guest name");
    guest.setguestName(gName);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String gPhone = JOptionPane.showInputDialog("Please enter the guest phone number");
    guest.setguestPhone(gPhone);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String gAddress = JOptionPane.showInputDialog("Please enter the Guest address");
    guest.setguestAddress(gAddress);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

try{
    String gEmail = JOptionPane.showInputDialog("Please enter the Guest email");
    guest.setguestEmail(gEmail);
}catch(IllegalArgumentException ex){
    JOptionPane.showMessageDialog(null, ex.getMessage());
}

return guest; 
}// end of create a guest 

//search guests 
public static int searchGuests(Guest[] allGuests, String guestID){
int searchIndex = -1;
for(int i=0; i<Guest.getOccupancy();i++){
    if((allGuests[i].getguestID()).equalsIgnoreCase(guestID)){
        searchIndex = i;
        break;
    }
}
return searchIndex;
}

//remove Guest 
public static void removeGuest(Guest[] allGuests) {
printGuest(allGuests);
String removeGuest = JOptionPane.showInputDialog("Enter the Guest you want to remove");
int index = searchGuests(allGuests, removeGuest);
if (index > -1) {
    for (int i = index; i < Guest.getOccupancy(); i++) {
        allGuests[i] = allGuests[i + 1];
    }
    allGuests[Guest.getOccupancy()] = null;
    Guest.updateOccupancy();
    } else {
 JOptionPane.showMessageDialog(null, "Error! Guest was not found");
}
}

//display guest 
public static void printGuest(Guest[] allGuests){
String output = "" ;
for(int i=0; i<Guest.getOccupancy(); i++){
    output += allGuests[i].toString() + "\n";
}
JOptionPane.showMessageDialog(null, output);
}
    // Zachs Section - Never tested, but it should work
    public static void showRoomOptions() {
        String menu = "**ROOM MENU**\nWhat would you like to do?\n\n1. Create Room\n2. Display Room\n3. Remove Room\n4. Back to Main Program\n5. Exit Program";
        int input = -1;
        do {
            try{
                input = Integer.parseInt(JOptionPane.showInputDialog(menu));
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null,"Please enter right menu option");
                }
            input = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (input) {
                case 1:
                    createRoom();
                    break;
                case 2:
                    displayRoom();
                    break;
                case 3:
                    removeRoom();
                    break;
                case 4:
                    main(null);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-5. Try Again.");
            }
        } while (input != 5);
    }

    public static void createRoom() {
        int rn = Integer.parseInt(JOptionPane.showInputDialog("Enter Room Number: "));
        int type = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Beds (1/2): "));
        int price = Integer.parseInt(JOptionPane.showInputDialog("Enter Price per Night: "));
        System.out.println(type);
        if (type == 1) {
            String bedType = JOptionPane.showInputDialog("Enter Bed Type: ");
            new OneBed(rn, "One Bed", price, bedType);
        } else if (type == 2) {
            String[] bedTypes = new String[2];
            bedTypes[0] = JOptionPane.showInputDialog("Enter Bed Type 1: ");
            bedTypes[1] = JOptionPane.showInputDialog("Enter Bed Type 2: ");
            new TwoBed(rn, "Two Bed", price, bedTypes);
        } else {
            throw new IllegalArgumentException("Number of Beds Must Be Either 1 or 2");
        }

    }

   

    public static int chooseRoomNumber() {
        String output = "Enter Room Number:\n";
        int input = -1;
        System.out.println(Room.getNumOfRooms());
        for (int i = 0; i < Room.getNumOfRooms(); i++) {
            output += "\n" + Rooms[i + 1].toString();
        }

        input = Integer.parseInt(JOptionPane.showInputDialog(output));

        if (input >= 0 && input <= Room.getNumOfRooms()) {
            return input;
        } else {
            throw new IllegalArgumentException("Room number must be between 0 and " + Room.getNumOfRooms());
        }
    }

    public static void displayRoom() {
        displayRoom(chooseRoomNumber());
    }

    public static Room searchRoom(int roomNumber){
        for(int i = 0; i < Room.getNumOfRooms(); i++){
            if(Rooms[i+1].getRoomNumber() == roomNumber)
                return Rooms[i+1];
        }
        return null;
    }

    public static  void displayRoom(int roomNumber) {
        String output = "SOMETHING WENT WRONG";
        if (Rooms[roomNumber].getRoomNumber() == roomNumber) {
            output = Rooms[roomNumber].toString();
        } else {
            for (int i = 0; i < Room.getNumOfRooms(); i++) {
                if (Rooms[i + 1].getRoomNumber() == roomNumber) {
                    output = Rooms[i + 1].toString();
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(null, output);
        showRoomOptions();
    }

    public static void removeRoom() {
        removeRoom(chooseRoomNumber());
    }

    public static void removeRoom(int roomNumber) {
        int num = -1;
        if (Rooms[roomNumber].getRoomNumber() == roomNumber) {
            num = roomNumber;
        } else {
            for (int i = 0; i < Room.getNumOfRooms(); i++) {
                if (Rooms[i + 1].getRoomNumber() == roomNumber) {
                    num = i + 1;
                }
            }
        }
        for (int i = num; i < Room.getNumOfRooms(); i++) {
            Rooms[i + 1] = Rooms[i + 2];
        }
        Rooms[Room.getNumOfRooms()] = null;
    }
};
