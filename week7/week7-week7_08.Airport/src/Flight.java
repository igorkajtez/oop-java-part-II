public class Flight {
    private String departureCode;
    private String destinationCode;
    
    public Flight(String departureCode, String destinationCode) {
        this.departureCode = departureCode;
        this.destinationCode = destinationCode;
    }
    
    public String toString() {
        return "(" + this.departureCode + "-" + this.destinationCode + ")";
    }
}