package ui;

import model.User;
import util.InputValidator;

import java.util.Scanner;

public class MainMenuScreen extends Screen {
    public static void showMainMenuScreen() {
        //we need to loop until users exits
            boolean keepRunning = true;

            while(keepRunning ) {
            displayHeader("Main Menu", "Select any Option");
            System.out.printf("%-40s\n", "===========================================");
            System.out.printf("\t\t\t\t%-40s\n", "Main Menu");
            System.out.printf("%-40s\n", "===========================================");
            System.out.printf("\t\t%-40s\n", "[1] View Account");
            System.out.printf("\t\t%-40s\n", "[2] View Music Selection");
            System.out.printf("\t\t%-40s\n", "[3] Rate A Song");
            System.out.printf("\t\t%-40s\n", "[4] Exit");
            System.out.printf("%-40s\n", "===========================================");
            System.out.print("\nEnter your choice: ");  
            handleUserSelection(currentUser); 


        }
    }
    private static void handleUserSelection(User currentUser) {
        int choice = InputValidator.readIntRange(1, 4);
        MainMenuOptions option = MainMenuOptions.values()[choice - 1];
        performMainMenuOption(option, currentUser);
    }

    //switch case for users choice in menu option
    public static void performMainMenuOption(MainMenuOptions mainMenuOptions, User currentUser) {
        switch(mainMenuOptions){
            case eViewAccount:
                showViewAccount(currentUser);
                break;
            case eViewMusicSelection:
                showMusicSelection();
                break;
            case eRateSong:
                Rate.showRateScreen(currentUser);
                break;
            case eExit:
            System.out.println("Goodbye, Thank you!");
            keepRunning = false;
            break;
                
        }
    }
    private static void showViewAccount(User currentUser) {
        displayHeader("Your Account", "Account Details");

        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("First Name: " + currentUser.getFirstName());
        System.out.println("Last Name: " + currentUser.getLastName());

        System.out.println("\nPress Enter to return to Main Menu...");
        new Scanner(System.in).nextLine(); // wait for user to continue
    }

    private static void showMusicSelection(){ 
        System.out.println("Show Music Selection..."); 
        System.out.println("\nPress Enter to return to Main Menu...");
        new Scanner(System.in).nextLine();
    }

}
