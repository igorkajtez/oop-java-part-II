
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        UserInterface ui = new UserInterface(reader, phoneBook);
        ui.start();
    }
}
