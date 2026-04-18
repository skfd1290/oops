package Pack1;

import java.util.Scanner;

public class Student extends Hostel implements Department {

    private String studentName;
    private int regNo;
    private String electiveSubject;
    private double avgMarks;

    private String dName;
    private String dHead;

    public void getData() {
        Scanner sc = new Scanner(System.in);

        // Student Data
        System.out.print("Enter Student Name: ");
        studentName = sc.nextLine();

        System.out.print("Enter Registration No: ");
        regNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Elective Subject: ");
        electiveSubject = sc.nextLine();

        System.out.print("Enter Average Marks: ");
        avgMarks = sc.nextDouble();

        // Hostel Data
        getHostelData();

        // Department Data
        getDepartmentData();
    }

    public void printData() {
        System.out.println("\n--- Student Details ---");
        System.out.println("Name: " + studentName);
        System.out.println("Reg No: " + regNo);
        System.out.println("Subject: " + electiveSubject);
        System.out.println("Avg Marks: " + avgMarks);

        System.out.println("\n--- Hostel Details ---");
        printHostelData();

        System.out.println("\n--- Department Details ---");
        printDepartmentData();
    }

    // Interface Methods
    public void getDepartmentData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Department Name: ");
        dName = sc.nextLine();

        System.out.print("Enter Department Head: ");
        dHead = sc.nextLine();
    }

    public void printDepartmentData() {
        System.out.println("Department Name: " + dName);
        System.out.println("Department Head: " + dHead);
    }
}