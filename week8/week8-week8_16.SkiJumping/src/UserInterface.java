
import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    private Tournament tournament;
    private int roundNum;
    
    public UserInterface(Scanner reader, Tournament tournament){
        this.reader = reader;
        this.tournament = tournament;
        this.roundNum = 1;
    }
    
    public void start(){
        System.out.println("Kumpula ski jumping week\n");
        addJumper();
        playTournament();
        endTournament();
    }
    
    public void addJumper(){
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        
        while(true){
            System.out.print("  Participant name: ");
            String name = this.reader.nextLine();
            
            if(name.equals("")){
                break;
            }else{
                this.tournament.addJumper(name);
            }
        }
        
        System.out.println("\nThe tournament begins!");        
    }
    
    public void playTournament(){
        while(true){
            System.out.println("\nWrite \"jump\" to jump; otherwise you quit: ");
            String command = this.reader.nextLine();
            
            if(!command.equals("jump")){
                break;
            }  
            
            playRound();            
        }
        System.out.println("\nThanks!\n");
    }
    
    public void playRound(){
        System.out.println("\nRound " + this.roundNum);
        
        System.out.println("\nJumping order:");
        this.tournament.jumpOrder();
        
        System.out.println("\nResults of round " + this.roundNum);
        this.tournament.roundJump();
        
        this.roundNum++;
    }
    
    public void endTournament(){
        System.out.println("Tournament results:");        
        this.tournament.printResult();
    }
    
    
    
    
    

}
