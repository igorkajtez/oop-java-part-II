
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Points {
    private Random random;
    private int length;
    private ArrayList<Integer> votes;
    
    public Points() {
        this.random = new Random();
        this.length = random.nextInt(61) + 60;
        this.votes = new ArrayList<>();
        getVotes();
    }
    
    public int getLength() {
        return this.length;
    }
    
    public void getVotes(){
        for(int i = 0; i < 5; i++){
            int vote = random.nextInt(11)+10;
            this.votes.add(vote);
        }        
    }
        
    public void printVotes(){
        System.out.print("[");
        for (int i = 0; i < 4; i++) {
            System.out.print(this.votes.get(i) + ", ");
        }
        System.out.print(this.votes.get(4) + "]\n");
    } 
    
    public int calculatePoints(){
        int points = 0;
        Collections.sort(this.votes);
        
        for(int i = 1; i < 4; i++){
            points += this.votes.get(i);
        }    
        
        return points + this.length;
    }
    
    

}
