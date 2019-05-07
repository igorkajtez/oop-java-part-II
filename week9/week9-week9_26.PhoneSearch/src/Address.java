public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
    
    public boolean containsKeyword(String keyword){
        return this.street.contains(keyword) || this.city.contains(keyword);
    }

    @Override
    public String toString() {
        return this.street + " " + this.city;
    }
    
    
    
    

}
