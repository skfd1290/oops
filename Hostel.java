package Pack1;

import java.util.Scanner;

public class Hostel {
    protected String hostelName;
    protected String hostelLocation;
    protected int noOfRooms;

    public void getHostelData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Hostel Name: ");
        hostelName = sc.nextLine();

        System.out.print("Enter Hostel Location: ");
        hostelLocation = sc.nextLine();

        System.out.print("Enter Number of Rooms: ");
        noOfRooms = sc.nextInt();

    }

    public void printHostelData() {
        System.out.println("Hostel Name: " + hostelName);
        System.out.println("Location: " + hostelLocation);
        System.out.println("Rooms: " + noOfRooms);
    }
    
}