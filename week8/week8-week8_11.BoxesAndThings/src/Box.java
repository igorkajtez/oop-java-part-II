
import java.util.ArrayList;
import java.util.List;

public class Box implements ToBeStored{
    private double maxWeight;
    private List<ToBeStored> things;
    
    public Box(double maxWeight){
        this.maxWeight = maxWeight;
        this.things = new ArrayList<>();
    }
    
    public void add(ToBeStored thing){
        if(this.weight() + thing.weight() <= this.maxWeight){
            this.things.add(thing);
        }        
    }
    
    public double weight(){
        double weight = 0;
        for(ToBeStored thing : this.things){
            weight += thing.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: " + this.things.size() + " things, total weight " + this.weight() + " kg";
    }
    
    

}
