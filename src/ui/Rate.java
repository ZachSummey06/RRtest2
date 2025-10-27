package ui;

import model.RatingManager;
import model.SongRating;
import util.InputValidator;
import model.User;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Rate extends Screen {

    public static void showRateScreen(User currentUser) {
        displayHeader("Rate a Song", "Enter your rating details below");

        Scanner scanner = new Scanner(System.in);
        RatingManager ratingManager = new RatingManager();

        System.out.print("Song Name: ");
        String songName = scanner.nextLine();

        System.out.print("Album Name: ");
        String albumName = scanner.nextLine();

        System.out.print("Artist Name: ");
        String artistName = scanner.nextLine();

        System.out.print("Rating (1–5): ");
        int rating = InputValidator.readIntRange(1, 5);

        System.out.print("Comments (optional): ");
        String comments = scanner.nextLine();

        SongRating newRating = new SongRating(
                currentUser.getUsername(), songName, albumName, artistName, rating, comments
        );

        ratingManager.saveRating(newRating);

        System.out.println("\n✅ Rating successfully submitted!");
        System.out.println(newRating.toString());
    }

}
