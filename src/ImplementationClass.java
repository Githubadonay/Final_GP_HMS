
// TODO
import javax.swing.JOptionPane;

public class ImplementationClass {

    // Main Arrays
    public static Room[] Rooms = new Room[100];
    public static Employee[] allEmployees = new Employee[100];
    public static Hotel[] allHotels = new Hotel[10];
    public static Reservation[] allReservations = new Reservation[10];
    public static Guest[] allGuests = new Guest[10];

    // Main Method
    public static void main(String[] args) {
    String menu = ("1. Create Hotel\n2. Display Hotel\n3. Select Hotel\n4. Exit");
    int input = -1;
    do{
        int option = Integer.parseInt(JOptionPane.showInputDialog(menu));
        switch (option) {
            case 1:
            //hotel(args);
            //createHotel(allHotels);
            allHotels[Hotel.getNumOfHotel()] = createHotel(allHotels);
                break;
            case 2:
            displayHotel(allHotels);
                break;
            case 3:
            String index = JOptionPane.showInputDialog("Enter Hotel ID to select: ");
            int id = Integer.parseInt(index);
            selectHotle(allHotels, id);
            case 4:
                System.exit(0);
                break;

            default:JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-4. Try Again.");

                break;
        }

    }while (input > 0 && input < 4);

}
public static Hotel createHotel(Hotel[] allHotels) {
    int hotelID = Integer.parseInt(JOptionPane.showInputDialog("What is the Hotel ID?"));
    String hotelName = JOptionPane.showInputDialog("What is that hotel name?");
    String hPhoneNumber = JOptionPane.showInputDialog("What is the hotel phone number?");
    String hEmailAddress = JOptionPane.showInputDialog("What is the hotels address?");
    String checkIN = JOptionPane.showInputDialog("What is the Hotels Check IN time?");
    String checkOUT = JOptionPane.showInputDialog("What is the Hotels Check Out time?");
    
    Hotel aHotel = new Hotel(hotelID, hotelName, hPhoneNumber, hEmailAddress, checkIN, checkOUT);
    return aHotel;
}

public static void displayHotel(Hotel[] allHotels) {
    String output = "";
    for (int i = 0; i < Hotel.getNumOfHotel(); i++) {
        output += allHotels[i].toString() + "\n";
    }
    JOptionPane.showMessageDialog(null, output);
}

public static int selectHotle(Hotel[] allHotels, int hotelID) {
    int searchIndex = -1;
    for (int i = 0; i < Hotel.getNumOfHotel(); i++) {
        if (allHotels[i].getHotelID() == hotelID) {
            searchIndex = i;
            break;
        }
    }
    if (searchIndex >= 0) {
        hotel(null);
    }
      //  hotel(allHotels[searchIndex]);
      return searchIndex;
} 




       public static void hotel(String[] args) { 
        Boolean flag = true; // Set to false to break the loop.

        String menu = ("*What would you like to see*\n1. Room Menu\n2. Employee Menu\n3. Reservation Menu\n4. Guest Menu\n5. Change Hotel\n6. Exit");
        do {
            int option = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (option) {
                case 1:
                    showRoomOptions();
                    break;
                case 2:
                    showEmployeeOptions();
                    break;
                case 5:
                    main(new String[0]);
                break;
                case 6:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-5. Try Again.");
            }
        } while (flag);
    }

    //Hotel info Adonays
    
    // Adonays Employee Section
    public static void showEmployeeOptions() {
        String menu = "1. Add employee\n2. Display Employees\n3. Search For Employee\n4. Remove Employee\n5. Back to main\n6. Exit Program";
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
                    hotel(new String[0]);
                    break;
                case 6: 
                System.exit(0);
                    break;
                default:
                    break;
            }
        } while (input > 0 && input < 6);
        displayEmployee(allEmployees);
    };


    public static Employee addEmployee( ) {
        Employee aEmployee = new Employee(0, null, null, 
        null, null, 0, null);

        int employeeID = Integer.parseInt(JOptionPane.showInputDialog("What is that Employee ID?"));
        aEmployee.setEmployeeID(employeeID);
        String name = JOptionPane.showInputDialog("What is the Employee Name?");
        aEmployee.setName(name);
        String email = JOptionPane.showInputDialog("What is Employee Email?");
        aEmployee.setEmail(email);
        String hireDate = JOptionPane.showInputDialog("What is Employee Hired date?");
        aEmployee.setHireDate(hireDate);
        String title = JOptionPane.showInputDialog("What is jobs title?");
        double salary = Double.parseDouble(JOptionPane.showInputDialog("What is the Job Salary?"));
        String jobDuty = JOptionPane.showInputDialog("What is jobs duty?");
        Job aJob = new Job(title, salary, jobDuty);
        aEmployee.setJob(aJob);
        return aEmployee;

    }// end of create cruise

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
        int employeeToRemove = Integer.parseInt(JOptionPane.showInputDialog("Enter the cruise ID to delate"));
        int index = findEmployee(allEmployees,employeeToRemove);
        for (int i = index; i < Employee.getNumOfEmployee(); i++) {
            allEmployees[i] = allEmployees[i + 1];
        }
        allEmployees[Employee.getNumOfEmployee()] = null;
        Employee.updateNumOfEmployee();
    }//end of Adonays Employee part

    // Zachs Section - Never tested, but it should work
    public static void showRoomOptions() {
        String menu = "1. Create Room\n2. Display Room\n3. Remove Room\n4. Back to Main Program\n5. Exit Program";
        int input = -1;
        do {
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
                    hotel(new String[0]);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-5. Try Again.");
            }
        } while (input > 0 && input < 6);
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

    public static void displayRoom(int roomNumber) {
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
