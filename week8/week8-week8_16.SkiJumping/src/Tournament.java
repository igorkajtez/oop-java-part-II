
import java.util.ArrayList;
import java.util.Collections;

public class Tournament {
    private ArrayList<Jumper> jumpers;
    private Points points;
    
    public Tournament() {
        this.jumpers = new ArrayList<>();
        this.points = new Points();
    }
    
    public void addJumper(String name) {
        this.jumpers.add(new Jumper(name));
    }
    
    public ArrayList<Jumper> getJumpers(){
        return this.jumpers;
    }
    
    public void jumpOrder(){
        Collections.sort(this.jumpers);
        
        int i = 1;
        for(Jumper jumper : this.jumpers){
            System.out.println("  " + i + ". " + jumper);
            i++;
        } 
    }
    
    public void roundJump(){
        for(Jumper jumper : this.jumpers){
            jumper.jump();
        }
    }
    
    public void printResult(){
        Collections.sort(this.jumpers);
        Collections.reverse(this.jumpers);
        
        System.out.println("Position    Name");
        for (int i = 0; i < this.jumpers.size(); i++) {
            Jumper jumper = this.jumpers.get(i);
            
            System.out.println((i + 1) + "           " + jumper.getName() + " (" + jumper.getPoints()+ " points)");
            System.out.print("            jump lengths: ");
            jumper.printLengths();
        }
    }

    

}
