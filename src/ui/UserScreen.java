package ui;

import util.InputValidator;
import model.User;

public class UserScreen extends Screen {

    public static void showUserScreen(User currentUser) {

        boolean keepRunning = true;

        while (keepRunning) {

            // use whatever infos available
            String username = (currentUser != null) ? currentUser.getUsername() : "User";
            String first = (currentUser != null) ? currentUser.getFirstName() : "";
            String last = (currentUser != null) ? currentUser.getLastName() : "";

            // header
            displayHeader("Hello! " + username, "User Profile");

            System.out.println("Username: " + username);
            System.out.println("First Name: " + first);
            System.out.println("Last Name: " + last);
            System.out.println("[Password Hidden]");

            System.out.println("\n[1] Back");
            System.out.print("Enter your choice: ");

            String choice = InputValidator.readString().trim();
            if (choice.equals("1")) {
                keepRunning = false;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}


