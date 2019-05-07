
import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    private PhoneBook phoneBook;

    public UserInterface(Scanner reader, PhoneBook phoneBook) {
        this.reader = reader;
        this.phoneBook = phoneBook;
    }
    
    public void printCommands(){
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }
    
    public void command(){
        String command = "";
        
        while(!command.equals("x")){
            
            System.out.print("\ncommand: ");
            command = this.reader.nextLine();
            
            if(command.equals("1")){
                addNumber();
            }
            if(command.equals("2")){
                searchNumber();
            }
            if(command.equals("3")){
                searchPerson();
            }
            if(command.equals("4")){
                addAddress();
            }
            if(command.equals("5")){
                searchInfo();
            }
            if(command.equals("6")){
                delete();
            }
            if(command.equals("7")){
                filteredSearch();
            }
            
        }
    }
    
    public void start(){
        printCommands();
        command();
    }
    
    public void addNumber(){
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        System.out.print("number: ");
        String number = this.reader.nextLine();
        
        this.phoneBook.addNumber(name, number);
    }
    
    public void searchNumber(){
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        
        this.phoneBook.searchNumber(name);
        
    }
    
    public void searchPerson(){
        System.out.print("number: ");
        String number = this.reader.nextLine();
        
        this.phoneBook.searchPerson(number);
        
    }
    
    public void addAddress(){
        System.out.print("whose address: ");
        String name = this.reader.nextLine();
        
        System.out.print("street: ");
        String street = this.reader.nextLine();
        
        System.out.print("city: ");
        String city = this.reader.nextLine();
        
        this.phoneBook.addAddress(name, street, city);
        
    }
    
    public void searchInfo(){
        System.out.print("whose information: ");
        String name = this.reader.nextLine();
        
        this.phoneBook.searchInfo(name);
    }
    
    public void delete(){
        System.out.print("whose information: ");
        String name = this.reader.nextLine();
        
        this.phoneBook.delete(name);
    }
    
    public void filteredSearch(){
        System.out.print("keyword (if empty, all listed): ");
        String keyword = this.reader.nextLine();
        
        this.phoneBook.filteredSearch(keyword);
    }

}
