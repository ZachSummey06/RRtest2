package model;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    private ArrayList<User> users;
    private final String userFilePath;

    public UserManager() {
        users = new ArrayList<>();
        this.userFilePath  = "data/users.csv";
    }

    public void loadUsersFromFile(){
        Scanner scnr;
        try{
            String line;
            User  user;
            scnr = new Scanner(new FileReader(userFilePath));
            while(scnr.hasNextLine()){
                line = scnr.nextLine();
                user = convertLineToUser(line, ",");
                if(user != null){
                    users.add(user);
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    private User convertLineToUser(String line, String delimiter){
        String[] userData = line.split(delimiter);
//        if(userData.length != 2){
//            return null;
//        }
        return new User(userData[0], userData[1], userData[2], userData[3]);
    }

    public User findUser(String username, String password) {
        for(User user: users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    public User findUser(String username) {
        for(User user: users){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsersList() {
        return users;
    }

    public boolean isUserExixst(String username){ return findUser(username) != null; }

}


