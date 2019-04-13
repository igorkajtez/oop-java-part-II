import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    private Airport airport;
    
    public UserInterface(Scanner reader, Airport airport) {
        this.reader = reader;
        this.airport = airport;
    }
    
    public void listAirportOperations() {
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
        System.out.print("> ");
    }
    
    public void listFlightServices() {
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
        System.out.print("> ");
    }
    
    public void displayAirportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        
        
        String command = "";
        while (!command.equals("x")) {
            
            listAirportOperations();
            command = this.reader.nextLine();
            if (command.equals("1")) {
                addPlane();
            } else if (command.equals("2")) {
                addFlight();
            } else if (command.equals("x")) {
                break;
            }
        }
    }
    
    public void displayFlightService() {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        
        String command = "";
        while (!command.equals("x")) {
            
            listFlightServices();
            command = this.reader.nextLine();
            if (command.equals("1")) {
                this.airport.printPlanes();
            } else if (command.equals("2")) {
                this.airport.printFlights();
            } else if (command.equals("3")) {
                System.out.print("Give plane ID: ");
                this.airport.printPlaneInfo(this.reader.nextLine());
            } else if (command.equals("x")) {
                break;
            }
        }
    }
    
    public void addPlane() {
        System.out.print("Give plane ID: ");
        String planeID = this.reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(this.reader.nextLine());
        
        this.airport.addPlane(planeID, capacity);
    }
    
    public void addFlight() {
        System.out.print("Give plane ID: ");
        String planeID = this.reader.nextLine();
        System.out.print("Give departure airport code: ");
        String departureCode = this.reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationCode = this.reader.nextLine();
        
        this.airport.addFlight(planeID, new Flight(departureCode, destinationCode));
    }
    
    public void start() {
        displayAirportPanel();
        displayFlightService();
    }
}