package loginapp;

import java.util.Scanner;

public class RegistrationLoginApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        System.out.println("===== REGISTER USER =====");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter South African cell number with international code (e.g. +27838968976): ");
        String cellPhoneNumber = scanner.nextLine();

        String registrationMessage = login.registerUser(firstName, lastName, userName, password, cellPhoneNumber);
        System.out.println(registrationMessage);

        if (registrationMessage.equals("User has been registered successfully.")) {
            System.out.println();
            System.out.println("===== LOGIN USER =====");

            System.out.print("Enter username: ");
            String loginUserName = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            boolean loginSuccess = login.loginUser(loginUserName, loginPassword);
            String loginStatusMessage = login.returnLoginStatus(loginSuccess);

            System.out.println(loginStatusMessage);
        } else {
            System.out.println("Registration failed. Please restart the program and try again.");
        }

        scanner.close();
    }
}