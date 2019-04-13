
import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader = new Scanner(System.in);
    private Dictionary dictionary = new Dictionary();
    
    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start(){
        System.out.println("Statement: ");
        System.out.println("    add - adds a word pair to the dictionary");
        System.out.println("    translate - asks a word and prints its translation");
        System.out.println("    quit - quit the text user interface");
        
        String input = "";
        while(!input.equals("quit")){
            System.out.print("Statement: ");
            String statement = this.reader.nextLine();
            
            if (statement.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }
            
            handleStatement(statement);
            System.out.println("");
        }
    }
    
    private void add(){
        System.out.print("In Finnish: ");
        String word = this.reader.nextLine();
        System.out.print("Translation: ");
        String translation = this.reader.nextLine();
        
        this.dictionary.add(word, translation);
    }
    
    private void translate(){
        System.out.print("Give a word: ");
        String word = this.reader.nextLine();
        if(this.dictionary.translate(word)==null){
            System.out.println("Unknown word");
        }else {
            System.out.println("Translation: " + this.dictionary.translate(word));
        }                
    }
    
    private void handleStatement(String input){
        if(input.equals("add")){
            add();
        }else if(input.equals("translate")){
            translate();
        }else{
            System.out.println("Unknown statement");
        }
    }

}
