package farmsimulator;

import java.util.ArrayList;
import java.util.Collection;

public class Farm implements Alive{
    private String owner;
    private Barn barn;
    private Collection<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<>();
        
    }
    
    public String getOwner(){
        return this.owner;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.barn.installMilkingRobot(milkingRobot);
    }

    @Override
    public void liveHour() {
        for(Cow cow : this.cows){
            cow.liveHour();
        }
    }
    
    public void manageCows(){        
        this.barn.takeCareOf(this.cows);        
    }
    
    public void addCow(Cow cow){
        this.cows.add(cow);
    }

    @Override
    public String toString() {
        String output = "Farm owner: " + this.owner + "\n" + 
                        "Barn bulk tank: " + this.barn.getBulkTank();                        
        
        if(this.cows.isEmpty()){
            output += "\nNo cows.";
        }else {
            output += "\nAnimals:";
            
            for(Cow cow : this.cows){
                output += "\n        " + cow;
            }
        }
        
        return output;
    }
    
    
    
    

}
