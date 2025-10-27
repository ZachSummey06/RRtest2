package model;

public class SongRating {
    private String username;
    private String songName;
    private String albumName;
    private String artistName;
    private int rating;
    private String comments;

    public SongRating(String username, String songName, String albumName, String artistName, int rating, String comments) {
        this.username = username;
        this.songName = songName;
        this.albumName = albumName;
        this.artistName = artistName;
        this.rating = rating;
        this.comments = comments;
    }

    public String getUsername() { return username; }
    public String getSongName() { return songName; }
    public String getAlbumName() { return albumName; }
    public String getArtistName() { return artistName; }
    public int getRating() { return rating; }
    public String getComments() { return comments; }

    public void setUsername(String username) { this.username = username; }
    public void setSongName(String songName) { this.songName = songName; }
    public void setAlbumName(String albumName) { this.albumName = albumName; }
    public void setArtistName(String artistName) { this.artistName = artistName; }
    public void setRating(int rating) { this.rating = rating; }
    public void setComments(String comments) { this.comments = comments; }

    @Override
    public String toString() {
        return String.format("User: %s | Song: %s | Album: %s | Artist: %s | Rating: %d | Comments: %s",
                username, songName, albumName, artistName, rating, comments);
    }
}
