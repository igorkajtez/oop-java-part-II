package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing{
    private List<Thing> things;
    private int maxCapacity;

    public Box(int maxCapacity) {
        this.things = new ArrayList<Thing>();
        this.maxCapacity = maxCapacity;
    }
    
    public boolean addThing(Thing thing){
        if(this.getVolume() + thing.getVolume() > this.maxCapacity){
            return false;
        }
        
        this.things.add(thing);
        return true;
    }

    @Override
    public int getVolume() {
        int totalVolume = 0;
        
        for(Thing thing : this.things){
            totalVolume += thing.getVolume();
        }
        
        return totalVolume;
    }


    
    

}
