
import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Thing> things;
    private int maxWeightLimit;
    private int totalWeight;
    
    public Suitcase(int maxWeightLimit){
        this.maxWeightLimit = maxWeightLimit;
        this.things = new  ArrayList<Thing>();
        this.totalWeight = 0;
    }
    
    public void addThing(Thing thing){
        if(this.totalWeight + thing.getWeight() > this.maxWeightLimit){
            return;
        }
        this.things.add(thing);
        this.totalWeight += thing.getWeight();
    }
    
    public void printThings(){
        for(Thing thing : this.things){
            System.out.println(thing);
        }
    }
    
    public int totalWeight(){
        return this.totalWeight;
    }
    
    public Thing heaviestThing(){
        
        if(this.things.isEmpty()){
            return null;
        }
        
        Thing heaviest = this.things.get(0);
        
        for (int i = 0; i < this.things.size(); i++) {
            if(this.things.get(i).getWeight() > heaviest.getWeight()){
                heaviest = this.things.get(i);
            }
        }
        
        return heaviest;
    }
    

    @Override
    public String toString() {
        if(this.things.size() == 0){
            return "empty" + " (" + this.totalWeight + " kg)";
        }else if(this.things.size() == 1){
            return "" + this.things.size() + " thing" + " (" + this.totalWeight + " kg)";
        }else {
            return "" + this.things.size() + " things" + " (" + this.totalWeight + " kg)";
        }        
    }
    
    

}
