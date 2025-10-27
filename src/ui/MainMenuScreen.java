package ui;

import model.User;
import util.InputValidator;

import java.util.Scanner;

public class MainMenuScreen extends Screen {
    public static void showMainMenuScreen() {
        if(LoginScreen.getIsAccount()) {
            displayHeader("Main Menu", "Select any Option");
            System.out.printf("%-40s\n", "===========================================");
            System.out.printf("\t\t\t\t%-40s\n", "Main Menu");
            System.out.printf("%-40s\n", "===========================================");
            System.out.printf("\t\t%-40s\n", "[1] View Account");
            System.out.printf("\t\t%-40s", "[2] View Music Selection");
        }
    }
    public static void performMainMenuOption(MainMenuOptions mainMenuOptions) {
        switch(mainMenuOptions){
            case eViewAccount:
                showViewAccount();
                break;
            case eViewMusicSelection:
                showMusicSelection();
                break;

        }
    }
    private static void showViewAccount(){ System.out.println("Show View Account..."); }
    private static void showMusicSelection(){ System.out.println("Show Music Selection..."); }
}
