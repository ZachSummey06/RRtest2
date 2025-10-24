package ui;
import util.InputValidator;
import model.User;
import model.Person;
import model.UserManager;
import java.util.*;

public class LoginScreen extends Screen {
    static boolean isAccount = false;
    public static String username = "";
    public static void showLoginScreen() {

        UserManager userManager = new UserManager();
        userManager.loadUsersFromFile();
        ArrayList<User> users = userManager.getUsersList();
        User user = new User("", "");
        username = user.getUsername();
        String password = user.getPassword();

        displayHeader("Login", "Enter Username and Password");
        System.out.print("Username: ");
        user.setUsername(InputValidator.readString());
        username = user.getUsername();
        if(userManager.isUserExixst(username)){
            System.out.print("Password: ");
             user.setPassword(InputValidator.readString());
             password = user.getPassword();
            userManager.findUser(username, password);
            isAccount = true;
            MainMenuScreen.showMainMenuScreen();
        }
//       if(!isAccount){
//           Set first name
//           Set last initial/name
//           Set new username and password by asking
//           Write new information to the users file
//        }

    }
    public static boolean getIsAccount(){ return isAccount; }
    public void setIsAccount(boolean isAccount){ this.isAccount = isAccount; }
}
