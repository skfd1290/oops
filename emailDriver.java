// EmailValidation.java

import java.util.Scanner;

public class EmailValidation {

    // Method to validate email
    static void checkEmail(String email) {

        // Basic email validation
        if (!(email.contains("@") &&
              email.contains(".") &&
              email.indexOf("@") < email.lastIndexOf("."))) {

            // Manually throwing exception
            throw new IllegalArgumentException("Invalid Email ID");
        }

        System.out.println("Valid Email ID");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter Email ID: ");
            String email = sc.nextLine();

            checkEmail(email);

        } catch (IllegalArgumentException e) {

            System.out.println("Exception: " + e.getMessage());
        }

        sc.close();
    }
}
