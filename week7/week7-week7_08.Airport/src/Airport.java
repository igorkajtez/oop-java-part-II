import java.util.ArrayList;
import java.util.HashMap;

public class Airport {
    private ArrayList<Plane> planes;
    private HashMap<Plane, Flight> flights;
    
    public Airport() {
        this.planes = new ArrayList<Plane>();
        this.flights = new HashMap<Plane, Flight>();
    }
    
    public void addPlane(String planeID, int capacity) {
        this.planes.add(new Plane(planeID, capacity));
    }
    
    public void addFlight(String planeID, Flight flight) {
        for (Plane p : this.planes) {
            if (p.getPlaneID().equals(planeID)) {
                Plane plane = new Plane(p.getPlaneID(), p.getCapacity());
                this.flights.put(plane, flight);
                break;
            }
        }
    }
    
    public void printPlanes() {
        for (Plane p : this.planes) {
            System.out.println(p);
        }
    }
    
    public void printFlights() {
        for (Plane p : this.flights.keySet()) {
            System.out.println(p + " " + this.flights.get(p));
        }
    }
    
    public void printPlaneInfo(String planeID) {
        for (Plane p : this.planes) {
            if (p.getPlaneID().equals(planeID)) {
                System.out.println(p);
            }
        }
    }
}