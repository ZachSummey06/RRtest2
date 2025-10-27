package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RatingManager {
    private ArrayList<SongRating> ratings;
    private final String ratingsFilePath;

    public RatingManager() {
        this.ratingsFilePath = "data/ratings.csv";
        this.ratings = new ArrayList<>();
    }

    // Load ratings from CSV file
    public void loadRatingsFromFile() {
        ratings.clear();
        try (Scanner scnr = new Scanner(new FileReader(ratingsFilePath))) {
            while (scnr.hasNextLine()) {
                String line = scnr.nextLine();
                SongRating rating = convertLineToRating(line, ",");
                if (rating != null) {
                    ratings.add(rating);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Error loading ratings: " + e.getMessage());
        }
    }

    // Convert a CSV line into a SongRating object
    private SongRating convertLineToRating(String line, String delimiter) {
        String[] data = line.split(delimiter, -1);
        if (data.length < 6) return null;

        String username = data[0].trim();
        String songName = data[1].trim();
        String albumName = data[2].trim();
        String artistName = data[3].trim();
        int rating;
        try {
            rating = Integer.parseInt(data[4].trim());
        } catch (NumberFormatException e) {
            return null;
        }
        String comments = data[5].replace("\"", "").trim();
        return new SongRating(username, songName, albumName, artistName, rating, comments);
    }

    // Save a single rating to the file
    public void saveRating(SongRating rating) {
        try (FileWriter writer = new FileWriter(ratingsFilePath, true)) {
            writer.write(String.format("%s,%s,%s,%s,%d,\"%s\"\n",
                    rating.getUsername(),
                    rating.getSongName(),
                    rating.getAlbumName(),
                    rating.getArtistName(),
                    rating.getRating(),
                    rating.getComments().replace("\"", "\"\"")));
            ratings.add(rating); // keep it in memory too
        } catch (IOException e) {
            System.out.println("⚠️ Error saving rating: " + e.getMessage());
        }
    }

    // Find all ratings by a specific user
    public ArrayList<SongRating> getRatingsByUser(String username) {
        ArrayList<SongRating> userRatings = new ArrayList<>();
        for (SongRating rating : ratings) {
            if (rating.getUsername().equalsIgnoreCase(username)) {
                userRatings.add(rating);
            }
        }
        return userRatings;
    }

    // Get all ratings in memory
    public ArrayList<SongRating> getAllRatings() {
        return ratings;
    }
}
