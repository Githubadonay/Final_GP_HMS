// TODO
import javax.swing.JOptionPane;

public class ImplementationClass {

    // Main Arrays
    public static Room[] Rooms = new Room[100];

    // Main Method
    public static void main(String[] args) {
        Boolean flag = true;    // Set to false to break the loop.
        String menu = "1. Room Menu\n...Everything Else...\n5. Exit";
        do {
            int option = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (option) {
                case 1:
                    showRoomOptions();
                    break;

                case 5:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-5. Try Again.");
            }
        } while (flag);
    }






    // Zachs Section - Never tested, but it should work
    public static void showRoomOptions () {
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
                    main(new String[0]);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Option. Must be 1-5. Try Again.");
            }
        } while (input > 0 && input < 6);
    }

    public static void createRoom () {
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

    public static int chooseRoomNumber () {
        String output = "Enter Room Number:\n";
        int input = -1;
        System.out.println(Room.getNumOfRooms());
        for (int i = 0; i < Room.getNumOfRooms(); i++) {
            output += "\n" + Rooms[i +1].toString();
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

    public static void displayRoom (int roomNumber) {
        String output = "SOMETHING WENT WRONG";
        if (Rooms[roomNumber].getRoomNumber() == roomNumber) {
            output = Rooms[roomNumber].toString();
        } else {
            for (int i = 0; i < Room.getNumOfRooms(); i++) {
                if (Rooms[i +1].getRoomNumber() == roomNumber) {
                    output = Rooms[i +1].toString();
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(null, output);
    }

    public static void removeRoom () {
        removeRoom(chooseRoomNumber());
    }

    public static void removeRoom (int roomNumber) {
        int num = -1;
        if (Rooms[roomNumber].getRoomNumber() == roomNumber) {
            num = roomNumber;
        } else {
            for (int i = 0; i < Room.getNumOfRooms(); i++) {
                if (Rooms[i +1].getRoomNumber() == roomNumber) {
                    num = i +1;
                }
            }
        }
        for (int i = num; i < Room.getNumOfRooms(); i++) {
            Rooms[i +1] = Rooms[i+2];
        }
        Rooms[Room.getNumOfRooms()] = null;
    }
}
