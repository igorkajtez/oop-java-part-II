
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Tournament tournament = new Tournament();
        UserInterface ui = new UserInterface(reader, tournament);
        ui.start();
       
    
    

    }
}
