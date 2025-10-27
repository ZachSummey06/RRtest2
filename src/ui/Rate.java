package ui;

import util.InputValidator;
import model.User;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Rate extends Screen {

    public static void showRateScreen(User currentUser) {
        displayHeader("Rate a Song", "Enter your rating details below");

        Scanner scanner = new Scanner(System.in);

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

        saveRatingToFile(currentUser.getUsername(), songName, albumName, artistName, rating, comments);

        System.out.println("\n✅ Rating successfully submitted!");
        System.out.printf(
                "User: %s\nSong: %s\nAlbum: %s\nArtist: %s\nRating: %d\nComments: %s\n",
                currentUser.getUsername(), songName, albumName, artistName, rating, comments
        );
    }

    private static void saveRatingToFile(String username, String song, String album, String artist, int rating, String comments) {
        String filePath = "data/ratings.csv";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(String.format("%s,%s,%s,%s,%d,\"%s\"\n",
                    username, song, album, artist, rating, comments.replace("\"", "\"\"")));
        } catch (IOException e) {
            System.out.println("⚠️ Error saving rating: " + e.getMessage());
        }
    }
}
