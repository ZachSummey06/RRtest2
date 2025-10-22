package ui;

public class Screen {
    protected static void displayHeader(String header, String subHeader) {
        System.out.println("-------------------------------------------------");
        System.out.printf("|\t\t\t\t%s\t\t\t\t|\n", header);

        if(!subHeader.equals("")){
            System.out.printf("\n%32s\n", subHeader);
        }

        System.out.println("-------------------------------------------------");
    }
}
