
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    private Map<String, Set<String>> numberByName;
    private Map<String, String> nameByNumber;
    private Map<String, Address> address;

    public PhoneBook() {
        this.numberByName = new HashMap<>();
        this.nameByNumber = new HashMap<>();
        this.address = new HashMap<>();
    }
    
    public void addNumber(String name, String number){
        if(!this.numberByName.containsKey(name)){
            this.numberByName.put(name, new HashSet<>());
        }
        
        if(!this.nameByNumber.containsKey(number)){
            this.nameByNumber.put(number, name);
        }
        
        this.numberByName.get(name).add(number);
    }
    
    public void searchNumber(String name){
        if(this.numberByName.containsKey(name)){
            for(String number : this.numberByName.get(name)){
                System.out.println("  " + number);
            }
        }else {
            System.out.println("  " + "not found");
        }
    }
    
    public void searchPerson(String number){
        if(this.nameByNumber.containsKey(number)){
            System.out.println("  " + this.nameByNumber.get(number));
        }else {
            System.out.println("  " + "not found");
        }
    }
    
    public void addAddress(String name, String street, String city){        
        this.address.put(name, new Address(street, city));        
    }
    
    public void searchInfo(String name){
        
        if(!this.address.containsKey(name) && !this.numberByName.containsKey(name)){
            System.out.println("  not found");            
        }else{
            
            if(this.address.containsKey(name)){
                System.out.println("  address: " + this.address.get(name));
                
            }else {
                System.out.println("  address unknown");
            }
        
            if(this.numberByName.containsKey(name)){
                System.out.println("  phone numbers:");
                for(String number : this.numberByName.get(name)){
                    System.out.println("    " + number);
                }
            }else {
                System.out.println("  phone number not found");
            }
            
        }
    }
    
    public void delete(String name){
        if(this.numberByName.containsKey(name)){
            
            for(String number : this.numberByName.get(name)){
                this.nameByNumber.remove(number);
            }            
            this.numberByName.remove(name);
        }
        
        if(this.address.containsKey(name)){
            this.address.remove(name);
        }
    }
    
    public void filteredSearch(String keyword){
        TreeMap<String, Set<String>> numberByNameSorted = new TreeMap<>(this.numberByName);
        boolean found = false;
        
        for (String name : numberByNameSorted.keySet()) {
            if (name.contains(keyword) || (this.address.containsKey(name) && this.address.get(name).containsKeyword(keyword))){
                found = true;
                System.out.println("\n " + name);
                searchInfo(name);
            }
        }
        
        if (!found) {
            System.out.println(" keyword not found");
        }
        
    }
}
