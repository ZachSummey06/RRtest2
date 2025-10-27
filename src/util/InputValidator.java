package util;
import java.util.Scanner;

public class InputValidator {

    private static Scanner scanner = new Scanner(System.in);

    public static int readIntNumber(String errorMessage) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException ignore) {}
            System.out.println(errorMessage); // why not in catch?
        }
    }
    public static int readIntRange(int min, int max) {
        int num;
        do {
            num = readIntNumber("Please enter " + min + " to " + max + ": ");
            if (num < min || num > max) {
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            }
        } while (num < min || num > max);
        return num;
    }

    public static String readString() {
        return scanner.nextLine().trim();
    }
}
