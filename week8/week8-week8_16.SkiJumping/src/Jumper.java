
import java.util.ArrayList;

public class Jumper implements Comparable<Jumper>{
    private String name;
    private int points;
    private ArrayList<Integer> lengthList;
    
    public Jumper(String name) {
        this.name = name;
        this.points = 0;
        this.lengthList = new ArrayList<>();
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getPoints(){
        return this.points;
    }
    
    public void addPoints(int points){
        this.points += points;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }

    @Override
    public int compareTo(Jumper other) {
        return this.getPoints() - other.getPoints();
    }
    
    public void jump(){
        Points p = new Points();
        
        System.out.println("  " + this.getName());
        System.out.println("    length: " + p.getLength());
        System.out.print("    judge votes: " );
        p.printVotes();
        
        this.addPoints(p.calculatePoints());
        this.lengthList.add(p.getLength());
     }
    
    public void printLengths(){
        System.out.print(this.lengthList.get(0) + " m");
        for(int i = 1; i < this.lengthList.size(); i++){
            System.out.print(", " + this.lengthList.get(i) + " m");
        }
        System.out.println("");
    }
    
    
    
    
    

    

}
