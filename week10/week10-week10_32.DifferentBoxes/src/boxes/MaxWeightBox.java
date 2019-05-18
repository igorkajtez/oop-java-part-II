package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {
    private int maxWeight;
    private List<Thing> things;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<>();
    }

    @Override
    public void add(Thing thing) {
        int totalAmount = 0;
        
        for(Thing t : this.things){
            totalAmount += t.getWeight();
        }
        
        if(thing.getWeight() + totalAmount <= this.maxWeight){
            this.things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {        
        return this.things.contains(thing);
    }

}
